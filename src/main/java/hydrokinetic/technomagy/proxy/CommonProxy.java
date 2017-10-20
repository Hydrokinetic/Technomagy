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
 * File creation date: Oct 19, 2017, 12:16:04 PM EST
 */

package hydrokinetic.technomagy.proxy;

import hydrokinetic.technomagy.block.BlockFirstBlock;
import hydrokinetic.technomagy.Config;
import hydrokinetic.technomagy.Technomagy;
import hydrokinetic.technomagy.block.BlockCounter;
import hydrokinetic.technomagy.block.ModBlocks;
import hydrokinetic.technomagy.block.tile.TileCounter;
import hydrokinetic.technomagy.item.ItemFirstItem;
import java.io.File;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod.EventBusSubscriber
public class CommonProxy {
    
    public static Configuration config;
    
    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "technomagy.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {  
        event.getRegistry().register(new BlockFirstBlock());
        event.getRegistry().register(new BlockCounter());
        GameRegistry.registerTileEntity(TileCounter.class, Technomagy.MODID + "_counter");
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) { 
        event.getRegistry().register(new ItemBlock(ModBlocks.firstBlock).setRegistryName(ModBlocks.firstBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.counter).setRegistryName(ModBlocks.counter.getRegistryName()));
        event.getRegistry().register(new ItemFirstItem());
    }
}
