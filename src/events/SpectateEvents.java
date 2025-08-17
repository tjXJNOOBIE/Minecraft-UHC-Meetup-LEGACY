package events;

import commands.Spectate;
import game.Start;
import me.Alex.KonixMeetup.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.DecimalFormat;
import java.util.Random;

public class SpectateEvents implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for(String specs : Spectate.spec){
			p.hidePlayer(Bukkit.getPlayer(specs));
			continue;
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(Spectate.spec.contains(p.getName())){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(Spectate.spec.contains(p.getName())){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		if(Spectate.spec.contains(p.getName())){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		if(Spectate.spec.contains(p.getName())){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEntityEvent event1){
        Player player = event1.getPlayer();
        Entity entity = event1.getRightClicked();
        if(entity instanceof Player == true){   
        	if(player.getItemInHand().getType() == Material.BOOK) {
        		if(Spectate.spec.contains(player.getName())){
        		Player p = (Player) entity;
        		double health = p.getHealth();
				double healthd = health;
				DecimalFormat df2 = new DecimalFormat("#.###");
				double value = Double.valueOf(df2.format(healthd));
				double saturation = p.getSaturation();
        		PlayerInventory pi = p.getInventory();
        		Inventory inv = Bukkit.createInventory(null, 54, "§aViewing " + p.getName());
        		ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 8);
        		ItemStack h = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        		ItemStack r = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
        		ItemMeta rm = r.getItemMeta();
        		rm.setDisplayName("§7Player's Health: §b" + value);
        		r.setItemMeta(rm);
        		ItemStack k = new ItemStack(Material.DIAMOND_SWORD, 1);
        		ItemMeta km = k.getItemMeta();
        		km.setDisplayName("§7Player's Kills: §b" + DeathEvent.kills.get(p.getName()));
        		k.setItemMeta(km);
        		ItemStack s = new ItemStack(Material.STAINED_CLAY, 1, (byte) 4);
        		ItemMeta sm = s.getItemMeta();
        		sm.setDisplayName("§7Player's Hunger: §b" + saturation);
        		s.setItemMeta(sm);
        		ItemMeta hm = h.getItemMeta();
        		hm.setDisplayName(p.getName());
        		h.setItemMeta(hm);
        		inv.setItem(0, pane);
        		inv.setItem(1, pane);
        		inv.setItem(2, pi.getHelmet());
        		inv.setItem(3, pi.getChestplate());
        		inv.setItem(4, h);
        		inv.setItem(5, pi.getLeggings());
        		inv.setItem(6, pi.getBoots());
        		inv.setItem(7, pane);
        		inv.setItem(8, pane);
        		inv.setItem(9, pi.getItem(0));
        		inv.setItem(10, pi.getItem(1));
        		inv.setItem(11, pi.getItem(2));
        		inv.setItem(12, pi.getItem(3));
        		inv.setItem(13, pi.getItem(4));
        		inv.setItem(14, pi.getItem(5));
        		inv.setItem(15, pi.getItem(6));
        		inv.setItem(16, pi.getItem(7));
        		inv.setItem(17, pi.getItem(8));
        		inv.setItem(18, pi.getItem(9));
        		inv.setItem(19, pi.getItem(10));
        		inv.setItem(20, pi.getItem(11));
        		inv.setItem(21, pi.getItem(12));
        		inv.setItem(22, pi.getItem(13));
        		inv.setItem(23, pi.getItem(14));
        		inv.setItem(24, pi.getItem(15));
        		inv.setItem(25, pi.getItem(16));
        		inv.setItem(26, pi.getItem(17));
        		inv.setItem(27, pi.getItem(18));
        		inv.setItem(28, pi.getItem(19));
        		inv.setItem(29, pi.getItem(20));
        		inv.setItem(30, pi.getItem(21));
        		inv.setItem(31, pi.getItem(22));
        		inv.setItem(32, pi.getItem(23));
        		inv.setItem(33, pi.getItem(24));
        		inv.setItem(34, pi.getItem(25));
        		inv.setItem(35, pi.getItem(26));
        		inv.setItem(36, pi.getItem(27));
        		inv.setItem(37, pi.getItem(28));
        		inv.setItem(38, pi.getItem(29));
        		inv.setItem(39, pi.getItem(30));
        		inv.setItem(40, pi.getItem(31));
        		inv.setItem(41, pi.getItem(32));
        		inv.setItem(42, pi.getItem(33));
        		inv.setItem(43, pi.getItem(34));
        		inv.setItem(44, pi.getItem(35));
        		inv.setItem(45, pane);
        		inv.setItem(46, pane);
        		inv.setItem(47, r);
        		inv.setItem(48, pane);
        		inv.setItem(49, k);
        		inv.setItem(50, pane);
        		inv.setItem(51, s);
        		inv.setItem(52, pane);
        		inv.setItem(53, pane);
        		player.openInventory(inv);
        		}
        	}
        }
	}
	
        @EventHandler
        public void onClick(PlayerInteractEvent e){
        	Player p = e.getPlayer();
        	Action a = e.getAction();
        	if(a==Action.RIGHT_CLICK_BLOCK || a==Action.RIGHT_CLICK_AIR){
        		
        		ItemStack hand = p.getItemInHand();
        		if(hand!=null&&hand.getType()==Material.NETHER_STAR){
        			if(Spectate.spec.contains(p.getName())){
        				Location l = new Location(p.getWorld(), 0, 100, 0);
        				p.teleport(l);
        				p.sendMessage(Main.getPrefix() +"§eYou have teleported to the §acenter §eof your world.");
        			}
        		}
        	}
        }
        
        @EventHandler
        public void onClick2(PlayerInteractEvent e){
        	Player p = e.getPlayer();
        	Action a = e.getAction();
        	if(a==Action.RIGHT_CLICK_BLOCK || a==Action.RIGHT_CLICK_AIR){
        		
        		ItemStack hand = p.getItemInHand();
        		if(hand!=null&&hand.getType()==Material.WATCH){
        			if(Spectate.spec.contains(p.getName())){
        				Random ran = new Random();
						int playerIndex = ran.nextInt(JoinCheck.playing.size());
						Player player = JoinCheck.playing.get(playerIndex);

        				p.teleport(player);
        				p.sendMessage("§eYou teleported to §a" + player.getName());
        			}
        		}
        	}
        }
        
        @EventHandler
        public void onClick22(PlayerInteractEvent e){
        	Player p = e.getPlayer();
        	Action a = e.getAction();
        	if(a==Action.RIGHT_CLICK_BLOCK || a==Action.RIGHT_CLICK_AIR){
        		
        		ItemStack hand = p.getItemInHand();
        		if(hand!=null&&hand.getType()==Material.IRON_INGOT){
        			if(Spectate.spec.contains(p.getName())){
        				Inventory inv = Bukkit.createInventory(null, 9, "§9World Selector");
        				ItemStack l = new ItemStack(Material.COBBLESTONE);
        				ItemMeta lm = l.getItemMeta();
        				lm.setDisplayName("§aLobby");
        				l.setItemMeta(lm);
        				ItemStack w = new ItemStack(Material.GRASS);
        				ItemMeta wm = w.getItemMeta();
        				wm.setDisplayName("§aWorld");
        				w.setItemMeta(wm);
        				ItemStack n = new ItemStack(Material.NETHERRACK);
        				ItemMeta nm = n.getItemMeta();
        				nm.setDisplayName("§aNether");
        				n.setItemMeta(nm);
        				inv.setItem(2, l);
        				inv.setItem(4, w);
        				inv.setItem(6, n);
        				p.openInventory(inv);
        		}
        	}
        }
    }
        
        @EventHandler
        public void onInventoryOpenEvent(InventoryOpenEvent e){
            if (e.getInventory().getHolder() instanceof Chest || e.getInventory().getHolder() instanceof DoubleChest){
                if(Spectate.spec.contains(e.getPlayer().getName())){
                	e.setCancelled(true);
                }
            }
        }
        
        @SuppressWarnings("deprecation")
		@EventHandler
        public void onCli24ck22(PlayerInteractEvent e){
        	Player p = e.getPlayer();
        	Action a = e.getAction();
        	if(a==Action.RIGHT_CLICK_BLOCK || a==Action.RIGHT_CLICK_AIR){
        		
        		ItemStack hand = p.getItemInHand();
        		if(hand!=null&&hand.getType()==Material.COMPASS){
        			if(Spectate.spec.contains(p.getName())){
        				Inventory inv = Bukkit.createInventory(null, 27, "§9Teleport to a Player");
        				for(String pall : Start.alive){
        					Player m = Bukkit.getPlayer(pall);
        					ItemStack h = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        					SkullMeta hm = (SkullMeta) h.getItemMeta();
        	        		hm.setDisplayName(m.getName());
        	        		hm.setOwner(m.getName());
        	        		h.setItemMeta(hm);
        	        		inv.addItem(h);                          
        	        	
        	        		continue;
        				}
        				p.openInventory(inv);
        		}
        	}
        }
    }
        
        @EventHandler
    	public void onCl2ick(InventoryClickEvent e){
    		if(e.getInventory().getName().contains("Teleport")){
    			e.setCancelled(true);
    			Player p = (Player)e.getWhoClicked();
    			if(e.getSlotType() == SlotType.CONTAINER){
    				SkullTeleport(p,e.getCurrentItem());
    			}
    		}
    	}
        
        @SuppressWarnings("deprecation")
    	public void SkullTeleport(Player player,ItemStack item){
            if(item.getType() != Material.AIR && item != null){
                    SkullMeta skullmeta = (SkullMeta)item.getItemMeta();
                    if(skullmeta.getDisplayName() != null){
                            if(Bukkit.getPlayer(skullmeta.getDisplayName()) != null){
                                    Player target = Bukkit.getPlayer(skullmeta.getDisplayName());
                                    player.teleport(target);
                                    player.sendMessage("§6§lMeetup §8§ §fYou've teleported to §a" + target.getName());
                            }
                    }
            }
    }
        
        @EventHandler
    	public void onCl2i22k(InventoryClickEvent e1){
    		HumanEntity ee = e1.getWhoClicked();
    		if((ee instanceof Player)){
    			Player p = (Player)ee;
    			
    			if(e1.getInventory().getName().contains("World")){
    				if(e1.getSlot() == 2){
    					p.closeInventory();
    					Location l = new Location(Bukkit.getWorld("UHCLobby1"), 971, 59 , -570);
    					p.teleport(l);
    					p.sendMessage("§eYou teleported to the §aLobby §eworld.");
    					e1.setCancelled(true);
    				}
    				
    				if(e1.getSlot() == 4){
    					p.closeInventory();
    					Location l = new Location(Bukkit.getWorld("UHC"), 0, 100 ,0);
    					p.teleport(l);
    					p.sendMessage("§eYou teleported to the §aUHC §eworld.");
    					e1.setCancelled(true);
    				}
    				
    				if(e1.getSlot() == 6){
    					p.closeInventory();
    					p.sendMessage("§cThe nether is disabled this game.");
    					e1.setCancelled(true);
    				}
    			}
    		}
    	}
        
        @EventHandler
    	public void onCl22i22k(InventoryClickEvent e1){
    		HumanEntity ee = e1.getWhoClicked();
    		if((ee instanceof Player)){
    			
    			if(e1.getInventory().getName().contains("Viewing")){
    				e1.setCancelled(true);
    			}
    		}
        }
        
        @EventHandler
        public void onPlayerDamage(EntityDamageEvent e){
          try {
        	  if ((e.getEntity() instanceof Player))
            {
              Player p = (Player)e.getEntity();
              if (Spectate.spec.contains(p.getName()))
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
              Player d = (Player)e.getDamager();
              if (Spectate.spec.contains(d.getName()))
                e.setCancelled(true);
            }
          }
          catch (Exception localException)
          {
          }
        }
        

        
        @EventHandler
        public void onSaturationLoss(FoodLevelChangeEvent e){
        	if(Spectate.spec.contains(e.getEntity().getName())){
        		e.setCancelled(true);
        	}
        }

}
