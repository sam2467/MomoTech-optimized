package cn.qy.MomoTech.Items.Machines.BasicMachine.Machine;

import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.MomoTech;
import cn.qy.MomoTech.utils.Maths;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RandomQuantumGenerator extends AbstractGUI implements RecipeDisplayItem {
    public RandomQuantumGenerator(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
        gtThread.runTaskTimerAsynchronously(MomoTech.getInstance(),20,1);
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
        return new int[]{};
    }
    public int getMenuSize(){
        return 54;
    }
    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_RANDOM_QUANTUM_GENERATOR";
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{};
    }
    public ItemStack output=new SlimefunItemStack("MOMOTECH_RANDOM_QUANTUM", Items.MOMOTECH_RANDOM_QUANTUM);
    protected ConcurrentHashMap<Chunk,ConcurrentHashMap<Location,BlockMenu>> MACHINE_POSITION=new ConcurrentHashMap<>();

    @Override
    public void onBreak(BlockBreakEvent e) {
        super.onBreak(e);
        Chunk chunk=e.getBlock().getChunk();
        ConcurrentHashMap<Location,BlockMenu> map= MACHINE_POSITION.getOrDefault(chunk,new ConcurrentHashMap<>());
        map.remove(e.getBlock().getLocation());
    }
    public void onPlace(BlockPlaceEvent e) {
        super.onPlace(e);
        Chunk chunk=e.getBlock().getChunk();
        ConcurrentHashMap<Location,BlockMenu> map= MACHINE_POSITION.getOrDefault(chunk,new ConcurrentHashMap<>());
        map.put(e.getBlock().getLocation(), BlockStorage.getInventory(e.getBlock()));
        MACHINE_POSITION.put(chunk,map);
    }
    public void newMenuInstance(BlockMenu inv, Block b){
        Chunk chunk=inv.getLocation().getChunk();
        ConcurrentHashMap<Location,BlockMenu> map= MACHINE_POSITION.getOrDefault(chunk,new ConcurrentHashMap<>());
        map.put(inv.getLocation(),inv);
        MACHINE_POSITION.put(chunk,map);
    }
    protected BukkitRunnable gtThread=new BukkitRunnable() {
        protected boolean isWorking =false;
        public void run() {
            if(isWorking){
                return;
            }
            isWorking=true;
            try{
                for (Map.Entry<Chunk,ConcurrentHashMap<Location,BlockMenu>> entry : MACHINE_POSITION.entrySet()){
                    Chunk chunk=entry.getKey();
                    if (!chunk.isLoaded()){
                        continue;
                    }
                    Iterator<Map.Entry<Location,BlockMenu>> iterator=entry.getValue().entrySet().iterator();
                    while(iterator.hasNext()){
                        Map.Entry<Location,BlockMenu> entry1=iterator.next();
                        Location loc=entry1.getKey();
                        SlimefunItem it =BlockStorage.check(loc);
                        if(it!=null){
                            tickTask(entry1.getValue());
                        }else{
                            iterator.remove();
                        }
                    }
                }
            }finally {
                isWorking=false;
            }
        }
    };
    @Override
    protected void findNextRecipe(BlockMenu inv){

    }

    protected void tickTask(BlockMenu inv) {
        if(inv.hasViewer()){
            for (int i = 0; i <= 53; ++i) {
                if (inv.getItemInSlot(i) != null) inv.consumeItem(i, inv.getItemInSlot(i).getAmount());
            }
            int i = Maths.GetRandom(53);
            inv.replaceExistingItem(i, output);
        }
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> list = new ArrayList<>(10);
        list.add(new CustomItemStack(Material.BOOK, "&f获取随机量子", "&7每tick在机器交互槽内随机出现, 并且清理交互槽内所有其他物品"));
        list.add(output.clone());
        return list;
    }
}
