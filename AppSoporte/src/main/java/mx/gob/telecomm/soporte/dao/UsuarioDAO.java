package mx.gob.telecomm.soporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.gob.telecomm.soporte.conexiondb.ConexionPostgres;
import mx.gob.telecomm.soporte.interfaces.ConexionDB;
import mx.gob.telecomm.soporte.model.Persona;
import mx.gob.telecomm.soporte.model.Usuario;

public class UsuarioDAO {

	private static String SQL_SELECT = null;

	public Usuario getUsuario(String userName, String password) {

		Connection conn = null;
		ConexionDB conPostgres = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		Usuario usuario = null;
		try {
			conPostgres = new ConexionPostgres();
			conn = conPostgres.getConnection();
			SQL_SELECT = "SELECT * FROM USUARIO WHERE USERNAME = " + "'" + userName + "'" + " AND " + "CONTRASENIA = "
					+ "'" + password + "'";
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String userNames = rs.getString("username");
				String pass = rs.getString("contrasenia");
				String rol = rs.getString("rol");
				int idPersona = rs.getInt("id_persona");
				usuario = new Usuario(userNames, password, rol, idPersona);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conPostgres.close(rs);
				conPostgres.close(stmt);
				conPostgres.close(stmt);
				conPostgres.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}

}
