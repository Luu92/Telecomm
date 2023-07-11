package mx.gob.telecomm.soporte.model;

public class Usuario {
	
	private int id;
	private String userName;
	private String password;
	private String rol;
	private int idPersona;
	
	public Usuario(String userName, String password, String rol, int idPersona) {
		this.userName = userName;
		this.password = password;
		this.rol = rol;
		this.idPersona = idPersona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getRol() {
		return rol;
	}

	public int getIdPersona() {
		return idPersona;
	}
	
	

}
