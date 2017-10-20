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

import hydrokinetic.technomagy.Technomagy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFirstBlock extends Block {
    
    public BlockFirstBlock() {
        super(Material.ROCK);
        setUnlocalizedName(Technomagy.MODID + ".firstblock");    // Used for localization
        setRegistryName("firstblock");
    }
}
