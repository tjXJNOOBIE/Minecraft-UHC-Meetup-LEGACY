package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WorldCreation implements CommandExecutor {
	
	public static void generateBorder(Location loc, int length) {

        int x1 = loc.getBlockX();
        int y1 = loc.getBlockY();
        int z1 = loc.getBlockZ();
    
        int x2 = x1 + length;
        int y2 = y1 + 40;
        int z2 = z1 + length;
    
        World world = loc.getWorld();
    
        for (int xPoint = x1; xPoint <= x2; xPoint++) {
            for (int yPoint = y1; yPoint <= y2; yPoint++) {
                    Block currentBlock = world.getBlockAt(xPoint, yPoint, z1);
                    currentBlock.setType(Material.BEDROCK);
            }
        }
        for (int xPoint = x1; xPoint <= x2; xPoint++) {
            for (int yPoint = y1; yPoint <= y2; yPoint++) {
                    Block currentBlock = world.getBlockAt(xPoint, yPoint, z2);
                    currentBlock.setType(Material.BEDROCK);
            }
        }
        for (int zPoint = z1; zPoint <= z2; zPoint++) {
            for (int yPoint = y1; yPoint <= y2; yPoint++) {
                    Block currentBlock = world.getBlockAt(x1, yPoint, zPoint);
                    currentBlock.setType(Material.BEDROCK);
            }
        }
        for (int zPoint = z1; zPoint <= z2; zPoint++) {
            for (int yPoint = y1; yPoint <= y2; yPoint++) {
                    Block currentBlock = world.getBlockAt(x2, yPoint, zPoint);
                    currentBlock.setType(Material.BEDROCK);
            }
        }
    }
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("border")){
			if(args.length == 0){
				if(sender.isOp()){
					Location l = new Location(Bukkit.getWorld("UHC"), -100, 50, -100);
					WorldCreation.generateBorder(l, 200);
					sender.sendMessage(ChatColor.GOLD + "Border created!");
				}
			}		
		}
		return true;
	}
}
