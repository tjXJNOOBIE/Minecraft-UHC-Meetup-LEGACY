package stats;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Stats implements Listener {
	
	public static Connection connection;
	
	public synchronized static void openConnection(){
		try{
			connection = DriverManager.getConnection("jdbc:mysql://0.0.0.0:3306/blimpsg_player", "root", "*@^cnbfHG@hjfl");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized static void closeConnection(){
		try{
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized static boolean playerDataContainsPlayer(Player p){
		try{
			PreparedStatement sql = connection.prepareStatement("SELECT * FROM `player_data` WHERE player=?;");
			sql.setString(1, p.getUniqueId().toString());
			ResultSet resultSet = sql.executeQuery();
			boolean containsPlayer = resultSet.next();
			
			sql.close();
			resultSet.close();
			
			return containsPlayer;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public synchronized static boolean offlinePlayerDataContainsPlayer(OfflinePlayer player){
		try{
			PreparedStatement sql = connection.prepareStatement("SELECT * FROM `player_data` WHERE player=?;");
			sql.setString(1, player.getUniqueId().toString());
			ResultSet resultSet = sql.executeQuery();
			boolean containsPlayer = resultSet.next();
			
			sql.close();
			resultSet.close();
			
			return containsPlayer;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event){
		Player p = event.getEntity();
		openConnection();
		try{
			int previousDeaths = 0;
			
			if(playerDataContainsPlayer(p)){
				PreparedStatement sql = connection.prepareStatement("SELECT deaths FROM `player_data` WHERE player=?;");
				sql.setString(1, p.getUniqueId().toString());
				
				ResultSet result = sql.executeQuery();
				result.next();
				
				previousDeaths = result.getInt("deaths");
				PreparedStatement deathsUpdate = connection.prepareStatement("UPDATE `player_data` SET deaths=? WHERE player=?;");
				deathsUpdate.setInt(1, previousDeaths + 1);
				deathsUpdate.setString(2, p.getUniqueId().toString());
				deathsUpdate.executeUpdate();
				
				deathsUpdate.close();
				sql.close();
				result.close();
			} else {
				PreparedStatement newPlayer = connection.prepareStatement("INSERT INTO `player_data` values(?,0,1,0);");
				newPlayer.setString(1, p.getUniqueId().toString());
				newPlayer.execute();
				newPlayer.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
	@EventHandler
	public void onKill(PlayerDeathEvent event){
		Player p = event.getEntity().getKiller();
		openConnection();
		try{
			int previousKills = 0;
			
			if(playerDataContainsPlayer(p)){
				PreparedStatement sql = connection.prepareStatement("SELECT kills FROM `player_data` WHERE player=?;");
				sql.setString(1, p.getUniqueId().toString());
				
				ResultSet result = sql.executeQuery();
				result.next();
				
				previousKills = result.getInt("kills");
				PreparedStatement killsUpdate = connection.prepareStatement("UPDATE `player_data` SET kills=? WHERE player=?;");
				killsUpdate.setInt(1, previousKills + 1);
				killsUpdate.setString(2, p.getUniqueId().toString());
				killsUpdate.executeUpdate();
				
				killsUpdate.close();
				sql.close();
				result.close();
			} else {
				PreparedStatement newPlayer = connection.prepareStatement("INSERT INTO `player_data` values(?,1,0,0);");
				newPlayer.setString(1, p.getUniqueId().toString());
				newPlayer.execute();
				newPlayer.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
	public static void wins(Player p){
		openConnection();
		try{
			int previousWins = 0;
			
			if(playerDataContainsPlayer(p)){
				PreparedStatement sql = connection.prepareStatement("SELECT wins FROM `player_data` WHERE player=?;");
				sql.setString(1, p.getUniqueId().toString());
				
				ResultSet result = sql.executeQuery();
				result.next();
				
				previousWins = result.getInt("wins");
				PreparedStatement winsUpdate = connection.prepareStatement("UPDATE `player_data` SET wins=? WHERE player=?;");
				winsUpdate.setInt(1, previousWins + 1);
				winsUpdate.setString(2, p.getUniqueId().toString());
				winsUpdate.executeUpdate();
				
				winsUpdate.close();
				sql.close();
				result.close();
			} else {
				PreparedStatement newPlayer = connection.prepareStatement("INSERT INTO `player_data` values(?,0,0,1);");
				newPlayer.setString(1, p.getUniqueId().toString());
				newPlayer.execute();
				newPlayer.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
