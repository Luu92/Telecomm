package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mx.gob.telecomm.soporte.application.App;

public class VistaPerfilAdminController {

	@FXML
	private Button btnReporte;
	

	@FXML
	void generarReporte() {
		try {
			App.setRoot("views/admin/ReporteSoporteTecnicoVistaAdmin");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
