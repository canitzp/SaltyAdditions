package de.canitzp.saltyadditions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ellpeck.actuallyadditions.items.metalists.TheFoods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author canitzp
 * @version 15.50.1
 */
@Mod(modid = SaltyAdditions.MODID, name = SaltyAdditions.NAME, version = SaltyAdditions.VERSION, dependencies = "required-after:ActuallyAdditions;required-after:SaltMod")
public class SaltyAdditions {

    public static final String MODID = "saltyadditions";
    public static final String NAME = "SaltyAdditions";
    public static final String VERSION = "R-1.7.10-15.44.1";
    public static final String UNLOCALIZEDNAME = MODID + ".";

    public static BufferedReader bufferedReader;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    SaltyAdditions.bufferedReader = new BufferedReader(new InputStreamReader(new URL("https://github.com/canitzp/SaltyAdditions/blob/master/Exclusion.txt").openStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.setDaemon(true);
        thread.setName(NAME + "Exclusion List Checker");
        TheFoods[] allFoods = TheFoods.values();
        for (TheFoods allFood : allFoods) {
            if (!isExcluded(allFood.name))
                new SaltyFood(allFood);
        }
        Logger logger = LogManager.getLogger(SaltyAdditions.NAME);
        logger.info("Loaded all successfully!");
    }

    public boolean isExcluded(final String foodName) {
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(foodName)) return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}


