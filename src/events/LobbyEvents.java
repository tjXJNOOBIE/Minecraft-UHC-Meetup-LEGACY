package events;

import game.Start;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by TJ on 4/30/2017.
 */
public class LobbyEvents implements Listener{

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        if (Start.lobby == true) {
            e.setCancelled(true);
        }
        if (Start.lobby == false) {
            e.setCancelled(false);
        }
        if(Start.watching.contains(e.getEntity().getName())){
            e.setCancelled(true);
        }
        if(Start.alive.contains(e.getEntity().getName())){
            e.setCancelled(false);
        }
    }
}
