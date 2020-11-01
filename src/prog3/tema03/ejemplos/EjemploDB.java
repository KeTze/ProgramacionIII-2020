package prog3.tema03.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploDB {
	public static void main(String[]args) {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			
			connection = DriverManager.getConnection("jdbc:sqlite:ejemplo.db");
			
			Statement statement = connection.createStatement();
			
			statement.executeUpdate("drop table if exists person");
			statement.executeUpdate("create table person (id integer, name string)");
			
			statement.executeUpdate("insert into person values(1, 'leo')");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
