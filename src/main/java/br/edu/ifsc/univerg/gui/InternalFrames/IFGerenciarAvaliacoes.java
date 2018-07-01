package br.edu.ifsc.univerg.gui.InternalFrames;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import com.towel.swing.img.JImagePanel;

import br.edu.ifsc.univerg.dao.AvaliacaoDAO;
import br.edu.ifsc.univerg.dao.DisciplinaDAO;
import br.edu.ifsc.univerg.dao.TurmaDAO;
import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.AvaliacaoModel;
import br.edu.ifsc.univerg.model.DisciplinaModel;
import br.edu.ifsc.univerg.model.TurmaModel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import com.toedter.calendar.JDateChooser;

public class IFGerenciarAvaliacoes extends JInternalFrame {
	private JImagePanel imagePanel;
	private JImagePanel jpCadastro;
	private JImagePanel jpRemoverAtualizar;
	private JButton jbVoltar;
	private JLabel jlbData;
	private JLabel jlbTurma;
	private JButton jbtSalvar;
	private JButton jbtNovo;
	private JTextField jtfBusca;
	private JLabel jlBuscar;
	private JButton jbtAlterar;
	private JButton jbtDeletar;
	private JScrollPane jspTabela;
	private JTable jtTabela;
	private JLabel lblDisciplina;
	private JComboBox jcbTurma;
	private JComboBox jcbDisciplina;
	private JDateChooser jtfData;
	private TableRowSorter<TableModel> rowSorter;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @throws Throwable 
	 */
	public IFGerenciarAvaliacoes() throws Throwable {
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setBounds(100, 100, 1070, 676);
		getContentPane().setLayout(null);
		getContentPane().add(getImagePanel());
		rowSorter = new TableRowSorter<TableModel>(jtTabela.getModel());
		jtTabela.setRowSorter(rowSorter);
		boxTurma();
		boxDisc();
		tabela();

	}
	private JImagePanel getImagePanel() throws Throwable {
		if (imagePanel == null) {
			imagePanel = new JImagePanel(loadImage("panel.png"));
			imagePanel.setBounds(0, -22, 1058, 694);
			imagePanel.setLayout(null);
			imagePanel.add(getJpCadastro());
			imagePanel.add(getJpRemoverAtualizar());
			imagePanel.add(getJbVoltar());
		}
		return imagePanel;
	}
	private static BufferedImage loadImage(String file) throws IOException {
		return ImageIO.read(new File(file));
	}
	private JImagePanel getJpCadastro()  throws IOException{
		if (jpCadastro == null) {
			jpCadastro = new JImagePanel(loadImage("panel.png"));
			jpCadastro.setBorder(new TitledBorder(null, "Cadastro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpCadastro.setBounds(19, 29, 1008, 267);
			jpCadastro.setLayout(null);
			jpCadastro.add(getJlbData());
			jpCadastro.add(getJlbTurma());
			jpCadastro.add(getJbtSalvar());
			jpCadastro.add(getJbtNovo());
			jpCadastro.add(getLblDisciplina());
			jpCadastro.add(getJcbTurma());
			jpCadastro.add(getJcbDisciplina());
			jpCadastro.add(getJtfData());
		}
		return jpCadastro;
	}
	private void tabela() {

		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
		DefaultTableModel model = (DefaultTableModel) jtTabela.getModel();

		// limpa a tabela
		model.setRowCount(0);
		List<AvaliacaoModel> dados = avaliacaoDAO.selectAvaliacao();

		// carrega pessoas da lista
		for (AvaliacaoModel am : dados) {
			// inclui uma linha na tabela
			model.addRow(new Object[] { am.getId(), am.getData(), am.getCod_Turma(),am.getNome_Disciplina()});
		}
	}
	private JImagePanel getJpRemoverAtualizar()  throws IOException{
		if (jpRemoverAtualizar == null) {
			jpRemoverAtualizar = new JImagePanel(loadImage("panel.png"));
			jpRemoverAtualizar.setBorder(new TitledBorder(null, "Atualizar / Remover", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpRemoverAtualizar.setBounds(19, 308, 1008, 300);
			jpRemoverAtualizar.setLayout(null);
			jpRemoverAtualizar.add(getBusca());
			jpRemoverAtualizar.add(getJlBuscar());
			jpRemoverAtualizar.add(getJbtAlterar());
			jpRemoverAtualizar.add(getJbtDeletar());
			jpRemoverAtualizar.add(getJspTabela());
		}
		return jpRemoverAtualizar;
	}
	private void boxTurma() {
		AvaliacaoDAO dao = new AvaliacaoDAO();
		jcbTurma.removeAllItems();
		jcbTurma.addItem("");
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(dao.busca_turma().toArray());
		jcbTurma.setModel(defaultComboBox);
	}
	private void boxDisc() {
		AvaliacaoDAO dao = new AvaliacaoDAO();
		jcbDisciplina.removeAllItems();
		jcbDisciplina.addItem("");
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(dao.busca_disciplina().toArray());
		jcbDisciplina.setModel(defaultComboBox);
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
	private JLabel getJlbData() {
		if (jlbData == null) {
			jlbData = new JLabel("Data:");
			jlbData.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbData.setForeground(new Color(0, 153, 51));
			jlbData.setBounds(10, 34, 55, 16);
		}
		return jlbData;
	}
	private JLabel getJlbTurma() {
		if (jlbTurma == null) {
			jlbTurma = new JLabel("Turma:");
			jlbTurma.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbTurma.setForeground(new Color(0, 153, 51));
			jlbTurma.setBounds(10, 77, 55, 16);
		}
		return jlbTurma;
	}
	private JButton getJbtSalvar() {
		if (jbtSalvar == null) {
			jbtSalvar = new JButton("Salvar");
			jbtSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					AvaliacaoModel am = new AvaliacaoModel(sdf.format(jtfData.getDate().getTime()),
							jcbTurma.getSelectedItem().toString(),jcbDisciplina.getSelectedItem().toString());
					AvaliacaoDAO avaliacaoDAO= new AvaliacaoDAO();
					if (AuxClass.getVal() != true) {
						avaliacaoDAO.incluir(am);
					} else {
						avaliacaoDAO.alterarAvalicao(am, AuxClass.getAux2());
					}
					tabela();
				}
			});
			jbtSalvar.setForeground(Color.WHITE);
			jbtSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtSalvar.setBackground(new Color(0, 153, 51));
			jbtSalvar.setBounds(860, 212, 122, 38);
		}
		return jbtSalvar;
	}
	private JButton getJbtNovo() {
		if (jbtNovo == null) {
			jbtNovo = new JButton("Novo");
			jbtNovo.setForeground(Color.WHITE);
			jbtNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtNovo.setBackground(new Color(0, 153, 51));
			jbtNovo.setBounds(726, 212, 122, 38);
		}
		return jbtNovo;
	}
	private JTextField getBusca() {
		if (jtfBusca == null) {
			jtfBusca = new JTextField();
			jtfBusca.setColumns(10);
			jtfBusca.setBounds(92, 36, 621, 28);
			jtfBusca.getDocument().addDocumentListener(new DocumentListener() {
				public void insertUpdate(DocumentEvent e) {
					String text = jtfBusca.getText();

					if (text.trim().length() == 0) {
						rowSorter.setRowFilter(null);
					} else {
						rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					}
				}

				public void removeUpdate(DocumentEvent e) {
					String text = jtfBusca.getText();

					if (text.trim().length() == 0) {
						rowSorter.setRowFilter(null);
					} else {
						rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					}
				}

				public void changedUpdate(DocumentEvent e) {
					throw new UnsupportedOperationException("Not supported yet.");
				}
			});
			jtfBusca.setColumns(10);
		}
		return jtfBusca;
	}
	private JLabel getJlBuscar() {
		if (jlBuscar == null) {
			jlBuscar = new JLabel("Buscar:");
			jlBuscar.setForeground(new Color(0, 153, 51));
			jlBuscar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlBuscar.setBounds(25, 42, 55, 16);
		}
		return jlBuscar;
	}
	private JButton getJbtAlterar() {
		if (jbtAlterar == null) {
			jbtAlterar = new JButton("Alterar");
			jbtAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					AuxClass.setVal(true);
					DefaultTableModel tableModel = (
					DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					AuxClass.setAux2(tableModel.getValueAt(row, 0).toString());
					AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
					avaliacaoDAO.buscarAlteracoes();
					List<AvaliacaoModel> dados = avaliacaoDAO.buscarAlteracoes();
					for (AvaliacaoModel am : dados) {
							try {
								jtfData.setDate(sdf.parse(am.getData()));
								jcbTurma.setSelectedItem(am.getCod_Turma());
								jcbDisciplina.setSelectedItem(am.getNome_Disciplina());
							} catch (ParseException e) {
								JOptionPane erro = new JOptionPane(e,JOptionPane.ERROR_MESSAGE);
								JDialog jd = erro.createDialog("Ocorreu um Erro!");
							}	
					}
					
				}
			});
			jbtAlterar.setForeground(Color.WHITE);
			jbtAlterar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtAlterar.setBackground(new Color(0, 153, 51));
			jbtAlterar.setBounds(725, 24, 122, 38);
		}
		return jbtAlterar;
	}
	private JButton getJbtDeletar() {
		if (jbtDeletar == null) {
			jbtDeletar = new JButton("Deletar");
			jbtDeletar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
					DefaultTableModel tableModel = (DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					avaliacaoDAO.excluir_avaliacao(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
					tabela();
				}
			});
			jbtDeletar.setForeground(Color.WHITE);
			jbtDeletar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtDeletar.setBackground(new Color(0, 153, 51));
			jbtDeletar.setBounds(860, 24, 122, 38);
		}
		return jbtDeletar;
	}
	private JScrollPane getJspTabela() {
		if (jspTabela == null) {
			jspTabela = new JScrollPane();
			jspTabela.setBounds(25, 70, 956, 203);
			jspTabela.setViewportView(getJtTabela());
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
					"Id:", "Data:", "Turma:", "Disciplina"
				}
			) {
				Class[] columnTypes = new Class[] {
					Object.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			jtTabela.getColumnModel().getColumn(1).setResizable(false);
			jtTabela.getColumnModel().getColumn(1).setPreferredWidth(165);
			jtTabela.getColumnModel().getColumn(2).setResizable(false);
			jtTabela.getColumnModel().getColumn(2).setPreferredWidth(144);
			jtTabela.getColumnModel().getColumn(3).setResizable(false);
			jtTabela.getColumnModel().getColumn(3).setPreferredWidth(308);
		}
		return jtTabela;
	}
	private JLabel getLblDisciplina() {
		if (lblDisciplina == null) {
			lblDisciplina = new JLabel("Disci:");
			lblDisciplina.setForeground(new Color(0, 153, 51));
			lblDisciplina.setFont(new Font("SansSerif", Font.BOLD, 13));
			lblDisciplina.setBounds(10, 115, 55, 16);
		}
		return lblDisciplina;
	}
	private JComboBox getJcbTurma() {
		if (jcbTurma == null) {
			jcbTurma = new JComboBox();
			jcbTurma.setBounds(77, 67, 599, 29);
		}
		return jcbTurma;
	}
	private JComboBox getJcbDisciplina() {
		if (jcbDisciplina == null) {
			jcbDisciplina = new JComboBox();
			jcbDisciplina.setBounds(77, 110, 599, 28);
		}
		return jcbDisciplina;
	}
	private JDateChooser getJtfData() {
		if (jtfData == null) {
			jtfData = new JDateChooser();
			jtfData.setBounds(75, 24, 144, 26);
		}
		return jtfData;
	}
}
