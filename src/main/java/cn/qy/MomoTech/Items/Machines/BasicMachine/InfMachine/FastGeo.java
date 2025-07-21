package cn.qy.MomoTech.Items.Machines.BasicMachine.InfMachine;

import cn.qy.MomoTech.GUI.AbstractElectricGUI;
import cn.qy.MomoTech.utils.MachineUtils;
import cn.qy.MomoTech.utils.Maths;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FastGeo extends AbstractElectricGUI implements RecipeDisplayItem {

    public FastGeo(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    @Override
    public int[] IN() {
        return new int[]{0, 1, 2, 3, 5, 6, 7, 8};
    }

    @Override
    public int getCapacity() {
        return 100000;
    }

    @Override
    public int getEnergyConsumption() {
        return 1000;
    }

    @Override
    public int[] OUT() {
        return new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17, 36, 37, 38, 39, 40, 41, 42, 43, 44};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{};
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_FAST_GEO";
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{4};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};
    }
    List<ItemStack> GEOResources=new ArrayList<>();
    public List<ItemStack> getGeoResources() {
        if(GEOResources==null||GEOResources.isEmpty()){
            for (GEOResource resource : Slimefun.getRegistry().getGEOResources().values()) {
                if (resource.isObtainableFromGEOMiner()) {
                    GEOResources.add(resource.getItem());
                }
            }
        }
        return GEOResources;
    }
    @Override
    protected boolean findNextRecipe(BlockMenu inv) {
        if (Utils.checkOutput(inv, getOutputSlots())) return false;
        for (int i : getInputSlots()) {
            ItemStack it = inv.getItemInSlot(i);
            if (it != null) {
                if (it.getType()==Material.NETHERITE_PICKAXE&&!it.hasItemMeta()) {
                    List<ItemStack> item = getGeoResources();
                    ItemStack output = item.get(Maths.GetRandom(item.size() - 1));
                    for (int j : getOutputSlots()) {
                        if (inv.getItemInSlot(j) == null) {
                            inv.pushItem(output.clone(), getOutputSlots());
                            it.setAmount(0);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(4);
        it.add(new CustomItemStack(Material.NETHERITE_PICKAXE, "&fRequires Netherite Pickaxe", "&7Mines natural resources once every tick, ignoring biome and weight"));
        it.add(new CustomItemStack(Material.BOOK, "&fAny registered geo resource"));
        return it;
    }
}

