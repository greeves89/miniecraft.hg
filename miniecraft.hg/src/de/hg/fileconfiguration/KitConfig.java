package de.hg.fileconfiguration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class KitConfig {
	private static File getConfigFile() {
        return new File("plugins/HungerGames", "kits.yml");
    }

    private static YamlConfiguration getConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static void setConfig() {
        YamlConfiguration cfg = getConfiguration();
        cfg.options().copyDefaults(true); 
        
        cfg.addDefault("Stomper", true);
        cfg.addDefault("Archer", true);
        cfg.addDefault("Soupmaster", false);
        cfg.addDefault("Farmer", true);
        cfg.addDefault("Fisherman", true);
        cfg.addDefault("Mage", true);
        cfg.addDefault("Miner", true);
        cfg.addDefault("Switcher", true);
        cfg.addDefault("Teleporter", true);
        
        
        try {
            cfg.save(getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConfig() {
        YamlConfiguration cfg = getConfiguration();	
        
    }
}
