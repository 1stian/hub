package com.ohneemc.hub;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetshop implements CommandExecutor {

    private Hub plugin;

    CommandSetshop(Hub hub) {
        this.plugin = hub;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("setshop") && commandSender instanceof Player) {
            if (strings.length == 1){
                if (strings[0].equalsIgnoreCase("confirm")){
                    return doRun((Player)commandSender);
                }else{
                    commandSender.sendMessage("Invalid arguments...");
                    return true;
                }
            }

            if (plugin.location().containsKey("shop")){
                commandSender.sendMessage("shop is already set.. Use /setshop confirm to overwrite.");
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
            plugin.location().put("shop", loc);

            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            float pitch = loc.getPitch();
            float yaw = loc.getYaw();

            World world = loc.getWorld();

            plugin.settings().set("shop.x", x);
            plugin.settings().set("shop.y", y);
            plugin.settings().set("shop.z", z);
            plugin.settings().set("shop.pitch", pitch);
            plugin.settings().set("shop.yaw", yaw);
            plugin.settings().set("shop.world", world.getName());

            player.sendMessage("shop location has ben set!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
