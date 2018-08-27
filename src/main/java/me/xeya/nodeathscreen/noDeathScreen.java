package me.xeya.nodeathscreen;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class noDeathScreen extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        if (e.getEntity().hasPermission("nodeathscreen.use")) {
            // 1 tick async delay to stop the player picking up the items from death.
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
                public void run() {
                    e.getEntity().spigot().respawn();
                }

            }, 1L);

        }
    }
}
