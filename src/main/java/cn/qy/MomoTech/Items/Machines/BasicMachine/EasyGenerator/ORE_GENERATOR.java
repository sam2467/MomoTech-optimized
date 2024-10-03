package cn.qy.MomoTech.Items.Machines.BasicMachine.EasyGenerator;

import cn.qy.MomoTech.GUI.AbstractEasyGeneratorGUI;
import cn.qy.MomoTech.utils.Maths;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ORE_GENERATOR extends AbstractEasyGeneratorGUI {
    public ORE_GENERATOR(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, id, it, recipeType, recipe);
    }
    ItemStack output=RandomizedItemStack.fromMaterial(Material.DIAMOND_ORE, Material.GOLD_ORE, Material.IRON_ORE, Material.COAL_ORE, Material.COPPER_ORE,
            Material.EMERALD_ORE, Material.REDSTONE_ORE, Material.NETHER_QUARTZ_ORE, Material.NETHER_GOLD_ORE,
            Material.LAPIS_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.DEEPSLATE_IRON_ORE,
            Material.DEEPSLATE_GOLD_ORE, Material.DEEPSLATE_COAL_ORE, Material.DEEPSLATE_COPPER_ORE, Material.DEEPSLATE_DIAMOND_ORE,
            Material.DEEPSLATE_EMERALD_ORE, Material.COPPER_ORE);
    @Override
    public ItemStack getOut() {
//        Material[] list = {Material.DIAMOND_ORE, Material.GOLD_ORE, Material.IRON_ORE, Material.COAL_ORE, Material.COPPER_ORE,
//                Material.EMERALD_ORE, Material.REDSTONE_ORE, Material.NETHER_QUARTZ_ORE, Material.NETHER_GOLD_ORE,
//                Material.LAPIS_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.DEEPSLATE_IRON_ORE,
//                Material.DEEPSLATE_GOLD_ORE, Material.DEEPSLATE_COAL_ORE, Material.DEEPSLATE_COPPER_ORE, Material.DEEPSLATE_DIAMOND_ORE,
//                Material.DEEPSLATE_EMERALD_ORE, Material.COPPER_ORE
//        };
        return output;
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_ORE_GENERATOR";
    }
}
