package br.edu.ifsc.univerg.model;
import java.sql.Date;


public class AvaliacaoModel {
	private int id;
	private String data;
	private String cod_Turma;
	private String nome_Disciplina;
	public AvaliacaoModel(String data, String cod_Turma, String nome_Disciplina) {
		this.data = data;
		this.cod_Turma = cod_Turma;
		this.nome_Disciplina = nome_Disciplina;
	}
	
	public AvaliacaoModel(int id, String data, String cod_Turma, String nome_Disciplina) {
		this.id = id;
		this.data = data;
		this.cod_Turma = cod_Turma;
		this.nome_Disciplina = nome_Disciplina;
	}

	public AvaliacaoModel(String data, String nome_Disciplina) {
		super();
		this.data = data;
		this.nome_Disciplina = nome_Disciplina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCod_Turma() {
		return cod_Turma;
	}
	public void setCod_Turma(String cod_Turma) {
		this.cod_Turma = cod_Turma;
	}
	public String getNome_Disciplina() {
		return nome_Disciplina;
	}
	public void setNome_Disciplina(String nome_Disciplina) {
		this.nome_Disciplina = nome_Disciplina;
	}
	
	
	
	
	
	
}
