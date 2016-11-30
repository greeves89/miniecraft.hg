package de.hg.fileconfiguration;

public class FileConfigManagment {

	public static void loadConfigs() {
		BasicConfig.setConfig();
		BasicConfig.readConfig();
		
		KitConfig.setConfig();
		KitConfig.readConfig();
		
		MySQLConfig.setConfig();
		MySQLConfig.readConfig();
	}
	
}
