package bdm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBejemplo {

	private static Connection connection = null;
	private static String dbName = "sampledatabase.db";

	/**
	 * Abrir una conexión con la BD
	 */
	public static void openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.err.println("ERROR: OPENING. " + e.getMessage());
		}
	}

	/**
	 * Cerrar la conexión con la BD
	 */
	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.err.println("ERROR: CLOSING. " + e.getMessage());
		}
	}

	/**
	 * Retornar un ResultSet con el resultado de ejecutar una Query en la BD (tiempo máximo de espera = 30 segundos)
	 */
	public static ResultSet query(String sql) {
		ResultSet rs = null;
		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("ERROR: QUERING. " + e.getMessage());
		}
		return rs;
	}

}