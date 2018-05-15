package br.edu.ifsc.univerg.model;

public class CursoModel {
	private long id;
	private String nome;
	public CursoModel(long id) {
		this.id = id;
	}
	public CursoModel(String nome) {
		
		this.nome = nome;
	}
	public CursoModel(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
}
