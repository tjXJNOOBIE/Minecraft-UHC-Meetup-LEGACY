package events;

import game.Start;
import me.Alex.KonixMeetup.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import stats.Stats;

import java.util.ArrayList;

public class EndgameDeterminant implements Listener {
	
	public static ArrayList<String> endgame = new ArrayList<String>();
	
	public static boolean endGame(final Player p){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, new Runnable() {
		    int counter = 11;
		    public void run() {
		        if (counter != -1) {
		            counter--;
		            if (counter != 0) {
		            	if(endgame.contains("false")){
		            	if(counter == 10){
		            		endgame.add("true");
							Bukkit.broadcastMessage("§6§k§l !;[;];];];];[;];];];[];];];[]!");
							Bukkit.broadcastMessage("   ");

							Bukkit.broadcastMessage(Main.getPrefix() + p.getDisplayName() + " §6has won Blimp UHC Meetup!");
							Bukkit.broadcastMessage("   ");

							Bukkit.broadcastMessage("§6§k§l!;[;];];];];[;];];];[];];];[]!");

							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd add &4&lCLEAN-UP");
		            		
		            	}

		            	if(counter == 9){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§4Server restarting in 10 seconds.");
		            	}
		            	if(counter==5){
		            		Main.SendToServer(p.getName(),"lobby",p);
						}

		            	if(counter == 3){
		            	}
		            	
		            	if(counter == 2){
		            		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "wr reset");
							Main.SendToServer(p.getName(),"lobby2",p);

						}
		            	
		            	if(counter == 1){
		            		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "restart");
		            	}
		                
		                if(counter <= 0) {
		                	counter = 0;
		                } 
		            	}
		            } else {
		                counter--;
		                	}
		                }
		    }
		}, 0L, 20L);
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player d = e.getEntity();
		Start.alive.remove(d.getName());
		if(Start.alive.size() <= 1){
			for(String pa : Start.alive){
				Player p2 = Bukkit.getPlayer(pa);
				endGame(p2);
				Stats.wins(p2);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerQuitEvent e){
		Player d = e.getPlayer();
		Start.alive.remove(d.getName());
		if(Start.alive.size() <= 1){
			for(String pa : Start.alive){
				Player p2 = Bukkit.getPlayer(pa);
				endGame(p2);
				Stats.wins(p2);
			}
		}
	}
}
