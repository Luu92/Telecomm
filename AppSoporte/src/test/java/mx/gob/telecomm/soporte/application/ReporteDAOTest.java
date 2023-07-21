package mx.gob.telecomm.soporte.application;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mx.gob.telecomm.soporte.dao.ReporteDAO;
import mx.gob.telecomm.soporte.model.ReporteSoporte;

class ReporteDAOTest {

	ReporteDAO nuevoReporte;
	ReporteSoporte reporte;
	
/*
	@Test
	@DisplayName("Prueba generarReporteSoporte")
	void testGenerarReporte() {
		nuevoReporte = new ReporteDAO();
		reporte = new ReporteSoporte();
		reporte.setId(130);
		reporte.setReporte("S-230718 / 121615");
		reporte.setTipo("Checklist");
		reporte.setElemento("Cámara");
		reporte.setRegistro("1001");
		reporte.setNombreTecnico("Marina Bistek");
		reporte.setAtiende("Fernando Ramirez");
		reporte.setStatus("CERRADO");
		reporte.setFechaApertura("2023-15-12");
		reporte.setFechaRevision("2023-15-12");
		reporte.setNotaApertura("Se retita camara xxxxxxx xxxxxx xxxx xxxxx x x xx ");
		reporte.setFechaCierre("2023-15-xx");
		reporte.setAtiendeCierre("Fernando Ramirez");
		reporte.setNotaCierre("xxx xxxx xxx xxxxx xxxx xxx xx xx xxxxxxxxx");
		nuevoReporte.generarReporte(reporte);
		assertNotNull(reporte);
	}
*/
	
	@Test
	@DisplayName("Prueba GetReporteSoporte")
	void testGetReporteSoporte() {
		nuevoReporte = new ReporteDAO();
		reporte = new ReporteSoporte();
		reporte = nuevoReporte.getReporteSoporte("51392");
		assertEquals("51392", reporte.getReporte());
	}
	
	
	@Test
	@DisplayName("Pueba TestEditarReporte")
	public void editarReporete() {
		nuevoReporte = new ReporteDAO();
		reporte = new ReporteSoporte();
		reporte = nuevoReporte.getReporteSoporte("50495");
		reporte.setFechaCierre("xxxx-xx-xx");
		reporte.setAtiendeCierre("XXXXXXXXXXXXXX");
		reporte.setNotaCierre("XXXXXXXXXXXXXXXXX");
		nuevoReporte.editarReporte("50495", reporte);
		
		reporte = nuevoReporte.getReporteSoporte("50495");
		assertEquals("XXXXXXXXXXXXXXXXX",reporte.getNotaCierre());

	}

}
