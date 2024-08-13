package events;

import com.afa.testPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    private Main main;
    public PlayerJoin(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (main.getConfig().getBoolean("events.onJoin.enabled") == true) {
            for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
                //
            }
        }
    }
}
