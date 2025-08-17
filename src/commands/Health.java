package commands;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Health implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("health")){
			if(args.length == 0){
				sender.sendMessage("§c/health <player>");
				return true;
			}
			
			Player t = Bukkit.getPlayer(args[0]);
			if(t == null){
				sender.sendMessage("§cThat player is not online.");
				return true;
			}
			
			if(!(t == null)){
				double health = t.getHealth();
				double healthd = health;
				DecimalFormat df2 = new DecimalFormat("#.##");
				double value = Double.valueOf(df2.format(healthd));
				sender.sendMessage(t.getDisplayName() + "'s Health §8» §b" + value + "§4❤");
				return true;
			}
		}
		return true;
	}
}
