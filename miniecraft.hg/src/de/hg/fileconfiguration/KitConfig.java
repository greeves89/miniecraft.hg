package de.hg.fileconfiguration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import de.hg.kits.Archer;
import de.hg.kits.Farmer;
import de.hg.kits.Fisherman;
import de.hg.kits.Grandpa;
import de.hg.kits.Kangaroo;
import de.hg.kits.Lumberjack;
import de.hg.kits.Mage;
import de.hg.kits.Miner;
import de.hg.kits.Pyro;
import de.hg.kits.Scout;
import de.hg.kits.Soupmaster;
import de.hg.kits.Stomper;
import de.hg.kits.Switcher;
import de.hg.kits.TeleporterKit;

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
        cfg.addDefault("Kangaroo", true);
        cfg.addDefault("KangaCooldown", 1);
        cfg.addDefault("Grandpa", true);
        cfg.addDefault("Scout", true);
        cfg.addDefault("ScoutPotions", 3);
        cfg.addDefault("Pyro", true);
        cfg.addDefault("Lumberjack", true);
        
        try {
            cfg.save(getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConfig() {
        YamlConfiguration cfg = getConfiguration();	
        
        Kangaroo.high = cfg.getInt("KangaCooldown");
        Scout.bottleAmount = cfg.getInt("ScoutPotions");
        
        Pyro.isEnabled = cfg.getBoolean("Pyro");
        Lumberjack.isEnabled = cfg.getBoolean("Lumberjack");
        Scout.isEnabled = cfg.getBoolean("Scout");
        Grandpa.isEnabled = cfg.getBoolean("Grandpa");
        Kangaroo.isEnabled = cfg.getBoolean("Kangaroo");
        Stomper.isEnabled = cfg.getBoolean("Stomper");
        Archer.isEnabled = cfg.getBoolean("Archer");
        Soupmaster.isEnabled = cfg.getBoolean("Soupmaster");
        Farmer.isEnabled = cfg.getBoolean("Farmer");
        Fisherman.isEnabled = cfg.getBoolean("Fisherman");
        Mage.isEnabled = cfg.getBoolean("Mage");
        Miner.isEnabled = cfg.getBoolean("Miner");
        Switcher.isEnabled = cfg.getBoolean("Switcher");
        TeleporterKit.isEnabled = cfg.getBoolean("Teleporter");
        
    }
}
