package game;

import me.Alex.KonixMeetup.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Start {
	
	static int counter;
	
	public static List<String> players = new ArrayList<String>();
	public static List<String> alive = new ArrayList<String>();
	public static List<Player> watching = new ArrayList<Player >();
	public static boolean lobby;
	public static boolean ingame;
	
	public static void giveKit(Player p){
		Random random = new Random();
		int chance = random.nextInt(101);
		if(chance <= 20){
			p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
			p.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));
			p.getInventory().addItem(new ItemStack(Material.FISHING_ROD, 1));
			p.getInventory().addItem(new ItemStack(Material.BOW, 1));
			p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
			p.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 1));
			p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
			p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF , 16));
			p.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
			p.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL, 1));
			p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 21));
			p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 7));
			p.getInventory().addItem(new ItemStack(Material.DIAMOND, 2));
			p.getInventory().addItem(new ItemStack(Material.STICK, 7));
			p.getInventory().addItem(new ItemStack(Material.BOOK, 5));
			p.getInventory().addItem(new ItemStack(Material.APPLE, 3));
			p.getInventory().addItem(new ItemStack(Material.WOOD, 64));
			p.getInventory().addItem(new ItemStack(Material.ANVIL));
			p.getInventory().addItem(new ItemStack(Material.ENCHANTMENT_TABLE));
			p.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE, 25));
			p.getInventory().addItem(new ItemStack(Material.ARROW, 23));
			p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
			p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
			p.sendMessage(Main.getPrefix()+"§fYou received §aKit-1§f.");
		}
		
		if(chance <= 40){
			if(chance > 20){
				p.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));
				p.getInventory().addItem(new ItemStack(Material.FISHING_ROD, 1));
				p.getInventory().addItem(new ItemStack(Material.BOW, 1));
				p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
				p.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 1));
				p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
				p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF , 13));
				p.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
				p.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL, 1));
				p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 18));
				p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 9));
				p.getInventory().addItem(new ItemStack(Material.DIAMOND, 3));
				p.getInventory().addItem(new ItemStack(Material.STICK, 4));
				p.getInventory().addItem(new ItemStack(Material.BOOK, 5));
				p.getInventory().addItem(new ItemStack(Material.APPLE, 2));
				p.getInventory().addItem(new ItemStack(Material.WOOD, 64));
				p.getInventory().addItem(new ItemStack(Material.ANVIL));
				p.getInventory().addItem(new ItemStack(Material.ENCHANTMENT_TABLE));
				p.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE, 27));
				p.getInventory().addItem(new ItemStack(Material.ARROW, 26));
				p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
				p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
				p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
				p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
				p.sendMessage(Main.getPrefix()+"§fYou received §aKit-2§f.");
			}
		}
		
		if(chance <= 60){
			if(chance > 40){
				p.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));
				p.getInventory().addItem(new ItemStack(Material.FISHING_ROD, 1));
				p.getInventory().addItem(new ItemStack(Material.BOW, 1));
				p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
				p.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 1));
				p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 5));
				p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF , 16));
				p.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
				p.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL, 1));
				p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 24));
				p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 11));
				p.getInventory().addItem(new ItemStack(Material.DIAMOND, 4));
				p.getInventory().addItem(new ItemStack(Material.STICK, 4));
				p.getInventory().addItem(new ItemStack(Material.BOOK, 5));
				p.getInventory().addItem(new ItemStack(Material.APPLE, 4));
				p.getInventory().addItem(new ItemStack(Material.WOOD, 64));
				p.getInventory().addItem(new ItemStack(Material.ANVIL));
				p.getInventory().addItem(new ItemStack(Material.ENCHANTMENT_TABLE));
				p.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE, 28));
				p.getInventory().addItem(new ItemStack(Material.ARROW, 25));
				p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
				p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
				p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
				p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
				p.sendMessage(Main.getPrefix()+"§fYou received §aKit-3§f.");
			}
		}
		
		if(chance <= 80){
			if(chance > 60){
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));
				p.getInventory().addItem(new ItemStack(Material.FISHING_ROD, 1));
				p.getInventory().addItem(new ItemStack(Material.BOW, 1));
				p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
				p.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 1));
				p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 2));
				p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF , 12));
				p.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
				p.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL, 1));
				p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 15));
				p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 3));
				p.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
				p.getInventory().addItem(new ItemStack(Material.STICK, 3));
				p.getInventory().addItem(new ItemStack(Material.BOOK, 5));
				p.getInventory().addItem(new ItemStack(Material.APPLE, 1));
				p.getInventory().addItem(new ItemStack(Material.WOOD, 64));
				p.getInventory().addItem(new ItemStack(Material.ANVIL));
				p.getInventory().addItem(new ItemStack(Material.ENCHANTMENT_TABLE));
				p.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE, 22));
				p.getInventory().addItem(new ItemStack(Material.ARROW, 19));
				p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
				p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
				p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
				p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
				p.sendMessage(Main.getPrefix()+"§fYou received §aKit-4§f.");
			}
		}
		
		if(chance < 101){
			if(chance > 80){
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
				p.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));
				p.getInventory().addItem(new ItemStack(Material.FISHING_ROD, 1));
				p.getInventory().addItem(new ItemStack(Material.BOW, 1));
				p.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
				p.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 1));
				p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
				p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF , 12));
				p.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 64));
				p.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL, 1));
				p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 16));
				p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 6));
				p.getInventory().addItem(new ItemStack(Material.DIAMOND, 2));
				p.getInventory().addItem(new ItemStack(Material.STICK, 6));
				p.getInventory().addItem(new ItemStack(Material.BOOK, 5));
				p.getInventory().addItem(new ItemStack(Material.APPLE, 2));
				p.getInventory().addItem(new ItemStack(Material.WOOD, 64));
				p.getInventory().addItem(new ItemStack(Material.ANVIL));
				p.getInventory().addItem(new ItemStack(Material.ENCHANTMENT_TABLE));
				p.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE, 24));
				p.getInventory().addItem(new ItemStack(Material.ARROW, 21));
				p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
				p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
				p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
				p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
				p.sendMessage(Main.getPrefix()+"§fYou received §aKit-5§f.");
			}
		}
	}
	
	public static void scatter(){
		for(Player p : Bukkit.getServer().getOnlinePlayers()){
			Random r = new Random();
			int low = -99;
			int high = 99;
			players.remove(p.getName());
			int x = r.nextInt(high-low) + low;
			int z = r.nextInt(high-low) + low;
			int y = Bukkit.getWorld("UHC").getHighestBlockYAt(x, z);
			Location l = new Location(Bukkit.getWorld("UHC"), x, y, z);
			p.teleport(l);
			p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 3, 3);
			giveKit(p);
			p.setFlying(false);
			p.setAllowFlight(false);
			alive.add(p.getName());
			continue;
		}
	}
	
	public static boolean lobbyStart(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, new Runnable() {
		    int counter = 71;
		    public void run() {
		        if (counter != -1) {
		            counter--;
					commands.Start.game_started = true;
		            if (counter != 0) {
		            	if(counter == 70){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a1 §fminute.");
		            	}
		            	
		            	if(counter == 55){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a45 §fseconds.");
		            	}
		            	
		            	if(counter == 40){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a30 §fseconds.");
		            	}

		            	if(counter == 30){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a20 §fseconds.");
		            	}

		            	if(counter == 25){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a15 §fseconds.");
		            	}

		            	if(counter == 20){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a10 §fseconds.");
		            	}

		            	if(counter == 15){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a5 §fseconds.");
		            	}

		            	if(counter == 14){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a4 §fseconds.");
		            	}

		            	if(counter == 13){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a3 §fseconds.");
		            	}

		            	if(counter == 12){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a2 §fseconds.");
		            	}
		            	if(counter == 11){
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§fMeetup starting in §a1 §fsecond.");
		            		Main.pregame.clear();
		            		Main.pregame.add("true");
		            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd add &c&lIN-GAME");
		            		scatter();
		            		//HeadHealth.registerHealthBar();
		            		World w = Bukkit.getWorld("UHC");
		            		w.setTime(1);
		            		Bukkit.broadcastMessage(Main.getPrefix()+"§cNow scattering all players...");
		            	}

		            	if(counter == 10){
		            	}

		            	if(counter == 1){
		            		gameStart();
		            	}

		                
		                if(counter <= 0) {
		                	counter = 0;
		                } 
		            } else {
		                counter--;
		                	}
		                }
		    }
		}, 0L, 20L);
		return true;
	}
	
	public static boolean gameStart(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, new Runnable() {
		    int counter = 1211;

		    public void run() {
		        if (counter != -1) {
		            counter--;
					ingame=true;
					lobby=false;
		            if (counter != 0) {
		            	if(counter == 1210){
		            		Bukkit.broadcastMessage(Main.getPrefix() +" §7Meetup has §abegun§7!");
		            		Main.game.clear();
		            		Main.game.add("true");
		            		GameIDSQLChecker.setGameState(1,Bukkit.getServer().getServerId());
		            	}
		            	
		            	if(counter == 1209){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 1 minute.");
		            	}
		            	
		            	if(counter == 1195){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 45 seconds.");
		            	}
		            	
		            	if(counter == 1180){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 30 seconds.");
		            	}
		            	
		            	if(counter == 1165){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 15 seconds.");
		            	}
		            	
		            	if(counter == 1160){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 10 seconds.");
		            	}
		            	
		            	if(counter == 1155){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 5 seconds.");
		            	}
		            	
		            	if(counter == 1154){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 4 seconds.");
		            	}
		            	
		            	if(counter == 1153){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 3 seconds.");
		            	}
		            	
		            	if(counter == 1152){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 2 seconds.");
		            	}
		            	
		            	if(counter == 1151){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cPvP will be enabled in 1 second.");
		            	}
		            	
		            	if(counter == 1150){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§7PvP is now §a§lENABLED§7!");
		            		Main.pvp.clear();
		            		Main.pvp.add("true");
		            	}
		            	
		            	if(counter == 910){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cGame ends in 15 minutes.");
		            	}
		            	
		            	if(counter == 610){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cGame ends in 10 minutes.");
		            	}
		            	
		            	if(counter == 310){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cGame ends in 5 minutes.");
		            	}
		            	
		            	if(counter == 70){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cGame ends in 1 minute.");
		            	}
		            	
		            	if(counter == 10){
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cMeetup has ended!");
		            	}
		            	
		            	if(counter == 9){
		            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		            		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd add &4&lCLEAN-UP");
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§cThis game resulted in a tie.");
		            		Bukkit.broadcastMessage(Main.getPrefix() +"§4Server will restart in 10 seconds.");
		            	}
		            	
		            	if(counter == 2){
		            		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "wr reset");
		            		for(Player p : Bukkit.getServer().getOnlinePlayers()){
		            			p.performCommand("hub");
		            			continue;
		            		}
		            	}
		            	
		            	if(counter == 1){
		            		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "restart");
		            	}
		            	
		            	if(counter <= 0) {
		                	counter = 0;
		                } 
		            } else {
		                counter--;
		                	}
		                }
		    }
		}, 0L, 20L);
		return true;
	}
}
