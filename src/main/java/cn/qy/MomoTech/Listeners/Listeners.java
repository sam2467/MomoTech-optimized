package cn.qy.MomoTech.Listeners;

import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.utils.Maths;
import com.xzavier0722.mc.plugin.slimefun4.storage.controller.ASlimefunDataContainer;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.DamageableItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
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

    @EventHandler(priority = EventPriority.HIGHEST,ignoreCancelled = true)
    public void blockBreakEvent(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE||p.isOp()) return ;
        if (p.getInventory().getItemInMainHand().getType() != Material.WOODEN_PICKAXE) return ;
        int i = Maths.GetRandom(100);
        if (i <= 3) {
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
                    Optional<String> sfid= Slimefun.getItemDataService().getItemData(helmet);
                    if (sfid.isPresent()&&"MOMOTECH_PROTECT_ITEM".equals(sfid.get())) {
                        e.setDamage(0);
                        e.setCancelled(true);
                    }
                }
            }
        }
        if (e.getDamager() instanceof Player){
            ItemStack hand=((Player) e.getDamager()).getInventory().getItemInMainHand();
            if(!hand.getType().isAir()){
                Optional<String> sfid= Slimefun.getItemDataService().getItemData(hand);
                if (sfid.isPresent()&& "MOMOTECH_DAMAGE_ITEM".equals(sfid.get())) {
                    if (e.getEntity() instanceof Damageable) {
                        ((Damageable)e.getEntity()).setHealth(0.0);
                        return;
                    }
                }else if(sfid.isPresent()&&"MOMOTECH_STONE_SWORD".equals(sfid.get())) {
                    e.setDamage(999999999999.99);
                    e.getEntity().setGlowing(true);
                    e.getEntity().setFreezeTicks(1000);
                    e.getEntity().setFireTicks(1000);
                }
            }
        }
    }
}
