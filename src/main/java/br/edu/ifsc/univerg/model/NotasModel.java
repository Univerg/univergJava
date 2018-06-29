package br.edu.ifsc.univerg.model;

public class NotasModel {
	private long id;
	private long id_turma;
	private long id_disciplina;
	private float nota1;
	private float nota2;
	private float nota3;
	public NotasModel(long id, long id_turma, long id_disciplina, float nota1, float nota2, float nota3) {
		this.id = id;
		this.id_turma = id_turma;
		this.id_disciplina = id_disciplina;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_turma() {
		return id_turma;
	}
	public void setId_turma(long id_turma) {
		this.id_turma = id_turma;
	}
	public long getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(long id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}
	public float getNota3() {
		return nota3;
	}
	public void setNota3(float nota3) {
		this.nota3 = nota3;
	}
	@Override
	public String toString() {
		return "NotasModel [id=" + id + ", id_turma=" + id_turma + ", id_disciplina=" + id_disciplina + ", nota1="
				+ nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + "]";
	}
	
}
