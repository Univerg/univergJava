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
import javax.swing.UIManager;

public class IFGerenciarNotas extends JInternalFrame {
	private JImagePanel imagePanel;
	private JImagePanel jpCadastro;
	private JButton jbVoltar;
	private JLabel jlbDisciplina;
	private JButton jbtSalvar;
	private JButton jbtNovo;
	private JTextField textField;
	private JLabel jlBuscar;
	private JButton jbtAlterar;
	private JButton jbtDeletar;
	private JScrollPane jspTabela;
	private JTable jtTabela;
	private JComboBox jcbDisciplina;
	private JTextField textField_1;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @throws Throwable 
	 */
	public IFGerenciarNotas() throws Throwable {
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
			imagePanel.add(getJpCadastro());
			imagePanel.add(getJbVoltar());
			imagePanel.add(getJbtAlterar());
			imagePanel.add(getJbtDeletar());
			imagePanel.add(getJbtNovo());
			imagePanel.add(getJbtSalvar());
		}
		return imagePanel;
	}
	private static BufferedImage loadImage(String file) throws IOException {
		return ImageIO.read(new File(file));
	}
	private JImagePanel getJpCadastro()  throws IOException{
		if (jpCadastro == null) {
			jpCadastro = new JImagePanel(loadImage("panel.png"));
			jpCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro/ Alterar / Deletar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpCadastro.setBounds(19, 29, 1008, 580);
			jpCadastro.setLayout(null);
			jpCadastro.add(getJlbDisciplina());
			jpCadastro.add(getJcbDisciplina());
			jpCadastro.add(getJspTabela());
			jpCadastro.add(getTextField());
			jpCadastro.add(getJlBuscar());
			
			JComboBox jcbTurma = new JComboBox();
			jcbTurma.setBounds(105, 14, 173, 28);
			jpCadastro.add(jcbTurma);
			
			JLabel jlTurma = new JLabel("Turma");
			jlTurma.setForeground(new Color(0, 153, 51));
			jlTurma.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlTurma.setBounds(21, 24, 86, 16);
			jpCadastro.add(jlTurma);
		}
		return jpCadastro;
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
	private JLabel getJlbDisciplina() {
		if (jlbDisciplina == null) {
			jlbDisciplina = new JLabel("Diciplina:");
			jlbDisciplina.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbDisciplina.setForeground(new Color(0, 153, 51));
			jlbDisciplina.setBounds(287, 19, 86, 16);
		}
		return jlbDisciplina;
	}
	private JButton getJbtSalvar() {
		if (jbtSalvar == null) {
			jbtSalvar = new JButton("Salvar");
			jbtSalvar.setBounds(483, 620, 122, 38);
			jbtSalvar.setForeground(Color.WHITE);
			jbtSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtSalvar.setBackground(new Color(0, 153, 51));
		}
		return jbtSalvar;
	}
	private JButton getJbtNovo() {
		if (jbtNovo == null) {
			jbtNovo = new JButton("Novo");
			jbtNovo.setBounds(351, 620, 122, 38);
			jbtNovo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			jbtNovo.setForeground(Color.WHITE);
			jbtNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtNovo.setBackground(new Color(0, 153, 51));
		}
		return jbtNovo;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(86, 68, 621, 28);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getJlBuscar() {
		if (jlBuscar == null) {
			jlBuscar = new JLabel("Buscar:");
			jlBuscar.setBounds(21, 73, 55, 16);
			jlBuscar.setForeground(new Color(0, 153, 51));
			jlBuscar.setFont(new Font("SansSerif", Font.BOLD, 13));
		}
		return jlBuscar;
	}
	private JButton getJbtAlterar() {
		if (jbtAlterar == null) {
			jbtAlterar = new JButton("Alterar");
			jbtAlterar.setBounds(747, 620, 122, 38);
			jbtAlterar.setForeground(Color.WHITE);
			jbtAlterar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtAlterar.setBackground(new Color(0, 153, 51));
		}
		return jbtAlterar;
	}
	private JButton getJbtDeletar() {
		if (jbtDeletar == null) {
			jbtDeletar = new JButton("Deletar");
			jbtDeletar.setBounds(615, 619, 122, 38);
			jbtDeletar.setForeground(Color.WHITE);
			jbtDeletar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtDeletar.setBackground(new Color(0, 153, 51));
		}
		return jbtDeletar;
	}
	private JScrollPane getJspTabela() {
		if (jspTabela == null) {
			jspTabela = new JScrollPane();
			jspTabela.setBounds(10, 107, 988, 462);
			jspTabela.setViewportView(getJtTabela());
			
			JImagePanel imagePanel_1 = new JImagePanel((BufferedImage) null);
			imagePanel_1.setLayout(null);
			imagePanel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro/ Alterar / Deletar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jspTabela.setColumnHeaderView(imagePanel_1);
			
			JLabel label = new JLabel("Diciplina:");
			label.setForeground(new Color(0, 153, 51));
			label.setFont(new Font("SansSerif", Font.BOLD, 13));
			label.setBounds(453, 19, 86, 16);
			imagePanel_1.add(label);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(536, 14, 173, 28);
			imagePanel_1.add(comboBox);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 107, 988, 462);
			imagePanel_1.add(scrollPane);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(88, 53, 621, 28);
			imagePanel_1.add(textField_1);
			
			JLabel label_1 = new JLabel("Buscar:");
			label_1.setForeground(new Color(0, 153, 51));
			label_1.setFont(new Font("SansSerif", Font.BOLD, 13));
			label_1.setBounds(21, 59, 55, 16);
			imagePanel_1.add(label_1);
		}
		return jspTabela;
	}
	private JTable getJtTabela() {
		if (jtTabela == null) {
			jtTabela = new JTable();
			jtTabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jspTabela.getViewport().setBackground(Color.darkGray);
			jtTabela.setBackground(Color.darkGray);
			jtTabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Matr\u00EDcula", "Nota 1", "Nota 2", "Nota 3"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Object.class, Object.class, Object.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			jtTabela.getColumnModel().getColumn(0).setPreferredWidth(153);
			jtTabela.getColumnModel().getColumn(1).setPreferredWidth(153);
			jtTabela.getColumnModel().getColumn(2).setPreferredWidth(105);
			jtTabela.getColumnModel().getColumn(3).setPreferredWidth(106);
			jtTabela.getColumnModel().getColumn(4).setPreferredWidth(107);
		}
		return jtTabela;
	}
	private JComboBox getJcbDisciplina() {
		if (jcbDisciplina == null) {
			jcbDisciplina = new JComboBox();
			jcbDisciplina.setBounds(359, 14, 173, 28);
		}
		return jcbDisciplina;
	}
}
