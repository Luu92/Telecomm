package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mx.gob.telecomm.soporte.application.App;

public class VistaPerfilTecnicoController {

	@FXML
    private Button btnReporte;

    @FXML
    void generarReporte() {
    		try {
				App.setRoot("views/VistaReporteSoporte");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
    
    
    

		
	
}
