package com.afa.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    private Main main;
    public FlyCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (main.getConfig().getBoolean("commands.fly.enabled") == true) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission(main.getConfig().getString("commands.fly.permission"))) {
                    if (player.getAllowFlight() == true) {
                        player.setAllowFlight(false);
                        player.sendMessage(ChatColor.RED + "Flight mode disabled.");
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage(ChatColor.GREEN + "Flight mode enabled.");
                    }
                } else {
                    player.sendMessage(main.getConfig().getString("commands.fly.permission-message"));
                }
            }
        } else {
            if (sender instanceof Player) {
                ((Player) sender).sendMessage(main.getConfig().getString("commands.fly.disabled-message"));
            } else {
                Bukkit.getLogger().warning(main.getConfig().getString("commands.fly.disabled-message"));
            }
        }

        return false;
    }
}
