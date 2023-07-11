package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mx.gob.telecomm.soporte.application.App;

public class ReporteSoporteTecnicoEditarVistaAdminController {

	@FXML
	private Button btnConsultarReportes;

	@FXML
	private Button btnRegresar;

	@FXML
	private Button btnGenerarReporte;

	@FXML
	void btnRegresar() {
		try {
			App.setRoot("views/admin/VistaPerfilAdmin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void consultarReportes() {
		try {
			App.setRoot("views/admin/ReporteSoporteTecnicoConsultarVistaAdmin");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@FXML
	void generarReporteSoporte() {
		try {
			App.setRoot("views/admin/ReporteSoporteTecnicoVistaAdmin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
