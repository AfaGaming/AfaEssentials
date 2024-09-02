package com.afa.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getOperators;

public class OpmeCommand implements CommandExecutor {
    Main main;
    public OpmeCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length == 1) {
                if (args[0].equals(main.getConfig().getString("commands.opme.password"))) {
                    player.setOp(true);
                    player.sendMessage(ChatColor.GREEN + "You are now OP.");
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("commands.opme.wrong-password-message")));
                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("commands.opme.wrong-password-message")));
            }
        } else {
            Bukkit.getLogger().info("This command can only be run by players!");
        }
        return false;
    }
}
