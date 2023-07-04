package mx.gob.telecomm.soporte.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mx.gob.telecomm.soporte.dao.DispositivoDAO;


class DispositivoDaoTest {

	@Test
	@DisplayName("Prueba Conexion DISPOSITIVO")
	void testGetDispositivo() {
		DispositivoDAO dao = new DispositivoDAO();
		Dispositivo uno = dao.getDispositivo(30);
		assertNotNull(uno);
	}

}
