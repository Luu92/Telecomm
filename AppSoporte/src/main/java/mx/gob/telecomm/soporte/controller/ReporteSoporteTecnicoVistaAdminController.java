package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mx.gob.telecomm.soporte.application.App;

public class ReporteSoporteTecnicoVistaAdminController {
	
	@FXML
    private Button btnConsRepSop;
	
	@FXML
	private Label nombrePersonal;

	

	@FXML
	void btnRegresar() {
		try {
			App.setRoot("views/admin/VistaPerfilAdmin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void editarReporteSoporte() {

		try {
			App.setRoot("views/admin/ReporteSoporteTecnicoEditarVistaAdmin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
    void consultarReportesSoporte() {
		try {
			App.setRoot("views/admin/ReporteSoporteTecnicoConsultarVistaAdmin");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public Label getNombrePersonal() {
		return nombrePersonal;
	}

	public void setNombrePersonal(Label nombrePersonal) {
		this.nombrePersonal = nombrePersonal;
	}
	
	
}
