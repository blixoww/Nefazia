package fr.blixow.nefazia;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack healsword;
    public static ItemStack witherSword;
    public static ItemStack poisonSword;
    public static ItemStack thorSword;
    public static ItemStack legendaryBow;
    public static ItemStack legendarySword;
    public static ItemStack fishingRod;
    public static ItemStack harvesterHoe;

    public static void init() {
        createPoisonSword();
        createWitherSword();
        createThorSword();
        createHealSword();
        createLegendaryBow();
        createLegendarySword();
        createFishingRod();
        createHarvesterHoe();
    }

    public static void createHarvesterHoe() {
        final ItemStack itemHoe = new ItemStack(Material.DIAMOND_HOE, 1);
        final ItemMeta hoeMeta = itemHoe.getItemMeta();
        hoeMeta.setDisplayName("§bMoisonneuse");
        final List<String> lore = new ArrayList<>();
        lore.add("§8§m----------------------------------");
        lore.add("");
        lore.add("§bSolidité 3");
        lore.add("§bPermet de replenter automatiquement");
        lore.add("");
        lore.add("§8§m----------------------------------");
        hoeMeta.setLore(lore);
        hoeMeta.addEnchant(Enchantment.DURABILITY, 3, false);
        hoeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemHoe.setItemMeta(hoeMeta);
        harvesterHoe = itemHoe;
        final ShapedRecipe hoeRecipe = new ShapedRecipe(itemHoe);
        hoeRecipe.shape("LL ", " S ", " S ");
        hoeRecipe.setIngredient('S', Material.STICK);
        hoeRecipe.setIngredient('L', Material.EMERALD_BLOCK, 1);
        Bukkit.getServer().addRecipe(hoeRecipe);
    }

    public static void createFishingRod() {
        final ItemStack itemRod = new ItemStack(Material.FISHING_ROD, 1);
        final ItemMeta rodMeta = itemRod.getItemMeta();
        rodMeta.setDisplayName("§bCanne à pêche électrique");
        final List<String> lore = new ArrayList<>();
        lore.add("§7§m----------------------------------");
        lore.add("");
        lore.add("§bSolidité 5");
        lore.add("");
        lore.add("§7§m----------------------------------");
        rodMeta.setLore(lore);
        rodMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        rodMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemRod.setItemMeta(rodMeta);
        fishingRod = itemRod;
        final ShapedRecipe recipeRod = new ShapedRecipe(itemRod);
        recipeRod.shape("L  ", " S ", "S  ");
        recipeRod.setIngredient('S', Material.STICK);
        recipeRod.setIngredient('L', Material.EMERALD_BLOCK);
        Bukkit.getServer().addRecipe(recipeRod);
    }

    public static void createLegendarySword() {
        final ItemStack itemSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        final ItemMeta swordMeta = itemSword.getItemMeta();
        swordMeta.setDisplayName("§bÉpée électrique");
        final List<String> lore = new ArrayList<>();
        lore.add("§7§m----------------------------------");
        lore.add("");
        lore.add("§bTranchant 5");
        lore.add("§bSolidité 5");
        lore.add("§bAura de feu 5");
        lore.add("§bReste dans l'inventaire après la mort");
        lore.add("");
        lore.add("§7§m----------------------------------");
        swordMeta.setLore(lore);
        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        swordMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
        swordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemSword.setItemMeta(swordMeta);
        legendarySword = itemSword;
        final ShapedRecipe recipeSword = new ShapedRecipe(itemSword);
        recipeSword.shape(" L ", " L ", " S ");
        recipeSword.setIngredient('S', Material.STICK);
        recipeSword.setIngredient('L', Material.EMERALD);
        Bukkit.getServer().addRecipe(recipeSword);
    }

    public static void createLegendaryBow() {
        final ItemStack itemBow = new ItemStack(Material.BOW, 1);
        final ItemMeta bowMeta = itemBow.getItemMeta();
        bowMeta.setDisplayName("§bArc électrique");
        final List<String> lore = new ArrayList<>();
        lore.add("§7§m----------------------------------");
        lore.add("");
        lore.add("§bSolidité 5");
        lore.add("§bPunch 2");
        lore.add("§bInfinity 1");
        lore.add("§bReste dans l'inventaire après la mort");
        lore.add("");
        lore.add("§7§m----------------------------------");
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, false);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemBow.setItemMeta(bowMeta);
        legendaryBow = itemBow;
        final ShapedRecipe recipeBow = new ShapedRecipe(itemBow);
        recipeBow.shape("LS ", "L S", "LS ");
        recipeBow.setIngredient('S', Material.STICK);
        recipeBow.setIngredient('L', Material.EMERALD_BLOCK);
        Bukkit.getServer().addRecipe(recipeBow);
    }

    public static void createHealSword() {
        final ItemStack itemSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        final ItemMeta swordMeta = itemSword.getItemMeta();
        swordMeta.setDisplayName("§4Épée de Soin");
        final List<String> lore = new ArrayList<>();
        lore.add("§7§m----------------------------------");
        lore.add("");
        lore.add("§4Tranchant 5");
        lore.add("§4Solidité 3");
        lore.add("§4Aura de feu 2");
        lore.add("§45% de chance d'être soigné");
        lore.add("");
        lore.add("§7§m----------------------------------");
        swordMeta.setLore(lore);
        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        swordMeta.addEnchant(Enchantment.DURABILITY, 3, false);
        swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
        swordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemSword.setItemMeta(swordMeta);
        healsword = itemSword;
        final ShapedRecipe recipeSword = new ShapedRecipe(itemSword);
        recipeSword.shape(" L ", " L ", " S ");
        recipeSword.setIngredient('S', Material.STICK);
        recipeSword.setIngredient('L', Material.EMERALD_BLOCK);
        Bukkit.getServer().addRecipe(recipeSword);
    }

    public static void createThorSword() {
        final ItemStack itemSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        final ItemMeta swordMeta = itemSword.getItemMeta();
        swordMeta.setDisplayName("§6Épée de Thor");
        final List<String> lore = new ArrayList<>();
        lore.add("§7§m----------------------------------");
        lore.add("");
        lore.add("§6Tranchant 5");
        lore.add("§6Solidité 3");
        lore.add("§6Aura de feu 2");
        lore.add("§620% de lancer des éclaires");
        lore.add("");
        lore.add("§7§m----------------------------------");
        swordMeta.setLore(lore);
        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        swordMeta.addEnchant(Enchantment.DURABILITY, 3, false);
        swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
        swordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemSword.setItemMeta(swordMeta);
        thorSword = itemSword;
        final ShapedRecipe recipeSword = new ShapedRecipe(itemSword);
        recipeSword.shape(" L ", " L ", " S ");
        recipeSword.setIngredient('S', Material.STICK);
        recipeSword.setIngredient('L', Material.GOLD_BLOCK);
        Bukkit.getServer().addRecipe(recipeSword);
    }

    public static void createWitherSword() {
        final ItemStack itemSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        final ItemMeta swordMeta = itemSword.getItemMeta();
        swordMeta.setDisplayName("§8Épée de wither");
        final List<String> lore = new ArrayList<>();
        lore.add("§7§m----------------------------------");
        lore.add("");
        lore.add("§8Tranchant 5");
        lore.add("§8Solidité 3");
        lore.add("§8Aura de feu 2");
        lore.add("§820% de chance de donner wither 2 pendant 3s");
        lore.add("");
        lore.add("§7§m----------------------------------");
        swordMeta.setLore(lore);
        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        swordMeta.addEnchant(Enchantment.DURABILITY, 3, false);
        swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
        swordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemSword.setItemMeta(swordMeta);
        witherSword = itemSword;
        final ShapedRecipe recipeSword = new ShapedRecipe(itemSword);
        recipeSword.shape(" L ", " L ", " S ");
        recipeSword.setIngredient('S', Material.STICK);
        recipeSword.setIngredient('L', Material.DIAMOND_BLOCK);
        Bukkit.getServer().addRecipe(recipeSword);
    }

    public static void createPoisonSword() {
        final ItemStack itemSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        final ItemMeta swordMeta = itemSword.getItemMeta();
        swordMeta.setDisplayName("§2Épée de poison");
        final List<String> lore = new ArrayList<>();
        lore.add("§7§m----------------------------------");
        lore.add("");
        lore.add("§2Tranchant 5");
        lore.add("§2Solidité 3");
        lore.add("§2Aura de feu 2");
        lore.add("§220% de chance de donner poison 2 pendant 3s");
        lore.add("");
        lore.add("§7§m----------------------------------");
        swordMeta.setLore(lore);
        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        swordMeta.addEnchant(Enchantment.DURABILITY, 3, false);
        swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, false);
        swordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemSword.setItemMeta(swordMeta);
        poisonSword = itemSword;
        final ShapedRecipe recipeSword = new ShapedRecipe(itemSword);
        recipeSword.shape(" L ", " L ", " S ");
        recipeSword.setIngredient('S', Material.STICK);
        recipeSword.setIngredient('L', Material.NETHER_STAR);
        Bukkit.getServer().addRecipe(recipeSword);
    }

}
