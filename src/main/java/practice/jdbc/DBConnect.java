package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import practice.classes.PropertiesClass;

public class DBConnect {
	private Connection con;
	private Statement stmt;

	public DBConnect() {
		try {
			
			PropertiesClass propertiesClass = new PropertiesClass();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(propertiesClass.url, propertiesClass.id, propertiesClass.password);
			System.out.println("Connection established");
			
			stmt = con.createStatement();

		} catch (Exception exception) {
			System.err.println(exception);
		}

	}
	
	public Statement getStatement() {
		return stmt;
	}
}
