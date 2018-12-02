package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Voo {

	private Date partida;
	private Date chegada;
	private Integer duracaoHoras;
	private Integer qutPassageiros;
	
	// Um Voo precisa ter dois Aeroportos	
	private Aeroporto origem; // Aeroporto de onde decola
	private Aeroporto destino; // Aeroporto onde pousa
	
	// Getters e setters
	public Date getPartida() {
		return partida;
	}
	
	public void setPartida(Date partida) {
		this.partida = partida;
	}
	
	public Date getChegada() {
		return chegada;
	}
	
	public void setChegada(Date chegada) {
		this.chegada = chegada;
	}
	
	public Integer getDuracaoHoras() {
		return duracaoHoras;
	}
	
	public void setDuracaoHoras(Integer duracaoHoras) {
		this.duracaoHoras = duracaoHoras;
	}
	
	public Integer getQutPassageiros() {
		return qutPassageiros;
	}
	
	public void setQutPassageiros(Integer qutPassageiros) {
		this.qutPassageiros = qutPassageiros;
	}

	public Aeroporto getOrigem() {
		return origem;
	}
	
	public void setOrigem(Aeroporto origem) {
		this.origem = origem;
		origem.addListaDecolagens(this);
	}
	
	public Aeroporto getDestino() {
		return destino;		
	}
	
	public void setDestino(Aeroporto destino) {
		this.destino = destino;
		destino.addListaPousos(this);
	}	
	
	@Override
	public String toString() {
		DateFormat sdf = new SimpleDateFormat("HH:mm");
		String horaPartida = sdf.format(partida);
		String horaChegada = sdf.format(chegada);
		return "Voo de "+ origem.getCodigo() + " para " + destino.getCodigo() +
				" que parte às "+ horaPartida + " e chega às "+ horaChegada;	
	}
	
	
}
