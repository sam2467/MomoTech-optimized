package cn.qy.MomoTech.Items.Machines.BasicMachine.Machine;

import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class NoneGenerator extends AbstractGUI implements RecipeDisplayItem {
    public NoneGenerator(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_NONE_GENERATOR";
    }


    @Override
    public int[] IN() {
        return new int[]{};
    }

    @Override
    public int[] OUT() {
        return new int[]{12, 14};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{9, 10, 11, 15, 16, 17};
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{13};
    }

    @Override
    protected void findNextRecipe(BlockMenu inv) {
        if (Utils.checkOutput(inv, getOutputSlots())) return;
        int[] inputSlots=getInputSlots();
        ItemStack[] stacks= Arrays.stream(inputSlots).mapToObj(inv::getItemInSlot).toArray(ItemStack[]::new);
        Material[] materials = new Material[stacks.length];
        ItemMeta[] metas=new ItemMeta[stacks.length];
        int[] amounts=new int[stacks.length];
        boolean pass=true;
        boolean hasNull=false;
        for(int i=0;i<stacks.length;i++){
            ItemStack stack=stacks[i];
            if(stack==null){
                hasNull=true;
                pass=false;
                break;
            }
            materials[i]=stack.getType();
            amounts[i]=stack.getAmount();

        }
        if(hasNull)return;
        Arrays.stream(inputSlots).forEach(i->inv.replaceExistingItem(i,null));
        for(int i=0;i<stacks.length;i++){

            for(int j=0;j<i;j++){
                if(amounts[j]==amounts[i]){
                    pass=false;
                    break;
                }
            }
        }
        if(pass){
            loop:
            for(int i=0;i<stacks.length;i++){
                for(int j=0;j<i;j++){
                    if(materials[j]==materials[i]){

                        if(metas[j]==null){
                            metas[j]=stacks[j].getItemMeta();
                        }
                        if (metas[i]==null){
                            metas[i]=stacks[i].getItemMeta();
                        }
                        if(Objects.equals(metas[i],metas[j])){
                            pass=false;
                            break loop;
                        }

                    }
                }
            }

            if(pass){
                inv.replaceExistingItem(getOutputSlots()[0],MomotechItem.none_);
            }
        }
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(8);
        it.add(new CustomItemStack(Material.BOOK, "&f制作NONE", "&7要求:输入槽位上所有物品种类和堆叠数量都不同"));
        it.add(MomotechItem.none_.clone());
        return it;
    }
}
