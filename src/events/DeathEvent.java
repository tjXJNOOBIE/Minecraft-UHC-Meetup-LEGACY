package events;

import commands.Spectate;
import game.Start;
import me.Alex.KonixMeetup.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class DeathEvent implements Listener {
	
	public static HashMap<String, ItemStack[]> rinv = new HashMap<String, ItemStack[]>();
	public static HashMap<String, ItemStack[]> rarm = new HashMap<String, ItemStack[]>();
	
	public static HashMap<String, Integer> kills = new HashMap<String, Integer>();
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		float direction = 90;
		Location l = new Location(Bukkit.getWorld("MULOBBY"), 0, 51, 0, direction, 0);
		p.teleport(l);
		p.performCommand("spec");
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		if(Start.alive.contains(e.getPlayer().getName())){
			rinv.put(e.getPlayer().getName(), e.getPlayer().getInventory().getContents());
			rarm.put(e.getPlayer().getName(), e.getPlayer().getInventory().getArmorContents());
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		if(Start.alive.contains(e.getPlayer().getName())){
			Player p = e.getPlayer();
			for(ItemStack en : rinv.get(p.getName())){
				p.getWorld().dropItem(p.getLocation(), en);
				continue;
			}
			
			for(ItemStack en : rarm.get(p.getName())){
				p.getWorld().dropItem(p.getLocation(), en);
				continue;
			}
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = p.getKiller();
		ItemStack h = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta hm = h.getItemMeta();
		hm.setDisplayName(ChatColor.GOLD + "Golden Head");
		h.setItemMeta(hm);
		e.getDrops().add(h);
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setExp(0F);
		p.setAllowFlight(true);
		p.setFlying(true);
		e.getDrops().add(new ItemStack(Material.EXP_BOTTLE,24));

		p.setVelocity(p.getLocation().getDirection().multiply(0.5));
		p.setVelocity(new Vector(p.getVelocity().getX(), 0.7D, p.getVelocity().getZ()));
		e.getDrops().add(new ItemStack(Material.GOLDEN_APPLE, 1));
		World w = p.getWorld();
		w.strikeLightning(p.getLocation().add(0,5,0));
		Start.alive.remove(p.getName());

		p.performCommand("spec");

		Start.watching.add(p);
		if((k instanceof  Player)) {
			e.setDeathMessage(Main.getPrefix() + p.getDisplayName() + ChatColor.YELLOW + " has been slain by " + k.getDisplayName());
		}
		if(!(k instanceof Player)){
			e.setDeathMessage(Main.getPrefix() + p.getDisplayName() + ChatColor.YELLOW+" died to natural causes");
		}
		kills.put(k.getName(), 0);
		new BukkitRunnable(){
			@Override
			public void run() {
				Spectate.giveItmes(p);
			}
		}.runTaskLater(Main.getPlugin(),20L);
		 if(kills.containsKey(k.getName()))
	            kills.put(k.getName(), kills.get(k.getName()) + 1);
	     else {
	        	kills.put(k.getName(), 1);
	     }

	}
	
	@EventHandler
    public void onPlayerDamage(EntityDamageEvent e){
      try {
    	  if ((e.getEntity() instanceof Player))
        {
          if (Main.pvp.contains("false"))
            e.setCancelled(true);
        }
      }
      catch (Exception localException)
      {
      }
    }
}
