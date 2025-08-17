package events;

import commands.Spectate;
import game.Start;
import me.Alex.KonixMeetup.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class LeaveEvent implements Listener {
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		Player p2 = e.getPlayer();
		if(Main.pregame.contains("true")){
			Spectate.spec.remove(e.getPlayer().getName());
			JoinCheck.playing.remove(e.getPlayer());
		}
		if(Spectate.spec.contains(e.getPlayer().getName())){
			e.getPlayer().getInventory().clear();
			e.getPlayer().getInventory().setArmorContents(null);
		}
		if(Start.alive.contains(e.getPlayer().getName())){
			ItemStack[] arrayOfItemStack;
			int j = (arrayOfItemStack = p2.getInventory().getContents()).length;
			for (int i = 0; i < j; i++) {
				ItemStack i1 = arrayOfItemStack[i];
				if (i1 != null) {
					p2.getWorld().dropItemNaturally(p2.getLocation(), i1);
					p2.getInventory().remove(i1);
				}
			}
			if (p2.getInventory().getHelmet() != null) {
				p2.getWorld().dropItemNaturally(p2.getLocation(), p2.getInventory().getHelmet());
			}
			if (p2.getInventory().getBoots() != null) {
				p2.getWorld().dropItemNaturally(p2.getLocation(), p2.getInventory().getBoots());
			}
			if (p2.getInventory().getLeggings() != null) {
				p2.getWorld().dropItemNaturally(p2.getLocation(), p2.getInventory().getLeggings());
			}
			if (p2.getInventory().getChestplate() != null) {
				p2.getWorld().dropItemNaturally(p2.getLocation(), p2.getInventory().getChestplate());
			}
			p2.getInventory().setHelmet(null);
			p2.getInventory().setBoots(null);
			p2.getInventory().setLeggings(null);
			p2.getInventory().setChestplate(null);

		}
		if(Main.game.contains("true")){
			Start.alive.remove(e.getPlayer().getName());
			JoinCheck.playing.remove(e.getPlayer());
		}
	}
}