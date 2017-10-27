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
 * File creation date: Oct 19, 2017, 12:03:44 PM EST
 */

package hydrokinetic.technomagy;


import hydrokinetic.technomagy.proxy.CommonProxy;
import hydrokinetic.technomagy.lib.LibGeneral;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = LibGeneral.MOD_ID, name = LibGeneral.MOD_NAME, version = LibGeneral.MOD_VERSION, dependencies = LibGeneral.DEPENDENCIES, useMetadata = true)
public class Technomagy {

    @SidedProxy(clientSide = "hydrokinetic.technomagy.proxy.ClientProxy", serverSide = "hydrokinetic.technomagy.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    public static Logger logger;
    
    @Mod.Instance
    public static Technomagy instance;
    
    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
