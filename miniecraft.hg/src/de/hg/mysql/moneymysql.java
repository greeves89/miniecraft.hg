package de.hg.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class moneymysql {

	public static boolean didUserExist(UUID uuid) {
		
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT Money FROM MoneySystem WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void addMoney(UUID uuid, int amount) {
		double money = getMoney(uuid);
		double result = money += amount;
		PreparedStatement ps;
		try {
			ps = mysql.getConnection().prepareStatement("UPDATE MoneySystem SET Money = ? WHERE UUID = ?");
			ps.setDouble(1, result);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static double getMoney(UUID uuid) {
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT Money FROM MoneySystem WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble("Money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
