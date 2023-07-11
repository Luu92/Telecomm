package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mx.gob.telecomm.soporte.application.App;
import mx.gob.telecomm.soporte.dao.UsuarioDAO;
import mx.gob.telecomm.soporte.model.Usuario;

public class AppController {

	@FXML
	private TextField password;

	@FXML
	private TextField userName;

	@FXML
	private Button btnEnviar;
	
	private Usuario usuario;

	/**
	 * Método para enviar las credenciales introducidas por el usuario. El método se
	 * ejecuta al hacer clic en el botón "Enviar". Verifica si el nombre de usuario
	 * y la contraseña son válidos y realiza una acción en consecuencia.
	 */
	@FXML
	void enviarCredenciales(ActionEvent event) {
		if(userName.getText().isEmpty() || password.getText().isEmpty()) {
			alertaError();
		}
		else {
			UsuarioDAO user = new UsuarioDAO();
			usuario = user.getUsuario(userName.getText().toUpperCase(), password.getText());
			if(usuario == null) {
					alertaErrorCredenciales();			
			}
			else
			{
				if(usuario.getRol().equals("ADMIN")) {
					try {
						App.setRoot("views/admin/VistaPerfilAdmin");
					} catch (IOException e) {
						System.err.println(String.format("Error al cargar ventana: %s",e.getMessage()));
					}
				}
				else {
					try {
						App.setRoot("views/tecnico/VistaPerfilTecnico");
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void alertaError() {
		Alert alerta = new Alert(Alert.AlertType.ERROR);
		alerta.setHeaderText(null);
		alerta.setTitle("Error");
		alerta.setContentText("Usuario o Contraseña no pueden ser vacíos");
		alerta.showAndWait();
		userName.clear();
		password.clear();
	}
	
	public void alertaErrorCredenciales() {
		Alert alerta = new Alert(Alert.AlertType.WARNING);
		alerta.setHeaderText(null);
		alerta.setTitle("Info");
		alerta.setContentText("Usuario o Contraseña Incorrectos");
		alerta.showAndWait();
	}
	

}
