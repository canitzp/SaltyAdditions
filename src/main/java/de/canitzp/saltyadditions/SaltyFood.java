package de.canitzp.saltyadditions;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import de.ellpeck.actuallyadditions.mod.items.metalists.TheFoods;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.liahim.saltmod.common.CommonProxy;
import ru.liahim.saltmod.common.ModItems;

public class SaltyFood extends ItemFood{

    public TheFoods item;
    //private IIcon[] textures;

    public SaltyFood(TheFoods foods){
        super(foods.healAmount + 2, foods.saturation + 2F, false);
        this.item = foods;
        setCreativeTab(CommonProxy.saltTab);
        setUnlocalizedName(SaltyAdditions.UNLOCALIZEDNAME + "salty" + foods.name);
        GameRegistry.registerItem(this, "salty" + foods.name);
        GameRegistry.addShapelessRecipe(new ItemStack(this), new ItemStack(ModItems.saltPinch), new ItemStack(InitItems.itemFoods, 1, foods.ordinal()));
    }

    public void init(){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, item.ordinal(), new ModelResourceLocation(SaltyAdditions.MODID + ":saltyFood", "inventory"));
    }
/*
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
*/
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return StatCollector.translateToLocal(SaltyAdditions.MODID + ".salty.name") + " " + StatCollector.translateToLocal("item.actuallyadditions.itemFood" + item.name + ".name");
    }




}
