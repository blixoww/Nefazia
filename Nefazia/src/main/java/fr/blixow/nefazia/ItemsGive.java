package fr.blixow.nefazia;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import java.util.ArrayList;
import java.util.List;

public class ItemsGive implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        PlayerInventory inventory = ((Player) sender).getInventory();

        if (sender.isOp()) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("healsword")) {
                    inventory.addItem(ItemManager.healsword);
                } else if (args[0].equalsIgnoreCase("withersword")) {
                    inventory.addItem(ItemManager.witherSword);
                } else if (args[0].equalsIgnoreCase("poisonsword")) {
                    inventory.addItem(ItemManager.poisonSword);
                } else if (args[0].equalsIgnoreCase("thorsword")) {
                    inventory.addItem(ItemManager.thorSword);
                } else if (args[0].equalsIgnoreCase("electricbow")) {
                    inventory.addItem(ItemManager.legendaryBow);
                } else if (args[0].equalsIgnoreCase("electricsword")) {
                    inventory.addItem(ItemManager.legendarySword);
                } else if (args[0].equalsIgnoreCase("fishingrod")) {
                    inventory.addItem(ItemManager.fishingRod);
                } else if (args[0].equalsIgnoreCase("harvesterhoe")) {
                    inventory.addItem(ItemManager.harvesterHoe);
                }
            } else {
                sender.sendMessage("§cL'item n'est pas trouvable.");
            }
        } else {
            sender.sendMessage("§cVous n'avez pas accès à cette commande.");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> list = new ArrayList<>();
        if (sender.isOp()) {
            if (args.length == 1) {
                list.add("healsword");
                list.add("withersword");
                list.add("poisonsword");
                list.add("thorsword");
                list.add("electricbow");
                list.add("electricsword");
                list.add("fishingrod");
                list.add("harvesterhoe");
            }
        }
        return list;
    }
}
