package cn.qy.MomoTech.GUI;

import com.xzavier0722.mc.plugin.slimefun4.storage.controller.SlimefunBlockData;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineProcessHolder;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractGUI extends SlimefunItem implements InventoryBlock {

    //private final MachineProcessor<CraftingOperation> processor = new MachineProcessor<>(this);
    protected List<MachineRecipe> recipes = new ArrayList<>();

    @ParametersAreNonnullByDefault
    protected AbstractGUI(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
        //this.processor.setProgressBar(this.getProgressBar());
        this.createPreset(this, this.getInventoryTitle(), this::constructMenu);
        this.addItemHandler(this.onBlockBreak());
    }

    protected AbstractGUI(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
       // this.processor.setProgressBar(this.getProgressBar());
        this.createPreset(this, this.getInventoryTitle(), this::constructMenu);
        this.addItemHandler(this.onBlockBreak());
        this.addItemHandler(this.onBlockPlace());
    }

    public abstract int[] IN();

    public abstract int[] OUT();

    public abstract int[] EMPTY();

    public int getMenuSize(){
        return -1;
    }
    public void createPreset(final SlimefunItem item, String title, final Consumer<BlockMenuPreset> setup) {
        BlockMenuPreset var10001 = new BlockMenuPreset(item.getId(), title) {
            public void init() {
                setup.accept(this);
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                return flow == ItemTransportFlow.INSERT ? getInputSlots() : getOutputSlots();
            }

            public boolean canOpen(Block b, Player p) {
                if (p.hasPermission("slimefun.inventory.bypass")) {
                    return true;
                } else {
                    return item.canUse(p, false) && Slimefun.getProtectionManager().hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK);
                }
            }
            public void newInstance(@Nonnull BlockMenu menu, @Nonnull Block b){
                AbstractGUI.this.newMenuInstance(menu,b);
            }
        };
    }
    public void newMenuInstance(BlockMenu menu, Block b){

    }
    @Nonnull
    protected BlockBreakHandler onBlockBreak() {
        return new BlockBreakHandler(false,false) {
            public void onPlayerBreak(BlockBreakEvent var1, ItemStack var2, List<ItemStack> var3){
                Block b=var1.getBlock();
                BlockMenu inv = BlockStorage.getInventory(b);
                if (inv != null) {
                    inv.dropItems(b.getLocation(), AbstractGUI.this.getInputSlots());
                    inv.dropItems(b.getLocation(), AbstractGUI.this.getOutputSlots());
                }
                AbstractGUI.this.onBreak(var1);
                //AbstractGUI.this.processor.endOperation(b);
            }
        };
    }
    public void onBreak(BlockBreakEvent e){

    }
    protected BlockPlaceHandler onBlockPlace() {
        return new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(@NotNull BlockPlaceEvent blockPlaceEvent) {
                AbstractGUI.this.onPlace(blockPlaceEvent);
            }
        };
    }
    public void onPlace(BlockPlaceEvent e){

    }
    //@Nonnull
    //public MachineProcessor<CraftingOperation> getMachineProcessor() {
      //  return this.processor;
  //  }

    protected void constructMenu(BlockMenuPreset preset) {
        if(getMenuSize()>0&&getMenuSize()%9==0){
            preset.setSize(getMenuSize());
        }
        int[] var2 = EMPTY();
        int var3 = var2.length;

        int var4;
        int i;
        for (var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
        }

        var2 = IN();
        var3 = var2.length;

        for (var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addItem(i, ChestMenuUtils.getInputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }

        var2 = OUT();
        var3 = var2.length;

        for (var4 = 0; var4 < var3; ++var4) {
            i = var2[var4];
            preset.addItem(i, ChestMenuUtils.getOutputSlotTexture(), ChestMenuUtils.getEmptyClickHandler());
        }
        add(preset);
    }

    public void add(BlockMenuPreset b) {
    }

    @Nonnull
    public String getInventoryTitle() {
        return this.getItemName();
    }

    public ItemStack getProgressBar() {
        return new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
    }

    public void register(@Nonnull SlimefunAddon addon) {
        this.addon = addon;

        this.registerDefaultRecipes();
        super.register(addon);

    }

    @Nonnull
    public abstract String getMachineIdentifier();

    protected void registerDefaultRecipes() {
    }

    public abstract int[] getInputSlots();

    public abstract int[] getOutputSlots();

    public void preRegister() {
        this.addItemHandler(new BlockTicker() {
            public void tick(Block b, SlimefunItem sf, SlimefunBlockData data) {
                AbstractGUI.this.tick(b);
            }

            public boolean isSynchronized() {
                return false;
            }
        });
    }

    protected void tick(Block b) {

        BlockMenu inv = BlockStorage.getInventory(b);
        this.findNextRecipe(inv);
    }

    protected abstract void findNextRecipe(BlockMenu inv);
}