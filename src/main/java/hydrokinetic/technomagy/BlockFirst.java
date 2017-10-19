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

package hydrokinetic.technomagy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFirst extends Block {
    public BlockFirst() {
        super(Material.ROCK);
        setUnlocalizedName(Technomagy.MODID + ".firstBlock");    // Used for localization
        setRegistryName("firstBlock");
    }
}
