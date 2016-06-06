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
		String sql = "INSERT INTO corrida (piloto, tempVolt, velocidV, volta) VALUES (?,?,?,?)";
		java.sql.PreparedStatement stmt = con.prepareStatement(sql);
		
		try {
			stmt.setString(1, registro.getPiloto());
            stmt.setInt(2, (int) registro.getTempcurva());
            stmt.setInt(3, (int) registro.getVelocidaC());
            stmt.setInt(4, (int) registro.getVolta());
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
	public List<DadosCorrida> lista() {
		String sql = "SELECT * FROM corrida";
		List<DadosCorrida> lista = new ArrayList<DadosCorrida>();
		try {
		PreparedStatement stmt = con.prepareStatement(sql);
	    ResultSet res = stmt.executeQuery();
	    
			while(res.next()){
				DadosCorrida v = new DadosCorrida();
				v.setPiloto(res.getString("piloto"));
				v.setTempcurva(res.getInt("tempVolt"));
				v.setVelocidaC(res.getInt("velocidV"));
				v.setVolta(res.getInt("volta"));		
				lista.add(v);
			}
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			}
		return lista;
		}
	
	public List<DadosCorrida> lista1() {
		String sql = "SELECT * FROM colocacao";
		List<DadosCorrida> lista1 = new ArrayList<DadosCorrida>();
		try {
		PreparedStatement stmt = con.prepareStatement(sql);
	    ResultSet res = stmt.executeQuery();
	    
			while(res.next()){
				DadosCorrida v = new DadosCorrida();
				v.setMensagem(res.getString("mensagem"));
				
						
				lista1.add(v);
			}
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			}
		return lista1;
		}
	
	public void excluir() throws RuntimeException, SQLException {
		String sql = "delete from corrida";
	
		java.sql.PreparedStatement stmt = con.prepareStatement(sql);
	
		
		try {
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
			
		}
	}
	public void excluir2() throws RuntimeException, SQLException {
		
		String sql1 = "delete from colocacao";
	
		java.sql.PreparedStatement stm = con.prepareStatement(sql1);
		
		try {
			
		
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			
			stm.close();
		}
	}
	
}

	