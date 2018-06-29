package br.edu.ifsc.univerg.model;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author guilh_000
 */
public class ValidarNum extends PlainDocument {

	int maximo;

	public ValidarNum(int max) {
		maximo = max;
	}

	public void insertString(int offs, String str, AttributeSet a)  {
		if ((getLength() + str.length()) <= maximo) {
			try {
				super.insertString(offs, str.replaceAll("[^0-9-]", ""), a);
			} catch (BadLocationException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				
			}
		}

	}
}