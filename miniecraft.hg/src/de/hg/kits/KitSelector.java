package de.hg.kits;

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

import de.hg.methods.Game;
public class KitSelector implements Listener {
	
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
						p.openInventory(getKitSelectorInventory(p));
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
						
					}
				}
			}
		}
	}
	public static Inventory getKitSelectorInventory(Player p) {
		Inventory selectorInv = Bukkit.createInventory(null, 36, "Kit Selector");
		
		ItemStack glass = new ItemStack(Material.THIN_GLASS);
		for (int i = 0; i < 8; i++) {
			selectorInv.setItem(0, glass);
		}
		for (Kit k : Kits.kits) {
			selectorInv.addItem(k.getKitItem());
		}
		return selectorInv;
	}
	public static void setKit() {
		
	}
}
