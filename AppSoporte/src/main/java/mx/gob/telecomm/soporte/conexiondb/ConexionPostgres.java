package mx.gob.telecomm.soporte.conexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mx.gob.telecomm.soporte.interfaces.ConexionDB;

public class ConexionPostgres implements ConexionDB {

	public static final  String NOMBRE_DB = "telecoom_app";
	private static final String JDBC_URL = "jdbc:postgresql://172.16.27.251:5432/" + NOMBRE_DB + "?";
	private static final String JDBC_USER = "soporte";
	private static final String JDBC_PASS = "soporte01";
	
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	
	public void close(ResultSet rs) throws SQLException {
		rs.close();
	}

	public void close(Statement smtm) throws SQLException {
		smtm.close();
	}

	public void close(PreparedStatement smtm) throws SQLException {
		smtm.close();
	}

	public void close(Connection conn) throws SQLException {
		conn.close();
	}
	 
}
