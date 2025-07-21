package cn.qy.MomoTech.Items.Machines.BasicMachine.Machine;

import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CreativeItemGenerator extends AbstractGUI implements RecipeDisplayItem {
    public CreativeItemGenerator(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_CREATIVE_ITEM_GENERATOR";
    }

    @Override
    public int[] IN() {
        return new int[]{};
    }

    @Override
    public int[] OUT() {
        return new int[]{30, 32};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{27, 28, 29, 33, 34, 35};
    }
    private final int[] INPUT_SLOT={0, 1, 2, 3, 4, 5, 6, 7, 8
            , 9, 10, 11, 12, 13, 14, 15, 16, 17
            , 18, 19, 20, 21, 22, 23, 24, 25, 26};
    @Override
    public int[] getInputSlots() {
        return INPUT_SLOT;
    }
    private final int[] OUT_SLOT={31};
    @Override
    public int[] getOutputSlots() {
        return OUT_SLOT;
    }
    public ItemStack outCreative1=new CustomItemStack(MomotechItem.creative_item);
    public ItemStack outCreative2=new CustomItemStack(MomotechItem.creative_item_I);
    @Override
    protected void findNextRecipe(BlockMenu inv) {
        ItemStack now=inv.getItemInSlot(getOutputSlots()[0]);
        if(now!=null&&now.getType()!=Material.END_CRYSTAL) {
            return;
        }
        int[] inputSlots=getInputSlots();
        int[] amount=new int[inputSlots.length];
        for(int i=0;i<amount.length;i++){
            ItemStack stack=inv.getItemInSlot(inputSlots[i]);
            if(stack==null)return;
            else amount[i]=stack.getAmount();
        }
        for(int i=0;i<amount.length;i++){
            inv.getItemInSlot(inputSlots[i]).setAmount(0);
        }
        ItemStack check;
        if(amount[0]==amount[1]){
            return;
        }
        boolean is0= amount[0]<amount[1];
        for (int i = 0; i <= 26; i += 9) {
            for (int j = i ; j < i + 8; j++) {
                if (( (!is0)&&amount[j+1] > amount[j] )
                        || (is0&&amount[j+1] < amount[j])
                        || amount[j+1] == amount[j]) {
                    return;
                }
            }
        }
        inv.pushItem(is0?outCreative2.clone():outCreative1.clone(), getOutputSlots());
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(8);
        it.add(new CustomItemStack(Material.BOOK, "&fCraft Primitive Matter α", "&7Requirement: Item stack counts in each row of the input slots must decrease singularly"));
        it.add(outCreative1.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fCraft Primitive Matter β", "&7Requirement: Item stack counts in each row of the input slots must increase singularly"));
        it.add(outCreative2.clone());
        return it;
    }
}
