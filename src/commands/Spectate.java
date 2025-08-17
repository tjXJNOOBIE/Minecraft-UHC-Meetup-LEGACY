package commands;

import events.DeathEvent;
import game.Start;
import me.Alex.KonixMeetup.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Spectate implements CommandExecutor {
	
	public static ArrayList<String> spec = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("spectate")){
			if(Start.alive.contains(sender.getName())){
				sender.sendMessage(ChatColor.RED + "You cannot spectate if you're in game.");
				return true;
			}
			if(spec.contains(sender.getName())){
				sender.sendMessage(Main.getPrefix() +ChatColor.RED+"You are already in spectator mode." );
				return true;
			}
				
			if(args.length == 0){
				Player p = (Player) sender;
				p.setAllowFlight(true);
				p.setFlying(true);
				spec.add(p.getName());
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 100, true),
						false);
				for(Player pall : Bukkit.getServer().getOnlinePlayers()){
					pall.hidePlayer(p);
					continue;
				}
						
				ItemStack c = new ItemStack(Material.NETHER_STAR);
				ItemMeta cm = c.getItemMeta();
				cm.setDisplayName("§aCenter");
				c.setItemMeta(cm);
				ItemStack t = new ItemStack(Material.COMPASS);
				ItemMeta tm = t.getItemMeta();
				tm.setDisplayName("§aTeleporter");
				t.setItemMeta(tm);
				ItemStack i = new ItemStack(Material.BOOK);
				ItemMeta im = i.getItemMeta();
				im.setDisplayName("§aInventory Checker");
				i.setItemMeta(im);
				p.getInventory().setItem(2, c);
				p.getInventory().setItem(4, t);
				p.getInventory().setItem(6, i);
				DeathEvent.kills.put(p.getName(), 0);
				float direction = 90;

				p.sendMessage("§eYou are now in §aspectator §emode.");
				return true;
				}
			}
				
			Player t = Bukkit.getPlayer(args[0]);
			if(t == null){
				sender.sendMessage(ChatColor.RED + "Player is not online.");
				return true;
			}
				
			{
				t.setAllowFlight(true);
				t.setFlying(true);
				spec.add(t.getName());
				for(Player pall : Bukkit.getServer().getOnlinePlayers()){
					pall.hidePlayer(t);
					continue;
				}
					
					ItemStack c = new ItemStack(Material.NETHER_STAR);
					ItemMeta cm = c.getItemMeta();
					cm.setDisplayName("§aCenter");
					c.setItemMeta(cm);
					ItemStack t2 = new ItemStack(Material.COMPASS);
					ItemMeta tm = t2.getItemMeta();
					tm.setDisplayName("§aTeleporter");
					t2.setItemMeta(tm);
					ItemStack i = new ItemStack(Material.BOOK);
					ItemMeta im = i.getItemMeta();
					im.setDisplayName("§aInventory Checker");
					i.setItemMeta(im);
					t.getInventory().setItem(2, c);
					t.getInventory().setItem(4, t2);
					t.getInventory().setItem(6, i);
				    t.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 100, true),
						false);
					DeathEvent.kills.put(t.getName(), 0);
					float direction = 90;

					t.sendMessage("§eYou are now in §aspectator §emode.");
					return true;
		}
	}

	public static void giveItmes(Player player){
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 100, true),
				false);
		ItemStack c = new ItemStack(Material.NETHER_STAR);
		ItemMeta cm = c.getItemMeta();
		cm.setDisplayName("§aCenter");
		c.setItemMeta(cm);
		ItemStack t2 = new ItemStack(Material.COMPASS);
		ItemMeta tm = t2.getItemMeta();
		tm.setDisplayName("§aTeleporter");
		t2.setItemMeta(tm);
		ItemStack i = new ItemStack(Material.BOOK);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName("§aInventory Checker §8(§7Right Click Player§8)");
		i.setItemMeta(im);
		player.getInventory().setItem(2, c);
		player.getInventory().setItem(4, t2);
		player.getInventory().setItem(6, i);
	}
}
