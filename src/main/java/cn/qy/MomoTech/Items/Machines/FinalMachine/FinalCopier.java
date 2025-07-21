package cn.qy.MomoTech.Items.Machines.FinalMachine;

import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.MomoTech;
import cn.qy.MomoTech.utils.CopierUtils;
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
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FinalCopier extends AbstractGUI implements RecipeDisplayItem {
    public FinalCopier(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_FINAL_COPIER";
    }

    @Override
    public int[] IN() {
        return new int[]{0, 2};
    }

    @Override
    public int[] OUT() {
        return new int[]{8, 6};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{3, 5};
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{1};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{7};
    }

    @Override
    public int[] MOREDROP(){
        return new int[]{4};
    }

    @Override
    protected void findNextRecipe(BlockMenu inv) {
        if (Utils.checkOutput(inv, getOutputSlots())) return;
        if (inv.getItemInSlot(4) == null) return;
        if (inv.getItemInSlot(1) == null) return;
        if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(1), MomotechItem.quantum1_, true)) {
            ItemStack copied = inv.getItemInSlot(4);
            if(!CopierUtils.isValidItem(copied)){
                new BukkitRunnable() {
                    public void run() {
                        inv.dropItems(inv.getLocation().clone().add(0,0.5,0),4);
                    }
                }.runTask(MomoTech.getInstance());
                return;
            }
            inv.consumeItem(1, 1);
            ItemStack it = copied.clone();
            it.setAmount(1);
            inv.pushItem(it.clone(), getOutputSlots());
        }
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(4);
        it.add(MomotechItem.quantum1_);
        it.add(new CustomItemStack(Material.BOOK, "&fInput Entangled Quantum to duplicate any item in the center interaction slot"));
        return it;
    }
}
