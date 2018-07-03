package br.edu.ifsc.univerg.gui.InternalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import com.towel.swing.img.JImagePanel;

import br.edu.ifsc.univerg.dao.DisciplinaDAO;
import br.edu.ifsc.univerg.dao.TurmaDAO;
import br.edu.ifsc.univerg.dao.adminDAO;
import br.edu.ifsc.univerg.model.AdminModel;
import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.DisciplinaModel;
import br.edu.ifsc.univerg.model.TurmaModel;
import br.edu.ifsc.univerg.model.ValidarLetra;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import java.awt.TextArea;
import com.lowagie.text.*; 
import com.lowagie.text.pdf.PdfWriter;


public class IFGerenciarDisciplina extends JInternalFrame {
	private JImagePanel imagePanel;
	private JImagePanel jpCadastro;
	private JImagePanel jpRemoverAtualizar;
	private JButton jbVoltar;
	private JTextField jtfNome;
	private JLabel jlbNome;
	private JLabel jlbLogin;
	private JButton jbtSalvar;
	private JButton jbtNovo;
	private JTextField jtfBusca;
	private JLabel jlBuscar;
	private JButton jbtAlterar;
	private JButton jbtDeletar;
	private JScrollPane jspTabela;
	private JTable jtTabela;
	private TableRowSorter<TableModel> rowSorter;
	private JComboBox jcbCurso;
	private TextArea jtaEmenta;

	/**
	 * Launch the application.
	 * 
	 * 
	 * /** Create the frame.
	 * 
	 * @throws Throwable
	 */
	public IFGerenciarDisciplina() throws Throwable {
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setBounds(100, 100, 1070, 676);
		getContentPane().setLayout(null);
		getContentPane().add(getImagePanel());
		rowSorter = new TableRowSorter<TableModel>(jtTabela.getModel());
		jtTabela.setRowSorter(rowSorter);
		carrefartabela();
		boxCursos() ;

	}
	private void boxCursos() {
		DisciplinaDAO dao = new DisciplinaDAO();
		jcbCurso.removeAllItems();
		jcbCurso.addItem("");
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(dao.busca_curso().toArray());
		jcbCurso.setModel(defaultComboBox);
	}

	private void carrefartabela() {

		DisciplinaDAO disciplina = new DisciplinaDAO();
		DefaultTableModel model = (DefaultTableModel) jtTabela.getModel();

		// limpa a tabela
		model.setRowCount(0);
		List<DisciplinaModel> dados = disciplina.selectDisciplina();

		// carrega pessoas da lista
		for (DisciplinaModel dm : dados) {
			// inclui uma linha na tabela
			model.addRow(new Object[] { dm.getId(), dm.getNomeCurso(), dm.getNome()});
		}
	}

