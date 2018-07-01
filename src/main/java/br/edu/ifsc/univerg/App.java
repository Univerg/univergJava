package br.edu.ifsc.univerg;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.edu.ifsc.univerg.gui.FrameLogin;
import br.edu.ifsc.univerg.gui.FrameSelecao;

public class App {
	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
			//UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					/*Conexao con = new Conexao();
					con.abrir();*/
					FrameSelecao frame = new FrameSelecao();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
			}
		});
	}

}
