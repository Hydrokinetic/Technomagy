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
 * File creation date: Oct 19, 2017, 9:14:09 PM EST
 */

package hydrokinetic.technomagy.block;

import hydrokinetic.technomagy.Technomagy;
import hydrokinetic.technomagy.block.tile.TileCounter;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCounter extends Block implements ITileEntityProvider {
    
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    
    public BlockCounter() {
        super(Material.IRON);
        setUnlocalizedName(Technomagy.MODID + ".counter");
        setRegistryName("counter");
    }
    
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCounter();
    }
    
    private TileCounter getTE(World world, BlockPos pos) {
        return (TileCounter) world.getTileEntity(pos);
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            // Check to ensure logic is happening on the server side.
            
            if (side == state.getValue(FACING)) {
                int counter;
                if (hitY < .5f) {
                    counter = getTE(world, pos).decrement();
                } else {
                    counter = getTE(world, pos).increment();
                }
                TextComponentTranslation component = new TextComponentTranslation("message.technomagy.counter_par", counter);
                component.getStyle().setColor(TextFormatting.AQUA);
                player.sendStatusMessage(component, false);
            }
        }
        // Return true even if clientside to ensure the game knows the block activation was handles
        // and will not place a block on the client.
        return true;
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
        // Since we're only allowing horizontal rotation only 2 bits are needed for facing. NSEW start at index 2, so add 2 here.
        return getDefaultState().withProperty(FACING, EnumFacing.getFront((meta & 3) + 2));
    }
    
    @Override
    public int getMetaFromState(IBlockState state) {
        // Since we're only allowing horizontal rotation only 2 bits are needed for facing. NSEW start at index 2, so subtract 2 here.
        return state.getValue(FACING).getIndex() - 2;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }
    
}
