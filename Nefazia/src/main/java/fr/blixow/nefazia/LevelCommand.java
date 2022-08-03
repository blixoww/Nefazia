package fr.blixow.nefazia;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class LevelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            switch (args.length) {
                default:
                    player.sendMessage("§c/level §8<§cjoueur§8> §8[§creset§8]");
                    break;
                case 1:
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        player.sendMessage("§8§m--------------------");
                        Main.getPlugin().getLevelManager().setLevelMessage(player);
                        player.sendMessage("§8§m--------------------");
                    } else {
                        player.sendMessage("§cLe joueur n'est pas trouvable");
                    }
                    break;
                case 2:
                    Player playerTarget = Bukkit.getPlayer(args[0]);
                    if (Objects.equals(args[1], "reset")) {
                        LevelData levelData = new LevelData(LevelEnum.LEVEL0, 0);
                        levelData.setLevel(LevelEnum.LEVEL0);
                        Main.getPlugin().getDataHashMap().put(player.getName(), levelData);
                        player.sendMessage("§eVous avez remis à §80 §eles niveaux de " + playerTarget.getName());
                        playerTarget.sendMessage("§eVos niveaux ont été remis à §80");
                        break;
                    }
            }
        }
        return false;
    }

}
