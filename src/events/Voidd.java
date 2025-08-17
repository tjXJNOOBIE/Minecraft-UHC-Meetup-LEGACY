package events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Voidd implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		if(e.getPlayer().getLocation().getY() <= 10&&e.getPlayer().getWorld().getName().equals("MULOBBY")){
				float direction = 90;
				Location l = new Location(Bukkit.getWorld("MULOBBY"), 0, 51, 0, direction, 0);
				e.getPlayer().teleport(l);

		}
	}
}
