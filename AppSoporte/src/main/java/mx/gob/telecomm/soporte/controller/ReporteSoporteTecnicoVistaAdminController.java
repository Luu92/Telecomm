package mx.gob.telecomm.soporte.controller;

import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mx.gob.telecomm.soporte.application.App;
import mx.gob.telecomm.soporte.dao.ReporteDAO;
import mx.gob.telecomm.soporte.dao.SucursalDAO;
import mx.gob.telecomm.soporte.model.ReporteSoporte;
import mx.gob.telecomm.soporte.model.Sucursal;

public class ReporteSoporteTecnicoVistaAdminController {

	@FXML
	private JFXTextArea aperturaNotas;

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
	private TextField nombreTecnico;

	@FXML
	private Label sucursal;

	@FXML
	private JFXComboBox<String> tipoReporte;

	@FXML
	private JFXButton validarCamaras;

	private String cadena;

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
		tipo.addAll("CHECKLIST", "DAÑO", "INSTALACIÓN", "MANTENIMIENTO",   "REUBICACIÓN",  "RETIRO", "SOPORTE");
		tipoReporte.setItems(tipo);

		ObservableList<String> elementoTipo = FXCollections.observableArrayList();
		elementoTipo.addAll("ALARMA", "BATERIA", "CÁMARA", "DVR", "NAS", "POE", "QNAP", "TARJETA RED");
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
		
		if(tipoReporte.getValue().equals("CHECKLIST")) {
			cadena = "CK-" + getNoReporte(getAleatorio().toString());
			noReporteSoporte.setText(cadena);
		}
		else if(tipoReporte.getValue().equals("DAÑO")) {
			cadena = "DO-" + getNoReporte(getAleatorio().toString());
			noReporteSoporte.setText(cadena);
		}
		else if(tipoReporte.getValue().equals("INSTALACIÓN")) {
			cadena = "IT-" + getNoReporte(getAleatorio().toString());
			noReporteSoporte.setText(cadena);
		}
		else if(tipoReporte.getValue().equals("MANTENIMIENTO")) {
			cadena = "MT-" + getNoReporte(getAleatorio().toString());
			noReporteSoporte.setText(cadena);
		}
		else if(tipoReporte.getValue().equals("REUBICACIÓN")) {
			cadena = "RB-" + getNoReporte(getAleatorio().toString());
			noReporteSoporte.setText(cadena);
		}
		else if(tipoReporte.getValue().equals("RETIRO")) {
			cadena = "RG-" + getNoReporte(getAleatorio().toString());
			noReporteSoporte.setText(cadena);
		}
		else {
			cadena = "ST-" + getNoReporte(getAleatorio().toString());
			noReporteSoporte.setText(cadena);
		}
		
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

	@FXML
	void guardarReporte() {
		try {
			if (status.getValue() == null || noRegistro.getText().equals("")) {
				errorCamposVacios();
			} else if (status.getValue().equals("CERRADO")) {
				ReporteSoporte nuevoReporte = new ReporteSoporte();
				ReporteDAO reporte = new ReporteDAO();
				nuevoReporte.setReporte(noReporteSoporte.getText());
				nuevoReporte.setTipo(tipoReporte.getValue());
				nuevoReporte.setElemento(elemento.getValue());
				nuevoReporte.setRegistro(noRegistro.getText());
				nuevoReporte.setNombreTecnico(nombreTecnico.getText());
				nuevoReporte.setAtiende("MARINA BISTEK");
				nuevoReporte.setStatus(status.getValue());
				nuevoReporte.setFechaApertura(fechaApertura.getValue().toString());
				nuevoReporte.setFechaRevision(fechaApertura.getValue().toString());
				nuevoReporte.setNotaApertura(aperturaNotas.getText());
				nuevoReporte.setFechaCierre(fechaApertura.getValue().toString());
				nuevoReporte.setAtiendeCierre("MARINA BISTEK");
				nuevoReporte.setNotaCierre(aperturaNotas.getText());
				reporte.generarReporte(nuevoReporte);
				cambiosGuardados();
			} else if (status.getValue().equals("ABIERTO")) {
				ReporteSoporte nuevoReporte = new ReporteSoporte();
				ReporteDAO reporte = new ReporteDAO();

				nuevoReporte.setReporte(noReporteSoporte.getText());
				nuevoReporte.setTipo(tipoReporte.getValue());
				nuevoReporte.setElemento(elemento.getValue());
				nuevoReporte.setRegistro(noRegistro.getText());
				nuevoReporte.setNombreTecnico(nombreTecnico.getText());
				nuevoReporte.setAtiende("MARINA BISTEK");// agregar persona que atiende
				nuevoReporte.setStatus(status.getValue());
				nuevoReporte.setFechaApertura(fechaApertura.getValue().toString());
				nuevoReporte.setFechaRevision(fechaApertura.getValue().toString());
				nuevoReporte.setNotaApertura(aperturaNotas.getText().toUpperCase());
				nuevoReporte.setFechaCierre(null);
				nuevoReporte.setAtiendeCierre(null);
				nuevoReporte.setNotaCierre(null);
				reporte.generarReporte(nuevoReporte);
				cambiosGuardados();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public Integer getAleatorio() {
		int numero = (int) (Math.random() * 9999 + 1);
		return numero;
	}

	public String getNoReporte(String largoRandom) {
		String noReporte = "";
		switch (largoRandom.length()) {
		case 1:
			noReporte = "000"+largoRandom.toString();
		break;

		case 2:
			noReporte = "00"+largoRandom.toString();
		break;
		
		case 3:
			noReporte = "0"+largoRandom.toString();
		break;
		case 4:
			noReporte = largoRandom.toString();
		break;
		default:
			noReporte = "error al generar folio";
		break;
		}
		return noReporte;
	}

	public void alertaError() {
		Alert alerta = new Alert(Alert.AlertType.ERROR);
		alerta.setHeaderText(null);
		alerta.setTitle("Error");
		alerta.setContentText("No existe información con ese número de registro");
		alerta.showAndWait();
		noRegistro.clear();
	}

	public void errorCamposVacios() {
		Alert alerta = new Alert(Alert.AlertType.WARNING);
		alerta.setHeaderText(null);
		alerta.setTitle("Campos Vacíos");
		alerta.setContentText("Campos * son obligatorios");
		alerta.showAndWait();
		noRegistro.clear();
	}

	public void cambiosGuardados() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText(null);
		alerta.setTitle("Excelente");
		alerta.setContentText("Tus cambios han sido guardados");
		alerta.showAndWait();
		status.setValue(null);
		tipoReporte.setValue(null);
		elemento.setValue(null);
		noRegistro.clear();
		estadoRepublica.setText("Estado de la Republica");
		listarSucursales.getItems().removeAll(listarSucursales.getItems());
		aperturaNotas.clear();
		nombreTecnico.clear();
	}

	@FXML
	void validarCamaras() {
		try {
			App.setRoot("views/assets/VistaValidarCamaras");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void initialize() {
		agregarDetallesComBox();
	}

}
