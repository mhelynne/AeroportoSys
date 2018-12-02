package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Voo;

public class Aeroporto {
	
	private String nome;
	private String codigo;
	private Integer anoDeCriacao;
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	//... Outros métodos vão aqui
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Integer getAnoDeCriacao() {
		return anoDeCriacao;
	}
	
	public void setAnoDeCriacao(Integer anoDeCriacao) {
		this.anoDeCriacao = anoDeCriacao;
	}
	
	public List<Voo> listaDecolagens(Date data) {	
		List<Voo> voos = new ArrayList<Voo>();
		// O código vai aqui
		
		return voos;
	}
	
	public List<Voo> listaAterrissagens(Date data) {	
		List<Voo> voos = new ArrayList<Voo>();
		// O código vai aqui
		
		return voos;
	}

}