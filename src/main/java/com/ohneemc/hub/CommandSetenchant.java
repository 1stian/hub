package com.ohneemc.hub;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetenchant implements CommandExecutor {

    private Hub plugin;

    CommandSetenchant(Hub hub) {
        this.plugin = hub;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("setenchant") && commandSender instanceof Player) {
            if (strings.length == 1){
                if (strings[0].equalsIgnoreCase("confirm")){
                    return doRun((Player)commandSender);
                }else{
                    commandSender.sendMessage("Invalid arguments...");
                    return true;
                }
            }

            if (plugin.location().containsKey("enchant")){
                commandSender.sendMessage("enchant is already set.. Use /setenchant confirm to overwrite.");
                return true;
            }else{
                return doRun((Player)commandSender);
            }
        }

        return false;
    }

    private boolean doRun(Player player){
        try {
            Location loc = player.getLocation();
            plugin.location().put("enchant", loc);

            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            float pitch = loc.getPitch();
            float yaw = loc.getYaw();

            World world = loc.getWorld();

            plugin.settings().set("enchant.x", x);
            plugin.settings().set("enchant.y", y);
            plugin.settings().set("enchant.z", z);
            plugin.settings().set("enchant.pitch", pitch);
            plugin.settings().set("enchant.yaw", yaw);
            plugin.settings().set("enchant.world", world.getName());

            player.sendMessage("enchant location has ben set!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
