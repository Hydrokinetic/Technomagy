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
 * File creation date: Oct 27, 2017, 2:02:33 PM EST
 */

package hydrokinetic.technomagy.state;

import hydrokinetic.technomagy.state.enums.ExtractorVariant;
import net.minecraft.block.properties.PropertyEnum;

public class TechnomagyStateProps {
    
    // BlockEStateExtractor
    public static final PropertyEnum<ExtractorVariant> EXTRACTOR_VARIANT = PropertyEnum.create("variant", ExtractorVariant.class);

}
