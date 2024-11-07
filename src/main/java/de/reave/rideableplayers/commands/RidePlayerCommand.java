package de.reave.rideableplayers.commands;

import de.reave.rideableplayers.Utils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.reave.rideableplayers.Utils.PluginText;
import static de.reave.rideableplayers.Utils.ColoredText;

public class RidePlayerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        //Errors
        if(!sender.hasPermission("rideplayer")){
            sender.sendMessage(PluginText(ColoredText("Error: Insufficient permissions", ChatColor.RED)));
            return true;
        }
        if(!(sender instanceof Player)){
            sender.sendMessage(PluginText(ColoredText("Error: You are no player", ChatColor.RED)));
            return true;
        }
        if(args.length != 1){
            sender.sendMessage(PluginText(ColoredText("Error: You have to select one player", ChatColor.RED)));
            return true;
        }
        if(!sender.getServer().getOnlinePlayers().contains(sender.getServer().getPlayer(args[0]))){
            sender.sendMessage(PluginText(ColoredText("Error: This player isn't online", ChatColor.RED)));
            return true;
        }
        if(args[0].equals(sender.getName())){
            sender.sendMessage(PluginText(ColoredText("Error: You can't ride yourself", ChatColor.RED)));
            return true;
        }

        Player player = (Player) sender;
        Player target = player.getServer().getPlayer(args[0]);

        /*double distance = Math.sqrt(Math.pow(player.getLocation().toVector().getX() - target.getLocation().toVector().getX(), 2) + Math.pow(player.getLocation().toVector().getY() - target.getLocation().toVector().getY(), 2) + Math.pow(player.getLocation().toVector().getZ() - target.getLocation().toVector().getZ(), 2));
        if(distance > 3){
            sender.sendMessage(PluginText(ColoredText("Error: Distance too large", ChatColor.RED)));
            return true;
        }*/

        target.setPassenger(player);

        return false;
    }
}
