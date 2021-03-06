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

/**
 * Servlet implementation class Altera
 */
@WebServlet("/Altera")
public class Altera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Altera() {
        super();
        // TODO Auto-generated constructor stub
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
		RequestDispatcher dispatcher;
		String pagina = null;
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
				regDAO.alterar(registro);
				pagina = "pagina05.html";
			
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				out.println("Erro de Altera��o.");
				e.printStackTrace();
			} finally {
				regDAO.finalize();
			}
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("Erro de abertura de conex�o.");
			e.printStackTrace();
		}
		System.out.println("forward: " + pagina);
		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
