package events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class HeadHealth implements Listener {
	
//	public static void registerHealthBar(){
	//	ScoreboardManager manager = Bukkit.getScoreboardManager();
	//	org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
		
	//	Objective o = board.registerNewObjective("health", "health");
	//	o.setDisplayName(ChatColor.DARK_RED + "❤");
	//	o.setDisplaySlot(DisplaySlot.BELOW_NAME);
		
	//	for(Player online : Bukkit.getOnlinePlayers()){
	//		  online.setScoreboard(board);
	//		  online.setHealth(online.getHealth());
	//		  continue;
	//		}
	//}
	
	@EventHandler
    public void onPlayerRegainHealth(EntityRegainHealthEvent event) {
        if(event.getRegainReason() == RegainReason.SATIATED || event.getRegainReason() == RegainReason.REGEN
                || event.getRegainReason() == RegainReason.CUSTOM)

            event.setCancelled(true);
	}
}
