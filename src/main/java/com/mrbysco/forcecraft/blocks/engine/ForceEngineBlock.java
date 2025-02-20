package com.mrbysco.forcecraft.blocks.engine;

import com.mojang.serialization.MapCodec;
import com.mrbysco.forcecraft.blockentities.ForceEngineBlockEntity;
import com.mrbysco.forcecraft.registry.ForceRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class ForceEngineBlock extends DirectionalBlock implements EntityBlock {

	public static final VoxelShape SHAPE_UP = Stream.of(
			Block.box(4, 8, 4, 12, 16, 12),
			Block.box(11, 4, 3, 15, 11, 13),
			Block.box(1, 4, 3, 5, 11, 13),
			Block.box(3, 4, 12, 13, 10, 14),
			Block.box(3, 4, 2, 13, 10, 4),
			Block.box(0, 0, 0, 16, 4, 16)
	).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public static final VoxelShape SHAPE_DOWN = Stream.of(
			Block.box(4, 0, 4, 12, 8, 12),
			Block.box(11, 5, 3, 15, 12, 13),
			Block.box(1, 5, 3, 5, 12, 13),
			Block.box(3, 6, 2, 13, 12, 4),
			Block.box(3, 6, 12, 13, 12, 14),
			Block.box(0, 12, 0, 16, 16, 16)
	).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public static final VoxelShape SHAPE_NORTH = Stream.of(
			Block.box(4, 4, 0, 12, 12, 8),
			Block.box(11, 3, 5, 15, 13, 12),
			Block.box(1, 3, 5, 5, 13, 12),
			Block.box(3, 12, 6, 13, 14, 12),
			Block.box(3, 2, 6, 13, 4, 12),
			Block.box(0, 0, 12, 16, 16, 16)
	).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public static final VoxelShape SHAPE_EAST = Stream.of(
			Block.box(8, 4, 4, 16, 12, 12),
			Block.box(4, 3, 11, 11, 13, 15),
			Block.box(4, 3, 1, 11, 13, 5),
			Block.box(4, 12, 3, 10, 14, 13),
			Block.box(4, 2, 3, 10, 4, 13),
			Block.box(0, 0, 0, 4, 16, 16)
	).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public static final VoxelShape SHAPE_SOUTH = Stream.of(
			Block.box(4, 4, 8, 12, 12, 16),
			Block.box(11, 3, 4, 15, 13, 11),
			Block.box(1, 3, 4, 5, 13, 11),
			Block.box(3, 2, 4, 13, 4, 10),
			Block.box(3, 12, 4, 13, 14, 10),
			Block.box(0, 0, 0, 16, 16, 4)
	).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public static final VoxelShape SHAPE_WEST = Stream.of(
			Block.box(0, 4, 4, 8, 12, 12),
			Block.box(5, 3, 11, 12, 13, 15),
			Block.box(5, 3, 1, 12, 13, 5),
			Block.box(6, 2, 3, 12, 4, 13),
			Block.box(6, 12, 3, 12, 14, 13),
			Block.box(12, 0, 0, 16, 16, 16)
	).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

	public static final MapCodec<ForceEngineBlock> CODEC = simpleCodec(ForceEngineBlock::new);

	public ForceEngineBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(ACTIVE, false));
	}

	@Override
	protected MapCodec<? extends DirectionalBlock> codec() {
		return CODEC;
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
	                                          Player player, InteractionHand hand, BlockHitResult hitResult) {
		BlockEntity blockentity = level.getBlockEntity(pos);
		if (blockentity instanceof ForceEngineBlockEntity) {
			IFluidHandler handler = level.getCapability(Capabilities.FluidHandler.BLOCK, pos, hitResult.getDirection());
			if (handler != null) {
				if (player.getItemInHand(hand).getCapability(Capabilities.FluidHandler.ITEM) != null) {
					FluidUtil.interactWithFluidHandler(player, hand, level, pos, hitResult.getDirection());
				} else {
					if (!level.isClientSide) {
						player.openMenu((ForceEngineBlockEntity) blockentity, pos);
					}
				}
			}

			return ItemInteractionResult.SUCCESS;
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			case UP -> SHAPE_UP;
			case DOWN -> SHAPE_DOWN;
			case NORTH -> SHAPE_NORTH;
			case EAST -> SHAPE_EAST;
			case SOUTH -> SHAPE_SOUTH;
			case WEST -> SHAPE_WEST;
			default -> super.getShape(state, level, pos, context);
		};
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING, ACTIVE);
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.setValue(FACING, mirrorIn.mirror(state.getValue(FACING)));
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Direction direction = context.getClickedFace();
		BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
		return blockstate.is(this) && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction).setValue(ACTIVE, Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos()))) :
				this.defaultBlockState().setValue(FACING, direction.getOpposite()).setValue(ACTIVE, Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos())));
	}

	@Override
	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if (!level.isClientSide) {
			boolean flag = state.getValue(ACTIVE);
			if (flag != level.hasNeighborSignal(pos)) {
				if (flag) {
					level.scheduleTick(pos, this, 4);
				} else {
					level.setBlock(pos, state.cycle(ACTIVE), 2);
				}
			}
		}
	}

	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
		if (state.getValue(ACTIVE) && !level.hasNeighborSignal(pos)) {
			level.setBlock(pos, state.cycle(ACTIVE), 2);
		}
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ForceEngineBlockEntity(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		return createEngineTicker(level, blockEntityType, ForceRegistry.FORCE_ENGINE_BLOCK_ENTITY.get());
	}

	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createEngineTicker(Level level, BlockEntityType<T> p_151989_, BlockEntityType<? extends ForceEngineBlockEntity> forceEngineBlockEntity) {
		return level.isClientSide ? null : createTickerHelper(p_151989_, forceEngineBlockEntity, ForceEngineBlockEntity::serverTick);
	}

	@Nullable
	protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> p_152133_, BlockEntityType<E> p_152134_, BlockEntityTicker<? super E> p_152135_) {
		return p_152134_ == p_152133_ ? (BlockEntityTicker<A>) p_152135_ : null;
	}

	public static ToIntFunction<BlockState> getLightValueActive(int lightValue) {
		return (state) -> state.getValue(ACTIVE) ? lightValue : 0;
	}

	@Override
	public void animateTick(BlockState stateIn, Level level, BlockPos pos, RandomSource rand) {
		if (stateIn.getValue(ACTIVE)) {
			Direction direction = stateIn.getValue(FACING);
			double d0 = (double) pos.getX() + 0.55D - (double) (rand.nextFloat() * 0.1F);
			double d1 = (double) pos.getY() + 0.55D - (double) (rand.nextFloat() * 0.1F);
			double d2 = (double) pos.getZ() + 0.55D - (double) (rand.nextFloat() * 0.1F);
			double d3 = (double) (0.4F - (rand.nextFloat() + rand.nextFloat()) * 0.4F);
			if (rand.nextInt(5) == 0) {
				level.addParticle(ParticleTypes.SMOKE, d0 + (double) direction.getStepX() * d3, d1 + (double) direction.getStepY() * d3, d2 + (double) direction.getStepZ() * d3, rand.nextGaussian() * 0.005D, rand.nextGaussian() * 0.005D, rand.nextGaussian() * 0.005D);
			}
		}
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.BLOCK;
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
		if (!state.is(newState.getBlock())) {
			BlockEntity blockEntity = level.getBlockEntity(pos);
			if (blockEntity instanceof ForceEngineBlockEntity engineTile) {
				Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), engineTile.inputHandler.getStackInSlot(0));
				Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), engineTile.inputHandler.getStackInSlot(1));
				Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), engineTile.outputHandler.getStackInSlot(0));
				Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), engineTile.outputHandler.getStackInSlot(1));
			}

			super.onRemove(state, level, pos, newState, isMoving);
		}
	}
}
