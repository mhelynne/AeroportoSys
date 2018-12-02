package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entidades.Voo;

public class Aeroporto {
	
	private String nome;
	private String codigo;
	private Integer anoDeInauguracao;
	
	
	// Um Aeroporto precisa ter um Endereco
	private Endereco endereco; // Associação entre Aeroporto e Endereco
	
	// Um Aeroporto tem vários voos
	private List<Voo> decolagens; // Associação entre Aeroporto e Voo
	private List<Voo> pousos;
	
	public Aeroporto() {
		decolagens = new ArrayList<>();
		pousos = new ArrayList<>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	//... Outros métodos vão aqui
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Integer getAnoDeInauguracao() {
		return anoDeInauguracao;
	}
	
	public void setAnoDeInauguracao(Integer anoDeInauguracao) {
		this.anoDeInauguracao = anoDeInauguracao;
	}
	
	public void addListaDecolagens(Voo voo) {
		decolagens.add(voo);
	}
	
	public void addListaPousos(Voo voo) {
		pousos.add(voo);
	}
	
	public List<Voo> listaDecolagens(Date data) {	
		List<Voo> voos = new ArrayList<Voo>();
		
		for (Voo d : decolagens) {
			if(mesmoDiaDoAno(d.getPartida(), data)){
				voos.add(d);
			}
		}
		
		return voos;
	}
	
	public List<Voo> listaPousos(Date data) {	
		List<Voo> voos = new ArrayList<Voo>();		
		
		for (Voo d : pousos) {						
			if(mesmoDiaDoAno(d.getChegada(), data)){
				voos.add(d);
			}
		}
		
		return voos;
	}

	// Retorna verdadeiro se o dia do ano for o mesmo
	boolean mesmoDiaDoAno(Date data1, Date data2) {		
		int diaDoAno1, diaDoAno2;
		
		Calendar c = Calendar.getInstance();
		c.setTime(data1);
		diaDoAno1 = c.get(c.DAY_OF_YEAR);
		
		c.setTime(data2);
		diaDoAno2 = c.get(c.DAY_OF_YEAR);
		
		return (diaDoAno1 == diaDoAno2);		
	}

	

}