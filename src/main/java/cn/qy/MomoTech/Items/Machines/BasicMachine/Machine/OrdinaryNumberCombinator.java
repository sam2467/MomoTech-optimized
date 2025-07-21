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

public class OrdinaryNumberCombinator extends AbstractGUI implements RecipeDisplayItem {
    public OrdinaryNumberCombinator(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    public static boolean check(ItemStack it) {
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_ADDITION, false, false)) return true;
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_DIVISION, false, false)) return true;
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_MULTIPLICATION, false, false)) return true;
        return SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_SUBTRACTION, false, false);
    }

    public static String check1(ItemStack it) {
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_ADDITION, false, false)) return "+";
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_DIVISION, false, false)) return "/";
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_MULTIPLICATION, false, false)) return "*";
        if (SlimefunUtils.isItemSimilar(it, Items.MOMOTECH_SYMBOL_SUBTRACTION, false, false)) return "-";
        return null;
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_ORDINARY_NUMBER_COMBINATOR";
    }

    @Override
    public int[] IN() {
        return new int[]{0, 1, 2, 3, 4, 9, 13, 18, 19, 20, 21, 22};
    }

    @Override
    public int[] OUT() {
        return new int[]{6, 7, 8, 15, 17, 24, 25, 26};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{5, 14, 23};
    }

    public int[] getInputSlots() {
        return new int[]{10, 11, 12};
    }

    public int[] getOutputSlots() {
        return new int[]{16};
    }

    private ItemStack out(String a, String b, String c) {
        double answer;
        double A = Double.parseDouble(a);
        double B = Double.parseDouble(b);
        try {
            answer = Double.parseDouble(Objects.requireNonNull(NumberCombinator.Ordinary(A, B, c)));
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
                it2 = inv.getItemInSlot(getInputSlots()[1]),
                it3 = inv.getItemInSlot(getInputSlots()[2]);
        if(it1==null||it2==null||it3==null){
            return;
        }
        if ("MOMOTECH_DIGITAL".equals(Slimefun.getItemDataService().getItemData(it1).orElseGet(()->"")))
            if ("MOMOTECH_DIGITAL".equals(Slimefun.getItemDataService().getItemData(it3).orElseGet(()->""))){
                String symbol=check1(it2);
                if (symbol!=null) {
                    ItemMeta meta1 = it1.getItemMeta(), meta2 = it3.getItemMeta();
                    List<String> lore1 = Utils.getLore(meta1);
                    List<String> lore2 = Utils.getLore(meta2);
                    ItemStack ans = out(lore1.get(0).substring(lore1.get(0).indexOf('f') + 1), lore2.get(0).substring(lore2.get(0).indexOf('f') + 1),symbol);
                    it1.setAmount(it1.getAmount()-1);
                    it2.setAmount(it2.getAmount()-1);
                    it3.setAmount(it3.getAmount()-1);
                    inv.replaceExistingItem(16,ans);
                    //inv.pushItem(ans.clone(), 16);
                }
            }
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(16);
        it.add(new CustomItemStack(Material.BOOK, "&fInput an expression to perform basic calculating operations"));
        it.add(MomotechItem.digital(0.0));
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Expression when the input expression is invalid"));
        it.add(MomotechItem.bug.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Decimal when the result has more than 4 decimal places"));
        it.add(MomotechItem.bug1.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Date when the result equals 1% of today's date represented as a number (e.g., 202407.29)"));
        it.add(MomotechItem.bug2.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Positive Overflow when the result exceeds 16,777,216"));
        it.add(MomotechItem.bug3.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fOutputs BUG - Negative Overflow when the result is less than -16,777,216"));
        it.add(MomotechItem.bug4.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fBUG - System may appear randomly, with its probability closely tied to the calculation result, number of online players, and TPS."));
        it.add(MomotechItem.bug5.clone());
        return it;
    }
}
