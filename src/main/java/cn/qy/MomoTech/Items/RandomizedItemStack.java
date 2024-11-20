package cn.qy.MomoTech.Items;

import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class RandomizedItemStack extends ItemStack {
    public ItemStack[] items;
    Random rand = new Random();
    public RandomizedItemStack(ItemStack... itemStacks) {
        super(Material.AIR);
        Validate.notEmpty(itemStacks);
        this.items = Arrays.stream(itemStacks).map(ItemStack::new).toArray(ItemStack[]::new);
    }
    public ItemStack[] getItemStacks() {
        ItemStack[] it=new ItemStack[items.length];
        for (int i = 0; i< items.length; i++){
            it[i]= items[i].clone();
        }
        return it;
    }
    public RandomizedItemStack(int num,ItemStack... itemStacks) {
        super(Material.AIR);
        Validate.notEmpty(itemStacks);
        this.items = Arrays.stream(itemStacks).map(ItemStack::new).peek(i->i.setAmount(num)).toArray(ItemStack[]::new);

    }
    public ItemStack clone(){
        ItemStack stack= items[rand.nextInt(items.length)].clone();
        return stack;
    }
    public ItemStack getInstance(){
        ItemStack stack= items[rand.nextInt(items.length)];
        if(stack instanceof RandomizedItemStack){
            return ((RandomizedItemStack)stack).getInstance();
        }else {
            return stack;
        }
    }
    public static RandomizedItemStack fromMaterial(Material... materials){
        Validate.notEmpty(materials);
        return new RandomizedItemStack(Arrays.stream(materials).map(ItemStack::new).toArray(ItemStack[]::new));
    }
    public static RandomizedItemStack fromMaterial(int num,Material... materials){
        Validate.notEmpty(materials);
        return new RandomizedItemStack(num,Arrays.stream(materials).map(ItemStack::new).toArray(ItemStack[]::new));
    }

}
