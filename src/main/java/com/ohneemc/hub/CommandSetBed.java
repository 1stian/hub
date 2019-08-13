package com.ohneemc.hub;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetBed implements CommandExecutor {

    private Hub plugin;

    CommandSetBed(Hub hub) {
        this.plugin = hub;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("setbed") && commandSender instanceof Player) {
            if (strings.length == 1){
                if (strings[0].equalsIgnoreCase("confirm")){
                    return doRun((Player)commandSender);
                }else{
                    commandSender.sendMessage("Invalid arguments...");
                    return true;
                }
            }

            if (plugin.location().containsKey("bed")){
                commandSender.sendMessage("bed is already set.. Use /setbed confirm to overwrite.");
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
            plugin.location().put("bed", loc);

            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            float pitch = loc.getPitch();
            float yaw = loc.getYaw();

            World world = loc.getWorld();

            plugin.settings().set("bed.x", x);
            plugin.settings().set("bed.y", y);
            plugin.settings().set("bed.z", z);
            plugin.settings().set("bed.pitch", pitch);
            plugin.settings().set("bed.yaw", yaw);
            plugin.settings().set("bed.world", world.getName());

            player.sendMessage("bed location has ben set!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
