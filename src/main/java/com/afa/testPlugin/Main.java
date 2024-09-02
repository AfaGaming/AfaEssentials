package com.afa.testPlugin;

import events.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // CONFIG LOGIC
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // COMMANDS
        getCommand("heal").setExecutor(new HealCommand(this));
        getCommand("feed").setExecutor(new FeedCommand(this));
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("gmc").setExecutor(new gmcCommand(this));
        getCommand("gms").setExecutor(new gmsCommand(this));
        getCommand("gma").setExecutor(new gmaCommand(this));
        getCommand("gmsp").setExecutor(new gmspCommand(this));
        getCommand("gamemode").setExecutor(new GamemodeCommand(this));
        getCommand("god").setExecutor(new GodCommand(this));
        getCommand("opme").setExecutor(new OpmeCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
//        getCommand("config").setExecutor(new ConfigCommand(this));

        // EVENTS
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);

        // LOGGING PLUGIN START
        Bukkit.getLogger().info("Woohoo! My plugin has started.");
    }
}
