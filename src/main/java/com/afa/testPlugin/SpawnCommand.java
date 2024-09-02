package com.afa.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private Main main;
    public SpawnCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Location spawn = new Location(
                    Bukkit.getWorld(main.getConfig().getString("commands.spawn.coordinates.World")),
                    main.getConfig().getInt("commands.spawn.coordinates.X"),
                    main.getConfig().getInt("commands.spawn.coordinates.Y"),
                    main.getConfig().getInt("commands.spawn.coordinates.Z")
            );
            player.teleport(spawn);
            player.sendMessage(ChatColor.GREEN + "You have been teleported to spawn!");
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        }
        return false;
    }
}
