package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Usuario;

public class UsuarioDAO extends AbstractDAO {
	
	public boolean login(Usuario usuario) {
		final String QUERY = "SELECT id FROM usuarios "+
							"where pin = '" + usuario.getPin()+ "'";
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
