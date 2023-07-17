package mx.gob.telecomm.soporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mx.gob.telecomm.soporte.conexiondb.ConexionPostgres;
import mx.gob.telecomm.soporte.interfaces.ConexionDB;
import mx.gob.telecomm.soporte.model.Sucursal;

public class SucursalDAO {

	private static String SQL_SELECT = null;

	public ObservableList<Sucursal> getSucursal(String registro) {

		Connection conn = null;
		ConexionDB conPostgres = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Sucursal sucursal = null;
		ObservableList<Sucursal> listaSucursales = FXCollections.observableArrayList();
		try {
			conPostgres = new ConexionPostgres();
			conn = conPostgres.getConnection();
			SQL_SELECT = "SELECT * FROM SUCURSAL WHERE REGISTRO = " +"'"+registro +"'";
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String region = rs.getString("region");
				String entidad = rs.getString("entidad");
				String registroDB = rs.getString("registro");
				String nombreSucursal = rs.getString("nombre_sucursal");
				String estadoSucursal = rs.getString("estado_sucursal");
				String tipoComunicacion = rs.getString("tipo_comunicacion");
				sucursal = new Sucursal(registroDB, entidad, nombreSucursal);
				sucursal.setId(id);
				sucursal.setRegion(region);
				sucursal.setEstadoSucursal(estadoSucursal);
				sucursal.setTipoComunicacion(tipoComunicacion);
				listaSucursales.add(sucursal);
			}
		} catch (Exception e) {
			System.out.println("Error 1 "+ e.getMessage());
		} finally {
			try {
				conPostgres.close(rs);
				conPostgres.close(stmt);
				conPostgres.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaSucursales;
	}

}
