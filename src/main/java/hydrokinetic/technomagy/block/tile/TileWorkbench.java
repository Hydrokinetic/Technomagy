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
 * File creation date: Oct 20, 2017, 9:43:21 AM EST
 */

package hydrokinetic.technomagy.block.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class TileWorkbench extends TileEntity {
    
    private boolean isMaster, hasMaster, isCorner;
    private int masterX, masterY, masterZ;
    int xCoord = pos.getX();
    int yCoord = pos.getY();
    int zCoord = pos.getZ();
    
    public boolean hasMaster() {
        return hasMaster;
    }
    
    public int getMasterX() {
        return masterX;
    }
    
    public int getMasterY() {
        return masterY;
    }
    
    public int getMasterZ() {
        return masterZ;
    }
    
    public void setHasMaster(boolean bool) {
        hasMaster = bool;
    }
 
    public void setMasterCoords(int x, int y, int z) {
       masterX = x;
       masterY = y;
       masterZ = z;
    }
}
