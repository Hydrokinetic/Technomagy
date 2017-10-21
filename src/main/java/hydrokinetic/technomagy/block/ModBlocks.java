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
 * File creation date: Oct 19, 2017, 12:46:14 PM EST
 */

package hydrokinetic.technomagy.block;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    
    @GameRegistry.ObjectHolder("technomagy:firstblock")
    public static BlockFirstBlock firstBlock;
    
    @GameRegistry.ObjectHolder("technomagy:counter")
    public static BlockCounter counter;
    
    @GameRegistry.ObjectHolder("technomagy:palette")
    public static BlockPalette palette;
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        counter.initModel();
        palette.initModel();
        firstBlock.initModel();
    }
}
