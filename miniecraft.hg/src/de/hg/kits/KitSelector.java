package de.hg.kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.hg.kits.Kits.kits;
import de.hg.methods.Game;
import de.hg.utils.message;

public class KitSelector implements Listener {

	public static ArrayList<Player> hasKitChoosen = new ArrayList<>();
	
	public static HashMap<Player, Kits.kits> kitHash = new HashMap<>();
	
	private static Inventory selector = Bukkit.createInventory(null, 45, "KitSelector");
	//
	
	//
	public static ItemStack getKitSelector() {
		ItemStack chest = new ItemStack(Material.CHEST);
		ItemMeta meta = chest.getItemMeta();
		meta.setDisplayName("§8Kits");
		chest.setItemMeta(meta);
		return chest;
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
			if (p.getItemInHand().getType() == Material.CHEST) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					if (Game.inStatup) {
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 10);
						openKitSelector(p);
					}
				}
			}
	}
	@EventHandler
	public void onInvInteract(InventoryClickEvent e) {
		if (Game.inInvenciblity == false && Game.isRunning == false) {
			if (e.getClickedInventory() != null) {
				if (e.getWhoClicked() instanceof Player) {
					Player p = (Player) e.getWhoClicked();
					if (e.getClickedInventory().getType() == selector.getType()) {
						ItemStack current = e.getCurrentItem();
						if (!kitHash.containsKey(p)) {
	 						if (current.equals(Archer.getKitItem(p))) {
								kitHash.put(p,kits.ARCHER);
							} else if (current.equals(Farmer.getKitItem(p))) {
								kitHash.put(p, kits.FARMER);
							} else if (current.equals(TeleporterKit.getKitItem(p))) {
								if (TeleporterKit.checkBuy(p)) {
									kitHash.put(p, kits.TELEPORTER);
								} else {
									p.sendMessage(message.kitDontOwn);
								}
							} else if (current.equals(Soupmaster.getKitItem(p))) {
								if (Soupmaster.checkBuy(p)) {
									kitHash.put(p, kits.SOUPMASTER);
								} else {
									p.sendMessage(message.kitDontOwn);
								}
							} else if (current.equals(Miner.getKitItem(p))) {
								if (Miner.checkBuy(p)) {
									kitHash.put(p, kits.MINER);
								} else {
									p.sendMessage(message.kitDontOwn);
								}
							} else if (current.equals(Stomper.getKitItem(p))) {
								if (Stomper.checkBuy(p)) {
									kitHash.put(p, kits.STOMPER);
								} else {
									p.sendMessage(message.kitDontOwn);
								}
							} else if (current.equals(Fisherman.getKitItem(p))) {
								if (Fisherman.checkBuy(p)) {
									kitHash.put(p, kits.FISHERMAN);
								} else {
									p.sendMessage(message.kitDontOwn);
								}
							} else if (current.equals(Mage.getKitItem(p))) {
								if (Mage.checkBuy(p)) {
									kitHash.put(p, kits.MAGIER);
								} else {
									p.sendMessage(message.kitDontOwn);
								}
							} else if (current.equals(Switcher.getKitItem(p))) {
								if (Switcher.checkBuy(p)) {
									kitHash.put(p, kits.SWITCHER);
								} else {
									p.sendMessage(message.kitDontOwn);
								}
							}
						} else {
							kitHash.remove(p);
							p.sendMessage("§cWähle dein Kit erneut!");
						}
						p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 10);
						p.sendMessage(message.prefix + "Du hast ein Kit gewählt!");
						p.getOpenInventory().close();
						e.setCancelled(true);
					}
				}
			}
		}
	}
	public static void openKitSelector(Player p) {
		ItemStack glass = new ItemStack(Material.THIN_GLASS);
		ItemMeta glassmeta = glass.getItemMeta();
		glassmeta.setDisplayName("§cKitSelector");
		glass.setItemMeta(glassmeta);
		
		for (int i = 0; i < 9; i++) {
			selector.setItem(i, glass);
		}
		
		selector.setItem(9, Archer.getKitItem(p));
		selector.setItem(10, Farmer.getKitItem(p));
		selector.setItem(11, TeleporterKit.getKitItem(p));
		selector.setItem(12, Soupmaster.getKitItem(p));
		selector.setItem(13, Miner.getKitItem(p));
		selector.setItem(14, Stomper.getKitItem(p));
		selector.setItem(15, Fisherman.getKitItem(p));
		selector.setItem(16, Mage.getKitItem(p));
		selector.setItem(17, Switcher.getKitItem(p));
		
		for (int i = 36; i < 45; i++) {
			selector.setItem(i, glass);
		}
		p.openInventory(selector);
	}
	public static void setKit() {
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (kitHash.containsKey(all)) {
				if (kitHash.get(all) == kits.ARCHER) {
					Archer.setKit(all);
				} else if (kitHash.get(all) == kits.FARMER) {
					Farmer.setKit(all);
				} else if (kitHash.get(all) == kits.TELEPORTER) {
					TeleporterKit.setKit(all);
				} else if (kitHash.get(all) == kits.SOUPMASTER) {
					Soupmaster.setKit(all);
				} else if (kitHash.get(all) == kits.MINER) {
					Miner.setKit(all);
				} else if (kitHash.get(all) == kits.FISHERMAN) {
					Fisherman.setKit(all);
				} else if (kitHash.get(all) == kits.MAGIER) {
					Mage.setKit(all);
				} else if (kitHash.get(all) == kits.SWITCHER) {
					Switcher.setKit(all);
				} else {
					ItemStack sword = new ItemStack(Material.WOOD_SWORD);
					all.getInventory().addItem(sword);
				}
			}
		}
	}
}
