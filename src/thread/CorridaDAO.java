package thread;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import thread.DadosCorrida;
import autentica.ConnectionFactory;
import autentica.Usuario;

public class CorridaDAO {
	private Connection con;

	public CorridaDAO() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}
	
	@Override
	public void finalize() throws SQLException {

		con.close();
	}
	public void incluir(DadosCorrida registro) throws RuntimeException, SQLException {
		String sql = "INSERT INTO corrida (piloto, tempVolt, velocidV) VALUES (?,?,?)";
		java.sql.PreparedStatement stmt = con.prepareStatement(sql);
		
		try {
			stmt.setString(1, registro.getPiloto());
            stmt.setInt(2, (int) registro.getTempcurva());
            stmt.setInt(3, (int) registro.getVelocidaC());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}
	
	public void incluir2(DadosCorrida registro) throws RuntimeException, SQLException {
		String sql1 = "INSERT INTO colocacao (mensagem) VALUES (?)";
		java.sql.PreparedStatement stmt = con.prepareStatement(sql1);
		
		try {
			stmt.setString(1, registro.getMensagem());
           
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}
	
	
}

	