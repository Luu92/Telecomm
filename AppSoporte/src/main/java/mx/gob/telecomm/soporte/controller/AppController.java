package mx.gob.telecomm.soporte.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mx.gob.telecomm.soporte.application.App;

public class AppController {

	@FXML
	private TextField password;

	@FXML
	private TextField userName;

	@FXML
	private Button btnEnviar;
	
	@FXML 
	private AnchorPane ap;

	/**
	 * Método para enviar las credenciales introducidas por el usuario. El método se
	 * ejecuta al hacer clic en el botón "Enviar". Verifica si el nombre de usuario
	 * y la contraseña son válidos y realiza una acción en consecuencia.
	 */
	@FXML
	void enviarCredenciales() {
		btnEnviar.setOnAction(e -> {
			if (userName.getText().equals("tecnico") && password.getText().equals("123")) {
				try {
					App.setRoot("views/tecnico/VistaPerfilTecnico");
				} catch (IOException e1) {
					System.out.println(e1.getMessage().toString());
				}
			}
			else if(userName.getText().equals("admin") && password.getText().equals("123")){
				try {
					App.setRoot("views/admin/VistaPerfilAdmin");
				} catch (IOException e1) {
					System.out.println(e1.getMessage().toString());
				}
			}
			else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setHeaderText(null);
				alerta.setTitle("Info");
				alerta.setContentText("Usuario o Contraseña Incorrectos");
				alerta.showAndWait();
			}
		});
	}

}
