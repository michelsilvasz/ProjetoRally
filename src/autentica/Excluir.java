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
 * Servlet implementation class ExcluirCadastro
 */
@WebServlet("/Excluir")
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Excluir() {
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
   		//System.out.println(request.getParameter("id"));
   		System.out.println("Id que eu digitei: "+request.getParameter("id"));
   		
   		Usuario registro = new Usuario(); 
   		registro.setId(new Integer(request.getParameter("id")));
   		
   		try {
   			LoginDAO regDAO = new LoginDAO();
   			try {
   				
   				regDAO.excluir(registro);
   				pagina = "pagina01.html";
   			
   			} catch (Exception e) {
   				PrintWriter out = response.getWriter();
   				out.println("Erro de Exclusão.");
   				e.printStackTrace();
   			} finally {
   				//regDAO.finalize();
   			}
   		} catch (Exception e) {
   			PrintWriter out = response.getWriter();
   			out.println("Erro de abertura de conexão.");
   			e.printStackTrace();
   		}
   		System.out.println("forward: " + pagina);
   		dispatcher = request.getRequestDispatcher(pagina);
   		dispatcher.forward(request, response);
   	}

}
