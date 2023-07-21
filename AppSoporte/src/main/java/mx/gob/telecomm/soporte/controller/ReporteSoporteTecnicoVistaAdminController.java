package mx.gob.telecomm.soporte.controller;

import java.io.IOException;
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
		cadena = fecha.toString();
		noReporteSoporte.setText("S-" + cadena.substring(2, 4) + cadena.substring(5, 7) + cadena.substring(8, 10)
				+ "/" + cadena.substring(11, 13) + cadena.substring(14, 16) + cadena.substring(17, 19));

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
			}
			else if (status.getValue().equals("CERRADO")) {
				ReporteSoporte nuevoReporte = new ReporteSoporte();
				ReporteDAO reporte = new ReporteDAO();
				/*//System.out.println("FECHA "+fechaApertura.getValue().toString().length();
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
				nuevoReporte.setNotaCierre(fechaApertura.getValue().toString());
				nuevoReporte.setAtiendeCierre("MARINA BISTEK");
				nuevoReporte.setNotaCierre(aperturaNotas.getText());
				reporte.generarReporte(nuevoReporte);*/
				cambiosGuardados();
			} else if (status.getValue().equals("ABIERTO")) {
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
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
	}

	@FXML
    void validarCamaras() {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/views/assets/VistaValidarCamaras"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
	
	@FXML
	public void initialize() {
		agregarDetallesComBox();
	}

}
