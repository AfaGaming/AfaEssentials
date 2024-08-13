package com.afa.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConfigCommand implements CommandExecutor {
    Main main;
    public ConfigCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                // toggling commands
                switch (args[0].toLowerCase()) {
                    case "feed":
                        if (main.getConfig().getBoolean("commands.feed.enabled") == true) {
                            main.getConfig().set("commands.feed.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the feed command.");
                        } else {
                            main.getConfig().set("commands.feed.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the feed command.");
                        }
                        break;
                    case "heal":
                        if (main.getConfig().getBoolean("commands.heal.enabled") == true) {
                            main.getConfig().set("commands.heal.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the heal command.");
                        } else {
                            main.getConfig().set("commands.heal.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the heal command.");
                        }
                        break;
                    case "fly":
                        if (main.getConfig().getBoolean("commands.fly.enabled") == true) {
                            main.getConfig().set("commands.fly.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the fly command.");
                        } else {
                            main.getConfig().set("commands.fly.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the fly command.");
                        }
                        break;
                    case "god":
                        if (main.getConfig().getBoolean("commands.god.enabled") == true) {
                            main.getConfig().set("commands.god.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the god command.");
                        } else {
                            main.getConfig().set("commands.god.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the god command.");
                        }
                        break;
                    case "gamemode":
                        if (main.getConfig().getBoolean("commands.gamemode.enabled") == true) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        }
                        break;
                    case "gmc":
                        if (main.getConfig().getBoolean("commands.gamemode.enabled") == true) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        }
                        break;
                    case "gms":
                        if (main.getConfig().getBoolean("commands.gamemode.enabled") == true) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        }
                        break;
                    case "gma":
                        if (main.getConfig().getBoolean("commands.gamemode.enabled") == true) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        }
                        break;
                    case "gmsp":
                        if (main.getConfig().getBoolean("commands.gamemode.enabled") == true) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        }
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "You must enter a correct command to toggle it on or off.");
                        break;
                }
                main.saveConfig();
            } else if (args.length > 1) {
                switch (args[0].toLowerCase()) {
                    case "feed":
                        if (args[1].toLowerCase().equals("true")) {
                            // enable command
                            main.getConfig().set("commands.feed.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the feed command.");
                        } else if (args[1].toLowerCase().equals("false")) {
                            main.getConfig().set("commands.feed.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the feed command.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /config <command> [<true/false>]");
                        }
                        break;
                    case "heal":
                        if (args[1].toLowerCase().equals("true")) {
                            // enable command
                            main.getConfig().set("commands.heal.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the heal command.");
                        } else if (args[1].toLowerCase().equals("false")) {
                            main.getConfig().set("commands.heal.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the heal command.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /config <command> [<true/false>]");
                        }
                        break;
                    case "fly":
                        if (args[1].toLowerCase().equals("true")) {
                            // enable command
                            main.getConfig().set("commands.fly.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the fly command.");
                        } else if (args[1].toLowerCase().equals("false")) {
                            main.getConfig().set("commands.fly.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the fly command.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /config <command> [<true/false>]");
                        }
                        break;
                    case "god":
                        if (args[1].toLowerCase().equals("true")) {
                            // enable command
                            main.getConfig().set("commands.god.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the god command.");
                        } else if (args[1].toLowerCase().equals("false")) {
                            main.getConfig().set("commands.god.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the god command.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /config <command> [<true/false>]");
                        }
                        break;
                    case "gamemode":
                        if (args[1].toLowerCase().equals("true")) {
                            // enable command
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        } else if (args[1].toLowerCase().equals("false")) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /config <command> [<true/false>]");
                        }
                        break;
                    case "gmc":
                        if (args[1].toLowerCase().equals("true")) {
                            // enable command
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        } else if (args[1].toLowerCase().equals("false")) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /config <command> [<true/false>]");
                        }
                        break;
                    case "gms":
                        if (args[1].toLowerCase().equals("true")) {
                            // enable command
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        } else if (args[1].toLowerCase().equals("false")) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /config <command> [<true/false>]");
                        }
                        break;
                    case "gma":
                        if (args[1].toLowerCase().equals("true")) {
                            // enable command
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        } else if (args[1].toLowerCase().equals("false")) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /config <command> [<true/false>]");
                        }
                        break;
                    case "gmsp":
                        if (args[1].toLowerCase().equals("true")) {
                            // enable command
                            main.getConfig().set("commands.gamemode.enabled", true);
                            player.sendMessage(ChatColor.GREEN + "You have enabled the gamemode commands.");
                        } else if (args[1].toLowerCase().equals("false")) {
                            main.getConfig().set("commands.gamemode.enabled", false);
                            player.sendMessage(ChatColor.RED + "You have disabled the gamemode commands.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /config <command> [<true/false>]");
                        }
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "You must enter a valid command to toggle it!");
                        break;
                }
                main.saveConfig();
            } else {
                player.sendMessage(ChatColor.RED + "You provided too many arguments!");
            }
        } else {
            Bukkit.getLogger().info("Only players can use this command.");
        }
        return true;
    }
}
