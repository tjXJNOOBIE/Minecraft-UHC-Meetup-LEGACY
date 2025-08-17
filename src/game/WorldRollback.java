package game;

import me.Alex.KonixMeetup.Main;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

public class WorldRollback {
	
	public static void unloadMap(String mapname){
        if(Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(mapname), false)){
            Main.plugin.getLogger().info("Successfully unloaded " + mapname);
        }else{
            Main.plugin.getLogger().severe("COULD NOT UNLOAD " + mapname);
        }
    }
    public static void loadMap(String mapname){
        Bukkit.getServer().createWorld(new WorldCreator(mapname));
    }
 
    public static void rollback(String mapname){
        unloadMap(mapname);
        loadMap(mapname);
    }
}
