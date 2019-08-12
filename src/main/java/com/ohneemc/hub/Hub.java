package com.ohneemc.hub;

import de.leonhard.storage.Json;
import de.leonhard.storage.Toml;
import org.bstats.bukkit.Metrics;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Hub extends JavaPlugin {

    private Toml data = new Toml("locations", getDataFolder().toString());
    Toml settings(){ return data;}

    private HashMap<String, Location> locs = new HashMap<>();
    HashMap<String, Location> location() {return  locs;}

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        this.getServer().getLogger().info("[Hub] Author: Stian '1stian' Tofte");

        Metrics metrics = new Metrics(this);

        registerCommands();
        registerListeners();
        loadLocations();

        this.getServer().getLogger().info("[Hub] enabled!");

    }

    private void registerCommands(){
        this.getCommand("hub").setExecutor(new CommandHub(this));
        this.getCommand("sethub").setExecutor(new CommandSethub(this));
    }

    private void registerListeners(){

    }

    private void loadLocations(){
        //Loading hub...
        //First check if hub has been set.
        if (settings().contains("hub")){
            double x = settings().getDouble("hub.x");
            double y = settings().getDouble("hub.y");
            double z = settings().getDouble("hub.z");
            float pitch = settings().getFloat("hub.pitch");
            float yaw = settings().getFloat("hub.yaw");
            World world = this.getServer().getWorld("hub.world");
            Location loc = new Location(world, x, y,z,yaw,pitch);
            location().put("hub", loc);
            this.getServer().getLogger().info("[Hub] Hub has been loaded.");
        }else{
            this.getServer().getLogger().info("[Hub] Hub has not been set yet.");
        }

        if (settings().contains("shop")){
            double x = settings().getDouble("shop.x");
            double y = settings().getDouble("shop.y");
            double z = settings().getDouble("shop.z");
            float pitch = settings().getFloat("shop.pitch");
            float yaw = settings().getFloat("shop.yaw");
            World world = this.getServer().getWorld("shop.world");
            Location loc = new Location(world, x, y,z,yaw,pitch);
            location().put("shop", loc);
            this.getServer().getLogger().info("[Hub] shop has been loaded.");
        }else{
            this.getServer().getLogger().info("[Hub] shop has not been set yet.");
        }

        if (settings().contains("bed")){
            double x = settings().getDouble("bed.x");
            double y = settings().getDouble("bed.y");
            double z = settings().getDouble("bed.z");
            float pitch = settings().getFloat("bed.pitch");
            float yaw = settings().getFloat("bed.yaw");
            World world = this.getServer().getWorld("bed.world");
            Location loc = new Location(world, x, y,z,yaw,pitch);
            location().put("bed", loc);
            this.getServer().getLogger().info("[Hub] bed has been loaded.");
        }else{
            this.getServer().getLogger().info("[Hub] bed has not been set yet.");
        }

        if (settings().contains("enchant")){
            double x = settings().getDouble("enchant.x");
            double y = settings().getDouble("enchant.y");
            double z = settings().getDouble("enchant.z");
            float pitch = settings().getFloat("enchant.pitch");
            float yaw = settings().getFloat("enchant.yaw");
            World world = this.getServer().getWorld("enchant.world");
            Location loc = new Location(world, x, y,z,yaw,pitch);
            location().put("enchant", loc);
            this.getServer().getLogger().info("[Hub] enchant has been loaded.");
        }else{
            this.getServer().getLogger().info("[Hub] enchant has not been set yet.");
        }
    }
}
