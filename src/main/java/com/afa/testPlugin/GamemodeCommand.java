package com.afa.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    Main main;
    public GamemodeCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (main.getConfig().getBoolean("commands.gamemode.enabled") == true) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission(main.getConfig().getString("commands.gamemode.permission"))) {
                    if (args.length >= 1) {
                        switch (args[0].toLowerCase()) {
                            case "creative":
                                player.setGameMode(GameMode.CREATIVE);
                                player.sendMessage(ChatColor.GREEN + "You are now in creative mode!");
                                break;
                            case "c":
                                player.setGameMode(GameMode.CREATIVE);
                                player.sendMessage(ChatColor.GREEN + "You are now in creative mode!");
                                break;
                            case "survival":
                                player.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage(ChatColor.GREEN + "You are now in survival mode!");
                                break;
                            case "s":
                                player.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage(ChatColor.GREEN + "You are now in survival mode!");
                                break;
                            case "adventure":
                                player.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage(ChatColor.GREEN + "You are now in adventure mode!");
                                break;
                            case "a":
                                player.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage(ChatColor.GREEN + "You are now in adventure mode!");
                                break;
                            case "spectator":
                                player.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage(ChatColor.GREEN + "You are now in spectator mode!");
                                break;
                            case "sp":
                                player.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage(ChatColor.GREEN + "You are now in spectator mode!");
                                break;
                            default:
                                player.sendMessage(ChatColor.RED + "That is not a valid gamemode!");
                                break;
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Please specify a gamemode!");
                    }
                } else {
                    player.sendMessage(main.getConfig().getString("commands.gamemode.permission-message"));
                }
            } else {
                Bukkit.getLogger().info("This command can only be used by players.");
            }
        } else {
            if (sender instanceof Player) {
                ((Player) sender).sendMessage(main.getConfig().getString("commands.gamemode.disabled-message"));
            } else {
                Bukkit.getLogger().warning(main.getConfig().getString("commands.gamemode.disabled-message"));
            }
        }
        return false;
    }
}