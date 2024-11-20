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

public class Plant extends AbstractElectricGUI implements RecipeDisplayItem {
    private final Material[] material = {Material.POTATO,
            Material.CARROT,
            Material.PUMPKIN_SEEDS,
            Material.MELON_SEEDS,
            Material.BEETROOT_SEEDS,
            Material.WHEAT_SEEDS,
            Material.BROWN_MUSHROOM,
            Material.RED_MUSHROOM,
            Material.BAMBOO,
            Material.DEAD_BUSH,
            Material.COCOA_BEANS,
            Material.SUGAR_CANE,
            Material.CACTUS,
            Material.NETHER_WART,
            Material.WITHER_ROSE,
            Material.TORCHFLOWER_SEEDS,
            Material.LILY_PAD,
            Material.VINE,
            Material.GLOW_LICHEN,
            Material.GRASS,
            Material.SWEET_BERRIES,
            Material.GLOW_BERRIES,
            Material.SEAGRASS,
            Material.KELP,
            Material.SEA_PICKLE
    };

    public Plant(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
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
        return "MOMOTECH_PLANT";
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

    public void pushIt(BlockMenu b,Material... it) {
        for (Material i : it) {
            b.pushItem(new ItemStack(i, 32), getOutputSlots());
        }
    }

    @Override
    protected boolean findNextRecipe(BlockMenu inv) {
        if (inv.getItemInSlot(0) == null) return false;
        ItemStack it = inv.getItemInSlot(0);
        if (it.getType()==Material.POTATO) {
            pushIt(inv,Material.POTATO, Material.POISONOUS_POTATO);
            return true;
        }
        else if (((it.getType()==Material.CARROT))) {
            pushIt(inv,Material.CARROT);
            return true;
        }
        else if (((it.getType()==Material.PUMPKIN_SEEDS))) {
            pushIt(inv,Material.PUMPKIN, Material.PUMPKIN_SEEDS);
            return true;
        }
        else if (((it.getType()==Material.MELON_SEEDS))) {
            pushIt(inv,Material.MELON, Material.MELON_SEEDS, Material.MELON_SLICE);
            return true;
        }
        else if (((it.getType()==Material.BEETROOT_SEEDS))) {
            pushIt(inv,Material.BEETROOT, Material.BEETROOT_SEEDS);
            return true;
        }
        else if (((it.getType()==Material.WHEAT_SEEDS))) {
            pushIt(inv,Material.WHEAT, Material.WHEAT_SEEDS);
            return true;
        }
        else if (((it.getType()==Material.BROWN_MUSHROOM))) {
            pushIt(inv,Material.BROWN_MUSHROOM, Material.BROWN_MUSHROOM_BLOCK, Material.MUSHROOM_STEM);
            return true;
        }
        else if (((it.getType()==Material.RED_MUSHROOM))) {
            pushIt(inv,Material.RED_MUSHROOM_BLOCK, Material.RED_MUSHROOM, Material.MUSHROOM_STEM);
            return true;
        }
        else if (((it.getType()==Material.BAMBOO))) {
            pushIt(inv,Material.BAMBOO);
            return true;
        }
        else if (((it.getType()==Material.DEAD_BUSH))) {
            pushIt(inv,Material.DEAD_BUSH, Material.STICK);
            return true;
        }
        else if (((it.getType()==Material.COCOA_BEANS))) {
            pushIt(inv,Material.COCOA_BEANS);
            return true;
        }
        else if (((it.getType()==Material.SUGAR_CANE))) {
            pushIt(inv,Material.SUGAR_CANE);
            return true;
        }
        else if (((it.getType()==Material.CACTUS))) {
            pushIt(inv,Material.CACTUS);
            return true;
        }
        else if (((it.getType()==Material.NETHER_WART))) {
            pushIt(inv,Material.NETHER_WART);
            return true;
        }
        else if (((it.getType()==Material.WITHER_ROSE))) {
            pushIt(inv,Material.WITHER_ROSE);
            return true;
        }
        else if (((it.getType()==Material.TORCHFLOWER_SEEDS))) {
            pushIt(inv,Material.TORCHFLOWER, Material.TORCHFLOWER_SEEDS);
            return true;
        }
        else if (((it.getType()==Material.LILY_PAD))) {
            pushIt(inv,Material.LILY_PAD);
            return true;
        }
        else if (((it.getType()==Material.VINE))) {
            pushIt(inv,Material.VINE);
            return true;
        }
        else if (((it.getType()==Material.GLOW_LICHEN))) {
            pushIt(inv,Material.GLOW_LICHEN);
            return true;
        }
        else if (((it.getType()==Material.GRASS))) {
            pushIt(inv,Material.GRASS);
            return true;
        }
        else if (((it.getType()==Material.SWEET_BERRIES))) {
            pushIt(inv,Material.SWEET_BERRIES);
            return true;
        }
        else if (((it.getType()==Material.GLOW_BERRIES))) {
            pushIt(inv,Material.GLOW_BERRIES);
            return true;
        }
        else if (((it.getType()==Material.SEAGRASS))) {
            pushIt(inv,Material.SEAGRASS);
            return true;
        }
        else if (((it.getType()==Material.KELP))) {
            pushIt(inv,Material.KELP);
            return true;
        }
        else if (((it.getType()==Material.SEA_PICKLE))) {
            pushIt(inv,Material.SEA_PICKLE);
            return true;
        }
        return false;
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(this.material.length * 2 + 1);
        for (Material t : this.material) {
            it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "&f支持的植物"));
            it.add(new ItemStack(t));
        }
        return it;
    }
}

