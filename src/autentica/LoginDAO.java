package autentica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import autentica.Usuario;
import metodosSQL.Carros;
import thread.DadosCorrida;;

public class LoginDAO {
	private Connection con;

	public LoginDAO() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}
	
	@Override
	public void finalize() throws SQLException {

		con.close();
	}
	
	// Pesquisar usuario
	public Usuario validaLogin(String usuario) {
		String sql = "SELECT * FROM usuario WHERE nome='" + usuario + "';";

		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usu = new Usuario();
				
				usu.setNome(rs.getString("nome"));
				usu.setSenha(rs.getString("senha"));
				
				usuarios.add(usu);

				return usu;
			}
		//	rs.close();
		//	stmt.close();

		} catch (SQLException e) {
			System.out.println("Usu�rio \"" + usuario + "\" n�o encontrado!");
			throw new RuntimeException(e);
		}

		return null;
	}
	public void incluir(Usuario usu) throws RuntimeException, SQLException {
		String sql = "INSERT INTO USUARIO (ID, NOME, SENHA, EMAIL, TELEFONE, data_nascimento) VALUES (?,?,?,?,?,?)";
		java.sql.PreparedStatement stmt = con.prepareStatement(sql);
		try {
			stmt.setInt(1, (int) usu.getId());
			stmt.setString(2, usu.getNome());
			stmt.setString(3, usu.getSenha());
			stmt.setString(4, usu.getEmail());
			stmt.setString(5, usu.getTelefone());
			stmt.setString(6, usu.getData_ns());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			//stmt.close();
		}
	}
	public void alterar(Usuario usu) throws RuntimeException, SQLException {
		String sql = "update USUARIO set NOME=? , SENHA=?, EMAIL=?, TELEFONE=?, data_nascimento=?  where ID=?";
		java.sql.PreparedStatement stmt = con.prepareStatement(sql);
		try {
			
			stmt.setString(1, usu.getNome());
			stmt.setString(2, usu.getSenha());
			stmt.setString(3, usu.getEmail());
			stmt.setString(4, usu.getTelefone());
			stmt.setString(5, usu.getData_ns());
			stmt.setInt(6, (int) usu.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		//	stmt.close();
		}
	}
	
	public void excluir(Usuario usu) throws RuntimeException, SQLException {
		String sql = "delete from usuario where ID ="+usu.getId()+";";
		java.sql.PreparedStatement stmt = con.prepareStatement(sql);
		try {
			//stmt.setInt(1, (int) usu.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		//	stmt.close();
		}
	}
	public List<Usuario> lista() {
		Usuario usu = new Usuario();
		String sql = "SELECT NOME, data_nascimento, EMAIL, TELEFONE FROM usuario where ID = "+1+" ;";
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
		PreparedStatement stmt = con.prepareStatement(sql);
		//  stmt.setInt(1, (int) usu.getId());
	    ResultSet res = stmt.executeQuery();
	    
			while(res.next()){
				Usuario v = new Usuario();
				
				v.setNome(res.getString("NOME"));
				v.setData_ns(res.getString("data_nascimento"));
				v.setEmail(res.getString("EMAIL"));
				v.setTelefone(res.getString("TELEFONE"));
				lista.add(v);
			}
			
			stmt.execute();
			//stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			}
		return lista;
		}
	
			
		
		
}
