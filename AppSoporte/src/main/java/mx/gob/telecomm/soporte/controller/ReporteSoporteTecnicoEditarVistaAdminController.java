package mx.gob.telecomm.soporte.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.jfoenix.controls.JFXTextArea;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mx.gob.telecomm.soporte.application.App;
import mx.gob.telecomm.soporte.dao.ReporteDAO;
import mx.gob.telecomm.soporte.dao.SucursalDAO;
import mx.gob.telecomm.soporte.model.ReporteSoporte;
import mx.gob.telecomm.soporte.model.Sucursal;

public class ReporteSoporteTecnicoEditarVistaAdminController {

	@FXML
	private Label atiende;
	
	@FXML
    private Button btnGuardarReporte;

	@FXML
	private Button btnConsultarReportes;

	@FXML
	private Button btnGenerarReporte;

	@FXML
	private Button btnRegresar;

	@FXML
	private Label estadoRepublica;

	@FXML
	private DatePicker fechaCierre;

	@FXML
	private TextField noReporte;

	@FXML
	private TextField nombreTecnico;

	@FXML
	private JFXTextArea notasCierre;

	@FXML
	private Label notasReporte;

	@FXML
	private Label status;

	@FXML
	private Label sucursal;

	@FXML
	private Label tipoReporte;

	private ReporteSoporte reporte = null;
	private ReporteDAO reportedb = null;

	@FXML
	void btnRegresar() {
		try {
			App.setRoot("views/admin/VistaPerfilAdmin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void buscarReporte() {
		try {
			reporte = new ReporteSoporte();
			reportedb = new ReporteDAO();
			reporte = reportedb.getReporteSoporte(noReporte.getText().toUpperCase());
			if (reporte != null) {
				agregarDetalles(reporte);
			} else {
				alertaError();
			}
		} catch (Exception e) {
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

	@FXML
	void guardarReporte() {
		ReporteSoporte reporte = new ReporteSoporte();
		ReporteDAO reportedb = new ReporteDAO();
		reporte.setFechaCierre(fechaCierre.getValue().toString());
		reporte.setNotaCierre(notasCierre.getText().toUpperCase());
		reporte.setAtiendeCierre(nombreTecnico.getText().toUpperCase());
		reportedb.editarReporte(noReporte.getText().toUpperCase(), reporte);
		cambiosGuardados();
	}

	public void agregarDetalles(ReporteSoporte reporte) {
		Sucursal sucursal = new Sucursal();
		SucursalDAO sucursaldb = new SucursalDAO();
		sucursal = sucursaldb.getSucursalUnica(reporte);
		atiende.setText(reporte.getAtiende());
		notasReporte.setText(reporte.getNotaApertura());
		estadoRepublica.setText(sucursal.getEntidad());
		this.sucursal.setText(sucursal.getNombreSucursal());
		status.setText(reporte.getStatus());
		tipoReporte.setText(reporte.getTipo());
		btnGuardarReporte.setDisable(false);
	}

	public void alertaError() {
		Alert alerta = new Alert(Alert.AlertType.ERROR);
		alerta.setHeaderText(null);
		alerta.setTitle("Error");
		alerta.setContentText("No existe información con ese número de registro");
		alerta.showAndWait();
		btnGuardarReporte.setDisable(true);
		noReporte.clear();
	}
	
	public void cambiosGuardados() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText(null);
		alerta.setTitle("Excelente");
		alerta.setContentText("Tus cambios han sido guardados");
		alerta.showAndWait();
		atiende.setText("Nombre del Personal de Apertura");
		notasReporte.setText("Notas de Apertura");
		estadoRepublica.setText("Estado de la República");
		sucursal.setText("Nombre Sucursal");
		status.setText("Abierto/Cerrado");
		tipoReporte.setText("Tipo Reporte");
		notasCierre.clear();
		nombreTecnico.clear();
		noReporte.clear();
		btnGuardarReporte.setDisable(true);
	}
	
	@FXML
	public void initialize() {
		fechaCierre.setValue(LocalDate.now());
		btnGuardarReporte.setDisable(true);	
	}
}
