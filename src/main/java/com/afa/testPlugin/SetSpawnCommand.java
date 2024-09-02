package com.afa.testPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    private Main main;
    public SetSpawnCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
       if (commandSender instanceof Player) {
           Player player = (Player) commandSender;
           Location location = player.getLocation();
           main.getConfig().set("commands.spawn.coordinates.World", player.getLocation().getWorld().getName());
           main.getConfig().set("commands.spawn.coordinates.X", player.getLocation().getX());
           main.getConfig().set("commands.spawn.coordinates.Y", player.getLocation().getY());
           main.getConfig().set("commands.spawn.coordinates.Z", player.getLocation().getZ());
           player.getWorld().setSpawnLocation(location);
           player.sendTitle(ChatColor.GREEN + "Done", ChatColor.YELLOW + "Spawn set!");
           player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 0.5F);
       }
        return false;
    }
}
