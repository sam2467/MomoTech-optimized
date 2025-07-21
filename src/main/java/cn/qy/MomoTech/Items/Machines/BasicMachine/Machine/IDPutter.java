package cn.qy.MomoTech.Items.Machines.BasicMachine.Machine;

import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class IDPutter extends AbstractGUI implements RecipeDisplayItem {

    public IDPutter(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }


    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_ID_PUTTER";
    }

    @Override
    public int[] IN() {
        return new int[]{0, 2, 6, 8};
    }

    @Override
    public int[] OUT() {
        return new int[]{};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{3, 4, 5};
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{1, 7};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{};
    }

    @Override
    protected void findNextRecipe(BlockMenu inv) {
        for (int i : getInputSlots()) {
            if (inv.getItemInSlot(i) == null)
                return;
        }
        if (inv.getItemInSlot(1).getAmount() != 1) return;

        if (!"MOMOTECH_ID_CARD".equals(Slimefun.getItemDataService().getItemData(inv.getItemInSlot(1)).orElseGet(()->""))|| !"MOMOTECH_LETTER".equals(Slimefun.getItemDataService().getItemData( inv.getItemInSlot(7)).orElseGet(()->"")))
            return;
        String lore;
        try{
            lore = Utils.getLore(inv.getItemInSlot(1).getItemMeta()).get(0);
            lore = lore + (Utils.getLore(inv.getItemInSlot(7).getItemMeta()).get(0).charAt(2));
        }catch (Exception e){
            lore="null";
            e.printStackTrace();
        }
        SlimefunItemStack it = new SlimefunItemStack("MOMOTECH_ID_CARD", new CustomItemStack(Material.PAPER, "&eIDCard", lore, "&7Add symbol-integrated Slimefun ID in &cID Integrator", "&7Valid IDs can be used to directly craft the corresponding Slime item in the &fCrafting Station"));
        inv.consumeItem(7, 1);
        inv.toInventory().setItem(1, it.clone());
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(8);
        it.add(new CustomItemStack(Material.BOOK, "&fAdd symbol to ID Card", "&7Make sure the ID Card stack size is 1", "&7Insert the ID Card on the left and the symbol on the right"));
        it.add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        it.add(MomotechItem.letter.clone());
        it.add(new SlimefunItemStack("MOMOTECH_ID_CARD", Items.MOMOTECH_ID_CARD));
        return it;
    }
}
