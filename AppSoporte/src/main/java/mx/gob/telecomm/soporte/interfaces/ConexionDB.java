package mx.gob.telecomm.soporte.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public interface ConexionDB {

	public Connection getConnection() throws SQLException;
	public void close(ResultSet rs) throws SQLException;
	public void close(Statement smtm) throws SQLException;
	public void close(PreparedStatement smtm) throws SQLException;
	public void close(Connection conn) throws SQLException;
}
