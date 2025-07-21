package cn.qy.MomoTech.Items.Machines.BasicMachine.Machine;

import cn.qy.MomoTech.GUI.AbstractGUI;
import cn.qy.MomoTech.Items.Items;
import cn.qy.MomoTech.Items.MomotechItem;
import cn.qy.MomoTech.utils.Maths;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static cn.qy.MomoTech.Items.MomotechItem.*;

public class QuantityConstructor extends AbstractGUI implements RecipeDisplayItem {
    public QuantityConstructor(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, new SlimefunItemStack(id, it), recipeType, recipe);
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return "MOMOTECH_QUANTITY_CONSTRUCTOR";
    }

    @Override
    public int[] IN() {
        return new int[]{};
    }

    @Override
    public int[] OUT() {
        return new int[]{50, 48};
    }

    @Override
    public int[] EMPTY() {
        return new int[]{53, 52, 51, 47, 46, 45};
    }

    @Override
    public int[] getInputSlots() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8
                , 9, 10, 11, 12, 13, 14, 15, 16, 17
                , 18, 19, 20, 21, 22, 23, 24, 25, 26
                , 27, 28, 29, 30, 31, 32, 33, 34, 35
                , 36, 37, 38, 39, 40, 41, 42, 43, 44};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{49};
    }

    private boolean BUGChecker(BlockMenu inv) {
        boolean[] checker1 = {false, false, false, false, false, false};
        for (int i : getInputSlots()) {
            ItemStack checker = inv.getItemInSlot(i);
            if (!SlimefunUtils.isItemSimilar(checker, bug, true, false) && !SlimefunUtils.isItemSimilar(checker, bug1, true, false) && !SlimefunUtils.isItemSimilar(checker, bug2, true, false) && !SlimefunUtils.isItemSimilar(checker, bug3, true, false) && !SlimefunUtils.isItemSimilar(checker, bug4, true, false) && !SlimefunUtils.isItemSimilar(checker, bug5, true, false))
                return false;
            if (inv.getItemInSlot(i).getAmount() != 64) return false;
            if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), bug, true, false))
                checker1[0] = true;
            if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), bug1, true, false))
                checker1[1] = true;
            if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), bug2, true, false))
                checker1[2] = true;
            if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), bug3, true, false))
                checker1[3] = true;
            if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), bug4, true, false))
                checker1[4] = true;
            if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), bug5, true, false))
                checker1[5] = true;
        }
        return checker1[0] && checker1[1] && checker1[2] && checker1[3] && checker1[4] && checker1[5];
    }

    private boolean UncontrollableEmptyChecker(BlockMenu inv) {
        for (int i : getInputSlots()) {
            if (inv.getItemInSlot(i).getAmount() != 64) return false;
            if (!SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), MomotechItem.uncontrollable_empty, true, false))
                return false;
        }
        return true;
    }

    private boolean CommonCommandChecker(BlockMenu inv) {
        for (int i : getInputSlots()) {
            if (inv.getItemInSlot(i).getAmount() != 64) return false;
            ItemStack it = inv.getItemInSlot(i).clone();
            it.setAmount(1);
            if (!it.equals(new ItemStack(Material.COMMAND_BLOCK)))
                return false;
        }
        return true;
    }

    private boolean RepeatingCommandChecker(BlockMenu inv) {
        for (int i : getInputSlots()) {
            if (inv.getItemInSlot(i).getAmount() != 64) return false;
            ItemStack it = inv.getItemInSlot(i).clone();
            it.setAmount(1);
            if (!it.equals(new ItemStack(Material.REPEATING_COMMAND_BLOCK)))
                return false;
        }
        return true;
    }

    private boolean ChainCommandChecker(BlockMenu inv) {
        for (int i : getInputSlots()) {
            if (inv.getItemInSlot(i).getAmount() != 64) return false;
            ItemStack it = inv.getItemInSlot(i).clone();
            it.setAmount(1);
            if (!it.equals(new ItemStack(Material.CHAIN_COMMAND_BLOCK)))
                return false;
        }
        return true;
    }

    private boolean FinalStarChecker(BlockMenu inv) {
        for (int i : getInputSlots()) {
            if (!SlimefunUtils.isItemSimilar(MomotechItem.final_star, inv.getItemInSlot(i), true, false))
                return false;
            if (inv.getItemInSlot(i).getAmount() != 64) return false;
        }
        return true;
    }

    private boolean RuleItemChecker(BlockMenu inv) {
        for (int i : getInputSlots()) {
            if (!SlimefunUtils.isItemSimilar(new SlimefunItemStack("MOMOTECH_RESOURCE", Items.MOMOTECH_RESOURCE), inv.getItemInSlot(i), true, false))
                return false;
            if (inv.getItemInSlot(i).getAmount() != 64) return false;
        }
        return true;
    }

    private void ConsumeItems(BlockMenu inv) {
        for (int i : getInputSlots()) {
            inv.consumeItem(i, inv.getItemInSlot(i).getAmount());
        }
    }

    private boolean CreativeItemChecker(BlockMenu inv) {
        boolean[] checker = {false, false};
        for (int i : getInputSlots()) {
            if (!SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), creative_item_I, true, false) && !SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), creative_item, true, false))
                return false;
            if (inv.getItemInSlot(i).getAmount() != 64) return false;
            if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), creative_item_I, true, false))
                checker[0] = true;
            if (SlimefunUtils.isItemSimilar(inv.getItemInSlot(i), creative_item, true, false))
                checker[1] = true;
        }
        return checker[0] && checker[1];
    }

    @Override
    protected void findNextRecipe(BlockMenu inv) {
        if (Utils.checkOutput(inv, getOutputSlots())) return;
        for (int i : getInputSlots()) {
            if (inv.getItemInSlot(i) == null) {
                return;
            }
        }
        if (Utils.checkOutput(inv, getOutputSlots())) return;
        if (BUGChecker(inv)) {
            ConsumeItems(inv);
            inv.pushItem(new SlimefunItemStack(MomotechItem.bug_crystal, 1), getOutputSlots());
            return;
        }
        if (CreativeItemChecker(inv)) {
            ConsumeItems(inv);
            inv.pushItem(new SlimefunItemStack(creative__, 1), getOutputSlots());
            return;
        }
        if (UncontrollableEmptyChecker(inv)) {
            ConsumeItems(inv);
            if (Math.abs(new Random().nextInt() % 2) == 0)
                inv.pushItem(new SlimefunItemStack(creative_item_II, 1), getOutputSlots());
            return;
        }
        if (FinalStarChecker(inv)) {
            ConsumeItems(inv);
            inv.pushItem(new SlimefunItemStack(MomotechItem.final_item, 1), getOutputSlots());
            return;
        }
        if (CommonCommandChecker(inv)) {
            ConsumeItems(inv);
            inv.pushItem(new SlimefunItemStack("MOMOTECH_COMMAND_BLOCK1", Items.MOMOTECH_COMMAND_BLOCK1), getOutputSlots());
            return;
        }
        if (RepeatingCommandChecker(inv)) {
            ConsumeItems(inv);
            inv.pushItem(new SlimefunItemStack("MOMOTECH_COMMAND_BLOCK2", Items.MOMOTECH_COMMAND_BLOCK2), getOutputSlots());
            return;
        }
        if (ChainCommandChecker(inv)) {
            ConsumeItems(inv);
            inv.pushItem(new SlimefunItemStack("MOMOTECH_COMMAND_BLOCK3", Items.MOMOTECH_COMMAND_BLOCK3), getOutputSlots());
            return;
        }
        if (RuleItemChecker(inv)) {
            ConsumeItems(inv);
            inv.pushItem(new SlimefunItemStack("MOMOTECH_FINAL_RULE", Items.MOMOTECH_FINAL_RULE), getOutputSlots());
            return;
        }
        for (int i : getInputSlots()) {
            if (inv.getItemInSlot(i) == null) return;
            if (inv.getItemInSlot(i).getAmount() == 64) {
                ConsumeItems(inv);
                if (Maths.GetRandom(2000) == 0)
                    inv.pushItem(new SlimefunItemStack(quantity_item, 1), getOutputSlots());
                return;
            }
        }
    }

    @NotNull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> it = new ArrayList<>(36);
        it.add(new CustomItemStack(Material.BOOK, "&fCraft Primitive Matter γ", "&fRequirement: After filling the input slots with 45×64 uncontrollable Void, there is a 50% chance to generate."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(uncontrollable_empty.clone());
        it.add(creative_item_II.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fCraft BUG Crystal", "&fRequirement: The input slots must contain exactly 6 types of bug materials simultaneously, and the total item count must reach 45×64 to generate."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(bug.clone());
        it.add(bug_crystal.clone());
        it.add(bug1.clone());
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(bug2.clone());
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(bug3.clone());
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(bug4.clone());
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(bug5.clone());
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(new CustomItemStack(Material.BOOK, "&fCraft Pure Origin", "&fRequirement: The input slots must contain only Primitive Matter α and β simultaneously, and the total item count must reach 45×64 to generate."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(creative_item_I.clone());
        it.add(creative__.clone());
        it.add(creative_item.clone());
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(new CustomItemStack(Material.BOOK, "&fCraft Corrupted Core", "&fRequirement: Generates after 45×64 Ultimate Hearts are present in the input slots."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(final_star.clone());
        it.add(final_item.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fCraft Quantum Plugin", "&fRequirement: When the input slots contain 45×64 of any items, there is a 0.05% chance to generate."));
        it.add(quantity_item.clone());
        it.add(new CustomItemStack(Material.BOOK, "&fCraft Genesis Command Block - COMMON", "&fRequirement: Generates after 45×64 Command Blocks are present in the input slots."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(new ItemStack(Material.COMMAND_BLOCK));
        it.add(new SlimefunItemStack("MOMOTECH_COMMAND_BLOCK1", Items.MOMOTECH_COMMAND_BLOCK1));
        it.add(new CustomItemStack(Material.BOOK, "&fCraft Genesis Command Block - REPEATING", "&fRequirement: Generates after 45×64 Repeating Command Blocks are present in the input slots."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(new ItemStack(Material.REPEATING_COMMAND_BLOCK));
        it.add(new SlimefunItemStack("MOMOTECH_COMMAND_BLOCK2", Items.MOMOTECH_COMMAND_BLOCK2));
        it.add(new CustomItemStack(Material.BOOK, "&fCraft Genesis Command Block - COMMON", "&fRequirement: Generates after 45×64 Command Blocks are present in the input slots."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(new ItemStack(Material.CHAIN_COMMAND_BLOCK));
        it.add(new SlimefunItemStack("MOMOTECH_COMMAND_BLOCK3", Items.MOMOTECH_COMMAND_BLOCK3));
        it.add(new CustomItemStack(Material.BOOK, "&fConceptual Item", "&fRequirement: Generates after 45×64 items are present in the input slots."));
        it.add(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "));
        it.add(new SlimefunItemStack("MOMOTECH_RESOURCE", Items.MOMOTECH_RESOURCE));
        it.add(new SlimefunItemStack("MOMOTECH_FINAL_RULE", Items.MOMOTECH_FINAL_RULE));
        return it;
    }
}
