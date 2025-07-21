package cn.qy.MomoTech.Items.Machines.BasicMachine.Machine;

import cn.qy.MomoTech.GUI.AbstractProcessMachine;
import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.utils.Maths;
import cn.qy.MomoTech.utils.SimpleOperation;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ParticleConstructor extends AbstractProcessMachine implements EnergyNetComponent, RecipeDisplayItem {

    public ParticleConstructor(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, id, it, recipeType, recipe);
    }

    @Override
    public int[] IN() {
        return new int[]{};
    }

    @Override
    public int[] OUT() {
        return new int[]{9, 17};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{0, 1, 2, 4, 6, 7, 8};
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_PARTICLE_CONSTRUCTOR";
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{};
    }

    @Override
    public int getProcessBarSlots() {
        return 5;
    }

    @Override
    public int getDefaultMaxProcess() {
        return 5;
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{10, 11, 12, 13, 14, 15, 16};
    }

    @Override
    public void add(BlockMenuPreset b) {
        b.addItem(3, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "&fStored NULL J"), ChestMenuUtils.getEmptyClickHandler());
    }

    private boolean isPrime(int i) {
        if (i == 2) return true;
        if (i < 2) return false;
        for (int j = 2; j <= (int) Math.sqrt((double) i); ++j) {
            if (i % j == 0) return false;
        }
        return true;
    }
    public ItemStack item_proton=new SlimefunItemStack("MOMOTECH_PROTON",Items.MOMOTECH_PROTON);
    public ItemStack item_zygote=new SlimefunItemStack("MOMOTECH_ZYGOTE",Items.MOMOTECH_ZYGOTE);
    @Override
    protected void findNextRecipe(BlockMenu inv) {
        int charge=this.getCharge(inv.getLocation());
        if(inv.hasViewer()){
            inv.replaceExistingItem(3, new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&fSaved " + charge + " J"));
        }
        SimpleOperation operation=this.getMachineProcessor().getOperation(inv.getLocation());
        if(operation==null){
            operation=new SimpleOperation(this.getDefaultMaxProcess());
            this.getMachineProcessor().startOperation(inv.getLocation(),operation);
        }
        operation.addRealProgress(1);
        if(inv.hasViewer()){
            inv.replaceExistingItem(this.getProcessBarSlots(),new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "§aProgress", "&f"+operation.getProgress()+"/" + operation.getTotalTicks()));
        }

        if(operation.isFinished()){
            this.getMachineProcessor().endOperation(inv.getLocation());
            operation=new SimpleOperation(Maths.GetRandom(49) + 1);
            this.getMachineProcessor().startOperation(inv.getLocation(),operation);

            if (this.isPrime(charge))
                inv.pushItem(item_proton.clone(), getOutputSlots());
            else inv.pushItem(item_zygote.clone(), getOutputSlots());
            if (charge > 1)
                this.setCharge(inv.getLocation(), charge - Maths.GetRandom(charge));
        }
    }

    @Override
    protected void tick(Block b) {
        BlockMenu inv = BlockStorage.getInventory(b);
        this.findNextRecipe(inv);
    }

    @Nonnull
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CAPACITOR;
    }

    public int getCapacity() {
        return 5000;
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> list = new ArrayList<>(10);
        list.add(new CustomItemStack(Material.BOOK, "&fRandomly cools down for 1~50 ticks after each operation"));
        list.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        list.add(new CustomItemStack(Material.BOOK, "&fOutputs a proton when the power is a prime number"));
        list.add(new SlimefunItemStack("MOMOTECH_PROTON", Items.MOMOTECH_PROTON));
        list.add(new CustomItemStack(Material.BOOK, "&fOutputs a non-prime particle when the power is a non-prime number"));
        list.add(new SlimefunItemStack("MOMOTECH_ZYGOTE", Items.MOMOTECH_ZYGOTE));
        return list;
    }
}
