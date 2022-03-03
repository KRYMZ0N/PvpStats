package me.krymz0n.pvpstatistics.listener;

import me.krymz0n.pvpstatistics.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    private final Main plugin;

    public DeathListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onDeath(PlayerDeathEvent evt) {
        Player p = evt.getEntity();
        String name = p.getDisplayName();
        int deaths = plugin.getConfig().getInt(name + " deaths");


        if (plugin.getConfig().get(name + " deaths") != null) {
            System.out.println("not null");
            deaths++;

            plugin.getConfig().set(name + " deaths", deaths);
            plugin.saveConfig();
        } else {
            System.out.println("Null");
            plugin.getConfig().set(name + " deaths", 1);
            plugin.saveConfig();
        }

        if (p.getKiller() != null) {
            Player killer = p.getKiller();
            String killName = killer.getDisplayName();
            int kills = plugin.getConfig().getInt(killName + " kills");


            if (plugin.getConfig().get(killName + " kills") != null) {
                System.out.println("not null");
                kills++;

                plugin.getConfig().set(killName + " kills", kills);
                plugin.saveConfig();
            } else {
                System.out.println("Null");
                plugin.getConfig().set(killName + " kills", 1);
                plugin.saveConfig();
            }
        }
    }
}
