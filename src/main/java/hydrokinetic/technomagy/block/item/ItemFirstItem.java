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
 * File creation date: Oct 19, 2017, 9:05:59 PM EST
 */

package hydrokinetic.technomagy.block.item;

import hydrokinetic.technomagy.Technomagy;
import net.minecraft.item.Item;

public class ItemFirstItem extends Item {
    
    public ItemFirstItem() {
        setRegistryName("firstitem");
        setUnlocalizedName(Technomagy.MODID + ".firstitem");
    }

}
