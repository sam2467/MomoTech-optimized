package cn.qy.MomoTech.GUI;

import cn.qy.MomoTech.Items.RandomizedItemStack;
import cn.qy.MomoTech.MomoTech;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class AbstractEasyGeneratorGUI extends AbstractGUI implements RecipeDisplayItem {
    public AbstractEasyGeneratorGUI(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }
    public AbstractEasyGeneratorGUI(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe,String machineId,ItemStack output) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
        this.output=output;
        this.machineId=machineId;

    }
    ItemStack output;
    String machineId;
    @Override
    public @NotNull List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(4);
        it.add(new CustomItemStack(Material.BOOK, "§f Generates efficiency amount of item every tick"));
        if(this.output instanceof RandomizedItemStack){
            ItemStack[] list=((RandomizedItemStack)this.output).getItemStacks();
            for(int i=0;i<list.length;i++){
                it.add(list[i]);
                it.add(null);
            }
        }else{
            it.add(this.output);
        }
        return it;
    }

    @Override
    public int[] IN() {
        return new int[]{};
    }

    @Override
    public int[] OUT() {
        return new int[]{};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{8};
    }

    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    public ItemStack getOut(){
        return this.output;
    }
    @Override
    protected void findNextRecipe(BlockMenu inv) {
        inv.pushItem(getOut().clone(), getOutputSlots());
    }
    public String getMachineIdentifier(){
        return this.machineId;
    }
}
