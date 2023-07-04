package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mx.gob.telecomm.soporte.application.App;

public class VistaConsultaReporteSoporteController {
	
	   @FXML
	    private Button btnEditarReporteSoporte;

	    @FXML
	    private Button btn_nue_rep_sop;

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
	    void vistaReporte() {
	    	try {
				App.setRoot("views/VistaReporteSoporte");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

}
