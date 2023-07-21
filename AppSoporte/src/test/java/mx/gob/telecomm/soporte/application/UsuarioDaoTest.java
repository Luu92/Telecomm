package mx.gob.telecomm.soporte.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mx.gob.telecomm.soporte.dao.UsuarioDAO;
import mx.gob.telecomm.soporte.model.Usuario;

class UsuarioDaoTest {

	@Test
	void testGetUsuario() {
		UsuarioDAO user = new UsuarioDAO();
		Usuario usuario = user.getUsuario("FER2","123");
		assertNotNull(usuario);
		assertEquals("FER2", usuario.getUserName());
	}

}
