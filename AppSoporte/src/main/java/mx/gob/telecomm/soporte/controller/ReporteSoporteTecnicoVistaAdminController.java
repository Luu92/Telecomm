package mx.gob.telecomm.soporte.controller;

import java.awt.Color;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import mx.gob.telecomm.soporte.application.App;
import mx.gob.telecomm.soporte.dao.SucursalDAO;
import mx.gob.telecomm.soporte.model.Sucursal;

public class ReporteSoporteTecnicoVistaAdminController {

	@FXML
	private Button btnBuscar;

	@FXML
	private Button btnConsRepSop;

	@FXML
	private Label nombrePersonal;

	@FXML
	private JFXComboBox<String> elemento;

	@FXML
	private Label estadoRepublica;

	@FXML
	private DatePicker fechaApertura;

	@FXML
	private JFXComboBox<String> listarSucursales;

	@FXML
	private JFXComboBox<String> status;

	@FXML
	private TextField noRegistro;
	
	@FXML
    private Label noReporteSoporte;

	@FXML
	private Label sucursal;

	@FXML
	private JFXComboBox<String> tipoReporte;

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

	public void agregarDetallesComBox() {
		ObservableList<String> tipo = FXCollections.observableArrayList();
		tipo.addAll("SOPORTE", "INSTALACIÓN", "GERENCIA", "REUBICACIÓN", "CHECKLIST", "DAÑO", "RETIRO");
		tipoReporte.setItems(tipo);

		ObservableList<String> elementoTipo = FXCollections.observableArrayList();
		elementoTipo.addAll("CÁMARA", "DVR", "ALARMA", "POE", "NAS", "BATERIA", "QNAP", "TARJETA RED");
		elemento.setItems(elementoTipo);

		ObservableList<String> statusReporte = FXCollections.observableArrayList();
		statusReporte.addAll("ABIERTO", "CERRADO");
		status.setItems(statusReporte);

		// Se asigna valor por cada cambio que se realiza en las cajas de opciones
		tipoReporte.setOnAction(e -> tipoReporte.setValue(tipoReporte.getValue()));

		fechaApertura.setValue(LocalDate.now());
		fechaApertura.setEditable(false);

	}

	@FXML
	void buscarRegistro() {
		SucursalDAO sucursales = new SucursalDAO();
		ObservableList<Sucursal> listaSucursales = FXCollections.observableArrayList();
		ObservableList<String> listaCom = FXCollections.observableArrayList();
		listaSucursales = sucursales.getSucursal(noRegistro.getText());
		Timestamp fecha = new Timestamp(System.currentTimeMillis());
		System.out.println(fecha);
		String cadena = fecha.toString();
		noReporteSoporte.setText("S-"+cadena.substring(2,4)+cadena.substring(5,7)+cadena.substring(8,10)+" / "+cadena.substring(11,13)+cadena.substring(14,16)+cadena.substring(17,19));
		
		if (listaSucursales.size() == 0) {
			alertaError();
		} else {
			estadoRepublica.setText(listaSucursales.get(0).getEntidad());

			for (Sucursal sucursal : listaSucursales) {
				listaCom.addAll(sucursal.getNombreSucursal());
			}
			listarSucursales.setItems(listaCom);
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
	public void initialize() {
		agregarDetallesComBox();
	}

}
