package commands;

import me.Alex.KonixMeetup.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import stats.Stats;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

public class StatsCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("stats")){
			if(args.length == 0){
				Player p = (Player) sender;
				getStats(p);
				return true;
			}
			
			Player p = (Player) sender;
			Player t = Bukkit.getPlayer(args[0]);
			OfflinePlayer ot = Bukkit.getOfflinePlayer(args[0]);
			if(!(t == null)){
				getsStats(t, p);
				return true;
			}
			
			if(t == null){
				getOfflineStats(ot, p);
			}
		}
		return true;
	}
	
	public static void getStats(Player p){
		Stats.openConnection();
		try{
			if(Stats.playerDataContainsPlayer(p)){
				PreparedStatement sql = Stats.connection.prepareStatement("SELECT deaths FROM `player_data` WHERE player=?;");
				sql.setString(1, p.getUniqueId().toString());
				ResultSet result = sql.executeQuery();
				result.next();
				int in = 0;
				in = result.getInt("deaths");
				
				PreparedStatement sql2 = Stats.connection.prepareStatement("SELECT kills FROM `player_data` WHERE player=?;");
				sql2.setString(1, p.getUniqueId().toString());
				ResultSet result2 = sql2.executeQuery();
				result2.next();
				int in2 = 0;
				in2 = result2.getInt("kills");
				
				double ratio = 0;
				DecimalFormat df2 = new DecimalFormat("#.##");
				double value = Double.valueOf(df2.format(ratio)).doubleValue();
				
				if(in != 0){
					ratio = (double) in2 / in;
					df2 = new DecimalFormat("#.##");
					value = Double.valueOf(df2.format(ratio));
				}
				
				if(in == 0){
					ratio = 0;
					df2 = new DecimalFormat("#.##");
					value = ratio;
				}
				
				PreparedStatement sql3 = Stats.connection.prepareStatement("SELECT wins FROM `player_data` WHERE player=?;");
				sql3.setString(1, p.getUniqueId().toString());
				ResultSet result3 = sql3.executeQuery();
				result3.next();
				int in3 = 0;
				in3 = result3.getInt("wins");
				
				p.sendMessage(Main.getPrefix()+"§8§ " + p.getDisplayName() + "§f's Statistics");
				p.sendMessage(Main.getPrefix()+"§8§ §fKills§8: §a" + in2);
				p.sendMessage(Main.getPrefix()+"§8§ §fDeaths§8: §a" + in);
				p.sendMessage(Main.getPrefix()+"§8§ §fKDR§8: §a" + value);
				p.sendMessage(Main.getPrefix()+"§8§ §fWins§8: §a" + in3);
				sql.close();
				sql2.close();
				sql3.close();
				result.close();
				result2.close();
				result3.close();
			} else {
				p.sendMessage(Main.getPrefix()+"§8§ " + p.getDisplayName() + "§f's Statistics");
				p.sendMessage(Main.getPrefix()+"§8§ §fKills§8: §a0");
				p.sendMessage(Main.getPrefix()+"§8§ §fDeaths§8: §a0");
				p.sendMessage(Main.getPrefix()+"§8§ §fKDR§8: §a0.00");
				p.sendMessage(Main.getPrefix()+"§8§ §fWins§8: §a0");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Stats.closeConnection();
		}
	}
	
	public static String getsStats(Player p, Player p2){
		Stats.openConnection();
		try{
			if(Stats.playerDataContainsPlayer(p)){
				PreparedStatement sql = Stats.connection.prepareStatement("SELECT deaths FROM `player_data` WHERE player=?;");
				sql.setString(1, p.getUniqueId().toString());
				ResultSet result = sql.executeQuery();
				result.next();
				int in = 0;
				in = result.getInt("deaths");
				
				PreparedStatement sql2 = Stats.connection.prepareStatement("SELECT kills FROM `player_data` WHERE player=?;");
				sql2.setString(1, p.getUniqueId().toString());
				ResultSet result2 = sql2.executeQuery();
				result2.next();
				int in2 = 0;
				in2 = result2.getInt("kills");
				
				double ratio = 0;
				DecimalFormat df2 = new DecimalFormat("#.##");
				double value = Double.valueOf(df2.format(ratio)).doubleValue();
				
				if(in != 0){
					ratio = (double) in2 / in;
					df2 = new DecimalFormat("#.##");
					value = Double.valueOf(df2.format(ratio));
				}
				
				if(in == 0){
					ratio = 0;
					df2 = new DecimalFormat("#.##");
					value = ratio;
				}
				
				PreparedStatement sql3 = Stats.connection.prepareStatement("SELECT wins FROM `player_data` WHERE player=?;");
				sql3.setString(1, p.getUniqueId().toString());
				ResultSet result3 = sql3.executeQuery();
				result3.next();
				int in3 = 0;
				in3 = result3.getInt("wins");
				
				p2.sendMessage(Main.getPrefix()+"§8§ " + p.getDisplayName() + "§f's Statistics");
				p2.sendMessage(Main.getPrefix()+"§8§ §fKills§8: §a" + in2);
				p2.sendMessage(Main.getPrefix()+"§8§ §fDeaths§8: §a" + in);
				p2.sendMessage(Main.getPrefix()+"§8§ §fKDR§8: §a" + value);
				p2.sendMessage(Main.getPrefix()+"§8§ §fWins§8: §a" + in3);
				sql.close();
				sql2.close();
				sql3.close();
				result.close();
				result2.close();
				result3.close();
			} else {
				p2.sendMessage(Main.getPrefix()+"§8§ " + p.getDisplayName() + "§f's Statistics");
				p2.sendMessage(Main.getPrefix()+"§8§ §fKills§8: §a0");
				p2.sendMessage(Main.getPrefix()+"§8§ §fDeaths§8: §a0");
				p2.sendMessage(Main.getPrefix()+"§8§ §fKDR§8: §a0.00");
				p2.sendMessage(Main.getPrefix()+"§8§ §fWins§8: §a0");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Stats.closeConnection();
		}
		return null;
	}
	
	public static String getOfflineStats(OfflinePlayer p, Player p2){
		Stats.openConnection();
		try{
			if(Stats.offlinePlayerDataContainsPlayer(p)){
				PreparedStatement sql = Stats.connection.prepareStatement("SELECT deaths FROM `player_data` WHERE player=?;");
				sql.setString(1, p.getUniqueId().toString());
				ResultSet result = sql.executeQuery();
				result.next();
				int in = 0;
				in = result.getInt("deaths");
				
				PreparedStatement sql2 = Stats.connection.prepareStatement("SELECT kills FROM `player_data` WHERE player=?;");
				sql2.setString(1, p.getUniqueId().toString());
				ResultSet result2 = sql2.executeQuery();
				result2.next();
				int in2 = 0;
				in2 = result2.getInt("kills");
				
				PreparedStatement sql3 = Stats.connection.prepareStatement("SELECT wins FROM `player_data` WHERE player=?;");
				sql3.setString(1, p.getUniqueId().toString());
				ResultSet result3 = sql3.executeQuery();
				result3.next();
				int in3 = 0;
				in3 = result3.getInt("wins");
				
				double ratio = 0;
				DecimalFormat df2 = new DecimalFormat("#.##");
				double value = Double.valueOf(df2.format(ratio)).doubleValue();
				
				if(in != 0){
					ratio = (double) in2 / in;
					df2 = new DecimalFormat("#.##");
					value = Double.valueOf(df2.format(ratio));
				}
				
				if(in == 0){
					ratio = 0;
					df2 = new DecimalFormat("#.##");
					value = ratio;
				}
				
				p2.sendMessage(Main.getPrefix()+"§8§ §b" + p.getName() + "§f's Statistics");
				p2.sendMessage(Main.getPrefix()+"§8§ §fKills§8: §a" + in2);
				p2.sendMessage(Main.getPrefix()+"§8§ §fDeaths§8: §a" + in);
				p2.sendMessage(Main.getPrefix()+"§8§ §fKDR§8: §a" + value);
				p2.sendMessage(Main.getPrefix()+"§8§ §fWins§8: §a" + in3);
				sql.close();
				sql2.close();
				sql3.close();
				result.close();
				result2.close();
				result3.close();
			} else {
				p2.sendMessage(Main.getPrefix()+"§8§ §b" + p.getName() + "§f's Statistics");
				p2.sendMessage(Main.getPrefix()+"§8§ §fKills§8: §a0");
				p2.sendMessage(Main.getPrefix()+"§8§ §fDeaths§8: §a0");
				p2.sendMessage(Main.getPrefix()+"§8§ §fKDR§8: §a0.00");
				p2.sendMessage(Main.getPrefix()+"§8§ §fWins§8: §a0");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Stats.closeConnection();
		}
		return null;
	}
}
