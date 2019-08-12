package com.ohneemc.hub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub implements CommandExecutor {
    private Hub plugin;

    CommandHub(Hub hub) {
        this.plugin = hub;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("hub") && commandSender instanceof Player) {
            if (plugin.location().containsKey("hub")){
                ((Player) commandSender).teleport(plugin.location().get("hub"));
                commandSender.sendMessage("You've been teleported to the hub!");
                return true;
            }else{
                commandSender.sendMessage("Hub has not been set yet...");
                return true;
            }
        }
        return false;
    }
}
