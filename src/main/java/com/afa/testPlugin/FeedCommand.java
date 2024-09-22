package com.afa.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    private Main main;
    public FeedCommand(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (main.getConfig().getBoolean("commands.feed.enabled") == true) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission(main.getConfig().getString("commands.feed.permission"))) {
                    player.sendMessage(ChatColor.GREEN + "Your appetite has been satisfied.");
                    player.setFoodLevel(20);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("commands.feed.permission-message") ));
                }
            }
        } else {
            if (sender instanceof Player) {
                ((Player) sender).sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("commands.feed.disabled-message")));
            } else {
                Bukkit.getLogger().warning(main.getConfig().getString("commands.feed.disabled-message"));
            }
        }
        return false;
    }
}
