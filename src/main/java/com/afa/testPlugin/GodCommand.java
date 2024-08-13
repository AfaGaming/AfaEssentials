package com.afa.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    Main main;
    public GodCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (main.getConfig().getBoolean("commands.god.enabled") == true) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission(main.getConfig().getString("commands.god.permission"))) {
                    if (player.isInvulnerable()) {
                        player.sendMessage(ChatColor.RED + "God mode disabled.");
                        player.setInvulnerable(false);
                    } else {
                        player.sendMessage(ChatColor.GREEN + "God mode enabled.");
                        player.setInvulnerable(true);
                    }
                } else {
                    player.sendMessage(main.getConfig().getString("commands.god.permission-message"));
                }
            }

        } else {
            if (sender instanceof Player) {
                ((Player) sender).sendMessage(main.getConfig().getString("commands.god.disabled-message"));
            } else {
                Bukkit.getLogger().warning(main.getConfig().getString("commands.god.disabled-message"));
            }
        }
        return false;
    }
}
