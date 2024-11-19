package cn.qy.MomoTech.Items.Machines.BasicMachine.InfMachine;

import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.utils.MachineUtils;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PumpkinCarver extends AbstractGUI implements RecipeDisplayItem {
    public PumpkinCarver(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_PUMPKIN_CARVER";
    }


    @Override
    public int[] IN() {
        return new int[]{0, 8};
    }

    @Override
    public int[] OUT() {
        return new int[]{9, 17, 18, 26};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{};
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{1, 2, 3, 4, 5, 6, 7};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25};
    }

    @Override
    protected void findNextRecipe(BlockMenu inv) {
        int[] inputSlot=getInputSlots();
        for(int i=0;i<inputSlot.length;i++){
            ItemStack itemToBeConsumed=inv.getItemInSlot(inputSlot[i]);
            if(itemToBeConsumed!=null){
                if(itemToBeConsumed.getType()==Material.PUMPKIN&&!itemToBeConsumed.hasItemMeta()){
                    int amount=itemToBeConsumed.getAmount();
                    ItemStack pushed=new ItemStack(Material.PUMPKIN_SEEDS,amount);
                    if((pushed=inv.pushItem(pushed,getOutputSlots()))!=null&&pushed.getAmount()==amount){
                        return;
                    }else {
                        inv.pushItem(new ItemStack(Material.CARVED_PUMPKIN,amount),getOutputSlots());
                        itemToBeConsumed.setAmount(0);
                    }
                }
            }
        }
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(12);
        it.add(new CustomItemStack(Material.BOOK, "&f自动化雕刻南瓜", "&7每 1tick 雕刻输入槽内所有的南瓜"));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(new ItemStack(Material.PUMPKIN));
        it.add(new ItemStack(Material.CARVED_PUMPKIN));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(new ItemStack(Material.PUMPKIN_SEEDS));
        return it;
    }
}
