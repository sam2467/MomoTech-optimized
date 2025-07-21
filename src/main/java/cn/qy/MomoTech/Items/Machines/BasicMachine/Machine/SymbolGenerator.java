package cn.qy.MomoTech.Items.Machines.BasicMachine.Machine;

import cn.qy.MomoTech.GUI.AbstractElectricGUI;
import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.utils.MachineUtils;
import cn.qy.MomoTech.utils.Maths;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SymbolGenerator extends AbstractElectricGUI implements RecipeDisplayItem {

    public SymbolGenerator(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    @Override
    public int getEnergyConsumption() {
        return 2000;
    }


    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_SYMBOL_GENERATOR";
    }


    @Override
    public int getCapacity() {
        return 100000;
    }

    @Override
    public int[] IN() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    }

    @Override
    public int[] OUT() {
        return new int[]{45, 46, 47, 48, 49, 50, 51, 52, 53};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};
    }

    public int[] getInputSlots() {
        return new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17};
    }

    public int[] getOutputSlots() {
        return new int[]{36, 37, 38, 39, 40, 41, 42, 43, 44};
    }

    private ItemStack out() {
        int output = Maths.GetRandom(100);
        if (output <= 20) return MomotechItem.symbol_division;
        else if (output <= 45) return MomotechItem.symbol_subtraction;
        else if (output <= 70) return MomotechItem.symbol_multiplication;
        else if (output <= 100) return MomotechItem.symbol_addition;
        else return null;

    }

    @Override
    protected boolean findNextRecipe(BlockMenu inv) {
        return MachineUtils.simpleNullonlyProcessor(inv,getInputSlots(),getOutputSlots(),Items.MOMOTECH_EMPTY_SHELL,out());
//        if (Utils.checkOutput(inv, getOutputSlots())) return false;
//        ItemStack it = out();
//        for (int i : this.getInputSlots())
//            if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), Items.MOMOTECH_EMPTY_SHELL, false, false)) {
//                for (int j : getOutputSlots()) {
//                    if (inv.getItemInSlot(j) == null) {
//                        inv.consumeItem(i, 1);
//                        if (it != null) {
//                            inv.replaceExistingItem(j, it);
//                        }
//                        return true;
//                    }
//                }
//            }
//        return false;
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(12);
        it.add(new CustomItemStack(Material.BOOK, "&fCraft operators", "&7After inputting Void, randomly outputs one operator with varying probabilities for different operators."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(MomotechItem.empty_shell.clone());
        it.add(MomotechItem.symbol_addition.clone());
        it.add(MomotechItem.empty_shell.clone());
        it.add(MomotechItem.symbol_division.clone());
        it.add(MomotechItem.empty_shell.clone());
        it.add(MomotechItem.symbol_subtraction.clone());
        it.add(MomotechItem.empty_shell.clone());
        it.add(MomotechItem.symbol_multiplication.clone());
        return it;

    }
}
