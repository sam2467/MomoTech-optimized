package cn.qy.MomoTech.GUI;

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

public class RuleDustGenerator extends AbstractElectricGUI implements  RecipeDisplayItem {
    protected RuleDustGenerator(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }
    public RuleDustGenerator(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe,ItemStack output) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
        this.output=output;
    }

    @Override
    public int[] IN() {
        return new int[]{0, 8};
    }

    @Override
    public int[] OUT() {
        return new int[]{18, 26};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17};
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_SHINE_AND_DARK_CONSTRUCTOR";
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{1, 2, 3, 4, 5, 6, 7};
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
    public int[] getOutputSlots() {
        return new int[]{19, 20, 21, 22, 23, 24, 25};
    }

    @Override
    protected boolean findNextRecipe(BlockMenu inv) {
        if (Utils.checkOutput(inv, getOutputSlots())) return false;
        for (int i : getInputSlots()) {
            if (inv.getItemInSlot(i) == null) continue;
            ItemStack it = inv.getItemInSlot(i).clone();
            it.setAmount(1);
            if (it.equals(new ItemStack(Material.COBBLESTONE))) {
                inv.toInventory().setItem(i, null);
                inv.pushItem(this.getItems().clone(), getOutputSlots());
                return true;
            }
        }
        return false;
    }
    ItemStack output;
    protected ItemStack getItems(){
        return output;
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(18);
        it.add(new CustomItemStack(Material.COBBLESTONE, "§fRequires input of cobblestones","§7 Consume an ammount of cobblestones every tick to generate an ammount itmes."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        return it;
    }
}

