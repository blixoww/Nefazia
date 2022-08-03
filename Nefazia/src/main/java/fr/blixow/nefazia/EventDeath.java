package fr.blixow.nefazia;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDeath implements Listener {

    private final Map<Player, List<ItemStack>> give = new HashMap<>();

    @EventHandler
    public void death(PlayerDeathEvent e) {
        List<ItemStack> list = new ArrayList<ItemStack>();

        for (ItemStack it : e.getDrops()) {
            if (it.hasItemMeta() && it.getItemMeta().hasDisplayName()
                    && it.getItemMeta().getDisplayName().equals("§bArc électrique")) {
                list.add(it);

            }
            if (it.hasItemMeta() && it.getItemMeta().hasDisplayName()
                    && it.getItemMeta().getDisplayName().equals("§5Épée électrique")) {
                list.add(it);

            }
        }
        for (ItemStack it : list) {
            e.getDrops().remove(it);
        }
        give.put(e.getEntity(), list);
    }

    @EventHandler
    public void respawn(PlayerRespawnEvent e) {
        for (ItemStack it : give.get(e.getPlayer())) {
            e.getPlayer().getInventory().addItem(it);
        }
    }
}
