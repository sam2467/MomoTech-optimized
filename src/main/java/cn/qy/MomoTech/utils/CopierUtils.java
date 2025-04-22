package cn.qy.MomoTech.utils;

import cn.qy.MomoTech.MomoTech;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.BundleMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Set;

public class CopierUtils {
    public static boolean isValidItem(ItemStack item){
        if(item==null||!item.hasItemMeta()){
            return true ;
        }
        ItemMeta meta = item.getItemMeta();
        if(MomoTech.isDisableCopierDupeStorage()){
            if(meta instanceof BlockStateMeta ){
                BlockStateMeta blockState= (BlockStateMeta) meta;
                if(blockState.hasBlockState()){
                    return false;
                }
            }
            if(meta instanceof BundleMeta){
                return false;
            }
            PersistentDataContainer container = meta.getPersistentDataContainer();
            Set<NamespacedKey> keys=container.getKeys();
            keys.remove(Slimefun.getItemDataService().getKey());
            keys.removeIf(k->k.getNamespace().equals(Slimefun.getItemDataService().getKey().getNamespace())||k.getNamespace().equals(MomoTech.getInstance().getName()));
            if(!keys.isEmpty()){
                return false;
            }
        }
        String sfid = Slimefun.getItemDataService().getItemData(meta).orElse(null);
        if(sfid!=null&&MomoTech.getCopierBlacklist().contains(sfid)) {
            return false;
        }
        return true;

    }
//    public static boolean isValidPdc(PersistentDataContainer container){
//
//    }
}
