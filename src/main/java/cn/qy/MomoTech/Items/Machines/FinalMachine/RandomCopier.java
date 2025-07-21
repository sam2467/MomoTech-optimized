package cn.qy.MomoTech.Items.Machines.FinalMachine;

import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.MomoTech;
import cn.qy.MomoTech.utils.CopierUtils;
import cn.qy.MomoTech.utils.Maths;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomCopier extends AbstractGUI implements RecipeDisplayItem {
    public RandomCopier(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }


    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_RANDOM_COPIER";
    }


    @Override
    public int[] IN() {
        return new int[]{45, 47};
    }

    @Override
    public int[] OUT() {
        return new int[]{51, 53};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{36, 37, 38, 39, 40, 41, 42, 43, 44, 48, 49, 50};
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{46};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{52};
    }

    int[] copierSlots = IntStream.range(0,36).toArray();

    @Override
    public int[] MOREDROP() {
        return copierSlots;
    }

    Random r = new Random();
    @Override
    protected void findNextRecipe(BlockMenu inv) {
        if (Utils.checkOutput(inv, getOutputSlots())) return;
        for (int i = 0; i < 36; i++) {
            ItemStack copied = inv.getItemInSlot(i);
            if (copied == null)
                return;
            else if(!CopierUtils.isValidItem(copied)){
                final  int index = i;
                new BukkitRunnable() {
                    public void run() {
                        inv.dropItems(inv.getLocation().clone().add(0,0.5,0),index);
                    }
                }.runTask(MomoTech.getInstance());
                return;
            }
            for (int j = 0; j < 36; j++) {
                if (inv.getItemInSlot(j) == null)
                    return;
                if (i == j) continue;
                ItemStack it = inv.getItemInSlot(i).clone(), it1 = inv.getItemInSlot(j).clone();
                it.setAmount(1);
                it1.setAmount(1);
                if (it.isSimilar(it1))
                    return;
                if (inv.getItemInSlot(i).getAmount() == inv.getItemInSlot(j).getAmount())
                    return;
            }
        }
        if (!SlimefunUtils.isItemSimilar(inv.getItemInSlot(46), MomotechItem.creative_item_II, true, false))
            return;
        int j = Math.abs(r.nextInt() % 36);
        inv.consumeItem(46, 1);
        if (Maths.GetRandom(9) != 0) return;
        ItemStack it = inv.getItemInSlot(j).clone();
        it.setAmount(1);
        inv.pushItem(it.clone(), getOutputSlots());
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(8);
        it.add(MomotechItem.creative_item_II.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fInserting Primitive Matter γ in the bottom-left slot gives a 10% chance to randomly duplicate one item from the top interaction slot.", "&7Requirement: Items in the interaction slot must all have different types and quantities."));
        return it;
    }
}
