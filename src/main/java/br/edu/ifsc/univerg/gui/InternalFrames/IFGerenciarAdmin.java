package br.edu.ifsc.univerg.gui.InternalFrames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import com.towel.swing.img.JImagePanel;

import br.edu.ifsc.univerg.dao.adminDAO;
import br.edu.ifsc.univerg.model.AdminModel;
import br.edu.ifsc.univerg.model.AuxClass;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

public class IFGerenciarAdmin extends JInternalFrame {
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
	private JTextField jtfId;
	private JLabel jlId;
	private JButton jbtAlterar;
	private JButton jbtDeletar;
	private JScrollPane jspTabela;
	private JTable jtTabela;
	private JPasswordField jtfSenha2;
	private TableRowSorter<TableModel> rowSorter;


	public IFGerenciarAdmin() throws Throwable {
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setBounds(100, 100, 1070, 676);
		getContentPane().setLayout(null);
		getContentPane().add(getImagePanel());
		rowSorter = new TableRowSorter<TableModel>(jtTabela.getModel());
		jtTabela.setRowSorter(rowSorter);
		carrefartabela();

	}

	private void carrefartabela() {

		adminDAO admin = new adminDAO();
		DefaultTableModel model = (DefaultTableModel) jtTabela.getModel();

		// limpa a tabela
		model.setRowCount(0);
		List<AdminModel> dados = admin.selectAdmin();

		// carrega pessoas da lista
		for (AdminModel am : dados) {
			// inclui uma linha na tabela
			model.addRow(new Object[] { am.getNome(), am.getLogin(), am.getSenha() });
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

	private JImagePanel getJpCadastro() throws IOException {
		if (jpCadastro == null) {
			jpCadastro = new JImagePanel(loadImage("panel.png"));
			jpCadastro.setBorder(new TitledBorder(null, "Cadastro", TitledBorder.LEADING, TitledBorder.TOP, null,
					new Color(0, 153, 51)));
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
			jpCadastro.add(getJtfId());
			jpCadastro.add(getJlId());
			jpCadastro.add(getJtfSenha2());
		}
		return jpCadastro;
	}

	private JImagePanel getJpRemoverAtualizar() throws IOException {
		if (jpRemoverAtualizar == null) {
			jpRemoverAtualizar = new JImagePanel(loadImage("panel.png"));
			jpRemoverAtualizar.setBorder(new TitledBorder(null, "Atualizar / Remover", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 153, 51)));
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
			jtfNome.setBounds(88, 66, 908, 28);
			jtfNome.setColumns(10);
		}
		return jtfNome;
	}

	private JTextField getJtfLogin() {
		if (jtfLogin == null) {
			jtfLogin = new JTextField();
			jtfLogin.setColumns(10);
			jtfLogin.setBounds(88, 106, 908, 28);
		}
		return jtfLogin;
	}

	private JPasswordField getJtfSenha() {
		if (jtfSenha == null) {
			jtfSenha = new JPasswordField();
			jtfSenha.setBounds(88, 146, 445, 28);
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

	private JLabel getJlbLogin() {
		if (jlbLogin == null) {
			jlbLogin = new JLabel("Login:");
			jlbLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbLogin.setForeground(new Color(0, 153, 51));
			jlbLogin.setBounds(21, 112, 55, 16);
		}
		return jlbLogin;
	}

	private JLabel getJlbSenha() {
		if (jlbSenha == null) {
			jlbSenha = new JLabel("Senha:");
			jlbSenha.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbSenha.setForeground(new Color(0, 153, 51));
			jlbSenha.setBounds(21, 152, 55, 16);
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
					adminDAO dao = new adminDAO();
					AdminModel admin = new AdminModel(jtfNome.getText(), jtfLogin.getText(),
							String.valueOf(jtfSenha.getPassword()));

					if (AuxClass.getVal() != true) {
						dao.incluir(admin);
						carrefartabela();
					} else {
						dao.alterarAdmin(admin, AuxClass.getAux());
						carrefartabela();
					}
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

	private JTextField getJtfId() {
		if (jtfId == null) {
			jtfId = new JTextField();
			jtfId.setEditable(false);
			jtfId.setColumns(10);
			jtfId.setBounds(88, 26, 94, 28);
		}
		return jtfId;
	}

	private JLabel getJlId() {
		if (jlId == null) {
			jlId = new JLabel("Id:");
			jlId.setForeground(new Color(0, 153, 51));
			jlId.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlId.setBounds(21, 32, 55, 16);
		}
		return jlId;
	}

	private JButton getJbtAlterar() {
		if (jbtAlterar == null) {
			jbtAlterar = new JButton("Alterar");
			jbtAlterar.setForeground(Color.WHITE);
			jbtAlterar.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtAlterar.setBackground(new Color(0, 153, 51));
			jbtAlterar.setBounds(725, 24, 122, 38);
			jbtAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					AuxClass.setVal(true);
					DefaultTableModel tableModel = (
					DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					AuxClass.setAux(tableModel.getValueAt(row, 1).toString());
					adminDAO admin = new adminDAO();
					admin.buscarAlteracoes();
					List<AdminModel> dados = admin.buscarAlteracoes();
					for (AdminModel adm : dados) {
						jtfNome.setText(adm.getNome());
						jtfLogin.setText(adm.getLogin());
						jtfSenha.setText(adm.getSenha());
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
			jbtDeletar.setBounds(860, 24, 122, 38);
			jbtDeletar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					adminDAO ad = new adminDAO();
					DefaultTableModel tableModel = (DefaultTableModel) jtTabela.getModel();
					int row = jtTabela.getSelectedRow();
					ad.excluirAdmin(tableModel.getValueAt(row, 1).toString());
					carrefartabela();

				}
			});
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
			jtTabela.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome:", "Login:" }) {
				Class[] columnTypes = new Class[] { String.class, String.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] { false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
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
			jtfSenha2.setBounds(551, 146, 445, 28);
		}
		return jtfSenha2;
	}
}
