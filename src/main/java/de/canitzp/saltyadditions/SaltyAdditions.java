package de.canitzp.saltyadditions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ellpeck.actuallyadditions.items.metalists.TheFoods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author canitzp
 * @version 15.44.1
 */
@Mod(modid = Strings.MODID, name = Strings.NAME, version = Strings.VERSION, dependencies = "required-after:ActuallyAdditions;required-after:SaltMod")
public class SaltyAdditions {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        TheFoods[] allFoods = TheFoods.values();
        for (int i = 0; i < allFoods.length; i++){
            new SaltyFood(allFoods[i]);
        }
        Logger logger = LogManager.getLogger(Strings.NAME);
        logger.info("Loaded all successfully!");
    }

}
