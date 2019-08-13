package com.ohneemc.hub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandShop implements CommandExecutor {

    private Hub plugin;

    CommandShop(Hub hub) {
        this.plugin = hub;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("shop") && commandSender instanceof Player) {
            if (plugin.location().containsKey("shop")){
                ((Player) commandSender).teleport(plugin.location().get("shop"));
                commandSender.sendMessage("You've been teleported to the shop!");
                return true;
            }else{
                commandSender.sendMessage("shop has not been set yet...");
                return true;
            }
        }
        return false;
    }
}
