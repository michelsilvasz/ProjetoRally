package thread;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thread.Podium;

/**
 * Servlet implementation class Carro
 */
@WebServlet("/Carro")

    public class Carro extends Thread  
    {  
		static int colocacao = 0;
        private Podium campeao;  
        private String corredor;     
        int tempoVolta = 0;  
        int tempVolt = 0;
        final static int TEMPO_MAXIMO = 20;
        int velocidadeV = 0;
        int velocidV = 0;
        final static int VELOCIDADE_MAXIMA = 80;
        
    public Carro(String nome, Podium c)  
    {  
        corredor = nome;  
        campeao = c;  
    }  
         
        @Override  
    public void run()  
    {  
              
              
          try  
          {  
                int i;  
                for(i=1;i<15;i++)  
                {  
                	tempoVolta++;
                	tempVolt = (int) (Math.random() * TEMPO_MAXIMO);
                	
                	velocidadeV ++;
                	velocidV = 20 +(int) (Math.random() * VELOCIDADE_MAXIMA);
                    
                	System.out.println(i+"º.Curva - Piloto "+ corredor + "\n tempo da curva: "+tempVolt+"segundos -- Velocidade "+velocidV+"km/h\n");  
                    int tempo = (int)(Math.random()*300);  
                    sleep(tempo);  
                    
                }     
                System.out.println("\nChegada - Piloto "+ corredor+"\n");
                this.campeao.setVencedor(corredor);
                colocacao++;
        		System.out.println("\n"+corredor + " foi o " + colocacao + "º colocado \n");
        							
              
          }    
          catch(Exception e)  
          {  
                 e.printStackTrace();             
          }  
      }  
 
     
    }
