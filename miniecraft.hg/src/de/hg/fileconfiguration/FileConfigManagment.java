package de.hg.fileconfiguration;

public class FileConfigManagment {

	public static void loadConfigs() {
		MySQLConfig.setConfig();
		MySQLConfig.readConfig();
	}
	
}
