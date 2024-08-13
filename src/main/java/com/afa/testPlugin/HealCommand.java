package com.afa.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    Main main;
    public HealCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (main.getConfig().getBoolean("commands.heal.enabled") == true) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission(main.getConfig().getString("commands.heal.permission"))) {
                    player.sendMessage(ChatColor.GREEN + "Your health has been restored.");
                    player.setHealth(20);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("commands.heal.permission-message")));
                }
            }
        } else {
            if (sender instanceof Player) {
                ((Player) sender).sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("commands.heal.disabled-message")));
            } else {
                Bukkit.getLogger().warning(main.getConfig().getString("commands.heal.disabled-message"));
            }
        }
        return false;
    }
}
