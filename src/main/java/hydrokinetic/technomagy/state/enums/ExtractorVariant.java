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
 * File creation date: Oct 27, 2017, 1:57:30 PM EST
 */

package hydrokinetic.technomagy.state.enums;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum ExtractorVariant implements IStringSerializable {
    THREEDIM, 
    FOURDIM, 
    FIVEDIM, 
    SIXDIM,
    SEVENDIM;

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }

}
