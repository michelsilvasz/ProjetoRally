package thread;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * Servlet implementation class Listar
 */
@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Listar() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CorridaDAO t = new CorridaDAO();
			t.excluir();
			t.excluir2();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); System.out.println("Errooooooooo asdfashdahb");
		}
		
		Podium campeao = new Podium();  
        Carro carro1 = new Carro("Ayrton Senna", campeao);  
        Carro carro2 = new Carro("Nelson Piquet", campeao);  
        Carro carro3 = new Carro("Michael Shumaker", campeao);  
        Carro carro4 = new Carro("Rubens Barrichello", campeao);  
                        
        carro1.start();  
        carro2.start();  
        carro3.start();  
        carro4.start();  
        
        java.util.concurrent.ExecutorService threadExecutor = java.util.concurrent.Executors.newCachedThreadPool();
		threadExecutor.execute(new Carro("Ayrton Senna", campeao));
		
        
        try  
        {  
            carro1.join();  
            carro2.join();  
            carro3.join();  
            carro4.join();  
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
       
        request.getRequestDispatcher("listaCorrida.jsp").forward(request, response);
    }
	

	}


