package de.canitzp.saltyadditions;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ellpeck.actuallyadditions.items.InitItems;
import ellpeck.actuallyadditions.items.metalists.TheFoods;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import ru.liahim.saltmod.main.SaltMod;

public class SaltyFood extends ItemFood{

    private TheFoods item;
    private IIcon[] textures;

    public SaltyFood(TheFoods foods){
        super(foods.healAmount + 2, foods.saturation + 2F, false);
        this.item = foods;
        setCreativeTab(SaltMod.LittleTab);
        setUnlocalizedName(SaltyAdditions.UNLOCALIZEDNAME + "salty" + foods.name);
        GameRegistry.registerItem(this, "salty" + foods.name);
        GameRegistry.addShapelessRecipe(new ItemStack(this), new ItemStack(SaltMod.saltPinch), new ItemStack(InitItems.itemFoods, 1, foods.ordinal()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        textures = new IIcon[2];
        textures[0] = reg.registerIcon(SaltyAdditions.MODID + ":overlay1");
        textures[1] = reg.registerIcon("actuallyadditions:itemFood" + item.name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1){
        return par1 >= textures.length ? null : textures[par1];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int meta, int pass) {
        return pass == 0 ? textures[0] : textures[1];
    }


    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return StatCollector.translateToLocal(SaltyAdditions.MODID + ".salty.name") + " " + StatCollector.translateToLocal("item.actuallyadditions.itemFood" + item.name + ".name");
    }




}
