package fr.blixow.nefazia;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class EventCrops implements Listener {

    public Material setCropToSeedMap(Material material) {
        Map<Material, Material> cropToSeedMap = new HashMap<>();
        cropToSeedMap.put(Material.WHEAT, Material.SEEDS);
        cropToSeedMap.put(Material.POTATO, Material.POTATO_ITEM);
        cropToSeedMap.put(Material.CARROT, Material.CARROT_ITEM);
        cropToSeedMap.put(Material.NETHER_WARTS, Material.NETHER_WARTS);
        return cropToSeedMap.get(material);
    }

    public boolean isFullyGrown(Block block) {
        if (block.getType() == Material.NETHER_WARTS)
            return (block.getData() == 3);
        return (block.getData() == 7);
    }

    private boolean isCrops(Block block) {
        ArrayList<Material> mats = new ArrayList<>();
        mats.add(Material.CROPS);
        mats.add(Material.CARROT);
        mats.add(Material.POTATO);
        mats.add(Material.NETHER_WARTS);
        return mats.contains(block.getType());
    }

    @EventHandler
    public void cropsBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Collection<ItemStack> drops = block.getDrops();
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        Location location = event.getBlock().getLocation();
        if (item.getType() == Material.DIAMOND_HOE && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals("§bMoisonneuse") && isCrops(block)) {
            if (isCrops(block)) {
                if (isFullyGrown(block)) {
                    addExperienceAndDrop(drops, player, location);
                    replantSeed(location, block.getType());
                    for (int x = -5; x < 5; x++) {
                        for (int z =  -5; z < 5; z++) {
                            Block blockReplant = event.getPlayer().getWorld().getBlockAt(event.getBlock().getX() + x, event.getBlock().getY(), event.getBlock().getZ() + z);
                            blockReplant.setType(blockReplant.getType());
                        }
                    }
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }

    public void addExperienceAndDrop(Collection<ItemStack> drops, Player player, Location location) {
        Main.getPlugin().getLevelManager().addRandomExperience(player, 10,20);
        for (ItemStack drop : drops)
            player.getWorld().dropItem(location.clone().add(0.0D, 1.0D, 0.0D), drop);
    }

    public void replantSeed(Location location, Material cropBlockType) {
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
            location.getBlock().setType(cropBlockType);
        }, 0L);
    }

    public void removeSeed(PlayerInventory inventory, Material seedType) {
        int seedIndexLocation = -1;
        for (int slotIndex = 0; slotIndex < inventory.getSize(); slotIndex++) {
            ItemStack currentItems = inventory.getItem(slotIndex);
            if (currentItems != null &&
                    currentItems.getType() == seedType) {
                seedIndexLocation = slotIndex;
                break;
            }
        }
        if (seedIndexLocation != -1) {
            ItemStack seedItemStack = inventory.getItem(seedIndexLocation);
            if (seedItemStack != null) {
                int seedAmount = seedItemStack.getAmount();
                seedItemStack.setAmount(seedAmount - 1);
            }
        }
    }

}