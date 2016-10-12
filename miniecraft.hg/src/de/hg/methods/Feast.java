package de.hg.methods;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import de.hg.worldgeneration.WorldGeneration;

public class Feast {

	private static String worldname = WorldGeneration.worldname;
	private static World world = Bukkit.getWorld(worldname);

	public static ArrayList<ItemStack> items = new ArrayList<>();
	
	public static ArrayList<Location> FeastLocation = new ArrayList<>();
	
	public static Location loc;
	 
	 public static Location getLocation() {
	  int x = 0;
	  int y = 0;
	  int z = 0;
	  
	  
	  Random rn = new Random();
	  y = rn.nextInt(20) + 55;
	  x = rn.nextInt(100) + 1;
	  z = rn.nextInt(100) + 1;
	  Location loc = new Location(world, x, y, z);
	  return loc;
	 }
	 public static void createFeast(Material material, int widht) {
		 Location middle = loc;
		 
		 Game.isFeast = true;
		 
		 generateItems();
	  
		 Location min = new Location(middle.getWorld(), middle.getX() - widht, middle.getY(), middle.getZ() - widht);
		 Location max = new Location(middle.getWorld(), middle.getX() + widht, middle.getY(), middle.getZ() + widht);
	  
		 for (int x = min.getBlockX(); x <= max.getBlockX(); x++) {
			 for (int z = min.getBlockZ(); z <= max.getBlockZ(); z++) {
				 Location l = new Location(middle.getWorld(), x, middle.getBlockY(), z);
				 middle.getWorld().getBlockAt(l).setType(material);
			 }
		 }
		 
		 // removing Blocks Above 
		 
		 for (int x = min.getBlockX(); x <= max.getBlockX(); x++) {
			 for (int z = min.getBlockZ(); z <= max.getBlockZ(); z++) {
				 for (int y = min.getBlockY() + 1; y < 200; y++) {
					 Location l = new Location(middle.getWorld(), x, y, z);
					 world.getBlockAt(l).setType(Material.AIR);
				 }
			 }
		 }
	 }
	 public static ItemStack getItem() {
		 Random rn = new Random();
		 ItemStack item = new ItemStack(items.get(rn.nextInt(items.size())));
		 return item;
	 }
	 /**
	  * Notioce that the widht must be the same as the feast widht if the hole 
	  * Feast want to be used!
	  * @param widht
	  */
	 public static void startCreatingItems(int widht) {
		 Location middle = loc;
		 
		 Location min = new Location(middle.getWorld(), middle.getX() - widht, middle.getY(), middle.getZ() - widht);
		 Location max = new Location(middle.getWorld(), middle.getX() + widht, middle.getY(), middle.getZ() + widht);
		 
		 for (int x = min.getBlockX(); x <= max.getBlockX(); x++)  {
			 for (int z = min.getBlockZ(); z <= max.getBlockZ(); z++)  {
				 Location l = new Location(world, x, middle.getY() + 25, z);
				 FeastLocation.add(l);
			 }
		 }
		 Random rn = new Random();
		 
		 for (int i = 0; i < 22; i++) {
			 Location spawning = FeastLocation.get(rn.nextInt(FeastLocation.size() + 1));
			 world.dropItemNaturally(spawning, getItem());
		 }
		 
	 }
	 
	 private static void generateItems() {
		 Random rn = new Random();
		 
		 
		 ItemStack diamond = new ItemStack(Material.DIAMOND, rn.nextInt(4) + 1);
		 ItemStack iron = new ItemStack(Material.IRON_INGOT, rn.nextInt(12) + 1);
		 ItemStack Dchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		 ItemStack DPants = new ItemStack(Material.DIAMOND_LEGGINGS);
		 ItemStack DBoots = new ItemStack(Material.DIAMOND_BOOTS);
		 ItemStack DHelmet = new ItemStack(Material.DIAMOND_HELMET);
		 ItemStack steak = new ItemStack(Material.COOKED_BEEF, rn.nextInt(32) + 1);
		 ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		 ItemStack strenght = new ItemStack(Material.POTION, 1, (short) 8233);
		 ItemStack SwPotion = new ItemStack(Material.POTION, 1, (short) 8226);
		 ItemStack WaterBucket = new ItemStack(Material.WATER_BUCKET);
		 ItemStack LavaBucket = new ItemStack(Material.LAVA_BUCKET);
		 ItemStack Bucket = new ItemStack(Material.BUCKET);	 
		 ItemStack XP = new ItemStack(Material.EXP_BOTTLE, rn.nextInt(16) + 1);
		 
		 items.add(Bucket);
		 items.add(LavaBucket);
		 items.add(WaterBucket);
		 items.add(XP);
		 items.add(SwPotion);
		 items.add(strenght);
		 items.add(sword);
		 items.add(steak);
		 items.add(DHelmet);
		 items.add(DBoots);
		 items.add(Dchestplate);
		 items.add(DPants);
		 items.add(iron);
		 items.add(diamond);
	 }
	 public static boolean checkIfLocationContainsFeast(Location l, int widht) {
		 Location middle = loc;
		 
		 Location min = new Location(middle.getWorld(), middle.getX() - widht, middle.getY(), middle.getZ() - widht);
		 Location max = new Location(middle.getWorld(), middle.getX() + widht, middle.getY(), middle.getZ() + widht);
		 
		 for (int x = min.getBlockX(); x <= max.getBlockX(); x++) {
			 for (int z = min.getBlockZ(); z <= max.getBlockZ(); z++) {
				 for (int y = min.getBlockY(); y < 200; y++) {
					 Location block = new Location(middle.getWorld(), x, y, z);
					 if (block == l) {
						 return true;
					 }
				 }
			 }
		 }
			return false;
		}
}
