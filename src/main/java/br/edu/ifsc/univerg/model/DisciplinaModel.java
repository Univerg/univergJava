package br.edu.ifsc.univerg.model;

public class DisciplinaModel {
	private int id;
	private int id_curso;
	private String nome;
	private String nomeCurso;
	private String ementa;
	public DisciplinaModel(int id, int id_curso, String nome) {
		this.id = id;
		this.id_curso = id_curso;
		this.nome = nome;
	}
	
	public DisciplinaModel(int id, String nome, String nomeCurso) {
		this.id = id;
		this.nome = nome;
		this.nomeCurso = nomeCurso;
	}

	public DisciplinaModel(String nome, String nomeCurso, String ementa) {
		this.nome = nome;
		this.nomeCurso = nomeCurso;
		this.ementa=ementa;
	}

	public DisciplinaModel(String nome, String ementa) {
		this.nome = nome;
		this.ementa=ementa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	@Override
	public String toString() {
		return "DisciplinaModel [id=" + id + ", id_curso=" + id_curso + ", nome=" + nome + ", nomeCurso=" + nomeCurso
				+ "]";
	}
	
	
	
	
}
