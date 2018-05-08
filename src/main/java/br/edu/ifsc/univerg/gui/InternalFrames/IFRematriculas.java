package br.edu.ifsc.univerg.gui.InternalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import com.towel.swing.img.JImagePanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class IFRematriculas extends JInternalFrame {
	private JImagePanel imagePanel;
	private JImagePanel jpRemoverAtualizar;
	private JButton jbVoltar;
	private JLabel jlSemestre;
	private JButton jbtGerar;
	private JComboBox jcbSemestre;
	private JButton jbtImprimir;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @throws Throwable 
	 */
	public IFRematriculas() throws Throwable {
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setBounds(100, 100, 1070, 676);
		getContentPane().setLayout(null);
		getContentPane().add(getImagePanel());

	}
	private JImagePanel getImagePanel() throws Throwable {
		if (imagePanel == null) {
			imagePanel = new JImagePanel(loadImage("panel.png"));
			imagePanel.setBounds(0, -22, 1058, 694);
			imagePanel.setLayout(null);
			imagePanel.add(getJpRemoverAtualizar());
			imagePanel.add(getJbVoltar());
		}
		return imagePanel;
	}
	private static BufferedImage loadImage(String file) throws IOException {
		return ImageIO.read(new File(file));
	}
	private JImagePanel getJpRemoverAtualizar()  throws IOException{
		if (jpRemoverAtualizar == null) {
			jpRemoverAtualizar = new JImagePanel(loadImage("panel.png"));
			jpRemoverAtualizar.setBorder(new TitledBorder(null, "Rematr\u00EDculas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpRemoverAtualizar.setBounds(19, 39, 1008, 569);
			jpRemoverAtualizar.setLayout(null);
			jpRemoverAtualizar.add(getJlSemestre());
			jpRemoverAtualizar.add(getJbtGerar());
			jpRemoverAtualizar.add(getJcbSemestre());
			jpRemoverAtualizar.add(getJbtImprimir());
		}
		return jpRemoverAtualizar;
	}
	private JButton getJbVoltar() {
		if (jbVoltar == null) {
			jbVoltar = new JButton("Voltar");
			jbVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			jbVoltar.setForeground(Color.WHITE);
			jbVoltar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbVoltar.setBackground(new Color(0, 153, 51));
			jbVoltar.setBounds(879, 620, 122, 38);
		}
		return jbVoltar;
	}
	private JLabel getJlSemestre() {
		if (jlSemestre == null) {
			jlSemestre = new JLabel("Semestre:");
			jlSemestre.setForeground(new Color(0, 153, 51));
			jlSemestre.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlSemestre.setBounds(25, 42, 69, 16);
		}
		return jlSemestre;
	}
	private JButton getJbtGerar() {
		if (jbtGerar == null) {
			jbtGerar = new JButton("Gerar");
			jbtGerar.setForeground(Color.WHITE);
			jbtGerar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtGerar.setBackground(new Color(0, 153, 51));
			jbtGerar.setBounds(336, 31, 122, 38);
		}
		return jbtGerar;
	}
	private JComboBox getJcbSemestre() {
		if (jcbSemestre == null) {
			jcbSemestre = new JComboBox();
			jcbSemestre.setBounds(106, 37, 218, 26);
		}
		return jcbSemestre;
	}
	private JButton getJbtImprimir() {
		if (jbtImprimir == null) {
			jbtImprimir = new JButton("Imprimir");
			jbtImprimir.setForeground(Color.WHITE);
			jbtImprimir.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtImprimir.setBackground(new Color(0, 153, 51));
			jbtImprimir.setBounds(470, 31, 122, 38);
		}
		return jbtImprimir;
	}
}
