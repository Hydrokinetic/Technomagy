/*
 * This file was created by Swordstone (aka Hydrokinetic)
 * as part of Technomagy, a mod for Minecraft. The source code
 * can be found here:
 * https://github.com/Hydrokinetic/Technomagy
 * 
 * Technomagy is open-source and distributed under the Creative
 * Commons Attribution-NonCommercial-ShareAlike 3.0 Unported
 * license. 
 * 
 * If you're wondering what that means, a summary can be found here:
 * https://creativecommons.org/licenses/by-nc-sa/3.0/
 * 
 * File creation date: Oct 26, 2017, 9:18:09 PM EST
 */

package hydrokinetic.technomagy.block.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileExtractor extends TileEntity implements ITickable {
    
    private int counter = 0;
    
    public int decrement() {
        counter--;
        markDirty(); // This tells MC that the tile entity needs to be saved next time the chunk is saved to disk.
        return counter;
    }
    
    @Override
    public void update() {
        if (world.getTotalWorldTime() % 20 == 0) {
            System.out.println("test");
        }
    }
    
    public int increment() {
        counter++;
        markDirty();
        return counter;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        counter = compound.getInteger("counter");
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("counter", counter);
        return compound;
    }

}
