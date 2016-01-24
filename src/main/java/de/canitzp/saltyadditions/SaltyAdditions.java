package de.canitzp.saltyadditions;

import de.ellpeck.actuallyadditions.mod.items.metalists.TheFoods;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author canitzp
 * @version 16.02.1
 */
@SuppressWarnings("unchecked")
@Mod(modid = SaltyAdditions.MODID, name = SaltyAdditions.NAME, version = SaltyAdditions.VERSION, dependencies = "required-after:ActuallyAdditions@[r24,);required-after:SaltMod@[1.7,)")
public class SaltyAdditions {

    public static final String MODID = "saltyadditions";
    public static final String NAME = "SaltyAdditions";
    public static final String VERSION = "@VERSION";
    public static final String UNLOCALIZEDNAME = MODID + ".";
    public static Logger logger = LogManager.getLogger(SaltyAdditions.NAME);
    private SaltyFood[] foodArray;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        TheFoods[] allFoods = TheFoods.values();
        foodArray = new SaltyFood[allFoods.length];
        for (TheFoods allFood : allFoods) {
            foodArray[allFood.ordinal()] = new SaltyFood(allFood);
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        for (SaltyFood food : foodArray) {
            food.init();
        }
        logger.info("SaltyAdditions loading completed!");
    }

}


