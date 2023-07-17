package mx.gob.telecomm.soporte.model;

public class Sucursal {

	private int id;
	private String region;
	private String entidad;
	private String registro;
	private String nombreSucursal;
	private String estadoSucursal;
	private String tipoComunicacion;
	
	public Sucursal() {}
	
	public Sucursal(String registro,String estado,String sucursal) {
		this.registro = registro;
		this.entidad = estado;
		this.nombreSucursal = sucursal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getEstadoSucursal() {
		return estadoSucursal;
	}

	public void setEstadoSucursal(String estadoSucursal) {
		this.estadoSucursal = estadoSucursal;
	}

	public String getTipoComunicacion() {
		return tipoComunicacion;
	}

	public void setTipoComunicacion(String tipoComunicacion) {
		this.tipoComunicacion = tipoComunicacion;
	}
	
}
