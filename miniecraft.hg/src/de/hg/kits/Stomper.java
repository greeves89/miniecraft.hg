package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.hg.kits.Kits.kits;
import de.hg.methods.Game;

public class Stomper implements Listener {
	private static String name = "§c§lStomper";
	
	private static boolean isFree = false;
	public static int price = 500;

	public static boolean checkBuy(Player p) {
		if (isFree) {
			return true;
		} else if (p.hasPermission("kits.stomper")) {
			return true;
		} else {
			return false;
		}
	}

 	public static List<String> getDescription(Player p) {
		List<String> lore = new ArrayList<>();
		lore.add("§cSpringe auf deinen Gegner,");
		lore.add("§cdieser wird einen Teil von deinem Fallschaden bekommen!");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2gekauft");
		} else {
			lore.add("§cnicht gekauft");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack iboots = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta = iboots.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		iboots.setItemMeta(meta);
		return iboots;
	}
	@EventHandler
	public void onStomp(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player && Game.isRunning && Game.inInvenciblity == false) {
			Player p = (Player) e.getEntity();
			if (KitSelector.kitHash.containsKey(p));
				if (KitSelector.kitHash.get(p).equals(kits.STOMPER) && e.getCause().equals(DamageCause.FALL)) {
					for (Entity ent : p.getNearbyEntities(3, 3, 3)) {
						if (ent instanceof LivingEntity) {
							((LivingEntity) ent).damage(e.getDamage() / 3);
							p.damage(e.getDamage() / 5);
						}
					}
					e.setCancelled(true);
				}
		}
	}
}
