package mrbysco.forcecraft.capablilities.playermodifier;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class PlayerModifierStorage implements Capability.IStorage<IPlayerModifier> {
    @Nullable
    @Override
    public INBT writeNBT(Capability<IPlayerModifier> capability, IPlayerModifier instance, Direction side) {
        CompoundNBT nbt = new CompoundNBT();

        nbt.putFloat("damage", instance.getDamage());
        nbt.putFloat("wingPower", instance.getWingPower());
        nbt.putFloat("flightCounter", instance.getFlightTimer());
        nbt.putFloat("heatDamage", instance.getHeatDamage());
        nbt.putFloat("attackDamage", instance.getAttackDamage());
        nbt.putInt("luckLevel", instance.getLuckLevel());

        return nbt;
    }

    @Override
    public void readNBT(Capability<IPlayerModifier> capability, IPlayerModifier instance, Direction side, INBT nbtIn) {
        if(nbtIn instanceof CompoundNBT){
            CompoundNBT nbt = ((CompoundNBT) nbtIn);

            instance.setAttackDamage(nbt.getFloat("attackDamage"));
            instance.setWingPower(nbt.getFloat("wingPower"));
            instance.setFlightTimer(nbt.getFloat("flightCounter"));
            instance.setDamage(nbt.getFloat("damage"));
            instance.setLuckLevel(nbt.getInt("luckLevel"));
        }
    }
}
