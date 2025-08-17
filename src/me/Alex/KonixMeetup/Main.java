package me.Alex.KonixMeetup;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import commands.Health;
import commands.Spectate;
import commands.StatsCommand;
import commands.WorldCreation;
import events.*;
import game.GameIDSQLChecker;
import game.Start;
import game.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import stats.Stats;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends JavaPlugin implements Listener, PluginMessageListener {

	public static Plugin plugin;

	public static List<String> game = new ArrayList<String>();
	public static List<String> pregame = new ArrayList<String>();
	public static List<String> pvp = new ArrayList<String>();
	public static String prefix = ChatColor.translateAlternateColorCodes('&', "&6BlimpUHCMU&8 » &7");

	public static boolean endGame() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) Main.plugin, new Runnable() {
			int counter = 2;

			public void run() {
				if (counter != -1) {
					counter--;
					if (counter != 0) {
						if (counter == 1) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd add &a&lLOBBY");
						}

						if (counter <= 0) {
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

	@SuppressWarnings("deprecation")
	public void onEnable() {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd add &a&lLOBBY");
		plugin = this;
		game.add("false");
		pregame.add("false");
		pvp.add("false");
		Start.lobby = true;
		getCommand("health").setExecutor(new Health());
		getCommand("border").setExecutor(new WorldCreation());
		getCommand("spectate").setExecutor(new Spectate());
		getCommand("stats").setExecutor(new StatsCommand());
		getCommand("start").setExecutor(new commands.Start());
		//	HeadHealth.registerHealthBar();
		registerEvents(this, new Voidd());
		registerEvents(this, new EndgameDeterminant());
		registerEvents(this, new HeadHealth());
		registerEvents(this, new Blocks());
		registerEvents(this, new DamageController());
		registerEvents(this, new DeathEvent());
		registerEvents(this, new JoinCheck());
		registerEvents(this, new LeaveEvent());
		registerEvents(this, new NoRain());
		registerEvents(this, new Scoreboard());
		registerEvents(this, new SpectateEvents());
		registerEvents(this, new Stats());
		registerEvents(this, this);
		registerEvents(this, new LobbyEvents());
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
		MySQL.setDefualtRating();
		MySQL.setSGFile();
		MySQL.getRatingFile();
		MySQL.getSgFile();
		MySQL.readRatingFiles();
		MySQL.readSGFiles();
		MySQL.connect();
		MySQL.connectSG();

		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd add &a&lLOBBY");
		EndgameDeterminant.endgame.add("false");
		endGame();
		ItemStack goldenHead = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta gMeta = goldenHead.getItemMeta();
		gMeta.setDisplayName(ChatColor.GOLD + "Golden Head");
		gMeta.setLore(Arrays.asList(new String[]{"You've crafted a Golden Head!", "Consuming this will grant you even greater effects", "than a normal Golden Apple!"}));
		goldenHead.setItemMeta(gMeta);

		ShapedRecipe goldenHeadRecipe = new ShapedRecipe(goldenHead);
		goldenHeadRecipe.shape(new String[]{"@@@", "@#@", "@@@"});

		goldenHeadRecipe.setIngredient('@', Material.GOLD_INGOT);
		goldenHeadRecipe.setIngredient('#', Material.SKULL_ITEM, 3);
		Bukkit.getServer().addRecipe(goldenHeadRecipe);
		new BukkitRunnable() {
			public void run() {
				if (JoinCheck.playing.size() < JoinCheck.minPlayers && Start.lobby == true) {
					Bukkit.broadcastMessage(prefix + ChatColor.RED + "There must be at least " + ChatColor.YELLOW + JoinCheck.minPlayers + ChatColor.RED + " players for the game to start.");
				}
			}
		}.runTaskTimer(this, 20 * 65, 20 * 65);
		new BukkitRunnable() {
			public void run() {
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					if (Spectate.spec.contains(player.getName())) {
						player.setFoodLevel(20);
					}
				}
			}
		}.runTaskTimer(this, 20, 20);
		new BukkitRunnable() {
			public void run() {
				for (Player watching : Bukkit.getServer().getOnlinePlayers()) {
					if (Spectate.spec.contains(watching.getName())) {
						watching.getInventory().setArmorContents(null);
						watching.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 100, true),
								false);
						watching.addPotionEffect(
								new PotionEffect(PotionEffectType.WEAKNESS, 1000000, 1000, true), false);
					}
				}
			}
		}.runTaskTimer(this, 20L, 20L);

		if ((GameIDSQLChecker.gameExist(Bukkit.getServer().getServerId()))) {
			GameIDSQLChecker.setGameState(0, Bukkit.getServerId());
		}
		if (!(GameIDSQLChecker.gameExist(Bukkit.getServer().getServerId()))) {
			GameIDSQLChecker.createServerID(Bukkit.getServer().getServerId());
			GameIDSQLChecker.setGameState(0, Bukkit.getServerId());
		}
	}

	public void onDisable() {
		plugin = null;
		try {
			if (Stats.connection == null || Stats.connection.isClosed()) {
				Stats.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... Listeners) {
		for (Listener listener : Listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}

	public static Plugin getPlugin() {
		return plugin;
	}

	public static String getPrefix() {
		return prefix;
	}


	//ENDGAME DETERMINANT
//STATS
//ROLLBACK ON GAMEEND
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChat(PlayerChatEvent event) {
		Player p = event.getPlayer();
		if (Start.alive.contains(p.getName())) {
			event.setFormat(Utils.getNameColour(p) + p.getDisplayName() + " §8» §7" + Utils.getChatColor(p) + event.getMessage());


		}
		if (p.getWorld().getName().equals("MULOBBY")) {
			event.setFormat(Utils.getNameColour(p) + p.getDisplayName() + " §8» §7" + Utils.getChatColor(p) + event.getMessage());


		}
		for (Player watching : Start.watching) {
			if (Spectate.spec.contains(p.getName())) {
				watching.sendMessage("§4SPEC§7 §8§l▏" + Utils.getNameColour(p) + p.getDisplayName() + " §8» §7" + Utils.getChatColor(p) + event.getMessage());
				event.setCancelled(true);
			}
		}
	}

	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (!channel.equals("BungeeCord")) {
			return;
		}
		try {
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
			String command = in.readUTF();
			if (command.equals("PlayerCount")) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void SendToServer(final String PlayerName, final String ServerName, final Player SendingUser) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(getPlugin(), new Runnable() {
			public void run() {
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("ConnectOther");
				out.writeUTF(PlayerName);
				out.writeUTF(ServerName);
				SendingUser.sendPluginMessage(getPlugin(), "BungeeCord", out.toByteArray());
				Bukkit.getLogger().info(ChatColor.GREEN + PlayerName + "CONNECTING TO " + ServerName);
			}
		}, 5L);
	}

	public static int getHealth(Player player) {
		return (int) StrictMath.ceil(damageable(player).getHealth());
	}

	public static Damageable damageable(Player player) {
		return player;
	}

}
