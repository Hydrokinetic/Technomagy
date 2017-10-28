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
 * File creation date: Oct 26, 2017, 9:17:09 PM EST
 */

package hydrokinetic.technomagy.block;

import hydrokinetic.technomagy.block.tile.TileExtractor;
import hydrokinetic.technomagy.lib.LibBlockNames;
import hydrokinetic.technomagy.state.TechnomagyStateProps;
import hydrokinetic.technomagy.state.enums.ExtractorVariant;
import javax.annotation.Nonnull;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockExtractor extends BlockMod implements ITileEntityProvider {
    
    public BlockExtractor() {
        super(Material.IRON, LibBlockNames.ESPACE_EXTRACTOR);
        setHardness(5.0F);
        setSoundType(SoundType.METAL);
        setDefaultState(blockState.getBaseState().withProperty(TechnomagyStateProps.EXTRACTOR_VARIANT, ExtractorVariant.THREEDIM));
    }
    
    // This exists so that, when createBlockState is called, it knows that this
    // BlockStateContainer is supposed to hold a PropertyEnum representing the extractor variant.
    @Nonnull
    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TechnomagyStateProps.EXTRACTOR_VARIANT);
    }
    
    // Takes a blockstate, returns the metadata value that corresponds to the extractor variant.
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TechnomagyStateProps.EXTRACTOR_VARIANT).ordinal();
    }
    
    // Takes a metadata value, returns the corresponding extractor variant.
    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (meta > ExtractorVariant.values().length) {
            meta = 0;
        }
        return getDefaultState().withProperty(TechnomagyStateProps.EXTRACTOR_VARIANT, ExtractorVariant.values()[meta]);
    }
    
    // Returns the list of all variants of this block, used for adding to the creative tab.
    @Override
    public void getSubBlocks(CreativeTabs par2, NonNullList<ItemStack> par3) {
        for (int i = 0; i < 5; i++)
            par3.add(new ItemStack(this, 1, i));
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase par4EntityLivingBase, ItemStack par5ItemStack) {
        TileExtractor extractor = (TileExtractor) world.getTileEntity(pos);
        world.setBlockState(pos, getStateFromMeta(par5ItemStack.getItemDamage()), 1 | 2);
    }
    
    @Override
    public int damageDropped(IBlockState state) {
            return getMetaFromState(state);
    }
    
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 1, new ModelResourceLocation(getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 2, new ModelResourceLocation(getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 3, new ModelResourceLocation(getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 4, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileExtractor();
    }
    
    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
    @Override
    public boolean isTranslucent(IBlockState state) {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing side, float hitX, float hitY, float hitZ) {
        
        // Return true even if clientside to ensure the game knows the block activation was handles
        // and will not place a block on the client.
        return true;
    }
    
}
