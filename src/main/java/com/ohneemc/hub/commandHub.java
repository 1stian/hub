package com.ohneemc.hub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandHub implements CommandExecutor {
    private Hub plugin;
    commandHub (Hub hub){
        this.plugin = hub;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("hub") && commandSender instanceof Player){
            ((Player) commandSender).teleport(plugin.location().get("hub"));
            commandSender.sendMessage("You've been teleported to the hub!");
            return true;
        }
        return false;
    }
}
