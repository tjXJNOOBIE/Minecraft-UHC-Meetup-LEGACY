package events;

import game.Start;
import me.Alex.KonixMeetup.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class JoinCheck implements Listener {

	public static ArrayList<Player> playing = new ArrayList<>();
	public static int minPlayers = 6;
	@EventHandler
    public void onPlayerRegainHealth(EntityRegainHealthEvent event) {
        if(event.getRegainReason() == RegainReason.SATIATED || event.getRegainReason() == RegainReason.REGEN)
            event.setCancelled(true);
    }
	
	@EventHandler
	public void onJoinn(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("blimp.fly")){
			p.setAllowFlight(true);
			p.setFlying(true);
			p.sendMessage(Main.getPrefix() + "You are now flying");
		}
	}
	

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();

		DeathEvent.kills.put(p.getName(), 0);

		float direction = 90;

		Location l = new Location(Bukkit.getWorld("MULOBBY"), 0, 51, 0, direction, 0);
		p.teleport(l);
		p.setHealth(20);
		p.setMaximumNoDamageTicks(18);
		p.setFoodLevel(20);
		p.setLevel(0);

		playing.add(p);

		p.getInventory().clear();
		p.setGameMode(GameMode.SURVIVAL);
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		p.removePotionEffect(PotionEffectType.ABSORPTION);
		p.removePotionEffect(PotionEffectType.HEAL);
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
		p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.WEAKNESS);

		for(Player pall : Bukkit.getServer().getOnlinePlayers()){
			pall.showPlayer(p);
			continue;
		}

		if(Main.pregame.contains("true")){
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spec " + p.getName());
		}
		if(Main.pregame.contains("false")){
			if(JoinCheck.playing.size() == minPlayers){
				Start.lobbyStart();
			}
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		e.setQuitMessage(Main.getPrefix() + p.getDisplayName() + " §6has left");
	}
}
