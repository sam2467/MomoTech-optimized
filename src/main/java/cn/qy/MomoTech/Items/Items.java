java
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
    public static final ItemStack QUANTITY_ITEM = new CustomItemStack(Material.PURPLE_DYE, c("Quantization Plugin", "748d8d", "858c9b", "978ca9", "a88bb8"), "&6Just a material");
    public static final ItemStack FROG_LIGHT_GENERATOR = new CustomItemStack(Material.OCHRE_FROGLIGHT, "&eFroglight Generator", "&7Randomly generates a type of froglight", "&7Efficiency:4x");
    public static final ItemStack STONE_GENERATOR = new CustomItemStack(Material.STONE, "&eStone&f Generator", "&7Automated production of waste stone/cobblestone/deepslate cobblestone", "&7Efficiency:8x");
    public static final ItemStack ORE_GENERATOR = new CustomItemStack(Material.DIAMOND_ORE, "&eOre&f Generator", "&7Automated production of various ores", "&7Efficiency:1x");
    public static final ItemStack SAND_GENERATOR = new CustomItemStack(Material.SANDSTONE, "&eSand&f Generator", "&7Automated red sand/sand/gravel/soul sand", "&7Efficiency:8x");
    public static final ItemStack STONE_GENERATOR_I = new CustomItemStack(Material.COBBLESTONE, "&eDirected Cobblestone&f Generator", "&7Automated production of cobblestone", "&7Efficiency:8x");
    public static final ItemStack GLASS_GENERATOR = new CustomItemStack(Material.GLASS, "&eDirected Glass&f Generator", "&7Automated production of glass", "&7Efficiency:8x");
    public static final ItemStack TEMPLATE_GENERATOR = new CustomItemStack(Material.MELON, "&eTemplate&f Generator", "&7Randomly generates high-version templates", "&7Efficiency:1x");
    public static final ItemStack FISH_GENERATOR = new CustomItemStack(Material.SEA_LANTERN, "&eAutomatic Fisher", "&7Randomly generates various fish", "&7Efficiency1x");
    public static final ItemStack DUST_GENERATOR = new CustomItemStack(Material.SAND, "&eOre Dust&f Generator", "&7Randomly produces various ore dusts", "&7Efficiency6x");
    public static final ItemStack STONES_GENERATOR = new CustomItemStack(Material.SNOW_BLOCK, "&6Stone Block&f Generator", "&7Automated production of stone blocks", "&7Efficiency8x");
    public static final ItemStack ICE_GENERATOR = new CustomItemStack(Material.BLUE_ICE, "&eIce&f Generator", "&7Automated production of ice", "&7Efficiency:1x");
    public static final ItemStack Generator = new CustomItemStack(Material.ORANGE_CONCRETE_POWDER, c("§#b98bc6Generator"), "§8⇨ §e⚡ §76,000 J/t");
    public static final ItemStack LINE_GENERATOR = new CustomItemStack(Material.GRAY_WOOL, "&eLine&f Generator", "&7Automated production of lines", "&7Efficiency:3x");
    public static final ItemStack COMMAND_BLOCK_GENERATOR = new CustomItemStack(Material.POLISHED_BLACKSTONE, "&b&lCommand Block Generator", "&7&lWhat? Command Blocks???", "&7Efficiency:1x");
    public static final ItemStack C_GENERATOR = new CustomItemStack(Material.COAL_BLOCK, "&eCarbon&f Generator", "&7Early game carbon is solved!", "&7Efficiency:1x");
    public static final ItemStack CREATIVE__ = new CustomItemStack(Material.GLASS_PANE, c("Pure Origin", "ed89f0", "e98ef6", "da94f7", "ca9bf8", "bba2fa"), "&6The ultimate, just beginning");
    public static final ItemStack COMMAND_BLOCK_GETTER = new CustomItemStack(Material.COMMAND_BLOCK, c("Replica", "aca9fb", "9cb0fc", "8db6fb") + " &7- " + c("Command Block", "7fc6ee", "7ccde1", "79d5d5", "77ddc9"));
    public static final ItemStack COBBLE_STONE_GENERATOR_II = new CustomItemStack(Material.SNOW_BLOCK, "&b&lCompressed Cobblestone Generator", "&7Efficiency:64x");
    public static final ItemStack MOMOTECH_DIGITAL = new CustomItemStack(SlimefunUtils.getCustomHead("80c4528e622bd318720d38e0e4599e69bf23308f89693920e0e4ecb55d1c0bac"), "§fDigital Component", "§f0.0");
    public static final ItemStack MOMOTECH_LETTER = new CustomItemStack(Material.SUGAR, c("Symbol", "74e5bd", "71edb0"), "&fa", "&7The basis for creating matter out of thin air");
    public static final ItemStack MOMOTECH_ID_CARD = new CustomItemStack(Material.PAPER, c("§#6ef5a4I§#73f5a2D§#78f6a0 Card"), "&fID:", "&7Add symbols to ID cards in &cID Integrator&7 to integrate Slimefun ID", "&7Valid IDs can be crafted directly into corresponding ID Slimefun items in the &fCrafting Table");
    public static final ItemStack MOMOTECH_ID_PUTTER = new CustomItemStack(Material.BOOKSHELF, c("§#7ef69eI§#83f79cD§#88f79a Integrator"), "&7Add characters to ID cards here");
    public static final ItemStack MOMOTECH_LETTER_CONSTRUCTOR = new CustomItemStack(Material.BEEHIVE, c("§#fccc98Symbol§#f9c4a6 Integrator"));
    public static final ItemStack MOMOTECH_FINAL_STAR = new CustomItemStack(Material.HONEYCOMB, c("§#9df991Ultimate§#acfa8c Heart"), "&7Condensed here");
    public static final ItemStack MOMOTECH_ID_CHANGER = new CustomItemStack(Material.GLASS, c("§#d6fc7cCrafting§#e4fd76 Table"), "&7&lInsert a valid ID card, directly read and output Slimefun items based on ID", "&7You can use this to craft &lany&7 Slimefun item", "&7Such as the phony items of disordered artistry (FINALTECH_PHONY)");
    public static final ItemStack MOMOTECH_UNCONTROLLABLE_EMPTY_GENERATOR = new CustomItemStack(Material.DEEPSLATE_LAPIS_ORE, c("§#fcf769Uncontrollable§#fde05b Empty §#fdc94e Generator"), "&7As a mass production base for uncontrollable empty spaces in the later stage..", "&7Rate:48x");
    public static final ItemStack MOMOTECH_RANDOM_COPIER = new CustomItemStack(Material.DEEPSLATE_EMERALD_ORE, c("§#ff550cRandom§#ff6c2d Copier"));
    public static final ItemStack MOMOTECH_FINAL_COPIER = new CustomItemStack(Material.DEEPSLATE_GOLD_ORE, c("§#ffe0d3Copier§#fff7f4 - §#efefefUltimate"), "&cIntegrated particles!");
    public static final ItemStack MOMOTECH_EXP = new CustomItemStack(Material.EXPERIENCE_BOTTLE, c("§#8c8c8cExperience§#747474 Very§#5b5b5b Much§#4d4d4d Experience"), "&7Experience immediately increases by 20 levels after throwing");
    public static final ItemStack MOMOTECH_FINAL_ITEM = new CustomItemStack(Material.FERN, c("§#b2d3d3Corrupted§#acd8d1 Code§#a5dece Core"), "&8&lOmnipresent", "&8&lUltimate-Epic Item");
    public static final ItemStack SEA_ITEM_GENERATOR = new CustomItemStack(Material.PRISMARINE, "&b&lPrismarine&f Generator", "&7Automated production of prismarine items", "&7Efficiency:8x");
    public static final ItemStack BEE_GENERATOR = new CustomItemStack(Material.BEE_NEST, "&6&lBee&f Generator", "&7Automated production of various bee-related items", "&7Efficiency:1x");
    public static final ItemStack SPIDER_EYE_GENERATOR = new CustomItemStack(Material.SPAWNER, "&7&lSpider Eye&f Generator", "&7Automated production of spider eyes, perhaps useful in supreme", "&7Efficiency:2x");
    public static final ItemStack MOMOTECH_ORE_COLLECTOR = new CustomItemStack(Material.DEEPSLATE_COAL_ORE, c("§#849985Clang§#8baa8c Clang§#91bb93~ §#98cd9bAutomated§#9edea2 Compressed§#a5efaa Ore!"), "&7Randomly generates a triple compressed ore");
    public static final ItemStack MOMOTECH_EMPTY_SHELL = new CustomItemStack(Material.STRUCTURE_VOID, "§7Empty", "&fI really don't understand why this is an important material!", "§f§lNULL");
    public static final ItemStack MOMOTECH_SYMBOL_ADDITION = new CustomItemStack(Material.BLAZE_POWDER, "§aSymbol +", "§f+");
    public static final ItemStack MOMOTECH_SYMBOL_SUBTRACTION = new CustomItemStack(Material.BLAZE_POWDER, "§aSymbol -", "§f-");
    public static final ItemStack MOMOTECH_SYMBOL_MULTIPLICATION = new CustomItemStack(Material.BLAZE_POWDER, "§aSymbol x", "§f*");
    public static final ItemStack MOMOTECH_SYMBOL_DIVISION = new CustomItemStack(Material.BLAZE_POWDER, "§aSymbol ÷", "§f/");
    public static final ItemStack MOMOTECH_NONE = new CustomItemStack(new ItemStack(Material.BLACK_WOOL), c("§#dffbb1N§#ebfdb2O§#f7feb3N§#fffdb7E"), "§7A void");
    public static final ItemStack MOMOTECH_NUMBER_BUG = new CustomItemStack(new ItemStack(Material.WHITE_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aExpression", "&7&lBUG Material");
    public static final ItemStack MOMOTECH_NUMBER_BUG_I = new CustomItemStack(new ItemStack(Material.RED_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aDecimal", "&7&lBUG Material");
    public static final ItemStack MOMOTECH_NUMBER_BUG_II = new CustomItemStack(new ItemStack(Material.ORANGE_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aDate", "&7&lBUG Material");
    public static final ItemStack MOMOTECH_NUMBER_BUG_III = new CustomItemStack(new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aPositive Overload", "&7&lBUG Material");
    public static final ItemStack MOMOTECH_NUMBER_BUG_IV = new CustomItemStack(new ItemStack(Material.GREEN_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aNegative Overload", "&7&lBUG Material");
    public static final ItemStack MOMOTECH_NUMBER_BUG_V = new CustomItemStack(new ItemStack(Material.BLUE_STAINED_GLASS_PANE), "§7§lB§k1§8U§f§l§k一§7G §e- §aSystem", "&7&lBUG Material");
    public static final ItemStack MOMOTECH_DIGITAL_CONSTRUCTOR = new CustomItemStack(SlimefunUtils.getCustomHead("f26dad74b2bab105cb68c94eb3be32f5dbda42eab944b6ed9e803136f8f619bc"), "§x§a§4§b§3§b§fDigital Constructor", "§7Converts §lEmpty §7into digital components", "&8Seems to only produce some basic numbers...", "§8⇨ §e⚡ §72,000 J/t");
    public static final ItemStack MOMOTECH_SYMBOL_GENERATOR = new CustomItemStack(SlimefunUtils.getCustomHead("f26dad74b2bab105cb68c94eb3be32f5dbda42eab944b6ed9e803136f8f619bc"), "§x§a§4§b§3§b§fSymbol Generator", "§7Generates symbols from §lEmpty", "§8⇨ §e⚡ §72,000 J/t");
    public static final ItemStack MOMOTECH_INCREMENT = new CustomItemStack(new ItemStack(Material.CREEPER_HEAD), c("§#fdf7c1Incrementer"));
    public static final ItemStack MOMOTECH_ORDINARY_NUMBER_COMBINATOR = new CustomItemStack(Material.SKELETON_SKULL, c("§#f9e6e0Basic§#f8e0ea Calculator"));
    public static final ItemStack MOMOTECH_EMPTY_SHELL_GENERATOR = new CustomItemStack(Material.BLACK_CONCRETE_POWDER, c("§#f8c7feEmpty§#f9c0fe Shell§#fab9ff Generator"), "&7Hmm... finally made it... hands-free!", "&6Efficiency:8x");
    public static final ItemStack MOMOTECH_EMPTY_SHELL_GENERATOR_I = new CustomItemStack(Material.WHITE_CONCRETE_POWDER, c("§#fdacffEmpty§#ffa5ff Shell§#ff9ef1 Generator§#ff96dd Enhanced§#ff8ec8 Version"), "&7No input required, produces more empty shells!", "&6Efficiency:64x");
    public static final ItemStack MOMOTECH_CREATIVE_ITEM = new CustomItemStack(Material.END_CRYSTAL, c("§#ff768bPrimitive§#ff6e77 Material§#ff6c64 α"), "&7Seems to be of great use, but seems to be just a basic material...");
    public static final ItemStack MOMOTECH_CREATIVE_ITEM_I = new CustomItemStack(Material.END_CRYSTAL, c("§#ff8739Primitive§#ff8f2b Material§#ff981d β"), "&7Seems to be of great use, but seems to be just a basic material...");
    public static final ItemStack MOMOTECH_CREATIVE_ITEM_GENERATOR = new CustomItemStack(Material.COBBLESTONE, c("§#fff085Primitive§#fffb9b Material§#faffaa Manufacturer"));
    public static final ItemStack MOMOTECH_UNCONTROLLABLE_EMPTY = new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "§8§l§k123&f&lUncontrollable Empty");
    public static final ItemStack CreativeGenerator = new CustomItemStack(new ItemStack(Material.BLACK_WOOL), c("§#d5ffeaCrazy§#cefff7 Generator"), "§8⇨ §e⚡ §799,999,999 J/t");
    public static final ItemStack MOMOTECH_NONE_GENERATOR = new CustomItemStack(new ItemStack(Material.DIRT), c("§#c7fadbN§#c5f6c0O§#c4f2a5N§#c2ee8bE §#c0eb70Manufacturer"), "&7A good source of &8&lNONE&7 in the early game...");
    public static final ItemStack MOMOTECH_CREATIVE_ITEM_II = new CustomItemStack(Material.END_CRYSTAL, c("§#ffb616Primitive§#ffc12c Material§#ffcd42 γ"), "&7Further improvement...");
    public static final ItemStack MOMOTECH_QUANTITY_CONSTRUCTOR = new CustomItemStack(Material.HONEY_BLOCK, c("§#addf4eQuantization§#9ddb63 Constructor"));
    public static final ItemStack MOMOTECH_BUG_CRYSTAL = new CustomItemStack(Material.NETHER_STAR, c("§#5ecbb4B§#4ec7c8U§#45c6c1G§#40c6ad Crystal"), "&7&lCrystallization from BUG");
    public static final ItemStack QY = new CustomItemStack(new ItemStack(Material.COMMAND_BLOCK), "&6&lQYhB05", "&7BUG creator...", "&7Wrote most of the messy code for this addon, is one of the addon founders", "&7Amateur code enthusiast");
    public static final ItemStack wbx = new CustomItemStack(new ItemStack(Material.COMMAND_BLOCK), "&e&lChenmose", "&7Cute~", "&7Provided some ideas, is one of the addon founders", "&8&lI won't tell you he slacked off after the early game");
    public static final ItemStack sky = new CustomItemStack(new ItemStack(Material.COMMAND_BLOCK), "&a&lskybule", "&7Provided interesting ideas and helped with testing", "&7Provided great help and support to the author!");
    public static final ItemStack plugin = new CustomItemStack(new ItemStack(Material.PAPER), "&f&lThis addon is called MomoTech, also known as Garbled Tech!", "&bThis is an open source project, thank you for your support. If you need to modify it or find bugs, please contact the author", "&6&lQQ Group Chat:827684043");
    public static final ItemStack BUGGGGG = new CustomItemStack(new ItemStack(Material.ENDER_CHEST), "&f&lBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG", "&8The author is an amateur middle school code enthusiast, please don't flame us, you are welcome to provide suggestions on QQ");
    public static final ItemStack ELSE_1 = new CustomItemStack(Material.PAPER, "&fFeature: No Electricity", "&7All machines not specified as consuming electricity do not consume electricity");
    public static final ItemStack ELSE_2 = new CustomItemStack(Material.PAPER, "&fFeature: Output Slot Only Empty", "&7Some machines only work when the output slot is empty");
    public static final ItemStack ELSE_3 = new CustomItemStack(Material.PAPER, "&fFeature: Bug - Date", "&7If your calculator's result equals a date and doesn't output Bug - Date, perhaps you can try adding +0 to that digital component again");
    public static final ItemStack FULL = new CustomItemStack(new ItemStack(Material.EGG), c("§#35c684Saturated§#2fc670 Charm"), "&bAlways hungry? Can't afford anything else in the early game? Use me!", "&bRight click to consume and immediately gain saturation effect");
    public static final ItemStack DAMAGE_ITEM = new CustomItemStack(new ItemStack(Material.CHAIN_COMMAND_BLOCK), c("§#29c73aStrange§#44ca39 Thing§#5fce38 (?"), "&6&lOne hit kill! Direct obliteration!");
    public static final ItemStack[][] Mineral = new ItemStack[9][5];
    public static final ItemStack STONE_SWORD = new CustomItemStack(Material.DIAMOND_SWORD, "&7&lSword of Vows", "&8Sword in the stone...", "&8Can cause huge damage", "&8Damage+999999999999.99");
    public static final ItemStack FINAL_C_ = new CustomItemStack(Material.COBBLESTONE, c("§#e5de345§#c7df3d0-fold§#a8df47 Compressed§#8ae050 Cobblestone§#6be15a Generator"), "&7&lThat's right, you heard me", "&fWho knows, maybe it's useful", "&7Efficiency:8x");
    public static final ItemStack PROTECT_ITEM = new CustomItemStack(new ItemStack(Material.TURTLE_HELMET), c("§#2dc380Forgiveness§#3bb883 Hat"), "&aWear on your head to be immune to entity attacks!", "&8Does not include burning, falling, etc.", "&7Don't ask why it's green");
    public static final ItemStack STAR_OF_ALL = new CustomItemStack(Material.HEART_OF_THE_SEA, c("§#58a088Integrated§#66948a Core"), "&6&lUsed to synthesize most of the integrated machines in this addon");
    public static final ItemStack MOMOTECH_COBBLE_STONE_STORE = new CustomItemStack(Material.GLASS, c("§#5a6e6eCobblestone§#536566 Storage"), "&7Provides 54 slots of storage space", "&7Cobblestone can also make chests, yay");
    public static final ItemStack MOMOTECH_COBBLESTONE_GENERATOR_FINAL = new CustomItemStack(Material.SLIME_BLOCK, c("§#3f4a4bEntropy-Reversing§#485351 Cobblestone§#525c58 Farm"), "&7Produces 48 stacks per tick, that's how high-yield it is!");
    public static final ItemStack MOMOTECH_QUANTUM = new CustomItemStack(Material.SNOWBALL, "&eQuantum", "&fRight-clicking seems to cause bad things to happen");
    public static final ItemStack MOMOTECH_QUANTUM1 = new CustomItemStack(Material.MAGMA_CREAM, "&aEntangled&b Quantum", "&fParticles entangled with quantum, right-clicking also seems to cause bad things to happen", "&fUsed for high-precision high-speed communication machines");
    public static final ItemStack MOMOTECH_BOX_OF_QUANTUM = new CustomItemStack(Material.CHEST, "&aQuantum&e Box", "&7Stabilized quantum, uses quantum to store items in machines", "&fRight-click to open ender chest with quantum");
    public static final ItemStack MOMOTECH_SILK_TOUCH_PICKAXE = new CustomItemStack(Material.NETHERITE_PICKAXE, "&bEntangled&6 Quantum&e Pickaxe", "&fSpecial tool");
    public static final ItemStack MOMOTECH_PICKAXE = new CustomItemStack(Material.NETHERITE_PICKAXE, "&eQuantum&6 Pickaxe", "&fSpecial tool", "&eFaster Initial D&f speed", "&8Right click to accelerate");
    public static final ItemStack MOMOTECH_PUMPKIN_CARVER = new CustomItemStack(Material.CARVED_PUMPKIN, c("§#a4b3bfPumpkin§#a7bac1 Lightspeed§#aac1c3 Carver"), "&fCan automatically carve pumpkins for you", "&7Efficiency:INFINITY");
    public static final ItemStack MOMOTECH_CLEAR = new CustomItemStack(Material.NETHERITE_INGOT, c("§#b9e3ceQuantum§#bfe6cb Clearer"), "&7&lHelps you clear existing attribute effects on you", "&8Mainly for quantum item effects");
    public static final ItemStack MOMOTECH_FIXER = new CustomItemStack(Material.IRON_BLOCK, c("§#dcebb4Equipment§#e3edae Repairer"), "&7Automatically repairs your equipment");
    public static final ItemStack MOMOTECH_TRANSPORTER = new CustomItemStack(Material.PISTON, "&aTeleporter");
    public static final ItemStack CHEST_GENERATOR = new CustomItemStack(Material.JUNGLE_LOG, "&6Chest&f Generator", "&7Efficiency:1x");
    public static final ItemStack MOMOTECH_OPEN_BOX_ITEM = new CustomItemStack(Material.PURPLE_STAINED_GLASS, c("§#f6ca63Box§#f7c356 Opener"), "&7Open box!", "&7Can disassemble quantum boxes, but only entangled quantum can be preserved...");
    public static final ItemStack MOMOTECH_SHINE = new CustomItemStack(Material.GLOWSTONE_DUST, "&fLight");
    public static final ItemStack MOMOTECH_DARK = new CustomItemStack(Material.GUNPOWDER, "&8Dark");
    public static final ItemStack MOMOTECH_SHINE_AND_DARK_CONSTRUCTOR = new CustomItemStack(Material.GLOWSTONE, c("§#55ffffLight§#6ffef6 and§#88fdee Dark§#a2fce5 Generator"), "§8⇨ §e⚡ §7500 J/t");
    public static final ItemStack MOMOTECH_SHINE_AND_DARK_GENERATOR = new CustomItemStack(Material.REDSTONE_LAMP, c("§#d5fad4Light§#eefacc and§#fef9c5 Dark§#fbf7c2 Generator"), "&7Draws energy from light and dark...", "§8⇨ §e⚡ §720,000 J/t");
    public static final ItemStack MOMOTECH_SHINE1 = new CustomItemStack(Material.GLOWSTONE_DUST, "&f&lLight Factor");
    public static final ItemStack MOMOTECH_DARK1 = new CustomItemStack(Material.GUNPOWDER, "&8&lDark Factor");
    public static final ItemStack MOMOTECH_NETHERITE_PICKAXE_CHANGER = new CustomItemStack(Material.BLACK_STAINED_GLASS, c("§#f5f5bcNetherite§#f3f4b9 Pickaxe§#f0f3b6 Converter"), "§8⇨ §e⚡ §7100 J/t");
    public static final ItemStack DIAMOND_PICKAXE_GENERATOR = new CustomItemStack(Material.DIAMOND_BLOCK, "&bDiamond Pickaxe&f Generator", "&7Efficiency:8x");
    public static final ItemStack MOMOTECH_CONSTRUCTOR = new CustomItemStack(Material.CHISELED_POLISHED_BLACKSTONE, c("§#e3f5a2Condenser"), "&7Condenses essence into one", "§8⇨ §e⚡ §7900 J/t");
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
    public static final ItemStack MOMOTECH_REAL_MAGNET = new CustomItemStack(Material.IRON_BLOCK, c("§#e2f096This§#e5ea92 is§#e9e38d the§#ecdd89 proper§#efd784 Magnet§#f2d080!"));
    public static final ItemStack MOMOTECH_ELECTRICITY_MAGNET = new CustomItemStack(Material.GOLD_BLOCK, c("§#fab695This§#fbaf9d is§#fda8a4 the§#ffa2ab proper§#fa9fac Electromagnet§#f39dab!"));
    public static final ItemStack MOMOTECH_IRON_STAR = new CustomItemStack(Material.GLASS_BOTTLE, "&f&lIron Core");
    public static final ItemStack MOMOTECH_COIL = new CustomItemStack(Material.STRING, c("§#d295a6Coil"));
    public static final ItemStack MOMOTECH_MAGNETIZE = new CustomItemStack(Material.IRON_BLOCK, c("§#d8a5b5Magnetizer"), "&7This is a more reasonable way to make magnets!", "§8⇨ §e⚡ §7200 J/t");
    public static final ItemStack MOMOTECH_MAGNET_GENERATOR = new CustomItemStack(Material.WHITE_STAINED_GLASS, c("§#e0bdcaEnergy§#e3c5d2 Power§#e4c9d8 Electromagnet§#e0c6de Integrated§#ddc3e3 Machine"), "§8⇨ §e⚡ §7500 J/t");
    public static final ItemStack MOMOTECH_INFINITY = new CustomItemStack(Material.NETHERITE_SCRAP, "&cRule&e Ingot");
    public static final ItemStack MOMOTECH_FAST_GEO = new CustomItemStack(Material.NETHERITE_BLOCK, c("§#c0afe6High-speed§#b9abdb Geological§#b1a7d0 Resource§#a9a2c5 Extraction§#a19eb9 Machine"), "§8⇨ §e⚡ §710,000 J/t");
    public static final ItemStack MOMOTECH_ORDINARY_GENERATOR = new CustomItemStack(Material.GLASS, c("§#99c29eBasic§#99ca9b Generator"), "§8⇨ §e⚡ §7500 J/t");
    public static final ItemStack MOMOTECH_MINERAL_ = new CustomItemStack(Material.NETHERITE_INGOT, "&6Mineral Core");
    public static final ItemStack MOMOTECH_METAL_ = new CustomItemStack(Material.IRON_INGOT, "&eMetal Core");
    public static final ItemStack FLINT_GENERATOR = new CustomItemStack(Material.DEEPSLATE_GOLD_ORE, "&6Flint&f Generator", "&7Efficiency:4x");
    public static final ItemStack MOMOTECH_RULE_STAR = new CustomItemStack(Material.IRON_NUGGET, "&cTime&6 Rift");
    public static final ItemStack MOMOTECH_FINAL_RULE = new CustomItemStack(Material.BONE_MEAL, "&3Concept&b Object");
    public static final ItemStack MOMOTECH_ENERGY_INGOT = new CustomItemStack(Material.NETHERITE_INGOT, c("§#c8d29aRadioactive§#d6d39a Charging§#e3d49b Ingot"));
    public static final ItemStack MOMOTECH_RESOURCE = new CustomItemStack(Material.COMMAND_BLOCK, "&a&lResource", "&7Greatly supports this addon and extensively promoted it");
    public static final ItemStack MOMOTECH_COMMAND_BLOCK1 = new CustomItemStack(Material.COMMAND_BLOCK, "&6Genesis Command Block - COMMON");
    public static final ItemStack MOMOTECH_COMMAND_BLOCK2 = new CustomItemStack(Material.REPEATING_COMMAND_BLOCK, "&6Genesis Command Block - REPEATING");
    public static final ItemStack MOMOTECH_COMMAND_BLOCK3 = new CustomItemStack(Material.CHAIN_COMMAND_BLOCK, "&6Genesis Command Block - CHAIN");
    public static final ItemStack MOMOTECH_RULE_ITEM = new CustomItemStack(Material.REDSTONE_TORCH, c("§#bfcebbGenesis§#abccc6 Gear"));
    public static final ItemStack MOMOTECH_EFFECT_DELETER = new CustomItemStack(Material.IRON_INGOT, c("§#74c5e7Status§#73c9e5 Effect§#72cde4 Clearer"), "&7Right-click to clear potion effects");
    public static final ItemStack MOMOTECH_THROW = new CustomItemStack(Material.GOLD_INGOT, c("§#6edbdeBackpack§#6bdddc Dropper"), "&7Right-click to drop all items", "&8Including armor");
    public static final ItemStack MOMOTECH_RULE_SHINE_AND_DARK_CONSTRUCTOR = new CustomItemStack(Material.GLOWSTONE, c("§#4eded8Rule§#47dfd6 Light§#3fdfd5 and§#39dcbe Dark§#34d8a2 Collector"), "&7Greatly increased probability...", "§8⇨ §e⚡ §75,000 J/t");
    public static final ItemStack MOMOTECH_ENTROPY_RECONSTRUCT = new CustomItemStack(Material.BLACK_CONCRETE, c("§#23cd4dEntropy-Reversing§#1dc930 Reconstructor"), "&7Honestly a bit slow..", "§8⇨ §e⚡ §7500 J/t");
    public static final ItemStack MOMOTECH_RULE_RECONSTRUCT = new CustomItemStack(Material.BLACK_CONCRETE, c("§#85e14eRule§#a8e960 Reconstructor"), "&7So fast?", "§8⇨ §e⚡ §75,000 J/t");
    public static final ItemStack MOMOTECH_RULE_MACHINE_STAR = new CustomItemStack(Material.BLACK_CONCRETE, c("§#85e14eRule§#8ede68 Machine§#98dc82 Component"));
    public static final ItemStack MOMOTECH_SHINE_AND_DARK_INGOT = new CustomItemStack(Material.FLINT, c("§#b9d2ceLight§#c2d2ca and§#cad1c7 Dark§#d3d0c3 Composite§#dbcfc0 Ingot"));
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR1 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directed &f- &bAl", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR2 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directed &f- &bMg", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR3 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directed &f- &bCu", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR4 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directed &f- &bAu", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR5 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directed &f- &bAg", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR6 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directed &f- &bPb", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR7 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directed &f- &bSn", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR8 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directed &f- &bZn", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_DUST_GENERATOR9 = new CustomItemStack(Material.POLISHED_DEEPSLATE, "&cRule Pulverizer &f- &6Directed &f- &bFe", "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_U_GENERATOR = new CustomItemStack(Material.GREEN_CONCRETE_POWDER, c("§#be63d9Rule§#cb6ad8 Uranium§#d871d8 Purifier"), "&7Efficiency:64x", "§8⇨ §e⚡ §75,000 J/t");
    public static final ItemStack MOMOTECH_RULE_GEO = new CustomItemStack(Material.NETHERITE_BLOCK, c("§#e4cfbcUltimate§#eacdba Geological§#e7c9c0 Resource§#e4c5c5 Extractor"), "&7Efficiency:16x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_CREATIVE_GENERATOR = new CustomItemStack(Material.BOOKSHELF, c("§#c4a9cbPrimitive§#b9a3be Material§#ae9cb1 Generator§#a396a4 α§#999098β§#8e8a8b Type"), "&7Automatically generates consuming large amounts of power", "&7Randomly generates a primitive material α or β every tick", "&7He really made me cry...", "§8⇨ §e⚡ §7100,000 J/t");
    public static final ItemStack MOMOTECH_RULE_REACTOR = new CustomItemStack(Material.DIAMOND_ORE, c("§#dfd3d8High-speed§#f0e3e8 Fission§#fdeff5 Reactor"), "&7Efficiency:8x", "§8⇨ §e⚡ §75,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Overworld Mob Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM1 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Fish Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM2 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Pigman Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM3 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Enderman Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM4 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Creeper Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM5 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Drowned Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM6 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Animal Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM7 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Slime Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM8 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Blaze Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MONSTER_ITEM9 = new CustomItemStack(Material.BLACK_STAINED_GLASS, "&7Magma Cube Farm Simulator", "&7Efficiency:32x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_RULE_CONSTRUCTOR = new CustomItemStack(Material.CHISELED_POLISHED_BLACKSTONE, "&6Rule " + c("§#e3f5a2Condenser"), "&7Efficiency:16x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MINERAL_GENERATOR = new CustomItemStack(Material.BLUE_CONCRETE_POWDER, c("§#f3f7eeRule§#f0f9ec Ore§#edfbe9 Machine"), "&7Efficiency:64x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_MINERAL_BLOCK_GENERATOR = new CustomItemStack(Material.GILDED_BLACKSTONE, c("§#eafee6Rule§#edfde5 Ore§#f1fce4 Block§#f4fae3 Collector"), "&7Efficiency:16x", "§8⇨ §e⚡ §715,000 J/t");
    public static final ItemStack MOMOTECH_PLANT = new CustomItemStack(Material.CHISELED_DEEPSLATE, c("§#ffefdcPlant§#ffe7d7 Cultivator"), "&7Insert plant seeds or items like lily pads, vines, grass, etc.", "&7Efficiency:32x", "§8⇨ §e⚡ §710,000 J/t");
    public static final ItemStack MOMOTECH_WOOD = new CustomItemStack(Material.CHISELED_DEEPSLATE, c("§#ffc6c4Tree§#fec2c1 Cultivator"), "&7Insert saplings or nether fungi", "&7Efficiency:32x", "§8⇨ §e⚡ §710,000 J/t");
    public static final ItemStack MOMOTECH_ENERGY_QUANTUM = new CustomItemStack(Material.SLIME_BALL, "&cHigh&e Energy&b Quantum", "&7Dangerous, high energy!");
    public static final ItemStack MOMOTECH_RANDOM_QUANTUM = new CustomItemStack(Material.CLAY_BALL, "&eRandom&b Quantum", "&7Random~", "&7Right-clicking will kill you");
    public static final ItemStack MOMOTECH_RANDOM_QUANTUM_GENERATOR = new CustomItemStack(Material.GRAY_WOOL, c("§#e4e2cdRandom§#ddead0 Quantum§#d7f3d3 Generator"));
    public static final ItemStack MOMOTECH_ENERGY_QUANTUM_GENERATOR = new CustomItemStack(Material.WHITE_WOOL, c("§#d7fcf2Quantum§#d7fef8 Charger"), "§8⇨ §e⚡ &7500,000 J/t");
    public static final ItemStack MOMOTECH_FINAL_INGOT_GENERATOR = new CustomItemStack(Material.GRAY_CONCRETE, c("§#e9ffffUltimate§#efffff Ingot§#f5ffff Forger"), "&7Efficiency:INFINITY");
    public static final ItemStack MOMOTECH_FINAL_GENERATOR = new CustomItemStack(Material.EMERALD_BLOCK, c("§#ffa7d8Ultimate§#ff97d0 Generator"), "§8⇨ §e⚡ &7800,000,000 J/t");
    public static final ItemStack MOMOTECH_FINAL_CAPITAL = new CustomItemStack(Material.YELLOW_STAINED_GLASS, c("§#ffeaf6Ultimate§#ffd9ee Capacitor"), "&7Not recommended to use two in the same energy network simultaneously", "&7Can store §8⇨ §e⚡ &72,000,000,000 J");
    public static final ItemStack MOMOTECH_FINAL_ELECTRIC_EATER = new CustomItemStack(Material.BLUE_STAINED_GLASS, c("§#ff9e5eUniverse§#ffa23f Power§#ffa621 Eater"), "&7Uses cosmic energy to consume electricity...", "§8⇨ §e⚡ §72,000,000,000 J/t");
    public static final ItemStack MOMOTECH_ITEM_FIXER = new CustomItemStack(Material.ORANGE_CONCRETE_POWDER, c("§#ebbf15Item§#e1ca1f Resetter"), "&7Resets Slimefun items");
    public static final ItemStack MOMOTECH_RULE_BOOTS = new CustomItemStack(Material.NETHERITE_BOOTS, "&7Ultimate Boots", "&bRadiation resistant", "&bImmune to bees", "&bSaturation", "&bFire resistance", "&bHealth regeneration", "&bWater breathing", "&bResistance II", "&bHaste II", "&bSpeed I", "&bHaste II", "&bJump Boost I", "&bSoulbound");
    public static final ItemStack MOMOTECH_RULE_PICKAXE = new CustomItemStack(Material.DIAMOND_PICKAXE, "&7Ultimate Pickaxe");
    public static final ItemStack MOMOTECH_LOOTER = new CustomItemStack(Material.GLASS_PANE, "&7&lSeal - Evoker", "&8Right click to open");
    public static final ItemStack MOMOTECH_FOREVER = new CustomItemStack(Material.BLUE_DYE, c("§#b9f24eEternal§#b0f265 Particle"), "&7Forever...");
    public static final ItemStack MOMOTECH_FOREVER_ = new CustomItemStack(Material.DIAMOND_BLOCK, c("§#95f2aaEternal§#8cf2c1 Singularity"), "&7Forever...");
    public static final ItemStack MOMOTECH_ETERNAL_MINING_MACHINE = new CustomItemStack(Material.GRAY_CONCRETE_POWDER, c("§#83dbe4Eternal§#86cce6 Mining§#88bee8 Machine"), "&7Slowly mining...");
    public static final ItemStack MOMOTECH_DIGIT_GENERATOR = new CustomItemStack(Material.BLACK_STAINED_GLASS, c("§#8ca1ecDigit§#8e92ee Generating§#808dec Capacitor"), "&7Can store §8⇨ §e⚡ &716,777,216 J");
    public static final ItemStack MOMOTECH_ID_DISPLAY = new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "&7&lItem ID Display");
    public static final ItemStack MOMOTECH_PROTON = new CustomItemStack(Material.TURTLE_EGG, c("§#3b74dfProton"));
    public static final ItemStack MOMOTECH_ZYGOTE = new CustomItemStack(Material.TURTLE_EGG, c("§#496bdcZygote"));
    public static final ItemStack MOMOTECH_PARTICLE_CONSTRUCTOR = new CustomItemStack(Material.GREEN_STAINED_GLASS, c("§#6d64dcProton§#7f60db Zygote§#915ddb Capacitor"), "&7Can store §8⇨ §e⚡ &75000 J");
    public static final ItemStack MOMOTECH_PROTON_INGOT = new CustomItemStack(Material.AMETHYST_SHARD, c("§#ffaa00Proton§#dbb538 Ingot"));
    public static final ItemStack MOMOTECH_ZYGOTE_INGOT = new CustomItemStack(Material.AMETHYST_SHARD, c("§#94cba7Zygote§#6ccab2 Ingot"));
    public static final ItemStack MOMOTECH_SALT_GENERATOR = new CustomItemStack(Material.WHITE_STAINED_GLASS, c("§#1cc9c9Salt§#68b5c8 Mine"));
    public static final ItemStack MOMOTECH_INGOT_CONSTRUCTOR = new CustomItemStack(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS, c("§#ff8dc5Alloy§#f2a0d6 Generator"), "&7Efficiency:32x");
    public static final ItemStack MOMOTECH_METAL_STAR = new CustomItemStack(Material.GOLD_BLOCK, "&6&lMetal Factor", "&7Used in the alloy generator");
    public static final ItemStack MOMOTECH_SAND_CHANGER = new CustomItemStack(Material.RED_SANDSTONE, c("§#8a79baLightspeed§#62539b Polisher"), "&7Efficiency:INFINITY");
    public static final ItemStack MOMOTECH_FINAL_ENERGY_GENERATOR = new CustomItemStack(Material.REDSTONE_LAMP, c("§#55ff55Universe§#55ff6e Super§#55ff87 Invincible§#55ffa1 Mysterious§#55ffba Epic§#55ffd3 Eternal§#55ffec Infinite§#5bfcf6 Charging§#74efd0 Cycle§#8ee3aa Overload§#a7d684 Energy§#c0c95e Generator§#d9bd39 Unit§#f2b013 ζ Type"), c("§#ffaa00§oInfinite§#fca634§o Universe§#f8a169§o Energy§#f59d9d§o..."), "§8⇨ §e⚡ &7999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999^0 J/t");
    public static final ItemStack MOMOTECH_SPECIAL_THINGS_CONSTRUCTOR = new CustomItemStack(Material.GLASS, "&fSpecial Compressor", "§8⇨ §e⚡ &7200 J/t");
    public static final ItemStack MOMOTECH_MATL114=new CustomItemStack(SlimefunUtils.getCustomHead("58d9d8a7927fb859a313fb0068f1d368c9dee7d0adacbbd35ffa4d998ff88deb"),c("§#eb33ebM§#dd2bdda§#cf22cft§#c11ac1l§#b311b31§#a509a51§#9700974"),"&7This version of MomoTech is an optimized and modified version","&7The modifications will not affect normal gameplay","&7If there are machine problems, please find Matl114");
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

        String[][] name = {{"One-fold Compressed Diamond", "Two-fold Compressed Diamond", "Three-fold Compressed Diamond", "Four-fold Compressed Diamond", "Five-fold Compressed Diamond"},
                {"One-fold Compressed Netherite", "Two-fold Compressed Netherite", "Three-fold Compressed Netherite", "Four-fold Compressed Netherite", "Five-fold Compressed Netherite"},
                {"One-fold Compressed Coal", "Two-fold Compressed Coal", "Three-fold Compressed Coal", "Four-fold Compressed Coal", "Five-fold Compressed Coal"},
                {"One-fold Compressed Emerald", "Two-fold Compressed Emerald", "Three-fold Compressed Emerald", "Four-fold Compressed Emerald", "Five-fold Compressed Emerald"},
                {"One-fold Compressed Diamond", "Two-fold Compressed Quartz", "Three-fold Compressed Quartz", "Four-fold Compressed Quartz", "Five-fold Compressed Quartz"},
                {"One-fold Compressed Diamond", "Two-fold Compressed Redstone", "Three-fold Compressed Redstone", "Four-fold Compressed Redstone", "Five-fold Compressed Redstone"},
                {"One-fold Compressed Iron", "Two-fold Compressed Iron", "Three-fold Compressed Iron", "Four-fold Compressed Iron", "Five-fold Compressed Iron"},
                {"One-fold Compressed Gold", "Two-fold Compressed Gold", "Three-fold Compressed Gold", "Four-fold Compressed Gold", "Five-fold Compressed Gold"},
                {"One-fold Compressed Lapis Lazuli", "Two-fold Compressed Lapis Lazuli", "Three-fold Compressed Lapis Lazuli", "Four-fold Compressed Lapis Lazuli", "Five-fold Compressed Lapis Lazuli"}};
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 3; ++j) {
                Mineral[i][j] = new CustomItemStack(Utils.it[i], "&f" + name[i][j], "§7Essence produced by squeezed minerals...");
            }
        }
        for (int i = 0; i < 50; i++) {
            Cobblestone[i] = new CustomItemStack(Material.COBBLESTONE, "&c> &f" + (i + 1) + "-fold Compressed Cobblestone", "&7No doubt, just materials", "&7Actually not all of them are useful, mainly for entertainment");
        }
        ItemStack[] GROUP = {new CustomItemStack(Material.PAPER, "&c&lNote", "&b&lAddon machines not specified do not require electricity", "&b&lAll machines only work when the output slot is empty"),
                new CustomItemStack(Material.SOUL_CAMPFIRE, c("§#efa3de&lBasic§#ed9beb&l Production§#ec98ed&l Machines")), new CustomItemStack(Material.IRON_INGOT, c("§#d9f995&lBasic§#c6efa2&l Items")),
                new CustomItemStack(Material.DIAMOND, c("§#8cd1c9&lTools")), new CustomItemStack(Material.REPEATING_COMMAND_BLOCK, c("§#b2eeaa&l&k… §#c2e9a3&lUltimate§#d2e49b&l Items §#e3df94&l&k…")),
                new CustomItemStack(Material.BLACK_CONCRETE_POWDER, c("§#f9b98c&lBasic§#fbbf79&l Machines")), new CustomItemStack(Material.GOLD_BLOCK, "§6§lCompressed Materials"),
                new CustomItemStack(Material.ENCHANTED_BOOK, c("§#fad365&lThanks§#f7da6c &l- §#f3e172 &lSpecial§#f0e878 Materials")), new CustomItemStack(Material.CHAIN_COMMAND_BLOCK, c("§#85f8c3&l&kMomo§#81fcc0&l&k Tech") + " §7(Code Author:QYhB05)"),
                new CustomItemStack(Material.BLAZE_POWDER, c("§#8b9fca&lInfinite§#a298bb Engineering§#b892ac &l- §#cf8b9d &lBeginner")), new CustomItemStack(Material.SEA_PICKLE, c("§#65bde4&lPower§#52b3f1 Expansion")), new CustomItemStack(Material.PRISMARINE_CRYSTALS, c("§#ff8773&lInfinite§#ff8c6e Engineering§#ff9168 &l- §#ff9663 &lUltimate"))};
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
