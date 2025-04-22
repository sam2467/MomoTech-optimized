package cn.qy.MomoTech.Items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.DistinctiveItem;
import me.matl114.matlib.utils.CraftUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.invoke.VarHandle;
import java.util.Objects;

public class DistinctiveSlimefunItem extends SlimefunItem implements DistinctiveItem {
    public DistinctiveSlimefunItem(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe){
        super(itemGroup, item, recipeType, recipe);
    }

    public boolean canStack(ItemMeta meta1,ItemMeta meta2){
        return CraftUtils.matchLoreField(meta1,meta2);// Objects.equals(meta1.lore(),meta2.lore());
    }
}
