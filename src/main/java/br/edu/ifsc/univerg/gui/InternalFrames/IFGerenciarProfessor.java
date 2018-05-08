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
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

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
	private JTextField textField;
	private JLabel jlBuscar;
	private JTextField jtfId;
	private JLabel jlId;
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
	private JTextField jtfNasc;
	private JLabel jlEspecializacao;
	private JLabel jlMatricula;
	private JTextField jtfMatricula;
	private JTextField jtfEspecializacao;

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
			jpCadastro.add(getJtfId());
			jpCadastro.add(getJlId());
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
			jpCadastro.add(getJtfNasc());
			jpCadastro.add(getJlEspecializacao());
			jpCadastro.add(getJlMatricula());
			jpCadastro.add(getJtfMatricula());
			jpCadastro.add(getJtfEspecializacao());
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
		}
		return jtfNome;
	}
	private JTextField getJtfLogin() {
		if (jtfLogin == null) {
			jtfLogin = new JTextField();
			jtfLogin.setColumns(10);
			jtfLogin.setBounds(85, 182, 180, 28);
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
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(92, 36, 621, 28);
		}
		return textField;
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
			jtfCep.setColumns(10);
			jtfCep.setBounds(822, 66, 122, 28);
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
			jtfEndereco.setBounds(270, 106, 180, 28);
		}
		return jtfEndereco;
	}
	private JLabel getJlbEndereo() {
		if (jlbEndereo == null) {
			jlbEndereo = new JLabel("Endereço:");
			jlbEndereo.setForeground(new Color(0, 153, 51));
			jlbEndereo.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbEndereo.setBounds(203, 112, 73, 16);
		}
		return jlbEndereo;
	}
	private JTextField getJtfCidade() {
		if (jtfCidade == null) {
			jtfCidade = new JTextField();
			jtfCidade.setColumns(10);
			jtfCidade.setBounds(517, 106, 180, 28);
		}
		return jtfCidade;
	}
	private JLabel getJlbCidade() {
		if (jlbCidade == null) {
			jlbCidade = new JLabel("Cidade:");
			jlbCidade.setForeground(new Color(0, 153, 51));
			jlbCidade.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbCidade.setBounds(462, 112, 67, 16);
		}
		return jlbCidade;
	}
	private JLabel getJlbEmail() {
		if (jlbEmail == null) {
			jlbEmail = new JLabel("Email:");
			jlbEmail.setForeground(new Color(0, 153, 51));
			jlbEmail.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlbEmail.setBounds(709, 112, 67, 16);
		}
		return jlbEmail;
	}
	private JTextField getJtfEmail() {
		if (jtfEmail == null) {
			jtfEmail = new JTextField();
			jtfEmail.setColumns(10);
			jtfEmail.setBounds(764, 106, 180, 28);
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
	private JTextField getJtfNasc() {
		if (jtfNasc == null) {
			jtfNasc = new JTextField();
			jtfNasc.setColumns(10);
			jtfNasc.setBounds(88, 106, 103, 28);
		}
		return jtfNasc;
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
	private JLabel getJlMatricula() {
		if (jlMatricula == null) {
			jlMatricula = new JLabel("Matricula:");
			jlMatricula.setForeground(new Color(0, 153, 51));
			jlMatricula.setFont(new Font("SansSerif", Font.BOLD, 13));
			jlMatricula.setBounds(573, 146, 73, 16);
		}
		return jlMatricula;
	}
	private JTextField getJtfMatricula() {
		if (jtfMatricula == null) {
			jtfMatricula = new JTextField();
			jtfMatricula.setEditable(false);
			jtfMatricula.setColumns(10);
			jtfMatricula.setBounds(660, 139, 284, 28);
		}
		return jtfMatricula;
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
