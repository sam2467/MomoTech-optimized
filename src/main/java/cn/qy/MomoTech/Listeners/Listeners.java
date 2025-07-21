package cn.qy.MomoTech.Listeners;

import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.utils.Maths;
import com.xzavier0722.mc.plugin.slimefun4.storage.controller.ASlimefunDataContainer;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.DamageableItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Optional;

public final class Listeners implements Listener {

    @EventHandler(priority = EventPriority.MONITOR,ignoreCancelled = true)
    public void blockBreakEvent(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() != Material.WOODEN_PICKAXE) return ;
        int i = Maths.GetRandom(100);
        if (i <= 8) {
            World w = e.getBlock().getWorld();
            Location l = e.getBlock().getLocation();
            w.dropItem(l, MomotechItem.empty_shell.clone());
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST,ignoreCancelled = true)
    public void entityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player){
            ItemStack helmet=((Player) e.getEntity()).getInventory().getHelmet();
            if(helmet!=null&&!helmet.getType().isAir()){
                if(helmet.getType()==Material.TURTLE_HELMET){
                    SlimefunItem item=SlimefunItem.getByItem(helmet);

                    if (item!=null&&"MOMOTECH_PROTECT_ITEM".equals(item.getId())) {
                        if(item.isDisabled()){
                            ((Player)e.getEntity()).sendMessage("§f§lThis item has been disabled!");
                        }else {
                            e.setDamage(0);
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
        if (e.getDamager() instanceof Player){
            ItemStack hand=((Player) e.getDamager()).getInventory().getItemInMainHand();
            if(!hand.getType().isAir()){
                SlimefunItem item=SlimefunItem.getByItem(hand);
                if(item!=null){
                    if ( "MOMOTECH_DAMAGE_ITEM".equals(item.getId())) {
                        if (e.getEntity() instanceof Damageable) {
                            if(item.isDisabled()){
                                ((Player)e.getDamager()).sendMessage("§f§lThis item has been disabled!");
                            }else{
                                ((Damageable)e.getEntity()).setHealth(0.0);
                                return;
                            }
                        }
                    }else if("MOMOTECH_STONE_SWORD".equals(item.getId())) {
                        if(item.isDisabled()){
                            ((Player)e.getDamager()).sendMessage("§f§lThis item has been disabled!");
                        }
                        else{
                            e.setDamage(999999999999.99);
                            e.getEntity().setGlowing(true);
                            e.getEntity().setFreezeTicks(1000);
                            e.getEntity().setFireTicks(1000);
                        }
                    }
                }
            }
        }
    }
}
