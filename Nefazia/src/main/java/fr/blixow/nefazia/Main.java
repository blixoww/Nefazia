package fr.blixow.nefazia;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {
    private static Main main;
    private LevelManager levelManager;
    private HashMap <String, LevelData> dataHashMap;
    private FileConfiguration configuration;
    
    @Override
    public void onEnable() {
        this.getCommand("ngive").setExecutor(new ItemsGive());
        this.getCommand("level").setExecutor(new LevelCommand());
        this.dataHashMap = new HashMap<>();

        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new EventSwords(), this);
        pm.registerEvents(new EventDeath(), this);
        pm.registerEvents(new EventCrops(), this);
        pm.registerEvents(new PlayerData(), this);
        configuration = getConfig();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    @Override
    public void onDisable() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            savePlayerData(player);
        }
    }

    @Override
    public void onLoad() {
        Main.main = this;
        ItemManager.init();
        levelManager = new LevelManager();
    }

    public void savePlayerData(Player player) {
        if (Main.getPlugin().getDataHashMap().containsKey(player.getName())) {
            LevelData levelData = Main.getPlugin().getDataHashMap().get(player.getName());
            Main.getPlugin().getConfiguration().set(player.getName() + ".levelData.level", levelData.getLevel().ordinal());
            Main.getPlugin().getConfiguration().set(player.getName() + ".levelData.xp", levelData.getXp());
            Main.getPlugin().saveConfig();
        }
    }
    public static Main getPlugin() {
        return main;
    }
    public FileConfiguration getConfiguration() { return configuration; }
    public LevelManager getLevelManager() { return levelManager; }
    public HashMap<String, LevelData> getDataHashMap() {
        return dataHashMap;
    }
    public LevelData getLevelDataByPlayerName(String name) {
        return Main.getPlugin().getDataHashMap().get(name);
    }
}
