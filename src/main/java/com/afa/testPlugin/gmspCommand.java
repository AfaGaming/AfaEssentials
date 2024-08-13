package com.afa.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmspCommand implements CommandExecutor {
    Main main;
    public gmspCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (main.getConfig().getBoolean("commands.gamemode.enabled") == true) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission(main.getConfig().getString("commands.gamemode.permission"))) {
                    player.sendMessage(ChatColor.GREEN + "You are now in spectator mode!");
                    player.setGameMode(GameMode.SPECTATOR);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("commands.gamemode.permission-message")));
                }
            }
        } else {
            if (sender instanceof Player) {
                ((Player) sender).sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("commands.gamemode.disabled-message")));
            } else {
                Bukkit.getLogger().warning(main.getConfig().getString("commands.gamemode.disabled-message"));
            }
        }
        return false;
    }
}
