package fr.blixow.nefazia;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventSwords implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player))
            return;
        if (!(event.getDamager() instanceof Player))
            return;
        Player target = (Player) event.getEntity();
        Player attacker = (Player) event.getDamager();
        ItemStack item = attacker.getItemInHand();

        if (!item.getItemMeta().hasDisplayName()) {
                return;
            }
        if (Math.random() < 0.3) {
            if (item.getType() == Material.DIAMOND_SWORD && item.getItemMeta().getDisplayName().equals("§2Epée de poison")) {
                event.setCancelled(true);
                target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 1));
                return;
            }
            if (item.getType() == Material.DIAMOND_SWORD && item.getItemMeta().getDisplayName().equals("§8Epée de wither")) {
                event.setCancelled(true);
                target.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
                return;
            }
            if (item.getType() == Material.DIAMOND_SWORD && item.getItemMeta().getDisplayName().equals("§6Epée de Thor")) {
                event.setCancelled(true);
                target.getWorld().strikeLightning(target.getLocation());
                return;
            }
        } else if (Math.random() < 0.1) {
            if (item.getType() == Material.DIAMOND_SWORD && item.getItemMeta().getDisplayName().equals("§4Epée de Soin")) {
                event.setCancelled(true);
                attacker.setHealth(Math.min(20, attacker.getHealth() + 10));
                return;
            }
        }
    }
}
