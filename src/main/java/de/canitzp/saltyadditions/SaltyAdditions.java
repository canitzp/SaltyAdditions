package de.canitzp.saltyadditions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.ellpeck.actuallyadditions.mod.items.metalists.TheFoods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author canitzp
 * @version 16.02.1
 */
@SuppressWarnings("unchecked")
@Mod(modid = SaltyAdditions.MODID, name = SaltyAdditions.NAME, version = SaltyAdditions.VERSION, dependencies = "required-after:ActuallyAdditions;required-after:SaltMod@[1.7,)")
public class SaltyAdditions {

    public static final String MODID = "saltyadditions";
    public static final String NAME = "SaltyAdditions";
    public static final String VERSION = "R-1.7.10-16.02.1";
    public static final String UNLOCALIZEDNAME = MODID + ".";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        TheFoods[] allFoods = TheFoods.values();
        for (TheFoods allFood : allFoods) {
            new SaltyFood(allFood);
        }
        Logger logger = LogManager.getLogger(SaltyAdditions.NAME);
        logger.info("SaltyAdditions loading completed!");
    }

}


