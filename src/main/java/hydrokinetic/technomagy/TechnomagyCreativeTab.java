/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hydrokinetic.technomagy;

import hydrokinetic.technomagy.block.ModBlocks;
import hydrokinetic.technomagy.item.ModItems;
import hydrokinetic.technomagy.lib.LibGeneral;
import javax.annotation.Nonnull;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class TechnomagyCreativeTab extends CreativeTabs {

    public static final TechnomagyCreativeTab INSTANCE = new TechnomagyCreativeTab();
    NonNullList<ItemStack> list;

    public TechnomagyCreativeTab() {
            super(LibGeneral.MOD_ID);
    }
    
    @Nonnull
    @Override
    public ItemStack getIconItemStack() {
            return new ItemStack(ModBlocks.eSpaceExtractor);
    }

    @Override
    public ItemStack getTabIconItem() {
            return getIconItemStack();
    }

    @Override
    public void displayAllRelevantItems(@Nonnull NonNullList<ItemStack> list) {
            this.list = list;

            addBlock(ModBlocks.counter);
            addBlock(ModBlocks.eSpaceExtractor);
            addBlock(ModBlocks.house);
            
            addItem(ModItems.firstItem);
    }

    private void addItem(Item item) {
            item.getSubItems(this, list);
    }

    private void addBlock(Block block) {
            ItemStack stack = new ItemStack(block);
            block.getSubBlocks(this, list);
    }
    
}
