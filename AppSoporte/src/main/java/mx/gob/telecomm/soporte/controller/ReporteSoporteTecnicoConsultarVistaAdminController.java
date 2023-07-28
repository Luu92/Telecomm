package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mx.gob.telecomm.soporte.application.App;
import mx.gob.telecomm.soporte.dao.ReporteDAO;
import mx.gob.telecomm.soporte.model.ReporteSoporte;

public class ReporteSoporteTecnicoConsultarVistaAdminController {

	@FXML
	private Button btnEditarReporteSoporte;

	@FXML
	private Button btnGenerarReporte;

	@FXML
	private Button btnRegresar;

	@FXML
	private TextField noRegistro;

	@FXML
	private TableColumn<ReporteSoporte, String> fechaReporteColumna;

	@FXML
	private TableColumn<ReporteSoporte, String> noReporteColumna;

	@FXML
	private TableColumn<ReporteSoporte, String> statusReporteColumna;

	@FXML
	private TableColumn<ReporteSoporte, String> atiendeReporteColumna;

	@FXML
	private TableView<ReporteSoporte> tablaReportes;

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

	@FXML
	void buscarReportes() {
		ReporteDAO reportedb = new ReporteDAO();
		ObservableList<ReporteSoporte> listaReportes = FXCollections.observableArrayList();
		listaReportes = reportedb.getListaReportes(noRegistro.getText());
		
		if (listaReportes.size() > 0) {
			tablaReportes.setItems(listaReportes);
		} else {
			alertaError();
		}
	}

	public void alertaError() {
		Alert alerta = new Alert(Alert.AlertType.ERROR);
		alerta.setHeaderText(null);
		alerta.setTitle("Error");
		alerta.setContentText("No existe información con ese número de registro");
		alerta.showAndWait();
		noRegistro.clear();
	}
	
	
	@FXML
    void limpiarDetalles() {
		noRegistro.clear();
		tablaReportes.getItems().clear();
    }
	
	@FXML
	public void initialize() {
		noReporteColumna.setCellValueFactory(new PropertyValueFactory<ReporteSoporte,String>("reporte"));
		fechaReporteColumna.setCellValueFactory(new PropertyValueFactory<ReporteSoporte,String>("fechaApertura"));
		statusReporteColumna.setCellValueFactory(new PropertyValueFactory<ReporteSoporte,String>("status"));
		atiendeReporteColumna.setCellValueFactory(new PropertyValueFactory<ReporteSoporte,String>("atiende"));
	}

}
