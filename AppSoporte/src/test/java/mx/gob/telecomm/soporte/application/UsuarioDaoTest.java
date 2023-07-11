package mx.gob.telecomm.soporte.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mx.gob.telecomm.soporte.dao.UsuarioDAO;
import mx.gob.telecomm.soporte.model.Usuario;

class UsuarioDaoTest {

	@Test
	void testGetUsuario() {
		UsuarioDAO user = new UsuarioDAO();
		Usuario usuario = user.getUsuario("FER69","123");
		try {			
			System.out.println(usuario.getRol());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertNotNull(usuario);
	}

}
