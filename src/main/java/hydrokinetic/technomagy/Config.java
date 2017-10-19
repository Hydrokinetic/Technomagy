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
 * File creation date: Oct 19, 2017, 12:22:22 PM EST
 */

package hydrokinetic.technomagy;

import hydrokinetic.technomagy.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {
    
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";
    
    public static boolean shouldIGoBowling = true;
    public static int favoriteNumber = 0;
    public static String whosAGoodBoy = "Dog";
    
    // Call from CommonProxy.preInit()
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        } catch (Exception e) {
            Technomagy.logger.log(Level.ERROR, "Problem loading config!", e);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }
    
    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        // cfg.getBoolean() gets value of config if specified, if not it will create value.
        shouldIGoBowling = cfg.getBoolean("goBowling", CATEGORY_GENERAL, shouldIGoBowling, "Set to false if you don't feel like going bowling.");
        favoriteNumber = cfg.getInt("favoriteNumber", CATEGORY_GENERAL, favoriteNumber, 0, 2, "set this to your favorite number (as long as it's between 0 and 2");
        whosAGoodBoy = cfg.getString("goodBoy", CATEGORY_GENERAL, whosAGoodBoy, "Set this to the name of your dog.");
    }
    
    private static void initDimensionConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
    }

}
