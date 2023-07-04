package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mx.gob.telecomm.soporte.application.App;

public class VistaSoporteController {
	
	@FXML
    private Button btnConsRepSop;
	

	@FXML
	void btnRegresar() {
		try {
			App.setRoot("views/VistaPerfilTecnico");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void editarReporteSoporte() {

		try {
			App.setRoot("views/VistaEditarReporteSoporte");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
    void consultarReportesSoporte() {
		try {
			App.setRoot("views/VistaConsultaReportesSoporte");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
