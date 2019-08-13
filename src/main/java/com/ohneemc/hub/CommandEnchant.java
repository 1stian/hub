package com.ohneemc.hub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEnchant implements CommandExecutor {

    private Hub plugin;

    CommandEnchant(Hub hub) {
        this.plugin = hub;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("enchant") && commandSender instanceof Player) {
            if (plugin.location().containsKey("enchant")){
                ((Player) commandSender).teleport(plugin.location().get("enchant"));
                commandSender.sendMessage("You've been teleported to the enchant!");
                return true;
            }else{
                commandSender.sendMessage("enchant has not been set yet...");
                return true;
            }
        }
        return false;
    }
}
