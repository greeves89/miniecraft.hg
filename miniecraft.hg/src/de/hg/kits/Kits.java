package de.hg.kits;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import de.hg.kits.*;

public class Kits {
	
	public static ArrayList<Kit> kits = new ArrayList<>();
	
	public static void initKits() {
		Kit archer = new Kit("Archer", Archer.getKitItem(), Archer.getKitItems(), Archer.getDescription(), Archer.onKit, 1000);
		
		kits.add(archer);
	}
	public static boolean doPlayerHaveAKitSelected(Player p) {
		for (Kit k : kits) {
			if (k.getOnKit().contains(p)) {
				return true;
			}
		}
		return false;
	}
	public static Kit getSelectedKit(Player p) {
		for (Kit k : kits) {
			if (k.getOnKit().contains(p)) {
				return k;
			}
		}
		return null;
	}
	
}
