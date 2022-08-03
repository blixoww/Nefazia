package fr.blixow.nefazia;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerData implements Listener {
    private Player player;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        player = event.getPlayer();
        if (Main.getPlugin().getConfiguration().contains(player.getName() + ".levelData") && Main.getPlugin().getConfiguration().contains(player.getName() + ".levelData.level") && Main.getPlugin().getConfiguration().contains(player.getName() + ".levelData.xp")) {
            LevelData levelData = new LevelData(LevelEnum.values()[Main.getPlugin().getConfiguration().getInt(player.getName() + ".levelData.level")], Main.getPlugin().getConfiguration().getInt(player.getName() + ".levelData.xp"));
            Main.getPlugin().getDataHashMap().put(player.getName(), levelData);
        } else {
            LevelData levelData = new LevelData(LevelEnum.LEVEL0, 0);
            Main.getPlugin().getDataHashMap().put(player.getName(), levelData);
        }
        Main.getPlugin().getLevelManager().setLevelMessage(player);
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        player = event.getPlayer();
        Main.getPlugin().savePlayerData(player);
    }
}
