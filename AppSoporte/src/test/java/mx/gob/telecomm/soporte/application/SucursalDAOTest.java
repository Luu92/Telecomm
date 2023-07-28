package mx.gob.telecomm.soporte.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mx.gob.telecomm.soporte.dao.ReporteDAO;
import mx.gob.telecomm.soporte.dao.SucursalDAO;
import mx.gob.telecomm.soporte.model.ReporteSoporte;
import mx.gob.telecomm.soporte.model.Sucursal;

class SucursalDAOTest {

	@Test
	@DisplayName("Prueba lista de SUCURSALES")
	void testGetSucursal() {
		ObservableList<Sucursal> listaSucursales = FXCollections.observableArrayList();
		SucursalDAO sucursal = new SucursalDAO();
		listaSucursales = sucursal.getSucursal("1001");
		assertEquals(7,listaSucursales.size());
		assertNotNull(listaSucursales);
	}
	
	@Test
	@DisplayName("Prueba Unica Sucursal")
	void testGetUnicaSucursal() {
		Sucursal sucursal = new Sucursal();
		SucursalDAO sucursaldb = new SucursalDAO();
		ReporteSoporte reporte = new ReporteSoporte();
		reporte.setRegistro("1008");
		sucursal = sucursaldb.getSucursalUnica(reporte);
		assertEquals("1008", sucursal.getRegistro());
	}

}
