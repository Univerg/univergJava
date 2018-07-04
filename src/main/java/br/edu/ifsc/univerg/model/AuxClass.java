package br.edu.ifsc.univerg.model;

public class AuxClass {
	static String aux;
	static String aux2;
	static String auxaluno;
	static String auxalunoid;
	static Boolean val=false;

	
	public static String getAuxaluno() {
		return auxaluno;
	}

	public static String getAuxalunoid() {
		return auxalunoid;
	}

	public static void setAuxalunoid(String auxalunoid) {
		AuxClass.auxalunoid = auxalunoid;
	}

	public static void setAuxaluno(String auxaluno) {
		AuxClass.auxaluno = auxaluno;
	}

	public static String getAux() {
		return aux;
	}

	public static void setAux(String aux) {
		AuxClass.aux = aux;
	}

	public static Boolean getVal() {
		return val;
	}

	public static void setVal(Boolean val) {
		AuxClass.val = val;
	}

	public static String getAux2() {
		return aux2;
	}

	public static void setAux2(String aux2) {
		AuxClass.aux2 = aux2;
	}
	
	

}