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
import java.util.ArrayList;

/**
 * @author canitzp
 * @version 15.50.1
 */
@SuppressWarnings("unchecked")
@Mod(modid = SaltyAdditions.MODID, name = SaltyAdditions.NAME, version = SaltyAdditions.VERSION, dependencies = "required-after:ActuallyAdditions;required-after:SaltMod")
public class SaltyAdditions {

    public static final String MODID = "saltyadditions";
    public static final String NAME = "SaltyAdditions";
    public static final String VERSION = "R-1.7.10-15.50.1";
    public static final String UNLOCALIZEDNAME = MODID + ".";

    public static ArrayList stringArray = new ArrayList();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL("https://raw.githubusercontent.com/canitzp/SaltyAdditions/master/Exclusion.txt").openStream()));
            while ((line = bufferedReader.readLine()) != null) {
                stringArray.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        TheFoods[] allFoods = TheFoods.values();
        for (TheFoods allFood : allFoods) {
            if (!stringArray.contains(allFood.name))
                new SaltyFood(allFood);
            System.out.println(allFood.name);
        }

        System.out.println(stringArray.toString());

        Logger logger = LogManager.getLogger(SaltyAdditions.NAME);
        logger.info("Loaded all successfully!");
    }


}


