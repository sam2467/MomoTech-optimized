package cn.qy.MomoTech.utils;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.function.Function;
import java.util.function.Predicate;

public class MachineUtils {
    public static void consumeAndPushNullOnly(BlockMenu inv, int[] inputSlots, int[] outputSlots, Predicate<ItemStack> consumeCondition, Function<ItemStack,ItemStack> pushCondition){
        consumeAndPushNullOnly(inv,inputSlots,outputSlots,consumeCondition,pushCondition,true);
    }
    public static void consumeAndPushNullOnly(BlockMenu inv, int[] inputSlots, int[] outputSlots, Predicate<ItemStack> consumeCondition, Function<ItemStack,ItemStack> pushCondition,boolean returnAfterPushed){
        int inputlen=inputSlots.length;
        int outputlen=outputSlots.length;
        int i=0,j=0;
        ItemStack testInput;
        ItemStack testOutput;
        while(i<inputlen && j<outputlen){
            testInput=inv.getItemInSlot(inputSlots[i]);
            if(testInput==null||!consumeCondition.test(testInput)){
                i++;
                continue;
            }
            testOutput=inv.getItemInSlot(outputSlots[j]);
            if(testOutput!=null){
                j++;
                continue;
            }
            inv.replaceExistingItem(outputSlots[j],pushCondition.apply(testInput));
            if(returnAfterPushed){
                return;
            }
        }
    }
    public static void simpleProcessor(BlockMenu inv,int[] inputSlot,int[] outputSlots,ItemStack itemToBeConsumed,ItemStack itemToBePushed){
        consumeAndPushNullOnly(inv,inputSlot,outputSlots,(it)->{
            return SlimefunUtils.isItemSimilar(it,itemToBeConsumed,false,true,false);
        },(it)->{
            it.setAmount(it.getAmount()-itemToBeConsumed.getAmount());
            return itemToBePushed;
        },true);
    }
}
