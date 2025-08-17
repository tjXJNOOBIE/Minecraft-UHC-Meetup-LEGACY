package game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Utils implements CommandExecutor {
	
	public String getName(Player player) {
		String name = player.getName();
		String[] arrayOfString;
		if ((arrayOfString = PermissionsEx.getUser(player).getGroupNames()).length != 0) {
			String groups = arrayOfString[0];
			if (groups.equals("mod")) {
				return ChatColor.RED + player.getName();
			}
			if (groups.contains("srmod")) {
				return ChatColor.DARK_RED + player.getName();
			}
			if (groups.contains("admin")) {
				return ChatColor.DARK_RED + "" + ChatColor.BOLD + player.getName();
			}
			if (groups.contains("iron")) {
				return ChatColor.GRAY + player.getName();
			}
			if (groups.contains("gold")) {
				return ChatColor.GOLD + player.getName();
			}
			if (groups.contains("diamond")) {
				return ChatColor.AQUA + player.getName();
			}
			if (groups.contains("owner")) {
				return ChatColor.DARK_RED + "" + ChatColor.BOLD + player.getName();
			}
			if (groups.contains("developer")) {
				return ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + player.getName();
			}
			if (groups.contains("vip")) {
				return ChatColor.DARK_PURPLE + player.getName();
			}
			if (groups.contains("special")) {
				return ChatColor.LIGHT_PURPLE + player.getName();
			}
			return ChatColor.BLUE + player.getName();
		}
		return name;
	}
	



	public String getNameChat(String name) {
		String[] arrayOfString;
		if ((arrayOfString = PermissionsEx.getUser(Bukkit.getPlayer(name)).getGroupNames()).length != 0) {
			String groups = arrayOfString[0];
			if (groups.contains("mod")) {
				return ChatColor.RED + name;
			}
			if (groups.contains("srmod")) {
				return ChatColor.DARK_RED + "" + ChatColor.ITALIC + name;
			}
			if (groups.contains("admin")) {
				return ChatColor.DARK_RED + name;
			}
			if (groups.contains("iron")) {
				return ChatColor.GRAY + name;
			}
			if (groups.contains("gold")) {
				return ChatColor.GOLD + name;
			}
			if (groups.contains("diamond")) {
				return ChatColor.DARK_AQUA + name;
			}
			if (groups.contains("owner")) {
				return ChatColor.DARK_RED + "" + ChatColor.BOLD + name;
			}
			if (groups.contains("developer")) {
				return ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + name;
			}
			if (groups.contains("vip")) {
				return ChatColor.DARK_PURPLE + name;
			}
			if (groups.contains("special")) {
				return ChatColor.LIGHT_PURPLE + name;
			}
			return ChatColor.BLUE + name;
		}
		return name;
	}

	public static String getChatColor(Player player) {
		String name = player.getName();
		String[] arrayOfString;
		if ((arrayOfString = PermissionsEx.getUser(player).getGroupNames()).length != 0) {
			String groups = arrayOfString[0];
			if (groups.contains("mod")) {
				return ChatColor.AQUA + "";
			}
			if (groups.contains("srmod")) {
				return ChatColor.AQUA + "";
			}
			if (groups.contains("admin")) {
				return ChatColor.AQUA + "";
			}
			if (groups.contains("iron")) {
				return ChatColor.GRAY + "";
			}
			if (groups.contains("gold")) {
				return ChatColor.GRAY + "";
			}
			if (groups.contains("diamond")) {
				return ChatColor.RED + "";
			}
			if (groups.contains("owner")) {
				return ChatColor.AQUA + "" + ChatColor.BOLD;
			}
			if (groups.contains("developer")) {
				return ChatColor.AQUA + "" + ChatColor.BOLD;
			}
			if (groups.contains("vip")) {
				return ChatColor.YELLOW + "";
			}
			if (groups.contains("special")) {
				return ChatColor.GOLD + "";
			}
			return ChatColor.GRAY + "";
		}
		return name;
	}
	public static String getNameColour(Player player) {
		String name = player.getName();
		String[] arrayOfString;
		if ((arrayOfString = PermissionsEx.getUser(player).getGroupNames()).length != 0) {
			String groups = arrayOfString[0];
			if (groups.equals("mod")) {
				return "§c";
			}
			if (groups.contains("srmod")) {
				return "§4";
			}
			if (groups.contains("admin")) {
				return "§4§l";
			}
			if (groups.contains("iron")) {
				return "§7";
			}
			if (groups.contains("gold")) {
				return "§6";
			}
			if (groups.contains("diamond")) {
				return "§b";
			}
			if (groups.contains("owner")) {
				return "§4§l";
			}
			if (groups.contains("developer")) {
				return "§d§l";
			}
			if (groups.contains("vip")) {
				return "§5";
			}
			if (groups.contains("special")) {
				return "d";
			}
			return "§9";
		}
		return name;
	}
	public static String getRank(Player player) {
		PermissionUser user = PermissionsEx.getUser(player);
		if (user.inGroup("mod")) {
			return ChatColor.RED + "Mod";
		}
		if (user.inGroup("srmod")) {
			return org.bukkit.ChatColor.DARK_RED + "SrMod";
		}
		if(user.inGroup("Admin")){
			return ChatColor.DARK_RED + "" + ChatColor.BOLD + "Admin";
		}
		if(user.inGroup("Developer")) {
			return org.bukkit.ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Developer";
		}

		if (user.inGroup("vip")) {
			return org.bukkit.ChatColor.DARK_PURPLE + "VIP";
		}
		if (user.inGroup("Diamond")) {
			return org.bukkit.ChatColor.AQUA + "Diamond";
		}
		if(user.inGroup("Gold")){
			return  ChatColor.GOLD + "Gold";
		}
		if(user.inGroup("Iron")) {
			return org.bukkit.ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Iron";
		}
		if(user.inGroup("Default")) {
			return ChatColor.AQUA +"Default";
		}

		return org.bukkit.ChatColor.AQUA +"Default";
	}

public static void setName(Player player) {

	PermissionUser user = PermissionsEx.getUser(player);
	if (user.inGroup("owner")) {
		player.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + player.getName());
		player.setPlayerListName(player.getDisplayName());
		return;
	}

	if (user.inGroup("admin")) {
		player.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + player.getName());
		player.setPlayerListName(ChatColor.DARK_RED + "" + ChatColor.BOLD + player.getName());
		return;
	}
	if (user.inGroup("srmod")) {
		player.setDisplayName(ChatColor.DARK_RED + player.getName());
		player.setPlayerListName(ChatColor.DARK_RED + player.getName());
		return;
	}
	if (user.inGroup("mod")) {
		player.setDisplayName(ChatColor.RED + player.getName());
		player.setPlayerListName(ChatColor.RED + player.getName());
		return;
	}
	if (user.inGroup("diamond")) {
		player.setDisplayName(ChatColor.AQUA + player.getName());
		player.setPlayerListName(player.getDisplayName());
		return;
	}
	if (user.inGroup("gold")) {
		player.setDisplayName(ChatColor.GOLD + player.getName());
		player.setPlayerListName(ChatColor.GOLD + player.getName());
		return;
	}
	if (user.inGroup("iron")) {
		player.setDisplayName(ChatColor.GRAY + player.getName());
		player.setPlayerListName(ChatColor.GRAY + player.getName());
		return;
	}
	if (user.inGroup("vip")) {
		player.setDisplayName(ChatColor.DARK_PURPLE + player.getName());
		player.setPlayerListName(ChatColor.DARK_PURPLE + player.getName());
		return;
	}
	if (user.inGroup("Builder")) {
		player.setDisplayName(ChatColor.GREEN + player.getName());
		player.setPlayerListName(ChatColor.GREEN + player.getName());
		return;
	}
	if (user.inGroup("default")) {
		player.setDisplayName(ChatColor.BLUE + player.getName());
		player.setPlayerListName(ChatColor.BLUE + player.getName());
		return;
	}
	if (user.inGroup("developer")) {
		if (player.getDisplayName().equalsIgnoreCase("tjxjnoobie")) {
			player.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "t" + ChatColor.RED + "" + ChatColor.BOLD + "j" + ChatColor.YELLOW + "" + ChatColor.BOLD + "X" + ChatColor.GOLD + "" + ChatColor.BOLD + "J" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "N" + ChatColor.GREEN + ChatColor.BOLD + "O" + ChatColor.DARK_AQUA + ChatColor.BOLD + "O" + ChatColor.AQUA + "" + ChatColor.BOLD + "B" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "I" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "E");
			player.setPlayerListName(player.getDisplayName());

			return;
		}
		if (player.getName().equalsIgnoreCase("6ae")) {
			player.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "6" + ChatColor.RED + "" + ChatColor.BOLD + "a" + ChatColor.YELLOW + "" + ChatColor.BOLD + "e");
			player.setPlayerListName(player.getDisplayName());

			return;
		}

		if (player.getName().equalsIgnoreCase("techwizmatt")) {
			player.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "t" + ChatColor.RED + "" + ChatColor.BOLD + "e" + ChatColor.YELLOW + "" + ChatColor.BOLD + "c" + ChatColor.GOLD + "" + ChatColor.BOLD + "h" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "w" + ChatColor.GREEN + ChatColor.BOLD + "i" + ChatColor.DARK_AQUA + ChatColor.BOLD + "z" + ChatColor.AQUA + "" + ChatColor.BOLD + "m" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "a" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "t" + ChatColor.RED + "" + ChatColor.BOLD + "t");
			player.setPlayerListName(player.getDisplayName());

			return;
		}
	}
}

	@Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}

