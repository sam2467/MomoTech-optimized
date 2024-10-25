package cn.qy.MomoTech.GUI;

import cn.qy.MomoTech.utils.Maths;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MonsterItemGenerator extends AbstractElectricGUI implements  RecipeDisplayItem {
    private Material[] it;
    protected MonsterItemGenerator(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }
    public MonsterItemGenerator(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe,Material[] its) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
        this.it=its;
    }

    @Override
    public int getCapacity() {
        return 100000;
    }

    @Override
    public int getEnergyConsumption() {
        return 15000;
    }


    @Override
    public int[] IN() {
        return new int[]{};
    }

    @Override
    public int[] OUT() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 45, 46, 47, 48, 49, 50, 51, 52, 53};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{};
    }

    @NotNull
    public String getMachineIdentifier() {
        return "MOMOTECH_MONSTER_GENERATOR0";
    }


    @Override
    public int[] getInputSlots() {
        return new int[]{};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 44, 43, 44};
    }

    public Material getItems(){
        return this.it[Maths.GetRandom(it.length-1)];
    }

    @Override
    protected boolean findNextRecipe(BlockMenu inv) {
        if (Utils.checkOutput(inv, getOutputSlots())) return false;
        inv.pushItem(new ItemStack(getItems(), 32), getOutputSlots());
        return true;
    }
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> item = new ArrayList<>();
        for (Material i : this.it) {
            item.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "&f可能的产物"));
            item.add(new ItemStack(i, 32));
        }
        return item;
    }
}
