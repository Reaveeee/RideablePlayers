package de.reave.rideableplayers.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.reave.rideableplayers.Utils.ColoredText;
import static de.reave.rideableplayers.Utils.PluginText;

public class ThrowOffPlayerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        //Errors
        if(!sender.hasPermission("throwoffplayer")){
            sender.sendMessage(PluginText(ColoredText("Error: Insufficient permissions", ChatColor.RED)));
            return true;
        }
        if(!(sender instanceof Player)){
            sender.sendMessage(PluginText(ColoredText("Error: You are no player", ChatColor.RED)));
            return true;
        }
        if(args.length != 0){
            sender.sendMessage(PluginText(ColoredText("Error: No arguments expected", ChatColor.RED)));
            return true;
        }

        Player player = (Player) sender;

        player.removePassenger(player.getPassenger());

        return false;
    }
}
