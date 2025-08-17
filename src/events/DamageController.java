package events;

import me.Alex.KonixMeetup.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageController implements Listener {
	
	@EventHandler
    public void onPlayerDamage(EntityDamageEvent e){
      try {
    	  if ((e.getEntity() instanceof Player))
        {
          if (Main.game.contains("false"))
            e.setCancelled(true);
        }
      }
      catch (Exception localException)
      {
      }
    }
    
    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e)
    {
      try
      {
        if ((e.getDamager() instanceof Player))
        {
          if (Main.pvp.contains("false"))
            e.setCancelled(true);
        }
      }
      catch (Exception localException)
      {
      }
    }
    @EventHandler
    public void onLight(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING ) {
            event.setCancelled(true);
        }
    }
}
