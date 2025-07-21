package cn.qy.MomoTech.Items.Machines.BasicMachine.InfMachine;

import cn.qy.MomoTech.GUI.AbstractElectricGUI;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.utils.MachineUtils;
import cn.qy.MomoTech.utils.Maths;
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

public class RuleShineAndDarkConstructor extends ShineAndDarkConstructor implements RecipeDisplayItem {
    public RuleShineAndDarkConstructor(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, id,it, recipeType, recipe);
        this.threshold=51;
    }

    @Override
    public int[] IN() {
        return new int[]{0, 2};
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
        return "MOMOTECH_RULE_SHINE_AND_DARK_CONSTRUCTOR";
    }


    @Override
    public int getCapacity() {
        return 100000;
    }

    @Override
    public int getEnergyConsumption() {
        return 5000;
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{1};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{3, 4, 5, 6, 7, 8};
    }

    //@Override
//    protected boolean findNextRecipe(BlockMenu inv) {
//        if (Utils.checkOutput(inv, getOutputSlots())) return false;
//        for (int i : getInputSlots()) {
//            if (inv.getItemInSlot(i) == null) continue;
//            ItemStack it = inv.getItemInSlot(i);
//            if (it.getType()==Material.NETHERITE_PICKAXE&&!it.hasItemMeta()) {
//                inv.replaceExistingItem(i, null,false);
//                int k = inv.getLocation().getBlockY();
//                if (Maths.GetRandom(1) == 0) {
//                    if (k < 0) {
//                        inv.pushItem(MomotechItem.dark.clone(), getOutputSlots());
//                        return true;
//                    } else if (k > 256) {
//                        inv.pushItem(MomotechItem.shine.clone(), getOutputSlots());
//                        return true;
//                    }
//                } else {
//                    inv.pushItem(MomotechItem.empty_shell.clone(), getOutputSlots());
//                    return true;
//                }
//                return false;
//            }
//        }
//
//        return false;
//    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(18);
        it.add(new CustomItemStack(Material.NETHERITE_PICKAXE, "&fRequires Netherite Pickaxe", "&750% chance to appear when machine y level is below 0"));
        it.add(MomotechItem.dark.clone());
        it.add(new CustomItemStack(Material.NETHERITE_PICKAXE, "&fRequires Netherite Pickaxe", "&750% chance to appear when machine y level is above 256"));
        it.add(MomotechItem.shine.clone());
        return it;
    }
}
