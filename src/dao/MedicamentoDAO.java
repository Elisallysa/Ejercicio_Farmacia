package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Medicamento;

public class MedicamentoDAO extends AbstractDAO {
	
	public ArrayList<Medicamento> getAll() {
		final String QUERY = "SELECT * FROM medicamentos order by nombre";
		var medicamentos = new ArrayList<Medicamento>();
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var id = rs.getInt("id");
				var nombre = rs.getString("nombre");
				var principio_activo = rs.getString("principio_activo");
				var fecha = rs.getString("fecha");
				var tipo = rs.getString("tipo");
				var cantidad = rs.getInt("cantidad");
				var precio = rs.getDouble("precio");
				Medicamento m = new Medicamento(id, nombre, principio_activo, fecha, tipo, cantidad, precio);
				medicamentos.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medicamentos;
	}

	public void insert(Medicamento m) {
		final String INSERT = "INSERT INTO medicamentos(`nombre`,`principio_activo`,`fecha`,`tipo`, `precio`, `cantidad`) " +
				"VALUES('" + m.getNombre() + "','" + m.getPrincipioActivo() + "', '"
				+ m.getFechaIncorporacion() + "', '" + m.getTipo() + "', " + m.getPrecio() + ","
				+ m.getCantidad() + ");";
		try {
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Medicamento m) {
		final String DELETE = "delete from medicamentos where id = " + m.getId();
		try {
			stmt.executeUpdate(DELETE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Medicamento m) {
		final String UPDATE = "UPDATE medicamentos\r\n" + "SET\r\n" + "nombre = '" + m.getNombre() + "',\r\n"
				+ "principio_activo = '" + m.getPrincipioActivo() + "',\r\n" + "fecha = '" + m.getFechaIncorporacion() + "',\r\n"
				+ "tipo = '" + m.getTipo() + "',\r\n" + "precio = " + m.getPrecio() + ",\r\n"
				+ "cantidad = " + m.getCantidad() + "\r\n"
				+ "WHERE id = " + m.getId() + ";";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addStock(int cantidad, Medicamento m) {
		final String UPDATE = "UPDATE medicamentos\r\n" + "SET\r\n"
				+ "cantidad = cantidad+"+cantidad+ "\r\n"
				+ "WHERE id = " + m.getId() + ";";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void venta(int cantidad, Medicamento m) {
		final String UPDATE = "UPDATE medicamentos\r\n" + "SET\r\n"
				+ "cantidad = cantidad-"+cantidad+ "\r\n"
				+ "WHERE id = " + m.getId() + ";";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
