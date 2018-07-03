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

public class IFNotas extends JInternalFrame {
	private JImagePanel imagePanel;
	private JImagePanel jpRemoverAtualizar;
	private JButton jbVoltar;
	private JLabel jlBuscar;
	private JScrollPane jspTabela;
	private JTable jtTabela;
	private JComboBox comboBox;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @throws Throwable 
	 */
	public IFNotas() throws Throwable {
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
			jpRemoverAtualizar.setBorder(new TitledBorder(null, "Notas e Frequ\u00EAncias", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpRemoverAtualizar.setBounds(20, 29, 1008, 573);
			jpRemoverAtualizar.setLayout(null);
			jpRemoverAtualizar.add(getJlBuscar());
			jpRemoverAtualizar.add(getJspTabela());
			jpRemoverAtualizar.add(getComboBox());
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
	private JLabel getJlBuscar() {
		if (jlBuscar == null) {
			jlBuscar = new JLabel("Fase:");
			jlBuscar.setForeground(new Color(0, 153, 51));
			jlBuscar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlBuscar.setBounds(25, 29, 72, 29);
		}
		return jlBuscar;
	}
	private JScrollPane getJspTabela() {
		if (jspTabela == null) {
			jspTabela = new JScrollPane();
			jspTabela.setBounds(25, 69, 956, 460);
			jspTabela.setViewportView(getJtTabela());
		}
		return jspTabela;
	}
	private JTable getJtTabela() {
		if (jtTabela == null) {
			jtTabela = new JTable();
			jtTabela.setForeground(Color.WHITE);
			jtTabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jspTabela.getViewport().setBackground(Color.darkGray);
			jtTabela.setBackground(Color.darkGray);
			jtTabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Disciplina", "Nota 1", "Nota 2", "Nota 3"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			jtTabela.getColumnModel().getColumn(0).setResizable(false);
			jtTabela.getColumnModel().getColumn(0).setPreferredWidth(256);
			jtTabela.getColumnModel().getColumn(1).setResizable(false);
			jtTabela.getColumnModel().getColumn(1).setPreferredWidth(90);
			jtTabela.getColumnModel().getColumn(2).setResizable(false);
			jtTabela.getColumnModel().getColumn(2).setPreferredWidth(90);
			jtTabela.getColumnModel().getColumn(3).setResizable(false);
			jtTabela.getColumnModel().getColumn(3).setPreferredWidth(90);
		}
		return jtTabela;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(66, 29, 232, 33);
		}
		return comboBox;
	}
}
