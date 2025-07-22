package cn.qy.MomoTech.Items;

import cn.qy.MomoTech.Group.MultiGroup;
import cn.qy.MomoTech.Group.SubGroup;
import cn.qy.MomoTech.MomoTech;
import cn.qy.MomoTech.NullEnchantment.Register;
import cn.qy.MomoTech.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Items {
    interface string {
        String str();
    }
    public static String c(String s, String... s1) {
        StringBuilder ans = new StringBuilder();
        for (int x1 = 0; x1 < s1.length; x1++) {
            if (s1[x1].length() == 1) {
                ans.append("§");
                ans.append(s1[x1]);
                ans.append(s.charAt(x1));
                continue;
            }
            ans.append("§x");
            for (char i : s1[x1].toCharArray()) {
                ans.append("§").append(i);
            }
            ans.append(s.charAt(x1));
        }
        return ans.toString();
    }
    public static String c(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '#') {
                sb.append('x');
                i++;
                if (i >= s.length()) break;
                for (int count = 0; count < 6; i++, count++) {
                    sb.append('§').append(s.charAt(i));
                }
            }
            if (i >= s.length()) break;
            sb.append(s.charAt(i));

        }
        return sb.toString();
    }
    public static final ItemStack QUANTITY_ITEM = new CustomItemStack(Material.PURPLE_DYE, c("Quantification Plugin", "748d8d", "858c9b", "978ca9", "a88bb8"), "&6Just a material");
    public static final ItemStack FROG_LIGHT_GENERATOR = new CustomItemStack(Material.OCHRE_FROGLIGHT, "&eFroglight Generator", "&7Randomly generates a type of froglight", "&7Efficiency: 4x");
    public static final ItemStack STONE_GENERATOR = new CustomItemStack(Material.STONE, "&eStone &fGenerator", "&7Automates production of stone types/cobblestone/deepslate cobblestone", "&7Efficiency: 8x");
    public static final ItemStack ORE_GENERATOR = new CustomItemStack(Material.DIAMOND_ORE, "&eRaw Ore &fGenerator", "&7Automates production of various raw ores", "&7Efficiency: 1x");
    public static final ItemStack SAND_GENERATOR = new CustomItemStack(Material.SANDSTONE, "&eSand &fGenerator", "&7Automates red sand/sand/gravel/soul sand", "&7Efficiency: 8x");
    public static final ItemStack STONE_GENERATOR_I = new CustomItemStack(Material.COBBLESTONE, "&eDirect Cobblestone &fGenerator", "&7Automates cobblestone production", "&7Efficiency: 8x");
    public static final ItemStack GLASS_GENERATOR = new CustomItemStack(Material.GLASS, "&eDirect Glass &fGenerator", "&7Automates glass production", "&7Efficiency: 8x");
    public static final ItemStack TEMPLATE_GENERATOR = new CustomItemStack(Material.MELON, "&eTemplate &fGenerator", "&7Randomly generates high version templates", "&7Efficiency: 1x");
    public static final ItemStack FISH_GENERATOR = new CustomItemStack(Material.SEA_LANTERN, "&eAuto Fisher", "&7Randomly generates various fish", "&7Efficiency: 1x");
    public static final ItemStack DUST_GENERATOR = new CustomItemStack(Material.SAND, "&eOre Dust &fGenerator", "&7Randomly produces various ore dusts", "&7Efficiency: 6x");
    public static final ItemStack STONES_GENERATOR = new CustomItemStack(Material.SNOW_BLOCK, "&6Stone Block &fGenerator", "&7Automates stone block production", "&7Efficiency: 8x");
    public static final ItemStack ICE_GENERATOR = new CustomItemStack(Material.BLUE_ICE, "&eIce &fGenerator", "&7Automates ice production", "&7Efficiency: 1x");
    public static final ItemStack Generator = new CustomItemStack(Material.ORANGE_CONCRETE_POWDER, c("§#b98bc6Gene§#cb8ad4ra§#dc8ae2tor"), "§8⇨ §e⚡ §76,000 J/t");
    public static final ItemStack LINE_GENERATOR = new CustomItemStack(Material.GRAY_WOOL, "&eString &fGenerator", "&7Automates string production", "&7Efficiency: 3x");
    public static final ItemStack COMMAND_BLOCK_GENERATOR = new CustomItemStack(Material.POLISHED_BLACKSTONE, "&b&lCommand Block Generator", "&7&lWhat? Command Blocks???", "&7Efficiency: 1x");
    public static final ItemStack C_GENERATOR = new CustomItemStack(Material.COAL_BLOCK, "&eCarbon &fGenerator", "&7Early game carbon problem solved!", "&7Efficiency: 1x");
    public static final ItemStack CREATIVE__ = new CustomItemStack(Material.GLASS_PANE, c("Pure Origin", "ed89f0", "e98ef6", "da94f7", "ca9bf8", "bba2fa"), "&6Ultimate, this is just the beginning");
    public static final ItemStack COMMAND_BLOCK_GETTER = new CustomItemStack(Material.COMMAND_BLOCK, c("Replica", "aca9fb", "9cb0fc", "8db6fb") + " &7- " + c("Command Block", "7fc6ee", "7ccde1", "79d5d5", "77ddc9"));
    public static final ItemStack COBBLE_STONE_GENERATOR_II = new CustomItemStack(Material.SNOW_BLOCK, "&b&lCompressed Cobblestone Generator", "&7Efficiency: 64x");
    public static final ItemStack MOMOTECH_DIGITAL = new CustomItemStack(SlimefunUtils.getCustomHead("80c4528e622bd318720d38e0e4599e69bf23308f89693920e0e4ecb55d1c0bac"), "§fDigital Component", "§f0.0");
    public static final ItemStack MOMOTECH_LETTER = new CustomItemStack(Material.SUGAR, c("Symbol", "74e5bd", "71edb0"), "&fa", "&7Foundation for creating matter from nothing");
    public static final ItemStack MOMOTECH_ID_CARD = new CustomItemStack(Material.PAPER, c("§#6ef5a4I§#73f5a2D §#78f6a0Card"), "&fID:", "&7Add symbols to integrate Slimefun ID in &cID Integrator", "&7Valid IDs can directly craft corresponding Slimefun items in the &fCrafting Station");
    public static final ItemStack MOMOTECH_ID_PUTTER = new CustomItemStack(Material.BOOKSHELF, c("§#7ef69eI§#83f79cD §#88f79aInt§#8df798egr§#92f896ator"), "&7Add characters to ID card here");
    public static final ItemStack MOMOTECH_LETTER_CONSTRUCTOR = new CustomItemStack(Material.BEEHIVE, c("§#fccc98Sym§#f9c4a6bol §#f7bcb4Int§#f4b3c2egr§#f2abd0ator"));
    public static final ItemStack MOMOTECH_FINAL_STAR = new CustomItemStack(Material.HONEYCOMB, c("§#9df991Ulti§#acfa8cmate §#bafb86Co§#c8fc81re"), "&7Condensed here");
    public static final ItemStack MOMOTECH_ID_CHANGER = new CustomItemStack(Material.GLASS, c("§#d6fc7cCraf§#e4fd76ting §#f3fe71Station"), "&7&lInsert valid ID card to directly output Slimefun items based on ID", "&7Can create &lany&7 Slimefun item through this", "&7Such as FinalTech's Phony item (FINALTECH_PHONY)");
    public static final ItemStack MOMOTECH_UNCONTROLLABLE_EMPTY_GENERATOR = new CustomItemStack(Material.DEEPSLATE_LAPIS_ORE, c("§#fcf769Un§#fde05bcon§#fdc94etro§#fdb241llable §#fe9b34Vo§#fe8326id §#ff6c19Generator"), "&7Late-game mass production base for uncontrollable void..", "&7Rate: 48x");
    public static final ItemStack MOMOTECH_RANDOM_COPIER = new CustomItemStack(Material.DEEPSLATE_EMERALD_ORE, c("§#ff550cRan§#ff6c2ddom§#ff834e §#ff9b6fCop§#ffb291ier §#ffc9b2"));
    public static final ItemStack MOMOTECH_FINAL_COPIER = new CustomItemStack(Material.DEEPSLATE_GOLD_ORE, c("§#ffe0d3Cop§#fff7f4ier §#efefef- §#d6d6d6End§#bebebe§#a5a5a5game"), "&cParticle Integration!");
    public static final ItemStack MOMOTECH_EXP = new CustomItemStack(Material.EXPERIENCE_BOTTLE, c("§#8c8c8cExp §#747474Exp §#5b5b5band §#4d4d4dMore §#535353Ex§#595959per§#5f5f5fie§#656464nce"), "&7Instantly gain 20 levels when thrown");
    public static final ItemStack MOMOTECH_FINAL_ITEM = new CustomItemStack(Material.FERN, c("§#b2d3d3Code §#acd8d1Co§#a5decere §#9fe3cc"), "&8&lOmnipresent", "&8&lEndgame - Epic Item");
    public static final ItemStack SEA_ITEM_GENERATOR = new CustomItemStack(Material.PRISMARINE, "&b&lPrismarine &fGenerator", "&7Automates prismarine item production", "&7Efficiency: 8x");
    public static final ItemStack BEE_GENERATOR = new CustomItemStack(Material.BEE_NEST, "&6&lBee &fGenerator", "&7Automates production of various bee-related items", "&7Efficiency: 1x");
    public static final ItemStack SPIDER_EYE_GENERATOR = new CustomItemStack(Material.SPAWNER, "&7&lSpider Eye &fGenerator", "&7Automates spider eye production, might be useful in Supreme", "&7Efficiency: 2x");
    public static final ItemStack MOMOTECH_ORE_COLLECTOR = new CustomItemStack(Material.DEEPSLATE_COAL_ORE, c("§#849985Ding§#8baa8cDing§#91bb93~ §#98cd9bAuto§#9edea2mated §#a5efaaComp§#aff6adressed §#bbf7aeOre §#c7f9afCol§#d3fab0lector!"), "&7Randomly generates a type of triple compressed ore");
    public static final ItemStack MOMOTECH_EMPTY_SHELL = new CustomItemStack(Material.STRUCTURE_VOID, "§7Void", "&fI really don't understand why this thing is an important material!", "§f§lNULL");
    public static final ItemStack MOMOTECH_SYMBOL_ADDITION = new CustomItemStack(Material.BLAZE_POWDER, "§aSymbol +", "§f+");
    public static final ItemStack MOMOTECH_SYMBOL_SUBTRACTION = new CustomItemStack(Material.BLAZE_POWDER, "§aSymbol -", "§f-");
    public static final ItemStack MOMOTECH_SYMBOL_MULTIPLICATION = new CustomItemStack(Material.BLAZE_POWDER, "§aSymbol x", "§f*");
    public static final ItemStack MOMOTECH_SYMBOL_DIVISION = new CustomItemStack(Material.BLAZE_POWDER, "§aSymbol ÷", "§f/");
    public static final ItemStack MOMOTECH_NONE = new CustomItemStack(new ItemStack(Material.BLACK_WOOL), c("§#dffbb1N§#ebfdb2O§#f7feb3N§#fffdb7E"), "§7A piece of void");
    public static final ItemStack MOMOTECH_NUMBER_BUG = new CustomItemStack(new ItemStack(Material.WHITE_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aFormula", "&7&lBUG Matter");
    public static final ItemStack MOMOTECH_NUMBER_BUG_I = new CustomItemStack(new ItemStack(Material.RED_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aDecimal", "&7&lBUG Matter");
    public static final ItemStack MOMOTECH_NUMBER_BUG_II = new CustomItemStack(new ItemStack(Material.ORANGE_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aDate", "&7&lBUG Matter");
    public static final ItemStack MOMOTECH_NUMBER_BUG_III = new CustomItemStack(new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aPositive Overflow", "&7&lBUG Matter");
    public static final ItemStack MOMOTECH_NUMBER_BUG_IV = new CustomItemStack(new ItemStack(Material.GREEN_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aNegative Overflow", "&7&lBUG Matter");
    public static final ItemStack MOMOTECH_NUMBER_BUG_V = new CustomItemStack(new ItemStack(Material.BLUE_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aSystem", "&7&lBUG Matter");
    public static final ItemStack MOMOTECH_DIGITAL_CONSTRUCTOR = new CustomItemStack(SlimefunUtils.getCustomHead("f26dad74b2bab105cb68c94eb3be32f5dbda42eab944b6ed9e803136f8f619bc"), "§x§a§4§b§3§b§fDigital Constructor", "§7Converts §lVoid §7into digital components", "&8Seems to only produce some basic numbers...", "§8⇨ §e⚡ §72,000 J/t");
    public static final ItemStack MOMOTECH_SYMBOL_GENERATOR = new CustomItemStack(SlimefunUtils.getCustomHead("f26dad74b2bab105cb68c94eb3be32f5dbda42eab944b6ed9e803136f8f619bc"), "§x§a§4§b§3§b§fSymbol Generator", "§7Generates symbols from §lVoid", "§8⇨ §e⚡ §72,000 J/t");
    public static final ItemStack MOMOTECH_INCREMENT = new CustomItemStack(new ItemStack(Material.CREEPER_HEAD), c("§#fdf7c1Inc§#fcf1ccrem§#faebd6enter"));
    public static final ItemStack MOMOTECH_ORDINARY_NUMBER_COMBINATOR = new CustomItemStack(Material.SKELETON_SKULL, c("§#f9e6e0Bas§#f8e0eaic §#f6daf4Cal§#f5d4fecul§#f6cdfeator"));
    public static final ItemStack MOMOTECH_EMPTY_SHELL_GENERATOR = new CustomItemStack(Material.BLACK_CONCRETE_POWDER, c("§#f8c7feVoid §#f9c0feGen§#fab9ffer§#fcb3ffator"), "&7Finally made it... hands-free!", "&6Efficiency: 8x");
    public static final ItemStack MOMOTECH_EMPTY_SHELL_GENERATOR_I = new CustomItemStack(Material.WHITE_CONCRETE_POWDER, c("§#fdacffVoid §#ffa5ffGen§#ff9ef1er§#ff96ddator §#ff8ec8Plus §#ff86b4Edi§#ff7ea0tion"), "&7No input needed, produces more void!", "&6Efficiency: 64x");
    public static final ItemStack MOMOTECH_CREATIVE_ITEM = new CustomItemStack(Material.END_CRYSTAL, c("§#ff768bPri§#ff6e77mal §#ff6c64Mat§#ff7556ter §#ff7e48α"), "&7Seems very useful, but it's just a basic material...");
    public static final ItemStack MOMOTECH_CREATIVE_ITEM_I = new CustomItemStack(Material.END_CRYSTAL, c("§#ff8739Pri§#ff8f2bmal §#ff981dMat§#ffa10eter §#ffaa00β"), "&7Seems very useful, but it's just a basic material...");
    public static final ItemStack MOMOTECH_CREATIVE_ITEM_GENERATOR = new CustomItemStack(Material.COBBLESTONE, c("§#fff085Pri§#fffb9bmal §#faffaaMat§#f3ffb7ter §#ebffc4Gen§#e4ffd1er§#ddffddator"));
    public static final ItemStack MOMOTECH_UNCONTROLLABLE_EMPTY = new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "§8§l§k123&f&lUncontrollable Void");
    public static final ItemStack CreativeGenerator = new CustomItemStack(new ItemStack(Material.BLACK_WOOL), c("§#d5ffeaCra§#cefff7zy §#c8fef6Gen"), "§8⇨ §e⚡ §799,999,999 J/t");
    public static final ItemStack MOMOTECH_NONE_GENERATOR = new CustomItemStack(new ItemStack(Material.DIRT), c("§#c7fadbN§#c5f6c0O§#c4f2a5N§#c2ee8bE §#c0eb70Gen§#bfe755er§#bde33aator"), "&7Good early-game source of &8&lNONE&7...");
    public static final ItemStack MOMOTECH_CREATIVE_ITEM_II = new CustomItemStack(Material.END_CRYSTAL, c("§#ffb616Pri§#ffc12cmal §#ffcd42Mat§#ffd858ter §#ffe46eγ"), "&7A step further...");
    public static final ItemStack MOMOTECH_QUANTITY_CONSTRUCTOR = new CustomItemStack(Material.HONEY_BLOCK, c("§#addf4eQuan§#9ddb63tum §#8ed777Con§#7ed38bstru§#6ecfa0ctor"));
    public static final ItemStack MOMOTECH_BUG_CRYSTAL = new CustomItemStack(Material.NETHER_STAR, c("§#5ecbb4B§#4ec7c8U§#45c6c1G §#40c6adCry§#3ac699stal"), "&7&lCrystallized BUG essence");
    public static final ItemStack QY = new CustomItemStack(new ItemStack(Material.COMMAND_BLOCK), "&6&lQYhB05", "&7The BUG Creator...", "&7Wrote most of this addon's spaghetti code, one of the founders", "&7Amateur code enthusiast");
    public static final ItemStack wbx = new CustomItemStack(new ItemStack(Material.COMMAND_BLOCK), "&e&lChenmose", "&7So cute~", "&7Provided some ideas, one of the founders", "&8&lI won't tell you they got lazy after early game");
    public static final ItemStack sky = new CustomItemStack(new ItemStack(Material.COMMAND_BLOCK), "&a&lskybule", "&7Provided interesting ideas and helped with testing", "&7Provided great help and support to the author!");
    public static final ItemStack plugin = new CustomItemStack(new ItemStack(Material.PAPER), "&f&lThis addon is called MomoTech, also known as Random Tech!", "&bThis is an open source project, thanks for your support. For modifications or bug reports, please contact the author", "&6&lDiscussion QQ Group: 827684043");
    public static final ItemStack BUGGGGG = new CustomItemStack(new ItemStack(Material.ENDER_CHEST), "&f&lBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG", "&8Author is just a middle school amateur coder, please don't flame us, welcome to provide feedback on QQ");
    public static final ItemStack ELSE_1 = new CustomItemStack(Material.PAPER, "&fFeature: No Power", "&7All machines that don't specify power usage don't consume energy");
    public static final ItemStack ELSE_2 = new CustomItemStack(Material.PAPER, "&fFeature: Empty Slots Only", "&7Some machines only work when the output slot has space");
    public static final ItemStack ELSE_3 = new CustomItemStack(Material.PAPER, "&fFeature: Bug - Date", "&7If your calculator result equals a date and doesn't output Bug - Date, try adding +0 to that number component");
    public static final ItemStack FULL = new CustomItemStack(new ItemStack(Material.EGG), c("§#35c684Sat§#2fc670ur§#29c65cat§#24c648ion"), "&bAlways hungry? Can't afford other stuff early game? Use me!", "&bRight-click to consume and instantly gain saturation");
    public static final ItemStack DAMAGE_ITEM = new CustomItemStack(new ItemStack(Material.CHAIN_COMMAND_BLOCK), c("§#29c73aStr§#44ca39ange §#5fce38Obj§#7ad137ect §#94d436(§#afd736?)"), "&6&lOne-hit kill! Direct elimination!");
    public static final ItemStack[][] Mineral = new ItemStack[9][5];
    public static final ItemStack STONE_SWORD = new CustomItemStack(Material.DIAMOND_SWORD, "&7&lSword of Victory's Oath", "&8Sword in stone...", "&8Can deal massive damage", "&8Damage +999999999999.99");
    public static final ItemStack FINAL_C_ = new CustomItemStack(Material.COBBLESTONE, c("§#e5de345§#c7df3d0x §#a8df47Com§#8ae050pre§#6be15assed §#4de163Cob§#2fe26cble§#10e376sto§#10db7bne §#1ecf7dGen"), "&7&lYes, you heard right", "&fWho knows, might be useful", "&7Efficiency: 8x");
    public static final ItemStack PROTECT_ITEM = new CustomItemStack(new ItemStack(Material.TURTLE_HELMET), c("§#2dc380Pro§#3bb883tec§#49ac85tion"), "&aWear on head for entity attack immunity!", "&8Doesn't include burning, falling, etc", "&7Don't ask why it's green");
    public static final ItemStack STAR_OF_ALL = new CustomItemStack(Material.HEART_OF_THE_SEA, c("§#58a088All§#66948ain§#6e8989One §#678080Co§#607777re"), "&6&lUsed to craft most all-in-one machines in this addon");
    public static final ItemStack MOMOTECH_COBBLE_STONE_STORE = new CustomItemStack(Material.GLASS, c("§#5a6e6eSto§#536566ne §#4c5c5dSto§#465354rage"), "&7Provides 54 slots of storage", "&7Even cobblestone can be chests now, yay!");
    public static final ItemStack MOMOTECH_COBBLESTONE_GENERATOR_FINAL = new CustomItemStack(Material.SLIME_BLOCK, c("§#3f4a4bAnti§#485351-Ent§#525c58ropy §#5b655eMi§#656f64ner"), "&7Produces 48 stacks per tick, that's how productive it is!");
    public static final ItemStack MOMOTECH_QUANTUM = new CustomItemStack(Material.SNOWBALL, "&eQuan&6tum", "&fRight-clicking might cause some bad things to happen");
    public static final ItemStack MOMOTECH_QUANTUM1 = new CustomItemStack(Material.MAGMA_CREAM, "&aEnt&bang&eled &eQuan&6tum", "&fParticles entangled with quantum, right-clicking might also cause some bad things to happen", "&fUsed in high-precision high-speed communication machines");
    public static final ItemStack MOMOTECH_BOX_OF_QUANTUM = new CustomItemStack(Material.CHEST, "&aQuan&etum &6Box", "&7Stabilized quantum, uses quantum for item storage in machines", "&fRight-click to use quantum to open ender chest");
    public static final ItemStack MOMOTECH_SILK_TOUCH_PICKAXE = new CustomItemStack(Material.NETHERITE_PICKAXE, "&bEnt&6ang&eled &eQuan&6tum &cPickaxe", "&fA special tool");
    public static final ItemStack MOMOTECH_PICKAXE = new CustomItemStack(Material.NETHERITE_PICKAXE, "&eQuan&6tum &cPickaxe", "&fA special tool", "&eFaster &fmining speed", "&8Right-click to accelerate");
    public static final ItemStack MOMOTECH_PUMPKIN_CARVER = new CustomItemStack(Material.CARVED_PUMPKIN, c("§#a4b3bfPump§#a7bac1kin §#aac1c3Car§#adc7c6ver §#b0cec8Spe§#b3d5caced §#b6dcccUp"), "&fAutomatically carves pumpkins for you", "&7Efficiency: INFINITY");
    public static final ItemStack MOMOTECH_CLEAR = new CustomItemStack(Material.NETHERITE_INGOT, c("§#b9e3ceQuan§#bfe6cbtum §#c6e7c5Cle§#cde9bfan§#d4eabaer"), "&7&lHelps remove attribute effects from your body", "&8Mainly targets quantum item effects");
    public static final ItemStack MOMOTECH_FIXER = new CustomItemStack(Material.IRON_BLOCK, c("§#dcebb4Equip§#e3edaement §#eaeea8Rep§#efeda0air§#f1e694er"), "&7Automatically repairs your equipment");
    public static final ItemStack MOMOTECH_TRANSPORTER = new CustomItemStack(Material.PISTON, "&aTransporter");
    public static final ItemStack CHEST_GENERATOR = new CustomItemStack(Material.JUNGLE_LOG, "&6Chest &fGenerator", "&7Efficiency: 1x");
    public static final ItemStack MOMOTECH_OPEN_BOX_ITEM = new CustomItemStack(Material.PURPLE_STAINED_GLASS, c("§#f6ca63Box §#f7c356Open§#f8bc4aer"), "&7Unbox it!", "&7Can disassemble quantum boxes, but only entangled quantum can be preserved...");
    public static final ItemStack MOMOTECH_SHINE = new CustomItemStack(Material.GLOWSTONE_DUST, "&fLight");
    public static final ItemStack MOMOTECH_DARK = new CustomItemStack(Material.GUNPOWDER, "&8Dark");
    public static final ItemStack MOMOTECH_SHINE_AND_DARK_CONSTRUCTOR = new CustomItemStack(Material.GLOWSTONE, c("§#55ffffLi§#6ffef6ght §#88fdeeDa§#a2fce5rk §#bbfbddGen"), "§8⇨ §e⚡ §7500 J/t");
    public static final ItemStack MOMOTECH_SHINE_AND_DARK_GENERATOR = new CustomItemStack(Material.REDSTONE_LAMP, c("§#d5fad4Light §#eefaccDark §#fef9c5Pow§#fbf7c2er §#f8f6bfGen"), "&7Extract energy from light and dark...", "§8⇨ §e⚡ §720,000 J/t");
    public static final ItemStack MOMOTECH_SHINE1 = new CustomItemStack(Material.GLOWSTONE_DUST, "&f&lLight Factor");
    public static final ItemStack MOMOTECH_DARK1 = new CustomItemStack(Material.GUNPOWDER, "&8&lDark Factor");
    public static final ItemStack MOMOTECH_NETHERITE_PICKAXE_CHANGER = new CustomItemStack(Material.BLACK_STAINED_GLASS, c("§#f5f5bcNet§#f3f4b9her§#f0f3b6ite §#edf1b3Pick§#ebf2b0axe §#e9f3acCon§#e7f3a9ver§#e5f4a5ter"), "§8⇨ §e⚡ §7100 J/t");
    public static final ItemStack DIAMOND_PICKAXE_GENERATOR = new CustomItemStack(Material.DIAMOND_BLOCK, "&bDiamond Pickaxe &fGenerator", "&7Efficiency: 8x");
    public static final ItemStack MOMOTECH_CONSTRUCTOR = new CustomItemStack(Material.CHISELED_POLISHED_BLACKSTONE, c("§#e3f5a2Con§#e1f69eden§#dff79bser"), "&7Condenses essences into one", "§8⇨ §e⚡ §7900 J/t");
    public static final ItemStack MOMOTECH_DIAMOND = new CustomItemStack(Material.DIAMOND, "&6Mineral Essence &f- &bDiamond");
    public static final ItemStack MOMOTECH_IRON = new CustomItemStack(Material.IRON_INGOT, "&6Mineral Essence &f- &bIron");
    public static final ItemStack MOMOTECH_GOLD = new CustomItemStack(Material.GOLD_INGOT, "&6Mineral Essence &f- &bGold");
    public static final ItemStack MOMOTECH_QUARTZ = new CustomItemStack(Material.QUARTZ, "&6Mineral Essence &f- &bQuartz");
    public static final ItemStack MOMOTECH_EMERALD = new CustomItemStack(Material.EMERALD, "&6Mineral Essence &f- &bEmerald");
    public static final ItemStack MOMOTECH_REDSTONE = new CustomItemStack(Material.REDSTONE, "&6Mineral Essence &f- &bRedstone");
    public static final ItemStack MOMOTECH_LAPIS = new CustomItemStack(Material.LAPIS_LAZULI, "&6Mineral Essence &f- &bLapis Lazuli");
    public static final ItemStack MOMOTECH_COAL = new CustomItemStack(Material.COAL, "&6Mineral Essence &f- &bCoal");
    public static final ItemStack MOMOTECH_Cu = new CustomItemStack(Material.BRICK, "&6Metal Essence &f- &bCopper");
    public static final ItemStack MOMOTECH_Pb = new CustomItemStack(Material.IRON_INGOT, "&6Metal Essence &f- &bLead");
    public static final ItemStack MOMOTECH_Mg = new CustomItemStack(Material.IRON_INGOT, "&6Metal Essence &f- &bMagnesium");
    public static final ItemStack MOMOTECH_Au = new CustomItemStack(Material.GOLD_INGOT, "&6Metal Essence &f- &bGold");
    public static final ItemStack MOMOTECH_Al = new CustomItemStack(Material.IRON_INGOT, "&6Metal Essence &f- &bAluminum");
    public static final ItemStack MOMOTECH_Sn = new CustomItemStack(Material.IRON_INGOT, "&6Metal Essence &f- &bTin");
    public static final ItemStack MOMOTECH_Zn = new CustomItemStack(Material.IRON_INGOT, "&6Metal Essence &f- &bZinc");
    public static final ItemStack MOMOTECH_Ag = new CustomItemStack(Material.IRON_INGOT, "&6Metal Essence &f- &bSilver");
    public static final ItemStack MOMOTECH_DIAMOND1 = new CustomItemStack(Material.DIAMOND, "&6Mineral Core &f- &bDiamond");
    public static final ItemStack MOMOTECH_IRON1 = new CustomItemStack(Material.IRON_INGOT, "&6Mineral Core &f- &bIron");
    public static final ItemStack MOMOTECH_GOLD1 = new CustomItemStack(Material.GOLD_INGOT, "&6Mineral Core &f- &bGold");
    public static final ItemStack MOMOTECH_QUARTZ1 = new CustomItemStack(Material.QUARTZ, "&6Mineral Core &f- &bQuartz");
    public static final ItemStack MOMOTECH_EMERALD1 = new CustomItemStack(Material.EMERALD, "&6Mineral Core &f- &bEmerald");
    public static final ItemStack MOMOTECH_REDSTONE1 = new CustomItemStack(Material.REDSTONE, "&6Mineral Core &f- &bRedstone");
    public static final ItemStack MOMOTECH_LAPIS1 = new CustomItemStack(Material.LAPIS_LAZULI, "&6Mineral Core &f- &bLapis Lazuli");
    public static final ItemStack MOMOTECH_COAL1 = new CustomItemStack(Material.COAL, "&6Mineral Core &f- &bCoal");
    public static final ItemStack MOMOTECH_Cu1 = new CustomItemStack(Material.BRICK, "&6Metal Core &f- &bCopper");
    public static final ItemStack MOMOTECH_Pb1 = new CustomItemStack(Material.IRON_INGOT, "&6Metal Core &f- &bLead");
    public static final ItemStack MOMOTECH_Mg1 = new CustomItemStack(Material.IRON_INGOT, "&6Metal Core &f- &bMagnesium");
    public static final ItemStack MOMOTECH_Au1 = new CustomItemStack(Material.GOLD_INGOT, "&6Metal Core &f- &bGold");
    public static final ItemStack MOMOTECH_Al1 = new CustomItemStack(Material.IRON_INGOT, "&6Metal Core &f- &bAluminum");
    public static final ItemStack MOMOTECH_Sn1 = new CustomItemStack(Material.IRON_INGOT, "&6Metal Core &f- &bTin");
    public static final ItemStack MOMOTECH_Zn1 = new CustomItemStack(Material.IRON_INGOT, "&6Metal Core &f- &bZinc");
    public static final ItemStack MOMOTECH_Ag1 = new CustomItemStack(Material.IRON_INGOT, "&6Metal Core &f- &bSilver");
    public static final ItemStack MOMOTECH_REAL_MAGNET = new CustomItemStack(Material.IRON_BLOCK, c("§#e2f096Now §#e5ea92This §#e9e38dis §#ecdd89a §#efd784Pro§#f2d080per §#f5ca80Mag§#f6c387net§#f8bc8e!"));
    public static final ItemStack MOMOTECH_ELECTRICITY_MAGNET = new CustomItemStack(Material.GOLD_BLOCK, c("§#fab695Now §#fbaf9dThis §#fda8a4is §#ffa2aba §#fa9facPro§#f39dabper §#ed9caaElec§#e69aa9tro§#df98a8mag§#d897a7net!"));
    public static final ItemStack MOMOTECH_IRON_STAR = new CustomItemStack(Material.GLASS_BOTTLE, "&f&lIron Core");
    public static final ItemStack MOMOTECH_COIL = new CustomItemStack(Material.STRING, c("§#d295a6Co§#d59daeil"));
    public static final ItemStack MOMOTECH_MAGNETIZE = new CustomItemStack(Material.IRON_BLOCK, c("§#d8a5b5Mag§#dbadbcnet§#deb5c3izer"), "&7This is a more reasonable way to make magnets!", "§8⇨ §e⚡ §7200 J/t");
    public static final ItemStack MOMOTECH_MAGNET_GENERATOR = new CustomItemStack(Material.WHITE_STAINED_GLASS, c("§#e0bdcaAll§#e3c5d2-in§#e4c9d8-One §#e0c6deEle§#ddc3e3ctro§#d9c0e8mag§#d6bdeenet§#d2bbf3ic §#cfb8f9Gen§#c8b4f2"), "§8⇨ §e⚡ §7500 J/t");
    public static final ItemStack MOMOTECH_INFINITY = new CustomItemStack(Material.NETHERITE_SCRAP, "&cRule &eIngot");
    public static final ItemStack MOMOTECH_FAST_GEO = new CustomItemStack(Material.NETHERITE_BLOCK, c("§#c0afe6High§#b9abdb-Speed §#b1a7d0Geo§#a9a2c5log§#a19eb9ical §#9a9bafRes§#9aa2abour§#9aaaa8ce §#9ab2a5Min§#99baa1er"), "§8⇨ §e⚡ §710,000 J/t");
    public static final ItemStack MOMOTECH_ORDINARY_GENERATOR = new CustomItemStack(Material.GLASS, c("§#99c29eBas§#99ca9bic §#9fce99Gen§#add099er§#bad19aator"), "§8⇨ §e⚡ §7500 J/t");
    public static final ItemStack MOMOTECH_MINERAL_ = new CustomItemStack(Material.NETHERITE_INGOT, "&6Mineral Core");
    public static final ItemStack MOMOTECH_METAL_ = new CustomItemStack(Material.IRON_INGOT, "&eMetal Core");
    public static final ItemStack FLINT_GENERATOR = new CustomItemStack(Material.DEEPSLATE_GOLD_ORE, "&6Flint &fGenerator", "&7Efficiency: 4x");
    public static final ItemStack MOMOTECH_RULE_STAR = new CustomItemStack(Material.IRON_NUGGET, "&cTime &6Shard");
    public static final ItemStack MOMOTECH_FINAL_RULE = new CustomItemStack(Material.BONE_MEAL, "&3Con&bcept &aMatter");
    public static final ItemStack MOMOTECH_ENERGY_INGOT = new CustomItemStack(Material.NETHERITE_INGOT, c("§#c8d29aRad§#d6d39aio§#e3d49bact§#f1d59bive §#e5d3a4Cha§#d2d1afrged Ingot"));
    public static final ItemStack MOMOTECH_RESOURCE = new CustomItemStack(Material.COMMAND_BLOCK, "&a&lResource", "&7Strongly supported this addon and promoted it extensively");
    public static final ItemStack MOMOTECH_COMMAND_BLOCK1 = new CustomItemStack(Material.COMMAND_BLOCK, "&6Genesis Command Block - COMMON");
    public static final ItemStack MOMOTECH_COMMAND_BLOCK2 = new CustomItemStack(Material.REPEATING_COMMAND_BLOCK, "&6Genesis Command Block - REPEATING");
    public static final ItemStack MOMOTECH_COMMAND_BLOCK3 = new CustomItemStack(Material.CHAIN_COMMAND_BLOCK, "&6Genesis Command Block - CHAIN");
    public static final ItemStack MOMOTECH_RULE_ITEM = new CustomItemStack(Material.REDSTONE_TORCH, c("§#bfcebbGen§#abccc6esis §#98cad1Gear§#85c7dd"));
    public static final ItemStack MOMOTECH_EFFECT_DELETER = new CustomItemStack(Material.IRON_INGOT, c("§#74c5e7Sta§#73c9e5tus §#72cde4Eff§#71d0e2ect §#70d4e1Cle§#6fd7dfarer"), "&7Right-click to clear potion effects");
    public static final ItemStack MOMOTECH_THROW = new CustomItemStack(Material.GOLD_INGOT, c("§#6edbdeInv§#6bdddcent§#63dddbtory §#5cdedaEje§#55ded9ctor"), "&7Right-click to throw out all items", "&8Including armor");
    public static final ItemStack MOMOTECH_RULE_SHINE_AND_DARK_CONSTRUCTOR = new CustomItemStack(Material.GLOWSTONE, c("§#4eded8Rule §#47dfd6Light §#3fdfd5& Dark §#39dcbeColl§#34d8a2ect§#2ed486or §#28d169"), "&7Greatly increased probability...", "§8⇨ §e⚡ §75,000 J/t");
    public static final ItemStack MOMOTECH_ENTROPY_RECONSTRUCT = new CustomItemStack(Material.BLACK_CONCRETE, c("§#23cd4dAnti§#1dc930-Ent§#1dc71aropy §#40d02cRecon§#62d83dstructor"), "&7To be honest, it's a bit slow..", "§8⇨ §e⚡ §7500 J/t");
    public static final ItemStack MOMOTECH_RULE_RECONSTRUCT = new CustomItemStack(Material.BLACK_CONCRETE, c("§#85e14eRule §#a8e960Recon§#caf271struc§#edfb82tor §#f9fc90"), "&7So fast?", "§8⇨ §e⚡ §75,000 J/t");
    public static final ItemStack MOMOTECH_RULE_MACHINE_STAR = new CustomItemStack(Material.BLACK_CONCRETE, c("§#85e14eRule §#8ede68Mach§#98dc82ine §#a1d99bComp§#abd7b5one§#b4d4cfnt"));
    public static final ItemStack MOMOTECH_SHINE_AND_DARK_INGOT = new CustomItemStack(Material.FLINT, c("§#b9d2ceLight §#c2d2ca& Dark §#cad1c7Com§#d3d0c3pos§#dbcfc0ite"));
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR1 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directional &f- &bAl", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR2 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directional &f- &bMg", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR3 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directional &f- &bCu", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR4 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directional &f- &bAu", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR5 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directional &f- &bAg", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR6 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directional &f- &bPb", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR7 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directional &f- &bSn", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR8 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directional &f- &bZn", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR9 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directional &f- &bFe", "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_U_GENERATOR = new CustomItemStack(Material.GREEN_CONCRETE_POWDER, c("§#be63d9Rule§#cb6ad8 Uranium§#d871d8 §#e577d7Refiner§#f27ed7§#ff85d6"), "&7Efficiency: 64x", "§8⇨ §e⚡ §75,000 J/t");
    public static final ItemStack MOMOTECH_RULE_GEO = new CustomItemStack(Material.NETHERITE_BLOCK, c("§#e4cfbc§#eacdbaEndgame§#e7c9c0 Geo§#e4c5c5logical§#e1c1cb §#ddbcd0Resource§#dab8d6 §#d7b4dbMiner§#cfafd7"), "&7Efficiency: 16x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_CREATIVE_GENERATOR = new CustomItemStack(Material.BOOKSHELF, c("§#c4a9cbPrimal§#b9a3be Matter§#ae9cb1 §#a396a4Generator§#999098 §#8e8a8b§#9b9697Type§#aca5a7 α§#bdb5b7β§#cec4c8"), "&7Consumes large amounts of power to generate", "&7Randomly generates one Primal Matter α or β per tick", "&7It's really making me cry...", "§8⇨ §e⚡ §7100,000 J/t");
    public static final ItemStack MOMOTECH_RULE_REACTOR = new CustomItemStack(Material.DIAMOND_ORE, c("§#dfd3d8High§#f0e3e8-Speed§#fdeff5 Fission§#faf2f2 §#f7f4f0Reactor"), "&7Efficiency: 8x", "§8⇨ §e⚡ §75,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Overworld Mob Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM1 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Fish Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM2 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Piglin Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM3 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Enderman Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM4 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Creeper Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM5 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Drowned Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM6 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Animal Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM7 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Slime Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM8 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Blaze Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM9 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Magma Cube Farm Simulator", "&7Efficiency: 32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_CONSTRUCTOR = new CustomItemStack(Material.CHISELED_POLISHED_BLACKSTONE, "&6Rule " + c("§#e3f5a2Con§#e1f69eden§#dff79bser"), "&7Efficiency: 16x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MINERAL_GENERATOR = new CustomItemStack(Material.BLUE_CONCRETE_POWDER, c("§#f3f7eeRule§#f0f9ec §#edfbe9Ore§#eafee7 Generator"), "&7Efficiency: 64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MINERAL_BLOCK_GENERATOR = new CustomItemStack(Material.GILDED_BLACKSTONE, c("§#eafee6Rule§#edfde5 §#f1fce4Mineral§#f4fae3 Block§#f8f9e2 §#fbf8e1Col§#fff6e0lector"), "&7Efficiency: 16x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_PLANT = new CustomItemStack(Material.CHISELED_DEEPSLATE, c("§#ffefdc§#ffe7d7Plant§#ffdfd2 §#ffd6cdCulti§#ffcec9vator"), "&7Insert plant seeds or items like lily pads, vines, grass, etc", "&7Efficiency: 32x", "§8⇨ §e⚡ §710,000 J/t");
    public static final ItemStack MOMOTECH_WOOD = new CustomItemStack(Material.CHISELED_DEEPSLATE, c("§#ffc6c4Tree§#fec2c1 §#f7cac4Culti§#f1d2c7va§#eadacator"), "&7Insert saplings or nether fungi", "&7Efficiency: 32x", "§8⇨ §e⚡ §710,000 J/t");
    public static final ItemStack MOMOTECH_ENERGY_QUANTUM = new CustomItemStack(Material.SLIME_BALL, "&cHigh &eEnergy &bQuan&atum", "&7Dangerous, High Energy!");
    public static final ItemStack MOMOTECH_RANDOM_QUANTUM = new CustomItemStack(Material.CLAY_BALL, "&eRan&bdom &aQuan&3tum", "&7Random~", "&7Right-click to die");
    public static final ItemStack MOMOTECH_RANDOM_QUANTUM_GENERATOR = new CustomItemStack(Material.GRAY_WOOL, c("§#e4e2cdRandom§#ddead0 §#d7f3d3Quantum§#d4f7d8 §#d5f8deGen§#d6f9e5er§#d6fbebator"));
    public static final ItemStack MOMOTECH_ENERGY_QUANTUM_GENERATOR = new CustomItemStack(Material.WHITE_WOOL, c("§#d7fcf2Quantum§#d7fef8 §#d8fffeCharg§#ddffffing §#e3ffffStation"), "§8⇨ §e⚡ &7500,000 J/t");
    public static final ItemStack MOMOTECH_FINAL_INGOT_GENERATOR = new CustomItemStack(Material.GRAY_CONCRETE, c("§#e9ffffEnd§#efffff§#f5ffffgame §#fbffffIngot §#fffbfdForge"), "&7Efficiency: INFINITY");
    public static final ItemStack MOMOTECH_FINAL_GENERATOR = new CustomItemStack(Material.EMERALD_BLOCK, c("§#ffa7d8End§#ff97d0game §#ff92bbPow§#ff969cer §#ff9a7dGen"), "§8⇨ §e⚡ &7800,000,000 J/t");
    public static final ItemStack MOMOTECH_FINAL_CAPITAL = new CustomItemStack(Material.YELLOW_STAINED_GLASS, c("§#ffeaf6End§#ffd9eegame §#ffc9e7Power §#ffb8dfCapacitor"), "&7Not recommended to use two in one power network", "&7Can store §8⇨ §e⚡ &72,000,000,000 J");
    public static final ItemStack MOMOTECH_FINAL_ELECTRIC_EATER = new CustomItemStack(Material.BLUE_STAINED_GLASS, c("§#ff9e5eCos§#ffa23fmic §#ffa621Power §#ffaa02Con§#f6b40asumer"), "&7Uses cosmic energy to consume power...", "§8⇨ §e⚡ &72,000,000,000 J/t");
    public static final ItemStack MOMOTECH_ITEM_FIXER = new CustomItemStack(Material.ORANGE_CONCRETE_POWDER, c("§#ebbf15Item §#e1ca1fRe§#d7d52astor§#cddf35at§#c3ea3fion"), "&7Reset Slimefun items");
    public static final ItemStack MOMOTECH_RULE_BOOTS = new CustomItemStack(Material.NETHERITE_BOOTS, "&7Endgame Boots", "&bRadiation Immune", "&bBee Immune", "&bSaturation", "&bFire Resistant", "&bRegeneration", "&bWater Breathing", "&bResistance II", "&bHaste II", "&bSpeed I", "&bHaste II", "&bJump Boost I", "&bSoul Bound");
    public static final ItemStack MOMOTECH_RULE_PICKAXE = new CustomItemStack(Material.DIAMOND_PICKAXE, "&7Endgame Pickaxe");
    public static final ItemStack MOMOTECH_LOOTER = new CustomItemStack(Material.GLASS_PANE, "&7&lSealed - Evoker", "&8Right-click to open");
    public static final ItemStack MOMOTECH_FOREVER = new CustomItemStack(Material.BLUE_DYE, c("§#b9f24eEter§#b0f265nal §#a7f27cPar§#9ef293ticle"), "&7Forever...");
    public static final ItemStack MOMOTECH_FOREVER_ = new CustomItemStack(Material.DIAMOND_BLOCK, c("§#95f2aaEter§#8cf2c1nal §#83f2d8Sin§#81e9e2gularity"), "&7Forever...");
    public static final ItemStack MOMOTECH_ETERNAL_MINING_MACHINE = new CustomItemStack(Material.GRAY_CONCRETE_POWDER, c("§#83dbe4Eter§#86cce6nal §#88bee8Min§#8aafea er"), "&7Mining slowly...");
    public static final ItemStack MOMOTECH_DIGIT_GENERATOR = new CustomItemStack(Material.BLACK_STAINED_GLASS, c("§#8ca1ecDig§#8e92eeital §#808decPow§#7288e9er §#6483e6Cap§#577ee4aci§#4979e1tor"), "&7Can store §8⇨ §e⚡ &716,777,216 J");
    public static final ItemStack MOMOTECH_ID_DISPLAY = new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "&7&lItem ID Display");
    public static final ItemStack MOMOTECH_PROTON = new CustomItemStack(Material.TURTLE_EGG, c("§#3b74dfPro§#376fddton"));
    public static final ItemStack MOMOTECH_ZYGOTE = new CustomItemStack(Material.TURTLE_EGG, c("§#496bdcZy§#5b68dcgote"));
    public static final ItemStack MOMOTECH_PARTICLE_CONSTRUCTOR = new CustomItemStack(Material.GREEN_STAINED_GLASS, c("§#6d64dcPart§#7f60dbicle §#915ddbCap§#a359daaci§#b15cdator"), "&7Can store §8⇨ §e⚡ &75000 J");
    public static final ItemStack MOMOTECH_PROTON_INGOT = new CustomItemStack(Material.AMETHYST_SHARD, c("§#ffaa00Pro§#dbb538ton §#b8c06fIngot"));
    public static final ItemStack MOMOTECH_ZYGOTE_INGOT = new CustomItemStack(Material.AMETHYST_SHARD, c("§#94cba7Zy§#6ccab2gote §#44cabeIngot"));
    public static final ItemStack MOMOTECH_SALT_GENERATOR = new CustomItemStack(Material.WHITE_STAINED_GLASS, c("§#1cc9c9Salt §#68b5c8Well §#b3a1c6"));
    public static final ItemStack MOMOTECH_INGOT_CONSTRUCTOR = new CustomItemStack(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS, c("§#ff8dc5All§#f2a0d6oy §#e6b3e6Gen§#d9c6f7er§#b1a0d8ator"), "&7Efficiency: 32x");
    public static final ItemStack MOMOTECH_METAL_STAR = new CustomItemStack(Material.GOLD_BLOCK, "&6&lMetal Factor", "&7Used in Alloy Generator");
    public static final ItemStack MOMOTECH_SAND_CHANGER = new CustomItemStack(Material.RED_SANDSTONE, c("§#8a79baHigh§#62539b-Speed §#8a8bbaGrin§#b3c4dader §#dbfcf9"), "&7Efficiency: INFINITY");
    public static final ItemStack MOMOTECH_FINAL_ENERGY_GENERATOR = new CustomItemStack(Material.REDSTONE_LAMP, c("§#55ff55Cos§#55ff6emic §#55ff87Sup§#55ffa1reme §#55ffbaInv§#55ffd3inc§#55ffecible §#5bfcf6Mys§#74efd0tic §#8ee3aaEpi§#a7d684c Et§#c0c95eern§#d9bd39al §#f2b013Inf§#ffa90cini§#ffa824te §#ffa73cPow§#ffa654er §#ffa56cGen§#ffa384era§#ffa29ctor §#f7ac9fζ §#ecb99bTy§#e0c797pe"), c("§#ffaa00§oInf§#fca634§oin§#f8a169§oite §#f59d9d§oCos§#f7bdac§omic §#fadcbb§oEn§#fcfcca§oer§#d9ec92§ogy§#b6db5b§o..."), "§8⇨ §e⚡ &7999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999^0 J/t");
    public static final ItemStack MOMOTECH_SPECIAL_THINGS_CONSTRUCTOR = new CustomItemStack(Material.GLASS, "&fSpecial Compressor", "§8⇨ §e⚡ &7200 J/t");
    public static final ItemStack MOMOTECH_MATL114=new CustomItemStack(SlimefunUtils.getCustomHead("58d9d8a7927fb859a313fb0068f1d368c9dee7d0adacbbd35ffa4d998ff88deb"),c("§#eb33ebM§#dd2bdda§#cf22cft§#c11ac1l§#b311b31§#a509a51§#9700974"),"&7This version of MomoTech is an optimized and modified version","&7The modifications will not affect normal gameplay","&7If you encounter any machine issues, please contact Matl114");
    public static final ItemGroup MOMOTECH_ITEM;
    public static final ItemGroup MOMOTECH_FINAL;
    public static final ItemGroup MOMOTECH;
    public static final ItemGroup MOMOTECH_MACHINE;
    public static final ItemGroup MOMOTECH_MINERAL;
    public static final ItemGroup MOMOTECH_ORDINARY_MACHINE;
    public static final ItemGroup MOMOTECH_THANKING;
    public static final ItemGroup MOMOTECH_TOOL;
    public static final ItemGroup MOMOTECH__;
    public static final ItemGroup MOMOTECH_ELECTRICITY;
    public static final ItemGroup MOMOTECH_INF;
    public static final ItemStack[] Cobblestone = new ItemStack[100];
    public static final ItemGroup MOMOTECH_INF_MACHINE;

    static {

        String[][] name = {{"1x Compressed Diamond", "2x Compressed Diamond", "3x Compressed Diamond", "4x Compressed Diamond", "5x Compressed Diamond"},
                {"1x Compressed Netherite", "2x Compressed Netherite", "3x Compressed Netherite", "4x Compressed Netherite", "5x Compressed Netherite"},
                {"1x Compressed Coal", "2x Compressed Coal", "3x Compressed Coal", "4x Compressed Coal", "5x Compressed Coal"},
                {"1x Compressed Emerald", "2x Compressed Emerald", "3x Compressed Emerald", "4x Compressed Emerald", "5x Compressed Emerald"},
                {"1x Compressed Diamond", "2x Compressed Quartz", "3x Compressed Quartz", "4x Compressed Quartz", "5x Compressed Quartz"},
                {"1x Compressed Diamond", "2x Compressed Redstone", "3x Compressed Redstone", "4x Compressed Redstone", "5x Compressed Redstone"},
                {"1x Compressed Iron", "2x Compressed Iron", "3x Compressed Iron", "4x Compressed Iron", "5x Compressed Iron"},
                {"1x Compressed Gold", "2x Compressed Gold", "3x Compressed Gold", "4x Compressed Gold", "5x Compressed Gold"},
                {"1x Compressed Lapis", "2x Compressed Lapis", "3x Compressed Lapis", "4x Compressed Lapis", "5x Compressed Lapis"}};
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 3; ++j) {
                Mineral[i][j] = new CustomItemStack(Utils.it[i], "&f" + name[i][j], "§7Essence produced from compressed minerals...");
            }
        }
        for (int i = 0; i < 50; i++) {
            Cobblestone[i] = new CustomItemStack(Material.COBBLESTONE, "&c> &f" + (i + 1) + "x Compressed Cobblestone", "&7Don't doubt it, it's just material", "&7Not all of them are actually used, mainly for fun");
        }
        ItemStack[] GROUP = {new CustomItemStack(Material.PAPER, "&c&lNOTICE", "&b&lAddon machines don't need power unless specified", "&b&lAll machines only work when the output slot has space"),
                new CustomItemStack(Material.SOUL_CAMPFIRE, c("§#efa3de&lBasic §#ed9beb&lPro§#ec98ed&lduc§#ee9fd9&ltion §#f1a5c6&lMach§#f4acb3&lin§#f6b2a0&les")), new CustomItemStack(Material.IRON_INGOT, c("§#d9f995&lBasic §#c6efa2&lIt§#b2e5af&le§#9fdbbc&lms")),
                new CustomItemStack(Material.DIAMOND, c("§#8cd1c9&lTo§#78c7d7&lols")), new CustomItemStack(Material.REPEATING_COMMAND_BLOCK, c("§#b2eeaa&l&k... §#c2e9a3&lEnd§#d2e49b&lgame §#e3df94&lIt§#f3da8d&lems §#fed48a&l&k...")),
                new CustomItemStack(Material.BLACK_CONCRETE_POWDER, c("§#f9b98c&lBasic §#fbbf79&lMach§#fec666&lin§#fdcc5f&les")), new CustomItemStack(Material.GOLD_BLOCK, "§6§lCompressed Materials"),
                new CustomItemStack(Material.ENCHANTED_BOOK, c("§#fad365&lCred§#f7da6c&lits §#f3e172&l- §#f0e878&lSpec§#edef7e&lial §#eaf684&lMat§#e6fc8b&lerials")), new CustomItemStack(Material.CHAIN_COMMAND_BLOCK, c("§#85f8c3&l&kMo§#81fcc0&l&kMo §#91f7b9&lTech§#a2f2b1") + " §7(Code by: QYhB05)"),
                new CustomItemStack(Material.BLAZE_POWDER, c("§#8b9fca&lInf§#a298bb&linite §#b892ac&lTech §#cf8b9d&l- §#e6848e&lBas§#fc7e7f&lic §#ff8178&lTier")), new CustomItemStack(Material.SEA_PICKLE, c("§#65bde4&lPow§#52b3f1&ler §#5eace9&lExp§#75a5da&lansion")), new CustomItemStack(Material.PRISMARINE_CRYSTALS, c("§#ff8773&lInf§#ff8c6e&linite §#ff9168&lTech §#ff9663&l- §#ff9b5e&lEnd§#ffa058&lga§#ffa553&lme"))};
        Register.add(GROUP);
        MOMOTECH__ = new SubGroup("MOMOTECH__", GROUP[0]);
        MOMOTECH_ORDINARY_MACHINE = new SubGroup("MOMOTECH_ORDINARY_MACHINE", GROUP[1]);
        MOMOTECH_ITEM = new SubGroup("MOMOTECH_ITEM", GROUP[2]);
        MOMOTECH_TOOL = new SubGroup("MOMOTECH_TOOL", GROUP[3]);
        MOMOTECH_FINAL = new SubGroup("MOMOTECH_FINAL", GROUP[4]);
        MOMOTECH_MACHINE = new SubGroup("MOMOTECH_MACHINE", GROUP[5]);
        MOMOTECH_MINERAL = new SubGroup("MOMOTECH_MINERAL", GROUP[6]);
        MOMOTECH_THANKING = new SubGroup("MOMOTECH_THANKING", GROUP[7]);
        MOMOTECH_INF = new SubGroup("MOMOTECH_INF", GROUP[9]);
        MOMOTECH_ELECTRICITY = new SubGroup("MOMOTECH_ELECTRICITY", GROUP[10]);
        MOMOTECH_INF_MACHINE = new SubGroup("MOMOTECH_INF_MACHINE", GROUP[11]);
        MOMOTECH = new MultiGroup("MOMOTECH", GROUP[8], MOMOTECH__, MOMOTECH_THANKING, MOMOTECH_ITEM, MOMOTECH_MINERAL, MOMOTECH_TOOL, MOMOTECH_ORDINARY_MACHINE, MOMOTECH_MACHINE, MOMOTECH_FINAL, MOMOTECH_ELECTRICITY, MOMOTECH_INF, MOMOTECH_INF_MACHINE);
        MOMOTECH.register(MomoTech.getInstance());
    }
}
