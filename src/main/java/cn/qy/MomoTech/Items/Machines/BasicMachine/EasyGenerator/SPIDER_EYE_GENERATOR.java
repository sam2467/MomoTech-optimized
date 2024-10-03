package cn.qy.MomoTech.Items.Machines.BasicMachine.EasyGenerator;

import cn.qy.MomoTech.GUI.AbstractEasyGeneratorGUI;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SPIDER_EYE_GENERATOR extends AbstractEasyGeneratorGUI {

    public SPIDER_EYE_GENERATOR(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, id, it, recipeType, recipe);
    }
    ItemStack output=new ItemStack(Material.SPIDER_EYE, 2);
    @Override
    public ItemStack getOut() {
        return output;
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_SPIDER_EYE_GENERATOR";
    }
}

