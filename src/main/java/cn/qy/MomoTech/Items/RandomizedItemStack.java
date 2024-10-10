package cn.qy.MomoTech.Items;

import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Random;

public class RandomizedItemStack extends ItemStack {
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
