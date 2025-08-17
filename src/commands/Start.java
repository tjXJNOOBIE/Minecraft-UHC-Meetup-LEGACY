package commands;

import me.Alex.KonixMeetup.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

/**
 * Created by TJ on 4/30/2017.
 */
public class Start implements CommandExecutor{

    public ArrayList<Player> started = new ArrayList<>();
    public static boolean game_started = false;
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        String playername = player.getName();
        if(game_started){
            sender.sendMessage(Main.getPrefix()+"The game has already been started by " + started.get(0));
            return true;
        }
        if (args.length == 0 && (sender.hasPermission("blimp.start") && game.Start.lobby == true)) {
            started.add(player);
            new BukkitRunnable(){
                @Override
                public void run() {
                    game.Start.lobbyStart();
                }
            }.runTaskLater(Main.getPlugin(),20*2);
            Bukkit.broadcastMessage(Main.prefix + "The game has been force started by " + ((Player) sender).getDisplayName());
        }
        if(args.length == 0 && (!sender.hasPermission("blimp.start"))) {
            sender.sendMessage(Main.getPrefix()+ ChatColor.RED+"You don't have permission to use this command");
        }
        if(args.length > 0 && (sender.hasPermission("blimp.start"))){
            sender.sendMessage(Main.getPrefix() + ChatColor.RED + "Too many arguments!");
        }
        if(args.length == 0 && (game.Start.lobby == false)){
            sender.sendMessage(Main.prefix + ChatColor.RED + "You may not start the game while it's running");
        }



        return true;
    }
}
