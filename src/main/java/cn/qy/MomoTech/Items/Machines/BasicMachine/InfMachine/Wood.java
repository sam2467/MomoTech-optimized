package cn.qy.MomoTech.Items.Machines.BasicMachine.InfMachine;

import cn.qy.MomoTech.GUI.AbstractElectricGUI;
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

public class Wood extends AbstractElectricGUI implements RecipeDisplayItem {
    private final Material[] it = {Material.OAK_SAPLING,
            Material.DARK_OAK_SAPLING,
            Material.SPRUCE_SAPLING,
            Material.CHERRY_SAPLING,
            Material.ACACIA_SAPLING,
            Material.MANGROVE_PROPAGULE,
            Material.JUNGLE_SAPLING,
            Material.BIRCH_SAPLING,
            Material.WARPED_FUNGUS,
            Material.CRIMSON_FUNGUS,
    };

    public Wood(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    @Override
    public int[] IN() {
        return new int[]{1};
    }

    @Override
    public int[] OUT() {
        return new int[]{};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{};
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_WOOD";
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{0};
    }

    @Override
    public int getCapacity() {
        return 100000;
    }

    @Override
    public int getEnergyConsumption() {
        return 10000;
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{2, 3, 4, 5, 6, 7, 8};
    }

    public void pushIt( BlockMenu b,Material... it) {
        for (Material i : it) {
            b.pushItem(new ItemStack(i, 32), getOutputSlots());
        }
    }

    @Override
    protected boolean findNextRecipe(BlockMenu inv) {
        if (inv.getItemInSlot(0) == null) return false;
        ItemStack it = inv.getItemInSlot(0);
        if (((it.getType()==Material.OAK_SAPLING))) {
            pushIt(inv,Material.OAK_LEAVES, Material.OAK_LOG, Material.OAK_SAPLING, Material.APPLE, Material.STICK);
            return true;
        } else if (((it.getType()==Material.DARK_OAK_SAPLING))) {
            pushIt(inv,Material.DARK_OAK_LEAVES, Material.DARK_OAK_LOG, Material.DARK_OAK_SAPLING, Material.APPLE, Material.STICK);
            return true;
        } else if (((it.getType()==Material.SPRUCE_SAPLING))) {
            pushIt(inv,Material.SPRUCE_LEAVES, Material.SPRUCE_LOG, Material.SPRUCE_SAPLING, Material.STICK);
            return true;
        } else if (((it.getType()==Material.CHERRY_SAPLING))) {
            pushIt(inv,Material.CHERRY_LEAVES, Material.CHERRY_LOG, Material.CHERRY_SAPLING, Material.STICK);
            return true;
        } else if (((it.getType()==Material.ACACIA_SAPLING))) {
            pushIt(inv,Material.ACACIA_LEAVES, Material.ACACIA_LOG, Material.ACACIA_SAPLING, Material.STICK);
            return true;
        } else if (((it.getType()==Material.MANGROVE_PROPAGULE))) {
            pushIt(inv,Material.MANGROVE_LEAVES, Material.MANGROVE_LOG, Material.MANGROVE_PROPAGULE, Material.STICK);
            return true;
        } else if (((it.getType()==Material.JUNGLE_SAPLING))) {
            pushIt(inv,Material.JUNGLE_LEAVES, Material.JUNGLE_LOG, Material.JUNGLE_SAPLING, Material.COCOA_BEANS, Material.STICK);
            return true;
        } else if (((it.getType()==Material.BIRCH_SAPLING))) {
            pushIt(inv,Material.BIRCH_LEAVES, Material.BIRCH_LOG, Material.BIRCH_SAPLING, Material.APPLE, Material.STICK);
            return true;
        } else if (((it.getType()==Material.WARPED_FUNGUS))) {
            pushIt(inv,Material.WARPED_STEM, Material.WARPED_WART_BLOCK, Material.WARPED_HYPHAE, Material.SHROOMLIGHT);
            return true;
        } else if (((it.getType()==Material.CRIMSON_FUNGUS))) {
            pushIt(inv,Material.CRIMSON_STEM, Material.NETHER_WART_BLOCK, Material.CRIMSON_HYPHAE, Material.SHROOMLIGHT);
            return true;
        }
        return false;
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(this.it.length * 2 + 1);
        for (Material t : this.it) {
            it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "&fSupported saplings"));
            it.add(new ItemStack(t));
        }
        return it;
    }
}

