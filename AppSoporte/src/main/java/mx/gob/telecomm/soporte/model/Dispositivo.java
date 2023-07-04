package mx.gob.telecomm.soporte.model;

public class Dispositivo {

	private int id;
	private String nombre;
	private String modelo;
	private String ipDireccion;
	private String statusEquipo;
	private String noSerie;
	private String noInventario;
	private String statusSisAlmacenamiento;
	private String modeloAlmacenamiento;
	private String noSerieAlmacenamiento;
	private String noInvAlmac;
	private String observaciones;
	
	public Dispositivo(int id, String nombre, String modelo){
		this.id = id;
		this.nombre = nombre;
		this.modelo = modelo;
	}
	
	public Dispositivo(int id, String nombre, String modelo, String ipDireccion, String statusEquipo, String noSerie,
			String noInventario, String statusSisAlmacenamiento, String modeloAlmacenamiento,
			String noSerieAlmacenamiento, String noInvAlmac, String observaciones) {
		this.id = id;
		this.nombre = nombre;
		this.modelo = modelo;
		this.ipDireccion = ipDireccion;
		this.statusEquipo = statusEquipo;
		this.noSerie = noSerie;
		this.noInventario = noInventario;
		this.statusSisAlmacenamiento = statusSisAlmacenamiento;
		this.modeloAlmacenamiento = modeloAlmacenamiento;
		this.noSerieAlmacenamiento = noSerieAlmacenamiento;
		this.noInvAlmac = noInvAlmac;
		this.observaciones = observaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id > 0)
			this.id = id;
		else 
			System.out.println("Error de caracteres");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getIpDireccion() {
		return ipDireccion;
	}

	public String getStatusEquipo() {
		return statusEquipo;
	}

	public String getNoSerie() {
		return noSerie;
	}

	public String getNoInventario() {
		return noInventario;
	}

	public String getStatusSisAlmacenamiento() {
		return statusSisAlmacenamiento;
	}

	public String getModeloAlmacenamiento() {
		return modeloAlmacenamiento;
	}

	public String getNoSerieAlmacenamiento() {
		return noSerieAlmacenamiento;
	}

	public String getNoInvAlmac() {
		return noInvAlmac;
	}

	public String getObservaciones() {
		return observaciones;
	}

	@Override
	public String toString() {
		return "==== Dispositivo ====\n"
				+ "Id=" + id 
				+ "\nNombre=" + nombre 
				+ "\nModelo=" + modelo 
				+ "\nIp Direccion=" + ipDireccion
				+ "\nStatus Equipo=" + statusEquipo 
				+ "\nNo Serie=" + noSerie 
				+ "\nNo Inventario=" + noInventario
				+ "\nStatus Sis Almacenamiento=" + statusSisAlmacenamiento 
				+ "\nModelo Almacenamiento=" + modeloAlmacenamiento 
				+ "\nNo Serie Almacenamiento=" + noSerieAlmacenamiento 
				+ "\nNo Inv Almac=" + noInvAlmac 
				+ "\nObservaciones=" + observaciones;
	}
	
	
	
	
}
