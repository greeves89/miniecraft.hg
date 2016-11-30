package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.hg.kits.Kits.kits;
import de.hg.methods.Game;

public class Fisherman implements Listener {
	private static String name = "§c§lAngler";

	public static boolean checkBuy(Player p) {
		if (p.hasPermission("kits.fisherman")) {
			return true;
		} else {
			return false;
		}
	}

 	public static List<String> getDescription(Player p) {
		List<String> lore = new ArrayList<>();
		lore.add("§cDu kannst Spieler, Tiere und Monster, ");
		lore.add("§czu dich ziehen!");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2gekauft");
		} else {
			lore.add("§cnicht gekauft");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
		ItemMeta meta = fishingrod.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		fishingrod.setItemMeta(meta);
		return fishingrod;
	}
	public static void setKit(Player p) {
		ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
		
		p.getInventory().addItem(fishingrod);
	}
	@EventHandler
	public void onFish(PlayerFishEvent e) {
		Player p = e.getPlayer();
		if (Game.isRunning && Game.inInvenciblity == false) {
			if (KitSelector.kitHash.get(p).equals(kits.FISHERMAN)) {
				if (e.getCaught() != null && e.getCaught() instanceof LivingEntity) {
					LivingEntity ent = (LivingEntity) e.getCaught();
					ent.teleport(p.getLocation());
				}
			}
		}
	}
	
}
