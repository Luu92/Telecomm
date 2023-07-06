package mx.gob.telecomm.soporte.application;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mx.gob.telecomm.soporte.conexiondb.ConexionPostgres;
import mx.gob.telecomm.soporte.interfaces.ConexionDB;

class ConexionPostgresTest {

	@Test
	@DisplayName("Prueba A Conexion POSTGRES Base de Datos")
	void test() {
		ConexionDB conn = new ConexionPostgres();
		try {
			conn.getConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		Assertions.assertNotNull(conn);
	}

}
