package br.edu.ifsc.univerg.gui.InternalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import com.towel.swing.img.JImagePanel;

import br.edu.ifsc.univerg.dao.AvaliacaoDAO;
import br.edu.ifsc.univerg.dao.NotasDAO;
import br.edu.ifsc.univerg.dao.adminDAO;
import br.edu.ifsc.univerg.model.AdminModel;
import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.NotasModel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JComboBox jcbTurma;
	private JComboBox jcbDisciplina;

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
		boxTurma();

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
			jpCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gerenciar Notas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpCadastro.setBounds(19, 29, 1008, 580);
			jpCadastro.setLayout(null);
			jpCadastro.add(getJlbDisciplina());
			jpCadastro.add(getJcbDisciplina());
			jpCadastro.add(getJspTabela());
			jpCadastro.add(getTextField());
			jpCadastro.add(getJlBuscar());
			jpCadastro.add(getJcbTurma());
			
			JLabel jlTurma = new JLabel("Turma:");
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
	
	private void boxDisc() {
		NotasDAO dao = new NotasDAO();
		jcbDisciplina.removeAllItems();
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(dao.busca_disciplina().toArray());
		jcbDisciplina.setModel(defaultComboBox);
		
	}
	private void boxTurma() {
		NotasDAO dao = new NotasDAO();
		jcbTurma.removeAllItems();
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(dao.busca_turma().toArray());
		jcbTurma.setModel(defaultComboBox);
		
	}
	private void carregarALunos() {

		NotasDAO notas = new NotasDAO();
		DefaultTableModel model = (DefaultTableModel) jtTabela.getModel();

		// limpa a tabela
		model.setRowCount(0);
		List<NotasModel> dados = notas.busca_aluno();

		// carrega pessoas da lista
		for (NotasModel nm : dados) {
			// inclui uma linha na tabela
			model.addRow(new Object[] { nm.getNomeAluno(),nm.getMatriculaAluno() });
		}
	}
	private JLabel getJlbDisciplina() {
		if (jlbDisciplina == null) {
			jlbDisciplina = new JLabel("Disciplina:");
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
		}
		return jspTabela;
	}
	private JTable getJtTabela() {
		if (jtTabela == null) {
			jtTabela = new JTable();
			
			jtTabela.addMouseListener(new MouseAdapter(){
			      public void mouseClicked(MouseEvent e){
			        if(e.getClickCount() == 2){
			          JOptionPane.showMessageDialog(null, "test");
			        }
			      }
			     });
			jtTabela.setForeground(Color.WHITE);
			jtTabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jspTabela.getViewport().setBackground(Color.darkGray);
			jtTabela.setBackground(Color.darkGray);
			jtTabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Matr\u00EDcula", "Nota 1", "Nota 2", "Nota 3", "M\u00E9dia"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			jtTabela.getColumnModel().getColumn(0).setPreferredWidth(160);
			jtTabela.getColumnModel().getColumn(1).setPreferredWidth(102);
			jtTabela.getColumnModel().getColumn(2).setPreferredWidth(90);
			jtTabela.getColumnModel().getColumn(3).setPreferredWidth(90);
			jtTabela.getColumnModel().getColumn(4).setPreferredWidth(90);
			jtTabela.getColumnModel().getColumn(5).setPreferredWidth(90);
		}
		return jtTabela;
	}
	private JComboBox getJcbTurma() {
		if (jcbTurma == null) {
			jcbTurma = new JComboBox();
			jcbTurma.addItemListener(new ItemListener() {

	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                // 
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                	NotasDAO dao = new NotasDAO();
						dao.busca_disciplina();
						AuxClass.setAux(e.getItem().toString());
						boxDisc();
	                }
	                    
	            }
	        });
			
			jcbTurma.setBounds(86, 14, 173, 28);
		}
		return jcbTurma;
	}
	private JComboBox getJcbDisciplina() {
		if (jcbDisciplina == null) {
			jcbDisciplina = new JComboBox();
			jcbDisciplina.addItemListener(new ItemListener() {

	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                // 
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                	NotasDAO dao = new NotasDAO();
						dao.busca_aluno();
						AuxClass.setAux(e.getItem().toString());
						carregarALunos();
	                }
	                    
	            }
	        });
			jcbDisciplina.setBounds(359, 14, 173, 28);
		}
		return jcbDisciplina;
	}
}
