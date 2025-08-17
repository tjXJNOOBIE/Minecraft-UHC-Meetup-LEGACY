package events;

import commands.Spectate;
import game.Start;
import game.Utils;
import me.Alex.KonixMeetup.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Scoreboard implements Listener {
	
	  public static String getTime()
	  {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM HH:mm");
	    return sdf.format(cal.getTime());
	  }

	  public static String getDate()
	  {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
	    return sdf.format(cal.getTime());
	  }

	  public static String getAdvancedTime()
	  {
	    TimeZone timeZone = Calendar.getInstance().getTimeZone();

	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	    return sdf.format(cal.getTime()) + " " + timeZone.getDisplayName(false, 0);
	  }

	  @SuppressWarnings("deprecation")
	public static void leadboard(final Player player)
	  {
		  org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		  Objective obj = board.registerNewObjective("main", "dummy");
		  obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		  obj.setDisplayName(ChatColor.AQUA + "Lobby");


		  Objective objective = board.registerNewObjective("health", "health");
		  objective.setDisplayName("§4 ❤");

		  objective.setDisplaySlot(DisplaySlot.BELOW_NAME);








		  Score you = obj.getScore(
				  Bukkit.getOfflinePlayer("§7» §bYou §7«"));
		  you.setScore(16);

		  Score spacer1 = obj.getScore(
				  Bukkit.getOfflinePlayer(ChatColor.GRAY+" "));
		  spacer1.setScore(14);











		  Score p = obj.getScore(Bukkit.getOfflinePlayer( "§7» §bRank §7«"));
		  p.setScore(13);

		  Score blank4 = obj.getScore(Bukkit.getOfflinePlayer(org.bukkit.ChatColor.GRAY + "             "));
		  blank4.setScore(11);




		  Score info = obj.getScore(Bukkit.getOfflinePlayer( "§7» §bInfo§7 «"));
		  info.setScore(10);

		  Score blank2 = obj.getScore(Bukkit.getOfflinePlayer(org.bukkit.ChatColor.GRAY + "    "));
		  blank2.setScore(4);


		  Score server = obj.getScore(
				  Bukkit.getOfflinePlayer("§7» §bServer §7«"));
		  server.setScore(6);




		  Score blank6 = obj.getScore(Bukkit.getOfflinePlayer(org.bukkit.ChatColor.GRAY + "              "));
		  blank6.setScore(7);





		  final Team Watching = board.registerNewTeam("watching");
		  Watching.addEntry(ChatColor.WHITE.toString() +"§3Watching§f:" );
		  obj.getScore(ChatColor.WHITE.toString() +"§3Watching§f:" ).setScore(2);

		  final Team Playing = board.registerNewTeam("playing");
		  Playing.addEntry(ChatColor.WHITE.toString() +"§3Playing§f:" + ChatColor.WHITE);
		  obj.getScore(ChatColor.WHITE.toString() +"§3Playing§f:" + ChatColor.WHITE).setScore(3);



		  final Team date = board.registerNewTeam("date");
		  date.addEntry(org.bukkit.ChatColor.WHITE.toString());
		  date.setSuffix(ChatColor.GRAY+getDate());
		  obj.getScore(org.bukkit.ChatColor.WHITE.toString()).setScore(9);


		  final Team advtime = board.registerNewTeam("advtime");
		  advtime.addEntry(org.bukkit.ChatColor.GREEN.toString() + ""+org.bukkit.ChatColor.WHITE);
		  obj.getScore(org.bukkit.ChatColor.GREEN.toString() + org.bukkit.ChatColor.WHITE).setScore(8);

		  final Team Server = board.registerNewTeam("server");
		  Server.addEntry(org.bukkit.ChatColor.DARK_AQUA.toString() + "US§f:" + " " + org.bukkit.ChatColor.WHITE);
		  Server.setSuffix(ChatColor.GREEN + Bukkit.getServer().getServerId());
		  obj.getScore(org.bukkit.ChatColor.DARK_AQUA.toString() + "US§f:" + " " + org.bukkit.ChatColor.WHITE).setScore(5);

		  final Team Rank = board.registerNewTeam("rank");
		  Rank.addEntry(Utils.getRank(player)+ " " + org.bukkit.ChatColor.WHITE);
		  obj.getScore(Utils.getRank(player)+ " " + org.bukkit.ChatColor.WHITE).setScore(12);

		  final Team You = board.registerNewTeam("you");
		  You.addEntry(org.bukkit.ChatColor.DARK_AQUA.toString() + player.getName());
		  obj.getScore(org.bukkit.ChatColor.DARK_AQUA.toString() + player.getName()).setScore(15);

		  player.setScoreboard(board);
		  new BukkitRunnable() {
			  public void run() {
				int playing= Start.alive.size();
				  int specs = Spectate.spec.size() ;

				  advtime.setSuffix(ChatColor.DARK_GRAY + getAdvancedTime());
				  board.getTeam("playing").setSuffix("§a " + playing);
				  board.getTeam("watching").setSuffix("§a " + specs);


				  obj.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lBlimp Network"));
	      }
	    }
	    .runTaskTimer(Main.getPlugin(), 20L, 20L);
	  }
	
	public static void updateScoreboard(final Player p){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, new Runnable(){
			public void run(){
				removeScoreboard(p);
				setScoreboard(p);
			}
		}, 0, 101L);
	}
	
	public static void setScoreboard(Player p){
		String gamestate = null;
		if(p.getWorld().getName().equalsIgnoreCase("MULOBBY")){
			gamestate = "§aLobby";
		}
		
		if(p.getWorld().getName().equalsIgnoreCase("UHC")){
			gamestate = "§cIn-Game";
		}
		String name = p.getName();
		if(name.length() == 15){
			name = name.substring(0, name.length() - 1);
		}
		
		if(name.length() == 16){
			name = name.substring(0, name.length() - 2);
		}

		ScoreboardManager manager = Bukkit.getScoreboardManager();
		org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective("test", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("§6Konix §8⎜ §aMeetup");
		Score s22 = objective.getScore("§8");
		s22.setScore(12);
		Score l = objective.getScore("§b" + name);
		l.setScore(11);
		Score w = objective.getScore("§e");
		w.setScore(10); 
		Score f = objective.getScore("§6Kills: §f" + DeathEvent.kills.get(p.getName()));
		f.setScore(9);
		Score f3 = objective.getScore("§6");
		f3.setScore(8);
		Score f2 = objective.getScore("§6Alive: §f" + Start.alive.size());
		f2.setScore(7);
		Score m = objective.getScore("§6Specs: §f" + Spectate.spec.size());
		m.setScore(6);
		Score f5 = objective.getScore("§5");
		f5.setScore(5);
		Score j = objective.getScore("§6Gamestate:");
		j.setScore(4);
		Score v = objective.getScore(gamestate);
		v.setScore(3);
		Score f4 = objective.getScore("§b");
		f4.setScore(2);
		Score s8 = objective.getScore("§bNA.KonixMC.net");
		s8.setScore(1);
		p.setScoreboard(board);
	}
	
	public static void removeScoreboard(Player p){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		p.setScoreboard(manager.getNewScoreboard());
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		leadboard(p);
	}
}
