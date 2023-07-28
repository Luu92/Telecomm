package mx.gob.telecomm.soporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mx.gob.telecomm.soporte.conexiondb.ConexionPostgres;
import mx.gob.telecomm.soporte.interfaces.ConexionDB;
import mx.gob.telecomm.soporte.model.ReporteSoporte;

public class ReporteDAO {

	private static String SQL_INSERT = null;
	private static String SQL_UPDATE = null;
	private static String SQL_SELECT = null;

	int resultado, actualizados;

	public void generarReporte(ReporteSoporte nuevoReporte) {
		Connection conn = null;
		ConexionDB conPostgres = null;
		PreparedStatement stmt = null;
		resultado = 0;
		try {
			conPostgres = new ConexionPostgres();
			conn = conPostgres.getConnection();
			SQL_INSERT = "INSERT INTO REPORTE_SOPORTE(REPORTE, TIPO, ELEMENTO, REGISTRO, NOMBRE_TECNICO, ATIENDE, STATUS, FECHA_APERTURA, FECHA_REVISION, NOTA_APERTURA, FECHA_CIERRE, ATIENDE_CIERRE, NOTA_CIERRE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, nuevoReporte.getReporte());
			stmt.setString(2, nuevoReporte.getTipo());
			stmt.setString(3, nuevoReporte.getElemento());
			stmt.setString(4, nuevoReporte.getRegistro());
			stmt.setString(5, nuevoReporte.getNombreTecnico());
			stmt.setString(6, nuevoReporte.getAtiende());
			stmt.setString(7, nuevoReporte.getStatus());
			stmt.setString(8, nuevoReporte.getFechaApertura());
			stmt.setString(9, nuevoReporte.getFechaRevision());
			stmt.setString(10, nuevoReporte.getNotaApertura());
			stmt.setString(11, nuevoReporte.getFechaCierre());
			stmt.setString(12, nuevoReporte.getAtiendeCierre());
			stmt.setString(13, nuevoReporte.getNotaCierre());
			resultado = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conPostgres.close(stmt);
				conPostgres.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void editarReporte(String reporte, ReporteSoporte actualizarReporte) {
		Connection conn = null;
		ConexionDB conPostgres = null;
		PreparedStatement stmt = null;

		actualizados = 0;
		try {
			conPostgres = new ConexionPostgres();
			conn = conPostgres.getConnection();
			SQL_UPDATE = "UPDATE REPORTE_SOPORTE SET STATUS = 'CERRADO', FECHA_CIERRE = ?, ATIENDE_CIERRE = ?, NOTA_CIERRE = ? WHERE  REPORTE = "
					+ "'" + reporte + "'";
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, actualizarReporte.getFechaCierre());
			stmt.setString(2, actualizarReporte.getAtiendeCierre());
			stmt.setString(3, actualizarReporte.getNotaCierre());
			actualizados = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conPostgres.close(stmt);
				conPostgres.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public ReporteSoporte getReporteSoporte(String numeroReporte) {
		Connection conn = null;
		ConexionDB conPostgres = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ReporteSoporte reporteSoporte = null;
		try {
			conPostgres = new ConexionPostgres();
			conn = conPostgres.getConnection();
			SQL_SELECT = "SELECT * FROM REPORTE_SOPORTE WHERE REPORTE = " + "'" + numeroReporte + "'";
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String reporteDB = rs.getString("REPORTE");
				String tipo = rs.getString("TIPO");
				String elemento = rs.getString("ELEMENTO");
				String registro = rs.getString("REGISTRO");
				String nombreTecnico = rs.getString("NOMBRE_TECNICO");
				String atiende = rs.getString("ATIENDE");
				String status = rs.getString("STATUS");
				String fechaApertura = rs.getString("FECHA_APERTURA");
				String fechaRevision = rs.getString("FECHA_REVISION");
				String notaApertura = rs.getString("NOTA_APERTURA");
				String fechaCierre = rs.getString("FECHA_CIERRE");
				String atiendeCierre = rs.getString("ATIENDE_CIERRE");
				String notaCierre = rs.getString("NOTA_CIERRE");
				reporteSoporte = new ReporteSoporte();
				reporteSoporte.setId(id);
				reporteSoporte.setReporte(reporteDB);
				reporteSoporte.setTipo(tipo);
				reporteSoporte.setElemento(elemento);
				reporteSoporte.setRegistro(registro);
				reporteSoporte.setNombreTecnico(nombreTecnico);
				reporteSoporte.setAtiende(atiende);
				reporteSoporte.setStatus(status);
				reporteSoporte.setFechaApertura(fechaApertura);
				reporteSoporte.setFechaRevision(fechaRevision);
				reporteSoporte.setNotaApertura(notaApertura);
				reporteSoporte.setFechaCierre(fechaCierre);
				reporteSoporte.setAtiendeCierre(atiendeCierre);
				reporteSoporte.setNotaCierre(notaCierre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conPostgres.close(rs);
				conPostgres.close(stmt);
				conPostgres.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return reporteSoporte;
	}

	public ObservableList<ReporteSoporte> getListaReportes(String noRegistro) {
		Connection conn = null;
		ConexionDB conPostgres = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ReporteSoporte reporteSoporte = null;
		ObservableList<ReporteSoporte> listaReportes = FXCollections.observableArrayList();
		try {
			conPostgres = new ConexionPostgres();
			conn = conPostgres.getConnection();
			SQL_SELECT = "SELECT * FROM REPORTE_SOPORTE WHERE REGISTRO = " + "'" + noRegistro + "'";
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String reporteDB = rs.getString("REPORTE");
				String tipo = rs.getString("TIPO");
				String elemento = rs.getString("ELEMENTO");
				String registro = rs.getString("REGISTRO");
				String nombreTecnico = rs.getString("NOMBRE_TECNICO");
				String atiende = rs.getString("ATIENDE");
				String status = rs.getString("STATUS");
				String fechaApertura = rs.getString("FECHA_APERTURA");
				String fechaRevision = rs.getString("FECHA_REVISION");
				String notaApertura = rs.getString("NOTA_APERTURA");
				String fechaCierre = rs.getString("FECHA_CIERRE");
				String atiendeCierre = rs.getString("ATIENDE_CIERRE");
				String notaCierre = rs.getString("NOTA_CIERRE");
				reporteSoporte = new ReporteSoporte();
				reporteSoporte.setId(id);
				reporteSoporte.setReporte(reporteDB);
				reporteSoporte.setTipo(tipo);
				reporteSoporte.setElemento(elemento);
				reporteSoporte.setRegistro(registro);
				reporteSoporte.setNombreTecnico(nombreTecnico);
				reporteSoporte.setAtiende(atiende);
				reporteSoporte.setStatus(status);
				reporteSoporte.setFechaApertura(fechaApertura);
				reporteSoporte.setFechaRevision(fechaRevision);
				reporteSoporte.setNotaApertura(notaApertura);
				reporteSoporte.setFechaCierre(fechaCierre);
				reporteSoporte.setAtiendeCierre(atiendeCierre);
				reporteSoporte.setNotaCierre(notaCierre);
				listaReportes.add(reporteSoporte);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conPostgres.close(rs);
				conPostgres.close(stmt);
				conPostgres.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaReportes;
	}

}
