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
 * File creation date: Oct 26, 2017, 10:24:21 PM EST
 */
package hydrokinetic.technomagy.block;

import hydrokinetic.technomagy.TechnomagyCreativeTab;
import hydrokinetic.technomagy.proxy.lib.LibGeneral;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockMod extends Block {
    
    public BlockMod(Material mat, String name) {
        super(mat);
        setUnlocalizedName(LibGeneral.MOD_ID + "." + name);
        setRegistryName(name);
        //setCreativeTab(TechnomagyCreativeTab.INSTANCE);
    }
    
    @Override
    public boolean eventReceived(IBlockState state, World world, BlockPos pos, int id, int param) {
            super.eventReceived(state, world, pos, id, param);
            TileEntity tileentity = world.getTileEntity(pos);
            return tileentity != null ? tileentity.receiveClientEvent(id, param) : false;
    }
    
    
}
