package de.hg.methods;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import de.hg.main.main;
import de.hg.mysql.statsMySQL;
import de.hg.worldgeneration.WorldGeneration;

public class EndGame {

	public static void setPlayerWinner(Player p) {
		letRocketsSpawn(p);
		generateWinnersStructure(p, 2, Material.GLASS, Material.CAKE_BLOCK);
	}
	public static void generateWinnersStructure(Player p, int widht, Material footer, Material header) {
		Game.endgame = true;
		Location middle = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 80, p.getLocation().getZ());
		
		Location teleportLocation = new Location(middle.getWorld(), middle.getBlockX(), middle.getBlockY() + 3, middle.getBlockZ());
		
		World world = p.getWorld();
		
		Location min = new Location(middle.getWorld(), middle.getBlockX() - widht, middle.getY(), middle.getBlockZ() - widht);
		Location max = new Location(middle.getWorld(), middle.getBlockX() + widht, middle.getY(), middle.getBlockZ() + widht);
		for (int x = min.getBlockX(); x <= max.getBlockX(); x++) {
			 for (int z = min.getBlockZ(); z <= max.getBlockZ(); z++) {
				 for (int y = min.getBlockY() + 1; y < 200; y++) {
					//removing the Blocks above
					 Location hight = new Location(middle.getWorld(), x, y, z);
					 world.getBlockAt(hight).setType(Material.AIR);
				 }
			 }
		 }
		
		for (int x = min.getBlockX(); x <= max.getBlockX(); x++) {
			 for (int z = min.getBlockZ(); z <= max.getBlockZ(); z++) {
				 Location footerLocation = new Location(world, x, middle.getBlockY(), z);
				 world.getBlockAt(footerLocation).setType(footer);
				 
				 Location headerLocation = new Location(world, x, middle.getBlockY() + 1, z);
				 world.getBlockAt(headerLocation).setType(header);
			 }
		 }
		statsMySQL.updateWin(p.getUniqueId(), true, 1);
		p.teleport(teleportLocation);
		p.sendMessage("§2Du hast das Spiel gewonnen!");
		p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 10);
	}
	private static int countdown;
	private static int high = 10;
	public static void letRocketsSpawn(final Player p) {
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {
			@Override
			public void run() {
				if (high != 0) {
					high--;
				} else {
					Bukkit.getScheduler().cancelTask(countdown);
					regenerate();
				}
				Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkEffect effect = FireworkEffect.builder()
						.withColor(Color.GREEN)
						.flicker(true)
						.trail(true)
						.with(FireworkEffect.Type.STAR)
						.build();
				
				FireworkMeta meta = firework.getFireworkMeta();
				meta.addEffect(effect);
				meta.setPower(1);
				firework.setFireworkMeta(meta);
				
			}
		}, 0, 20);
		
	}
	public static void regenerate() {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv delete " + WorldGeneration.worldname);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv confirm");
		Bukkit.getServer().reload();
	}
}
