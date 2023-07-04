package mx.gob.telecomm.soporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.telecomm.soporte.conexiondb.ConexionPostgres;
import mx.gob.telecomm.soporte.interfaces.ConexionDB;
import mx.gob.telecomm.soporte.model.Dispositivo;

public class DispositivoDAO {

	private static String SQL_SELECT = null;
	
	
	public Dispositivo getDispositivo(int idDispositivo) {
		Connection conn = null;
		ConexionDB conPostgres = null;
		PreparedStatement stmt = null;
        ResultSet rs = null;
        Dispositivo dispositivo = null;
        try {
        	conPostgres = new ConexionPostgres();
        	conn = conPostgres.getConnection();
        	SQL_SELECT = "SELECT * FROM DISPOSITIVO WHERE ID = "+idDispositivo;
        	stmt = conn.prepareStatement(SQL_SELECT);
        	rs = stmt.executeQuery();
        	while(rs.next()) {
        		int id = rs.getInt("id");
        		String nombre = rs.getString("nombre");
        		String modelo = rs.getString("modelo");
        		dispositivo = new Dispositivo(id,nombre,modelo);
        	}
        	
        }catch (Exception e) {
        	System.out.println(e.getMessage());
		}
        finally {
			try {
				conPostgres.close(rs);
				conPostgres.close(stmt);
				conPostgres.close(stmt);
				conPostgres.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
		return dispositivo;
	}
	
}
