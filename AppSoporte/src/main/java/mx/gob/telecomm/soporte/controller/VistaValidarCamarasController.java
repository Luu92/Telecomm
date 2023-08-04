package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import mx.gob.telecomm.soporte.application.App;

public class VistaValidarCamarasController {

	@FXML
	void regresarPrincipal() {
		try {
			App.setRoot("views/admin/ReporteSoporteTecnicoVistaAdmin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
