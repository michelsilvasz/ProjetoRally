package thread;
import java.io.Serializable;

public class DadosCorrida implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer volta;
	public Integer getVolta() {
		return volta;
	}

	public void setVolta(Integer volta) {
		this.volta = volta;
	}

	private Integer Tempcurva;
	private Integer velocidaC;
	private String piloto;
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public DadosCorrida() {
		
	}

	public Integer getTempcurva() {
		return Tempcurva;
	}

	public void setTempcurva(Integer tempcurva) {
		Tempcurva = tempcurva;
	}

	public Integer getVelocidaC() {
		return velocidaC;
	}

	public void setVelocidaC(Integer velocidaC) {
		this.velocidaC = velocidaC;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	
	
	
	

}
