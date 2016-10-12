package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleporterKit {
private static String name = "§c§lTeleporter";
	
	private static boolean isFree = false;
	public static int price = 200;

	public static boolean checkBuy(Player p) {
		if (isFree) {
			return true;
		} else if (p.hasPermission("kits.teleporter")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static List<String> getDescription(Player p) {
		List<String> lore = new ArrayList<>();
		lore.add("§8Teleportiere dich woimmer du hin willst!");
		lore.add("§8Du bekommst 5 Enderperlen!");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2gekauft");
		} else {
			lore.add("§cnicht gekauft");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
		ItemMeta meta = enderpearl.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		enderpearl.setItemMeta(meta);
		return enderpearl;
	}
	public static void setKit(Player p) {
		ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 5);
		
		p.getInventory().addItem(enderpearl);
	}
}
