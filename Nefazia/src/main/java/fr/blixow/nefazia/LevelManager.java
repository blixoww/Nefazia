package fr.blixow.nefazia;

import org.bukkit.entity.Player;

public class LevelManager {

    public void addExperience(Player player, int experience) {
        LevelData levelData = Main.getPlugin().getLevelDataByPlayerName(player.getName());
        levelData.setXp(levelData.getXp() + experience);
        player.sendMessage("§e» §bVous avez gagné :§8 " + Integer.parseInt(String.valueOf(experience)) + "§b d'xp");
        this.xpLeveling(player);
    }

    public void addRandomExperience(Player player, int min, int max) {
        LevelData levelData = Main.getPlugin().getLevelDataByPlayerName(player.getName());
        int experience = min + (int) (Math.random() * (max - min) + 1);
        LevelEnum currentLevel = levelData.getLevel();
        if (currentLevel.ordinal() < currentLevel.getLevelLimit()) {
            levelData.setXp(levelData.getXp() + experience);
            player.sendMessage("§e» §bVous avez gagné :§8 " + Integer.parseInt(String.valueOf(experience)) + "§b d'xp");
            this.xpLeveling(player);
            this.progressionBarLevel(player);
        }
    }

    public void xpLeveling(Player player) {
        LevelData levelData = Main.getPlugin().getLevelDataByPlayerName(player.getName());
        LevelEnum levelEnum = LevelEnum.values()[levelData.getLevel().ordinal() + 1];
        LevelEnum currentLevel = levelData.getLevel();
        if (currentLevel.ordinal() < currentLevel.getLevelLimit()) {
            if (levelData.getXp() >= levelEnum.getXpNeeded()) {
                levelData.setXp(levelData.getXp() - levelEnum.getXpNeeded());
                levelData.setLevel(levelEnum);
                player.sendMessage("§e» §bPassage au niveau §8" + levelEnum.ordinal());
            }
        }
    }

    public void setLevelMessage(Player player) {
        LevelData levelData = Main.getPlugin().getLevelDataByPlayerName(player.getName());
        LevelEnum currentLevel = levelData.getLevel();
        Main.getPlugin().getDataHashMap().forEach((k, v) -> {
            try {
                String level = String.valueOf(v.getLevel().getLevelAmount());
                String xp = String.valueOf(v.getXp());
                if (currentLevel.ordinal() < currentLevel.getLevelLimit()) {
                    player.sendMessage("§e» §b" + k + " §7: §f " + level + " §8(§f" + xp + "§8xp" + "§8/§f" + currentLevel.getNextValue().getXpNeeded() + "§8)");
                } else {
                    player.sendMessage("§e» §b" + k + " §7: §f " + level + " §8(§fNiveau Maximum§8)");
                }
            } catch (Exception ignored) {
            }
        });
    }

    public void progressionBarLevel(Player player) {
        LevelData levelData = Main.getPlugin().getLevelDataByPlayerName(player.getName());
        LevelEnum currentLevel = levelData.getLevel();
        Main.getPlugin().getDataHashMap().forEach((k, v) -> {
            try {
                if (currentLevel.ordinal() < currentLevel.getLevelLimit()) {
                    int next_xp_level = currentLevel.getNextValue().getXpNeeded();
                    int percent = (levelData.getXp() * 10 / next_xp_level);
                    StringBuilder percent_string = new StringBuilder("§a");
                    for (int j = 0; j < 10; j++) {
                        if (j == percent) {
                            percent_string.append("§c");
                        }
                        percent_string.append("█");
                    }
                    player.sendMessage("" + percent_string);
                }
            } catch (Exception ignored) {
            }
        });
    }
}
