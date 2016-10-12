package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Archer {

	private static String name = "�e�lSch�tze";
	
	private static boolean isFree = true;
	public static int price = 150;
	
	public static boolean checkBuy(Player p) {
		if (isFree) {
			return true;
		} else if (p.hasPermission("kits.archer")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static List<String> getDescription(Player p) {
		List<String> lore = new ArrayList<>();
		lore.add("�8Schie�e deine Gegner mit einem Bogen ab.");
		lore.add("");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("�2gekauft");
		} else {
			lore.add("�cnicht gekauft!");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = bow.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		bow.setItemMeta(meta);
		return bow;
	}
	public static void setKit(Player p) {
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
		
		ItemStack arrow = new ItemStack(Material.ARROW);
		
		p.getInventory().addItem(bow);
		p.getInventory().addItem(arrow);
	}
}
