package de.hg.kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import de.hg.main.main;
import de.hg.methods.Game;

public class Kangaroo implements Listener {

	public static ArrayList<Player> kanga = new ArrayList<Player>();
	public static ArrayList<Player> hasKanga = new ArrayList<>();
	
	public static int high = 2;
	
	
	private static String name = "§e§lKangaroo";
	
	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.kangaroo")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static List<String> getDescription(Player p) {
		List<String> lore = new ArrayList<>();
		lore.add("§cJump high, but when you sneak jump far!");
		lore.add("");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2owned");
		} else {
			lore.add("§4DISABLED");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack rocket = new ItemStack(Material.FIREWORK);
		ItemMeta meta = rocket.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		rocket.setItemMeta(meta);
		return rocket;
	}
	public static void setKit(Player p) {
		kanga.add(p);
		
		ItemStack rocket = new ItemStack(Material.FIREWORK);
		ItemMeta meta = rocket.getItemMeta();
		meta.setDisplayName("§eKangaroo Rocket");
		rocket.setItemMeta(meta);
		
		p.getInventory().addItem(rocket);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.FIREWORK) {
			if (Game.isRunning && kanga.contains(p)) {
				if (!hasKanga.contains(p)) {
				if ((event.getAction() == Action.LEFT_CLICK_AIR)
						|| (event.getAction() == Action.LEFT_CLICK_BLOCK)
						|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)
						|| (event.getAction() == Action.RIGHT_CLICK_AIR))
					event.setCancelled(true);
				Block b = p.getLocation().getBlock();
					if (!p.isSneaking()) {
						p.setFallDistance(-5.0F);
						Vector vector = p.getEyeLocation().getDirection();
						vector.multiply(0.6F);
						vector.setY(1.0F);
						p.setVelocity(vector);
						p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 2);

					} else {
						p.setFallDistance(-5.0F);
						Vector vector = p.getEyeLocation().getDirection();
						vector.multiply(1.2F);
						vector.setY(0.5D);
						p.setVelocity(vector);
						p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 2);
					}
					hasKanga.add(p);
					addKanga(p);
				}

			} else {
				event.setCancelled(true);
			}
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
		if (Game.isRunning && kanga.contains(p)) {
			if (event.getItemDrop().getItemStack().getType() == Material.FIREWORK)
				event.setCancelled(true);
		}
	}

	@EventHandler
	public void onKangaroo3(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player p = (Player) event.getEntity();
			if (Game.isRunning && kanga.contains(p)) {
				if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
					if (event.getDamage() > 7.0D) {
						event.setCancelled(true);
						p.damage(7.0D);
					}

				}
			}
		}
	}
	public static void addKanga(final Player p) {
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				hasKanga.remove(p);
				
			}
		}, high*20);
	}
}
