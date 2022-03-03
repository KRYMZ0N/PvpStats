package me.krymz0n.pvpstatistics;

import me.krymz0n.pvpstatistics.listener.DeathListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
