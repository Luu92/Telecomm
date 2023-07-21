package mx.gob.telecomm.soporte.model;

public class ReporteSoporte {
	
	private int id;
	private String reporte;
	private String tipo;
	private String elemento; 
	private String registro;
	private String nombreTecnico;
	private String atiende;
	private String status;
	private String fechaApertura; 
	private String fechaRevision; 
	private String notaApertura; 
	private String fechaCierre;
	private String atiendeCierre;
	private String notaCierre;
	
	public ReporteSoporte() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNombreTecnico() {
		return nombreTecnico;
	}

	public void setNombreTecnico(String nombreTecnico) {
		this.nombreTecnico = nombreTecnico;
	}

	public String getAtiende() {
		return atiende;
	}

	public void setAtiende(String atiende) {
		this.atiende = atiende;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(String fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public String getNotaApertura() {
		return notaApertura;
	}

	public void setNotaApertura(String notaApertura) {
		this.notaApertura = notaApertura;
	}

	public String getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getAtiendeCierre() {
		return atiendeCierre;
	}

	public void setAtiendeCierre(String atiendeCierre) {
		this.atiendeCierre = atiendeCierre;
	}

	public String getNotaCierre() {
		return notaCierre;
	}

	public void setNotaCierre(String notaCierre) {
		this.notaCierre = notaCierre;
	}
	
}
