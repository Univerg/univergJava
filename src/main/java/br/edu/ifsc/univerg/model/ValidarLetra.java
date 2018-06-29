package br.edu.ifsc.univerg.model;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author guilh_000
 */
public class ValidarLetra extends PlainDocument {

	int maximo;

	public ValidarLetra(int max) {
		maximo = max;
	}

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if ((getLength() + str.length()) <= maximo) {
			super.insertString(offs, str.replaceAll("[^A-Z^a-z- ]", ""), a);
		}
		

	}
}