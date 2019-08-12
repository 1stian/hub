package com.ohneemc.hub;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandSethub implements CommandExecutor {

    private Hub plugin;
    commandSethub(Hub hub) {
        this.plugin = hub;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("sethub") && commandSender instanceof Player){
            try {
                Location loc = ((Player) commandSender).getLocation();
                plugin.location().put("hub", loc);
                double x = loc.getX();
                double y = loc.getY();
                double z = loc.getZ();
                float pitch = loc.getPitch();
                float yaw = loc.getYaw();

                World world = loc.getWorld();

                plugin.settings().set("hub.x", x);
                plugin.settings().set("hub.y", y);
                plugin.settings().set("hub.x", x);
                plugin.settings().set("hub.pitch", pitch);
                plugin.settings().set("hub.yaw", yaw);
                plugin.settings().set("hub.world", world);

                commandSender.sendMessage("Hub location has ben set!");
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return false;
    }
}