	private JImagePanel getImagePanel() throws Throwable {
		if (imagePanel == null) {
			imagePanel = new JImagePanel(loadImage("panel.png"));
			imagePanel.setBounds(0, -23, 1058, 694);
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

	private JImagePanel getJpCadastro() throws IOException {
		if (jpCadastro == null) {
			jpCadastro = new JImagePanel(loadImage("panel.png"));
			jpCadastro.setBorder(new TitledBorder(null, "Gerenciar Disciplina", TitledBorder.LEADING, TitledBorder.TOP, null,
					new Color(0, 153, 51)));
			jpCadastro.setBounds(19, 39, 529, 570);
			jpCadastro.setLayout(null);
			jpCadastro.add(getJcbCurso());
			jpCadastro.add(getJtfNome());
			jpCadastro.add(getJlbNome());
			jpCadastro.add(getJlbLogin());
			jpCadastro.add(getJbtSalvar());
			jpCadastro.add(getJbtNovo());
			jpCadastro.add(getJtaEmenta());
			
			JLabel jlEmenta = new JLabel("Ementa:");
			jlEmenta.setForeground(new Color(0, 153, 51));
			jlEmenta.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlEmenta.setBounds(27, 117, 52, 16);
			jpCadastro.add(jlEmenta);
		}
		return jpCadastro;
	}

	private JImagePanel getJpRemoverAtualizar() throws IOException {
		if (jpRemoverAtualizar == null) {
			jpRemoverAtualizar = new JImagePanel(loadImage("panel.png"));
			jpRemoverAtualizar.setBorder(new TitledBorder(null, "Atualizar / Remover", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpRemoverAtualizar.setBounds(558, 39, 490, 570);
			jpRemoverAtualizar.setLayout(null);
			jpRemoverAtualizar.add(getTextField());
			jpRemoverAtualizar.add(getJlBuscar());
			jpRemoverAtualizar.add(getJbtAlterar());
			jpRemoverAtualizar.add(getJbtDeletar());
			jpRemoverAtualizar.add(getJspTabela());
			
			JButton jbtPdf = new JButton("PDF");
			jbtPdf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DisciplinaDAO dao = new DisciplinaDAO();
					DefaultTableModel tableModel = (
							DefaultTableModel) jtTabela.getModel();
							int row = jtTabela.getSelectedRow();
							AuxClass.setAux2(tableModel.getValueAt(row, 0).toString());
							String nomeCurso = tableModel.getValueAt(row, 1).toString().toString();
							String nomeArquivo = tableModel.getValueAt(row, 2).toString().toString();
							
					
					 // criação do objeto documento
				       Document document = new Document();
				       try {
				           
				           PdfWriter.getInstance(document, new FileOutputStream("C://PDF//"+nomeArquivo+nomeCurso+".pdf"));
				           document.open();
				           
				           // adicionando um parágrafo ao documento
				           document.add(new Paragraph(dao.selectEmenta()+""));
				       }
				       catch(DocumentException de) {
				           JOptionPane.showMessageDialog(null,de.getMessage());
				       }
				       catch(IOException ioe) {
				    	   JOptionPane.showMessageDialog(null,ioe.getMessage());
				       }
				       document.close();
				   }	
			    
				
			});
			jbtPdf.setBounds(289, 524, 122, 38);
			jpRemoverAtualizar.add(jbtPdf);
			jbtPdf.setForeground(Color.WHITE);
			jbtPdf.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtPdf.setBackground(new Color(0, 153, 51));
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
			jbVoltar.setBounds(912, 620, 122, 38);
		}
		return jbVoltar;
	}
	private TextArea getJtaEmenta() {
		if(jtaEmenta == null) {
			 jtaEmenta = new TextArea();
			jtaEmenta.setBounds(10, 137, 509, 373);
		}
		return jtaEmenta;
		
	}

	private JTextField getJtfNome() {
		if (jtfNome == null) {
			jtfNome = new JTextField();
			jtfNome.setBounds(91, 21, 428, 28);
			jtfNome.setColumns(10);
			jtfNome.setDocument(new ValidarLetra(50));
		}
		return jtfNome;
	}

	private JLabel getJlbNome() {
		if (jlbNome == null) {
			jlbNome = new JLabel("Nome:");
			jlbNome.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbNome.setForeground(new Color(0, 153, 51));
			jlbNome.setBounds(24, 27, 55, 16);
		}
		return jlbNome;
	}

	private JLabel getJlbLogin() {
		if (jlbLogin == null) {
			jlbLogin = new JLabel("Curso:");
			jlbLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbLogin.setForeground(new Color(0, 153, 51));
			jlbLogin.setBounds(24, 67, 55, 16);
		}
		return jlbLogin;
	}

	private JButton getJbtSalvar() {
		if (jbtSalvar == null) {
			jbtSalvar = new JButton("Salvar");
			jbtSalvar.setForeground(Color.WHITE);
			jbtSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtSalvar.setBackground(new Color(0, 153, 51));
			jbtSalvar.setBounds(152, 516, 122, 38);
			jbtSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DisciplinaModel model = new DisciplinaModel(jtfNome.getText(), jtaEmenta.getText());
					
					AuxClass.setAux(jcbCurso.getSelectedItem().toString());
					DisciplinaDAO dao = new DisciplinaDAO();
					if (AuxClass.getVal() != true) {
						AuxClass.setAux(jcbCurso.getSelectedItem().toString());
						dao.incluir(model);
					} else {
						dao.alterarDisciplina(model, AuxClass.getAux2());
						
					}
					carrefartabela();
				}
			});
		}
		return jbtSalvar;
	}

	private JButton getJbtNovo() {
		if (jbtNovo == null) {
			jbtNovo = new JButton("Novo");
			jbtNovo.setForeground(Color.WHITE);
			jbtNovo.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtNovo.setBackground(new Color(0, 153, 51));
			jbtNovo.setBounds(20, 516, 122, 38);
		}
		return jbtNovo;
	}

	private JTextField getTextField() {
		if (jtfBusca == null) {
			jtfBusca = new JTextField();
			jtfBusca.setColumns(10);
			jtfBusca.setBounds(92, 36, 377, 28);
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
			jbtAlterar.setForeground(Color.WHITE);
			jbtAlterar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtAlterar.setBackground(new Color(0, 153, 51));
			jbtAlterar.setBounds(25, 524, 122, 38);
			jbtAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AuxClass.setVal(true);
					DefaultTableModel tableModel = (
					DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					AuxClass.setAux2(tableModel.getValueAt(row, 0).toString());
					DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
					disciplinaDAO.buscarAlteracoes();
					List<DisciplinaModel> dados = disciplinaDAO.buscarAlteracoes();
					for (DisciplinaModel dm : dados) {
						jtfNome.setText(dm.getNome());
						jcbCurso.setSelectedItem(dm.getNomeCurso());
						jtaEmenta.setText(dm.getEmenta());
						
					}
					
					
				}
			});
		}
		return jbtAlterar;

	}

	private JButton getJbtDeletar() {
		if (jbtDeletar == null) {
			jbtDeletar = new JButton("Deletar");
			jbtDeletar.setForeground(Color.WHITE);
			jbtDeletar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtDeletar.setBackground(new Color(0, 153, 51));
			jbtDeletar.setBounds(157, 524, 122, 38);
			jbtDeletar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
					DefaultTableModel tableModel = (DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					disciplinaDAO.exclui_disciplina(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
					carrefartabela();
				}
			});
		}
		return jbtDeletar;
	}

	private JScrollPane getJspTabela() {
		if (jspTabela == null) {
			jspTabela = new JScrollPane();
			jspTabela.setBounds(25, 70, 444, 443);
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
					"Id:", "Disciplina:", "Curso:"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			jtTabela.getColumnModel().getColumn(0).setPreferredWidth(38);
			jtTabela.getColumnModel().getColumn(1).setResizable(false);
			jtTabela.getColumnModel().getColumn(1).setPreferredWidth(260);
			jtTabela.getColumnModel().getColumn(2).setResizable(false);
			jtTabela.getColumnModel().getColumn(2).setPreferredWidth(260);
		}
		return jtTabela;
	}
	private JComboBox getJcbCurso() {
		if (jcbCurso == null) {
			jcbCurso = new JComboBox();
			jcbCurso.setBounds(91, 66, 274, 28);
			
		}
		return jcbCurso;
	}
}
