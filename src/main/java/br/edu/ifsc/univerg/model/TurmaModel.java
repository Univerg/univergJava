package br.edu.ifsc.univerg.model;

public class TurmaModel {

	String turno;
	String id;
	String cod;
	
	
	public TurmaModel(String id, String cod) {
		super();
		this.id = id;
		this.cod = cod;
	}
	
	public TurmaModel(String turno) {
		super();
		this.turno = turno;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "TurmaModel [turno=" + turno + ", id=" + id + ", cod=" + cod + "]";
	}

//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	///bbbbb

}
