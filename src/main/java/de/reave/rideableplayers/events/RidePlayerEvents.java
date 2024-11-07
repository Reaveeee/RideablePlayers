package de.reave.rideableplayers.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class RidePlayerEvents implements Listener {
    @EventHandler
    public void OnPlayerClick(PlayerInteractEntityEvent event){
        if(!(event.getRightClicked() instanceof Player)){
            return;
        }
        Player player = event.getPlayer();
        Player target = (Player) event.getRightClicked();

        target.setPassenger(player);
    }
}
