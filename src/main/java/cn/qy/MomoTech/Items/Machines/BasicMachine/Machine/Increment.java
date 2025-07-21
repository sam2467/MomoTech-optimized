package cn.qy.MomoTech.Items.Machines.BasicMachine.Machine;

import cn.qy.MomoTech.Exceptions;
import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.utils.NumberCombinator;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Increment extends AbstractGUI implements RecipeDisplayItem {

    public Increment(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }


    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_INCREMENT";
    }

    @Override
    public int[] IN() {
        return new int[]{0, 1, 2, 3, 4, 5, 9, 11, 12, 14, 18, 19, 20, 21, 22, 23};
    }

    @Override
    public int[] OUT() {
        return new int[]{6, 7, 8, 15, 17, 24, 25, 26};
    }

    @Override
    public int[] EMPTY() {
        return new int[0];
    }

    public int[] getInputSlots() {
        return new int[]{10, 13};
    }

    public int[] getOutputSlots() {
        return new int[]{16};
    }

    private ItemStack out(String b, String a) {
        double answer;
        double A = Double.parseDouble(a);
        double B = Double.parseDouble(b);
        try {
            answer = Double.parseDouble(Objects.requireNonNull(NumberCombinator.Ordinary(A, B, "+")));
            return MomotechItem.digital(answer);
        } catch (Exceptions.NumberBugException e) {
            //输出NUMBER_BUG
            return MomotechItem.bug;
        } catch (Exceptions.NumberBugIException e) {
            //输出NUMBER_BUG_I
            return MomotechItem.bug1;
        } catch (Exceptions.NumberBugIIException e) {
            //输出NUMBER_BUG_II
            return MomotechItem.bug2;
        } catch (Exceptions.NumberBugIIIException e) {
            //输出NUMBER_BUG_III
            return MomotechItem.bug3;
        } catch (Exceptions.NumberBugIVException e) {
            //输出NUMBER_BUG_IV
            return MomotechItem.bug4;
        } catch (Exceptions.NumberBugVException e) {
            //输出NUMBER_BUG_V
            return MomotechItem.bug5;
        }

    }

    protected void findNextRecipe(BlockMenu inv) {
        if(inv.getItemInSlot(16)!=null){
            return;
        }
        ItemStack it1 = inv.getItemInSlot(getInputSlots()[0]),
                it2 = inv.getItemInSlot(getInputSlots()[1]);
        if(it1==null||it2==null){
            return;
        }
        if ("MOMOTECH_DIGITAL".equals(Slimefun.getItemDataService().getItemData(it1).orElseGet(()->null)))
            if ("MOMOTECH_DIGITAL".equals(Slimefun.getItemDataService().getItemData(it2).orElseGet(()->null))) {
                ItemMeta meta1 = it1.getItemMeta(), meta2 = it2.getItemMeta();
                List<String> lore1 = Utils.getLore(meta1);
                List<String> lore2 = Utils.getLore(meta2);
                ItemStack ans = out(lore1.get(0).substring(lore1.get(0).indexOf('f') + 1), lore2.get(0).substring(lore2.get(0).indexOf('f') + 1));
                it1.setAmount(it1.getAmount() - 1);
                it2.setAmount(it2.getAmount() - 1);
                inv.replaceExistingItem(16,ans);
            }
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(16);
        it.add(new CustomItemStack(Material.BOOK, "&fInput two numbers to perform simple addition"));
        it.add(MomotechItem.digital(0.0));
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Expression when the input expression is invalid"));
        it.add(MomotechItem.bug.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Decimal when the result has more than 4 decimal places"));
        it.add(MomotechItem.bug1.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Date when the result equals 1% of today’s date represented as a number (e.g., 202407.29)"));
        it.add(MomotechItem.bug2.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Positive Overflow when the result exceeds 16,777,216"));
        it.add(MomotechItem.bug3.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Negative Overflow when the result is less than -16,777,216"));
        it.add(MomotechItem.bug4.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fBUG - System may appear randomly, with its probability closely related to the calculation result, online player count, and TPS."));
        it.add(MomotechItem.bug5.clone());
        return it;
    }
}
