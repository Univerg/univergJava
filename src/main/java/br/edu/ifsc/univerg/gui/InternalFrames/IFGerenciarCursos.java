package br.edu.ifsc.univerg.gui.InternalFrames;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import com.towel.swing.img.JImagePanel;
import br.edu.ifsc.univerg.dao.AlunoDAO;
import br.edu.ifsc.univerg.dao.CursoDAO;
import br.edu.ifsc.univerg.dao.adminDAO;
import br.edu.ifsc.univerg.model.AdminModel;
import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.CursoModel;
import br.edu.ifsc.univerg.model.ProfessorModel;
import br.edu.ifsc.univerg.model.ValidarLetra;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

public class IFGerenciarCursos extends JInternalFrame {
	private JImagePanel imagePanel;
	private JImagePanel jpCadastro;
	private JImagePanel jpRemoverAtualizar;
	private JButton jbVoltar;
	private JTextField jtfNome;
	private JLabel lblNome;
	private JButton jbtSalvar;
	private JButton jbtNovo;
	private JTextField jtfBusca;
	private JLabel jlBuscar;
	private JButton jbtAlterar;
	private JButton jbtDeletar;
	private JScrollPane jspTabela;
	private JTable jtTabela;
	private TableRowSorter<TableModel> pesquisaTextField;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @throws Throwable 
	 */
	public IFGerenciarCursos() throws Throwable {
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setBounds(100, 100, 1070, 676);
		getContentPane().setLayout(null);
		getContentPane().add(getImagePanel());
		pesquisaTextField = new TableRowSorter<TableModel>(jtTabela.getModel());
		jtTabela.setRowSorter(pesquisaTextField);
		tabela();

	}
	private void tabela(){
		CursoDAO curso = new CursoDAO();
		DefaultTableModel model = (DefaultTableModel) jtTabela.getModel();

		// limpa a tabela
		model.setRowCount(0);
		 List<CursoModel> dados = curso.selectCurso();

		// carrega pessoas da lista
		for (CursoModel cr : dados) {
			// inclui uma linha na tabela
			model.addRow(
					new Object[] { cr.getId(), cr.getNome() });
	}
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
			jpCadastro.setBorder(new TitledBorder(null, "Gerenciar Curso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpCadastro.setBounds(19, 29, 1008, 267);
			jpCadastro.setLayout(null);
			jpCadastro.add(getJtfNome());
			jpCadastro.add(getLblNome());
			jpCadastro.add(getJbtSalvar());
			jpCadastro.add(getJbtNovo());
		}
		return jpCadastro;
	}
	private JImagePanel getJpRemoverAtualizar()  throws IOException{
		if (jpRemoverAtualizar == null) {
			jpRemoverAtualizar = new JImagePanel(loadImage("panel.png"));
			jpRemoverAtualizar.setBorder(new TitledBorder(null, "Atualizar / Remover", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpRemoverAtualizar.setBounds(19, 308, 1008, 300);
			jpRemoverAtualizar.setLayout(null);
			jpRemoverAtualizar.add(getJtfBusca());
			jpRemoverAtualizar.add(getJlBuscar());
			jpRemoverAtualizar.add(getJbtAlterar());
			jpRemoverAtualizar.add(getJbtDeletar());
			jpRemoverAtualizar.add(getJspTabela());
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
	private JTextField getJtfNome() {
		if (jtfNome == null) {
			jtfNome = new JTextField();
			jtfNome.setColumns(10);
			jtfNome.setBounds(77, 28, 908, 28);
			jtfNome.setDocument(new ValidarLetra(50));
			
		}
		return jtfNome;
	}
	private JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome:");
			lblNome.setFont(new Font("SansSerif", Font.BOLD, 13));
			lblNome.setForeground(new Color(0, 153, 51));
			lblNome.setBounds(10, 33, 55, 16);
		}
		return lblNome;
	}
	private JButton getJbtSalvar() {
		if (jbtSalvar == null) {
			jbtSalvar = new JButton("Salvar");
			jbtSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CursoDAO cursoDAO = new CursoDAO();
					CursoModel curso = new CursoModel(jtfNome.getText());
					if (AuxClass.getVal() != true) {
						try {
							cursoDAO.incluir(curso);
							tabela();
							
						} catch (Exception e) {
							// TODO: handle exception
						}
					} else {
						try {
							cursoDAO.alterarCurso(curso, AuxClass.getAux());
							tabela();
							
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
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
	private JTextField getJtfBusca() {
		if (jtfBusca == null) {
			jtfBusca = new JTextField();
			jtfBusca.setColumns(10);
			jtfBusca.setBounds(92, 36, 621, 28);
			jtfBusca.getDocument().addDocumentListener(new DocumentListener() {	
				public void insertUpdate(DocumentEvent e) {
					String text = jtfBusca.getText();
					if (text.trim().length() == 0) {
						pesquisaTextField.setRowFilter(null);
					} else {
						pesquisaTextField.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					}
				}
				
				public void removeUpdate(DocumentEvent e) {
					String text = jtfBusca.getText();

					if (text.trim().length() == 0) {
						pesquisaTextField.setRowFilter(null);
					} else {
						pesquisaTextField.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					}
					
				}
				
				public void changedUpdate(DocumentEvent e) {
					throw new UnsupportedOperationException("Not supported yet.");
					
				}
			});;
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
					AuxClass.setVal(true);
					DefaultTableModel tableModel = (DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					AuxClass.setAux(tableModel.getValueAt(row, 0).toString());
					CursoDAO cursoDAO = new CursoDAO();
					cursoDAO.buscarAlteracoes();
					List<CursoModel> dados = cursoDAO.buscarAlteracoes();
					for (CursoModel cursoModel : dados) {
						jtfNome.setText(cursoModel.getNome());
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
					CursoDAO cursoDAO = new CursoDAO();
					DefaultTableModel tableModel = (DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					cursoDAO.excluirCurso(tableModel.getValueAt(row, 0).toString());
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
			jtTabela.setForeground(Color.WHITE);
			jtTabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jspTabela.getViewport().setBackground(Color.darkGray);
			jtTabela.setBackground(Color.darkGray);
			jtTabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Curso"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			jtTabela.getColumnModel().getColumn(0).setResizable(false);
			jtTabela.getColumnModel().getColumn(0).setPreferredWidth(260);
			jtTabela.getColumnModel().getColumn(1).setResizable(false);
			jtTabela.getColumnModel().getColumn(1).setPreferredWidth(260);
		}
		return jtTabela;
	}
}
