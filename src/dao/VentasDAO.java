package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.Medicamento;
import models.Usuario;
import models.Venta;

public class VentasDAO extends AbstractDAO{
	
	/**
	 * Clase para obtener la fecha de hoy con formato día-mes-año:
	 */
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	
	public int consulta() {
		final String QUERY = "SELECT count(id) ventashoy FROM ventas "+
				"where fecha_venta = '" + dtf.format(LocalDateTime.now()) + "'";
		var ventashoy = 0;
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				ventashoy = rs.getInt("ventashoy");
				return ventashoy;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventashoy;
	}
	
	public void insert(Venta v, Medicamento m) {
		final String INSERT = "INSERT INTO ventas(`fecha_venta`,`medicamento`,`cantidad`) " +
				"VALUES('" + v.getFecha() + "'," + m.getId() + ", "
				+ v.getCantidad() + ");";
		try {
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public double ingresos() {
		final String QUERY = "SELECT v.fecha_venta, sum(m.precio*v.cantidad) ingresos "+
				"FROM ventas v INNER JOIN medicamentos m ON m.id = v.medicamento "
				+ "WHERE v.fecha_venta = '" + dtf.format(LocalDateTime.now()) + "'";
		double ingresos = 0;
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				ingresos = rs.getDouble("ingresos");
				return ingresos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingresos;
	}
}
