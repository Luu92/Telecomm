package mx.gob.telecomm.soporte.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mx.gob.telecomm.soporte.dao.SucursalDAO;
import mx.gob.telecomm.soporte.model.Sucursal;

class SucursalDAOTest {

	@Test
	@DisplayName("Prueba lista de SUCURSALES")
	void testGetSucursal() {
		ObservableList<Sucursal> listaSucursales = FXCollections.observableArrayList();
		SucursalDAO sucursal = new SucursalDAO();
		listaSucursales = sucursal.getSucursal("1001");
		for (Sucursal sucursalLista : listaSucursales) {
			System.out.println(sucursalLista.getNombreSucursal());
		}
		//System.out.println("Espero que si llegue algo"+sucursal.getSucursal("1002"));
		assertNotNull(listaSucursales);
		//System.out.println(listaSucursales.toString());
	}

}
