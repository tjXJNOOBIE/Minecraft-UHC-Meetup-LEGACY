package events;

import me.Alex.KonixMeetup.Main;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Blocks implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(Main.game.contains("false")){
			if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBreak2(BlockBreakEvent e){
		if(Main.pvp.contains("false")){
			if(e.getBlock().getType() == Material.ENCHANTMENT_TABLE){
				if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onBreak3(BlockBreakEvent e){
		if(Main.pvp.contains("false")){
			if(e.getBlock().getType() == Material.ANVIL){
				if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		if(Main.game.contains("false")){
			if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBreak23(BlockPlaceEvent e){
		if(Main.pvp.contains("false")){
			if(e.getBlock().getType() == Material.LAVA_BUCKET){
				if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e){
			if(e.getItem().getType() == Material.GOLDEN_APPLE){
				ItemStack goldenHead = e.getItem();
				if(goldenHead.hasItemMeta()){
						PotionEffect pe = new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0);
						PotionEffect re = new PotionEffect(PotionEffectType.REGENERATION, 200, 1);
						pe.apply(e.getPlayer());
						re.apply(e.getPlayer());
			}
		}
	}
}
