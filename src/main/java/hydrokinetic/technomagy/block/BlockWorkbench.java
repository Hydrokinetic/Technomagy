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
 * File creation date: Oct 19, 2017, 12:42:14 PM EST
 */

package hydrokinetic.technomagy.block;

import hydrokinetic.technomagy.block.tile.TileWorkbench;
import hydrokinetic.technomagy.lib.LibBlockNames;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWorkbench extends BlockMod implements ITileEntityProvider {
    
    public BlockWorkbench() {
        super(Material.WOOD, LibBlockNames.WORKBENCH);
    }
    
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        TileEntity te = getTE(world, pos);
        if (!(te instanceof TileWorkbench)) {
            return false;
        }
        //TODO: remove this and put actual stuff here
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileWorkbench();
    }
    
    private TileWorkbench getTE(World world, BlockPos pos) {
        return (TileWorkbench) world.getTileEntity(pos);
    }
    
}
