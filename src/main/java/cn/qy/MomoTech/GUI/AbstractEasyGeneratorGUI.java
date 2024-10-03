package cn.qy.MomoTech.GUI;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public abstract class AbstractEasyGeneratorGUI extends AbstractGUI implements RecipeDisplayItem {
    public AbstractEasyGeneratorGUI(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    @Override
    public @NotNull List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(4);
        it.add(new CustomItemStack(Material.BOOK, "§f每 1tick 生成 效率 个对应产物"));
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

    public abstract ItemStack getOut();
    public static class RandomizedItemStack extends ItemStack{
        public ItemStack[] itemStacks;
        Random rand = new Random();
        int itemAmount=1;
        public RandomizedItemStack(ItemStack... itemStacks) {
            super(Material.AIR);
            Validate.notEmpty(itemStacks);
            this.itemStacks = itemStacks;
        }
        public RandomizedItemStack(int num,ItemStack... itemStacks) {
            super(Material.AIR);
            Validate.notEmpty(itemStacks);
            this.itemStacks = Arrays.stream(itemStacks).map(ItemStack::clone).toArray(ItemStack[]::new);
            this.itemAmount=num;
        }
        public ItemStack clone(){
            ItemStack stack= itemStacks[rand.nextInt(itemStacks.length)].clone();
            if(itemAmount!=1){
                stack.setAmount(itemAmount);
            }
            return stack;
        }
        public static RandomizedItemStack fromMaterial(Material... materials){
            Validate.notEmpty(materials);
            return new RandomizedItemStack(Arrays.stream(materials).map(ItemStack::new).toArray(ItemStack[]::new));
        }
        public static RandomizedItemStack fromMaterial(int num,Material... materials){
            Validate.notEmpty(materials);
            return new RandomizedItemStack(Arrays.stream(materials).map(m->new ItemStack(m,num)).toArray(ItemStack[]::new));
        }
    }
    @Override
    protected void findNextRecipe(BlockMenu inv) {
        inv.pushItem(getOut().clone(), getOutputSlots());
    }
}
