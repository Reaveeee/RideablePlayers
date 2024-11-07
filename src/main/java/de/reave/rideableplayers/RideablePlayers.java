package de.reave.rideableplayers;

import de.reave.rideableplayers.commands.RidePlayerCommand;
import de.reave.rideableplayers.commands.ThrowOffPlayerCommand;
import de.reave.rideableplayers.events.RidePlayerEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class RideablePlayers extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("rideplayer").setExecutor(new RidePlayerCommand());
        getCommand("throwoffplayer").setExecutor(new ThrowOffPlayerCommand());
        getServer().getPluginManager().registerEvents(new RidePlayerEvents(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
