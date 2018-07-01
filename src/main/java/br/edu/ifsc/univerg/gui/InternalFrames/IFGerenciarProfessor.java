package br.edu.ifsc.univerg.gui.InternalFrames;
import javax.swing.JInternalFrame;
import com.towel.swing.img.JImagePanel;
import br.edu.ifsc.univerg.dao.ProfessorDAO;
import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.ProfessorModel;
import br.edu.ifsc.univerg.model.ValidarLetra;
import br.edu.ifsc.univerg.model.ValidarNum;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

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
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import com.toedter.calendar.JDateChooser;

public class IFGerenciarProfessor extends JInternalFrame {
	private JImagePanel imagePanel;
	private JImagePanel jpCadastro;
	private JImagePanel jpRemoverAtualizar;
	private JButton jbVoltar;
	private JTextField jtfNome;
	private JTextField jtfLogin;
	private JPasswordField jtfSenha;
	private JLabel jlbNome;
	private JLabel jlbLogin;
	private JLabel jlbSenha;
	private JButton jbtSalvar;
	private JButton jbtNovo;
	private JTextField jtfBusca;
	private JLabel jlBuscar;
	private JButton jbtAlterar;
	private JButton jbtDeletar;
	private JScrollPane jspTabela;
	private JTable jtTabela;
	private JPasswordField jtfSenha2;
	private JLabel jlCpf;
	private JTextField jtfCpf;
	private JTextField jtfRg;
	private JLabel jlRg;
	private JTextField jtfTelefone;
	private JLabel jlTelefone;
	private JTextField jtfCep;
	private JLabel jlCep;
	private JTextField jtfEndereco;
	private JLabel jlbEndereo;
	private JTextField jtfCidade;
	private JLabel jlbCidade;
	private JLabel jlbEmail;
	private JTextField jtfEmail;
	private JLabel jlNasc;
	private JLabel jlEspecializacao;
	private JTextField jtfEspecializacao;
	private TableRowSorter<TableModel> rowSorter;
	private JDateChooser jtfNasc;
	private MaskFormatter Maskara;
	private String aux;


	
	private void mask() {
		try {
			Maskara = new MaskFormatter(aux);
			Maskara.setValidCharacters("0123456789");
			Maskara.setPlaceholderCharacter('_');

		} catch (Exception error_mask) {
			JOptionPane.showMessageDialog(null, "Erro: " + error_mask);
		}

	}

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 * @throws Throwable 
	 */
	public IFGerenciarProfessor() throws Throwable {
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setBounds(100, 100, 1070, 676);
		getContentPane().setLayout(null);
		getContentPane().add(getImagePanel());
		rowSorter = new TableRowSorter<TableModel>(jtTabela.getModel());
		jtTabela.setRowSorter(rowSorter);
		tabela();
	}
	public void tabela(){
		ProfessorDAO professor = new ProfessorDAO();
		DefaultTableModel model = (DefaultTableModel) jtTabela.getModel();

		// limpa a tabela
		model.setRowCount(0);
		 List<ProfessorModel> dados = professor.selectProfessor();

		// carrega pessoas da lista
		for (ProfessorModel pr : dados) {
			// inclui uma linha na tabela
			model.addRow(
					new Object[] { pr.getNome(), pr.getMatricula() });
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
			jpCadastro.setBorder(new TitledBorder(null, "Cadastro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpCadastro.setBounds(19, 29, 1008, 267);
			jpCadastro.setLayout(null);
			jpCadastro.add(getJtfNome());
			jpCadastro.add(getJtfLogin());
			jpCadastro.add(getJtfSenha());
			jpCadastro.add(getJlbNome());
			jpCadastro.add(getJlbLogin());
			jpCadastro.add(getJlbSenha());
			jpCadastro.add(getJbtSalvar());
			jpCadastro.add(getJbtNovo());
			jpCadastro.add(getJtfSenha2());
			jpCadastro.add(getJlCpf());
			jpCadastro.add(getJtfCpf());
			jpCadastro.add(getJtfRg());
			jpCadastro.add(getJlRg());
			jpCadastro.add(getJtfTelefone());
			jpCadastro.add(getJlTelefone());
			jpCadastro.add(getJtfCep());
			jpCadastro.add(getJlCep());
			jpCadastro.add(getJtfEndereco());
			jpCadastro.add(getJlbEndereo());
			jpCadastro.add(getJtfCidade());
			jpCadastro.add(getJlbCidade());
			jpCadastro.add(getJlbEmail());
			jpCadastro.add(getJtfEmail());
			jpCadastro.add(getJlNasc());
			jpCadastro.add(getJlEspecializacao());
			jpCadastro.add(getJtfEspecializacao());
			jpCadastro.add(getJtfNasc());
			

		}
		return jpCadastro;
	}
	private JImagePanel getJpRemoverAtualizar()  throws IOException{
		if (jpRemoverAtualizar == null) {
			jpRemoverAtualizar = new JImagePanel(loadImage("panel.png"));
			jpRemoverAtualizar.setBorder(new TitledBorder(null, "Atualizar / Remover", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
			jpRemoverAtualizar.setBounds(19, 308, 1008, 300);
			jpRemoverAtualizar.setLayout(null);
			jpRemoverAtualizar.add(getTextField());
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
			jtfNome.setBounds(88, 66, 180, 28);
			jtfNome.setColumns(10);
			jtfNome.setDocument(new ValidarLetra(50));
		}
		return jtfNome;
	}
	private JTextField getJtfLogin() {
		if (jtfLogin == null) {
			jtfLogin = new JTextField();
			jtfLogin.setColumns(10);
			jtfLogin.setBounds(85, 182, 180, 28);
			jtfLogin.setDocument(new ValidarNum(20));
		}
		return jtfLogin;
	}
	private JPasswordField getJtfSenha() {
		if (jtfSenha == null) {
			jtfSenha = new JPasswordField();
			jtfSenha.setBounds(85, 222, 180, 28);
		}
		return jtfSenha;
	}
	private JLabel getJlbNome() {
		if (jlbNome == null) {
			jlbNome = new JLabel("Nome:");
			jlbNome.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbNome.setForeground(new Color(0, 153, 51));
			jlbNome.setBounds(21, 72, 55, 16);
		}
		return jlbNome;
	}
	private JDateChooser getJtfNasc() {
		if(jtfNasc==null) {
			jtfNasc = new JDateChooser();
			jtfNasc.setBounds(88, 105, 143, 28);
			
		}
		return jtfNasc;
	}
	private JLabel getJlbLogin() {
		if (jlbLogin == null) {
			jlbLogin = new JLabel("Login:");
			jlbLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbLogin.setForeground(new Color(0, 153, 51));
			jlbLogin.setBounds(21, 188, 52, 16);
		}
		return jlbLogin;
	}
	private JLabel getJlbSenha() {
		if (jlbSenha == null) {
			jlbSenha = new JLabel("Senha:");
			jlbSenha.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbSenha.setForeground(new Color(0, 153, 51));
			jlbSenha.setBounds(18, 228, 55, 16);
			////
		}
		return jlbSenha;
	}
	private JButton getJbtSalvar() {
		if (jbtSalvar == null) {
			jbtSalvar = new JButton("Salvar");
			jbtSalvar.setForeground(Color.WHITE);
			jbtSalvar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtSalvar.setBackground(new Color(0, 153, 51));
			jbtSalvar.setBounds(860, 212, 122, 38);
			jbtSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String senha1 = new String (jtfSenha.getPassword());
					String senha2=  new String (jtfSenha2.getPassword());
					String validarcpf= jtfCpf.getText().replaceAll("()_-.", "");
					String validarfone=jtfTelefone.getText().replaceAll("()_-.", "");
					String validarcep=jtfCep.getText().replaceAll("()_-.", "");
					
					
					if(jtfNome.getText().trim().isEmpty() || validarcpf.length()!=14 || jtfRg.getText().trim().isEmpty()||
							validarfone.length()!=15|| validarcep.length()!=10 ||  sdf.format(jtfNasc.getDate().getTime()).trim().isEmpty() ||
							jtfEndereco.getText().trim().isEmpty() || jtfCidade.getText().trim().isEmpty() || jtfEmail.getText().trim().isEmpty() ||
							jtfEspecializacao.getText().trim().isEmpty() || jtfLogin.getText().trim().isEmpty() || jtfSenha.getText().trim().isEmpty()|| jtfSenha2.getText().trim().isEmpty()){
						JOptionPane.showMessageDialog(null, "Preencha todos dos campos!");
						}
					
					ProfessorModel professor = new ProfessorModel(jtfNome.getText(),
							jtfCpf.getText(), 
							jtfRg.getText(), 
							jtfTelefone.getText(), 
							jtfCep.getText(), 
							sdf.format(jtfNasc.getDate().getTime()), 
							jtfEndereco.getText(), 
							jtfCidade.getText(), 
							jtfEmail.getText(), 
							jtfEspecializacao.getText(), 
							jtfLogin.getText(), 
							String.valueOf(jtfSenha.getPassword())
							);
					ProfessorDAO professorDao = new ProfessorDAO();
					if (AuxClass.getVal()!=true){
					try {
						
						professorDao.incluir(professor);
						tabela();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
					else {
						
						try {

							professorDao.alterarProfessor(professor,AuxClass.getAux());
							tabela();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					new AuxClass();
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
			jbtNovo.setBounds(726, 212, 122, 38);
		}
		return jbtNovo;
	}
	private JTextField getTextField() {
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
				public void actionPerformed(ActionEvent e) {
					AuxClass.setVal(true);
					DefaultTableModel tableModel = (
					DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					AuxClass.setAux(tableModel.getValueAt(row, 1).toString());
					ProfessorDAO professor = new ProfessorDAO();
					professor.buscarAlteracoes();
					 List<ProfessorModel> dados = professor.buscarAlteracoes();
					 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						// carrega pessoas da lista
					 //test
					 //
						for (ProfessorModel pr : dados) {
							// inclui uma linha na tabela
							
							try {
								jtfNome.setText( pr.getNome());
								jtfCpf.setText(pr.getCpf());
								jtfRg.setText(pr.getRg());
								jtfTelefone.setText(pr.getFone());
								jtfCep.setText(pr.getCep());
								jtfNasc.setDate(sdf.parse(pr.getNascimento()));
								jtfEndereco.setText(pr.getEndereco());
								jtfCidade.setText(pr.getCidade());
								jtfEmail.setText(pr.getEmail());
								jtfEspecializacao.setText(pr.getEspecializacao());
								jtfLogin.setText(pr.getLogin());
								jtfSenha.setText(pr.getSenha());
							} catch (ParseException e1) {
								JOptionPane erro = new JOptionPane(e1,JOptionPane.ERROR_MESSAGE);
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
					ProfessorDAO professor = new ProfessorDAO();
					DefaultTableModel tableModel = (DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					professor.excluir_Professor(tableModel.getValueAt(row, 1).toString());
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
					"Nome:", "Matricula:"
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
	private JPasswordField getJtfSenha2() {
		if (jtfSenha2 == null) {
			jtfSenha2 = new JPasswordField();
			jtfSenha2.setBounds(277, 222, 180, 28);
		}
		return jtfSenha2;
	}
	private JLabel getJlCpf() {
		if (jlCpf == null) {
			jlCpf = new JLabel("CPF:");
			jlCpf.setForeground(new Color(0, 153, 51));
			jlCpf.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlCpf.setBounds(280, 72, 35, 16);
		}
		return jlCpf;
	}
	private JTextField getJtfCpf() {
		if (jtfCpf == null) {
			jtfCpf = new JTextField();
			aux = ("###.###.###-##");
			mask();
			jtfCpf= new javax.swing.JFormattedTextField(Maskara);
			jtfCpf.setColumns(10);
			jtfCpf.setBounds(315, 66, 122, 28);
		}
		return jtfCpf;
	}
	private JTextField getJtfRg() {
		if (jtfRg == null) {
			jtfRg = new JTextField();
			jtfRg.setColumns(10);
			jtfRg.setBounds(476, 66, 122, 28);
			jtfRg.setDocument(new ValidarNum(12));
			
		}
		return jtfRg;
	}
	private JLabel getJlRg() {
		if (jlRg == null) {
			jlRg = new JLabel("RG:");
			jlRg.setForeground(new Color(0, 153, 51));
			jlRg.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlRg.setBounds(449, 72, 23, 16);
		}
		return jlRg;
	}
	private JTextField getJtfTelefone() {
		if (jtfTelefone == null) {
			jtfTelefone = new JTextField();
			aux = ("(###)#####-####");
			mask();
			jtfTelefone= new javax.swing.JFormattedTextField(Maskara);
			jtfTelefone.setColumns(10);
			jtfTelefone.setBounds(649, 66, 122, 28);
		}
		return jtfTelefone;
	}
	private JLabel getJlTelefone() {
		if (jlTelefone == null) {
			jlTelefone = new JLabel("Fone:");
			jlTelefone.setForeground(new Color(0, 153, 51));
			jlTelefone.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlTelefone.setBounds(610, 72, 36, 16);
		}
		return jlTelefone;
	}
	private JTextField getJtfCep() {
		if (jtfCep == null) {
			jtfCep = new JTextField();
			aux = ("##.###-###");
			mask();
			jtfCep= new javax.swing.JFormattedTextField(Maskara);
			jtfCep.setColumns(10);
			jtfCep.setBounds(822, 66, 160, 28);
		}
		return jtfCep;
	}
	private JLabel getJlCep() {
		if (jlCep == null) {
			jlCep = new JLabel("CEP:");
			jlCep.setForeground(new Color(0, 153, 51));
			jlCep.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlCep.setBounds(783, 72, 36, 16);
		}
		return jlCep;
	}
	private JTextField getJtfEndereco() {
		if (jtfEndereco == null) {
			jtfEndereco = new JTextField();
			jtfEndereco.setColumns(10);
			jtfEndereco.setBounds(308, 103, 180, 28);
		}
		return jtfEndereco;
	}
	private JLabel getJlbEndereo() {
		if (jlbEndereo == null) {
			jlbEndereo = new JLabel("Endereço:");
			jlbEndereo.setForeground(new Color(0, 153, 51));
			jlbEndereo.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbEndereo.setBounds(241, 109, 73, 16);
		}
		return jlbEndereo;
	}
	private JTextField getJtfCidade() {
		if (jtfCidade == null) {
			jtfCidade = new JTextField();
			jtfCidade.setColumns(10);
			jtfCidade.setBounds(555, 103, 180, 28);
			jtfCidade.setDocument(new ValidarLetra(50));
		}
		return jtfCidade;
	}
	private JLabel getJlbCidade() {
		if (jlbCidade == null) {
			jlbCidade = new JLabel("Cidade:");
			jlbCidade.setForeground(new Color(0, 153, 51));
			jlbCidade.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbCidade.setBounds(500, 109, 67, 16);
		}
		return jlbCidade;
	}
	private JLabel getJlbEmail() {
		if (jlbEmail == null) {
			jlbEmail = new JLabel("Email:");
			jlbEmail.setForeground(new Color(0, 153, 51));
			jlbEmail.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbEmail.setBounds(747, 109, 67, 16);
		}
		return jlbEmail;
	}
	private JTextField getJtfEmail() {
		if (jtfEmail == null) {
			jtfEmail = new JTextField();
			jtfEmail.setColumns(10);
			jtfEmail.setBounds(802, 103, 180, 28);
		}
		return jtfEmail;
	}
	private JLabel getJlNasc() {
		if (jlNasc == null) {
			jlNasc = new JLabel("Nasc:");
			jlNasc.setForeground(new Color(0, 153, 51));
			jlNasc.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlNasc.setBounds(21, 112, 73, 16);
		}
		return jlNasc;
	}
	private JLabel getJlEspecializacao() {
		if (jlEspecializacao == null) {
			jlEspecializacao = new JLabel("Especialização:");
			jlEspecializacao.setForeground(new Color(0, 153, 51));
			jlEspecializacao.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlEspecializacao.setBounds(21, 140, 103, 30);
		}
		return jlEspecializacao;
	}
	private JTextField getJtfEspecializacao() {
		if (jtfEspecializacao == null) {
			jtfEspecializacao = new JTextField();
			jtfEspecializacao.setColumns(10);
			jtfEspecializacao.setBounds(125, 142, 434, 28);
		}
		return jtfEspecializacao;
	}
}
