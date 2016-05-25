package autentica;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cadastro() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("senha"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("telefone"));
		System.out.println(request.getParameter("datanasci"));
		
		Usuario registro = new Usuario(); 
		registro.setId(new Integer(request.getParameter("id")));
		registro.setNome(new String(request.getParameter("nome")));
		registro.setSenha(new String(request.getParameter("senha")));
		registro.setEmail(new String(request.getParameter("email")));
		registro.setTelefone(new String(request.getParameter("telefone")));
		registro.setData_ns(new String(request.getParameter("datanasci")));
		
		try {
			LoginDAO regDAO = new LoginDAO();
			try {
				regDAO.incluir(registro);
				RequestDispatcher rd = request.getRequestDispatcher("../pagina01.html");
			//	request.setAttribute("titulo", "Inclusão de Usuario");
			//	request.setAttribute("usuario", registro);
				rd.forward(request, response);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				out.println("Erro de Inclusão.");
				e.printStackTrace();
			} finally {
				regDAO.finalize();
			}
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("Erro de abertura de conexão.");
			e.printStackTrace();
		}
	}
}
