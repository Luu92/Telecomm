package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mx.gob.telecomm.soporte.application.App;

public class ReporteSoporteTecnicoConsultarVistaAdminController {
	
	  @FXML
	    private Button btnEditarReporteSoporte;

	    @FXML
	    private Button btnGenerarReporte;

	    @FXML
	    private Button btnRegresar;

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
	    void generarReporteSoporte() {
	    	try {
				App.setRoot("views/admin/ReporteSoporteTecnicoVistaAdmin");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

}
