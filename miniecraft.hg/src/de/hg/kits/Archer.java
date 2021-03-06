package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Archer {

	private static String name = "�e�lArcher";
	
	public static boolean isEnabled;
	public static ArrayList<Player> onKit;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.archer")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static List<String> getDescription() {
		List<String> lore = new ArrayList<>();
		lore.add("�8Shoot your enemies down!");
		return lore;
	}
	public static ItemStack getKitItem() {
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = bow.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription());
		bow.setItemMeta(meta);
		return bow;
	}
	public static ItemStack[] getKitItems() {
		ItemStack[] items = new ItemStack[1];
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
		bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
		ItemStack arrow = new ItemStack(Material.ARROW, 20);
		
		items[0] = bow;
		items[1] = arrow;
		return items;
	}
}
