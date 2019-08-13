package com.ohneemc.hub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBed implements CommandExecutor {

    private Hub plugin;

    CommandBed(Hub hub) {
        this.plugin = hub;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("bed") && commandSender instanceof Player) {
            if (plugin.location().containsKey("bed")){
                ((Player) commandSender).teleport(plugin.location().get("bed"));
                commandSender.sendMessage("You've been teleported to the bed!");
                return true;
            }else{
                commandSender.sendMessage("bed has not been set yet...");
                return true;
            }
        }
        return false;
    }
}
