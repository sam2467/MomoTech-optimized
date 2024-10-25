package cn.qy.MomoTech.Items;

import cn.qy.MomoTech.MomoTech;
import io.github.thebusybiscuit.slimefun4.core.debug.Debug;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Random;

public class RandomizedItemStack extends ItemStack {
    public ItemStack[] itemStacks;
    Random rand = new Random();
    int itemAmount;
    public RandomizedItemStack(ItemStack... itemStacks) {
        super(Material.AIR);
        Validate.notEmpty(itemStacks);
        this.itemStacks = itemStacks;
        this.itemAmount = 1;
    }
    public ItemStack[] getItemStacks() {
        ItemStack[] it=new ItemStack[itemStacks.length];
        for (int i=0;i<itemStacks.length;i++){
            it[i]=itemStacks[i].clone();
            if(itemAmount!=1){
                it[i].setAmount(itemAmount);
            }
        }
        return it;
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
        return new RandomizedItemStack(num,Arrays.stream(materials).map(ItemStack::new).toArray(ItemStack[]::new));
    }

}
