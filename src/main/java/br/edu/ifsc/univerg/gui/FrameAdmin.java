package br.edu.ifsc.univerg.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import com.towel.swing.img.JImagePanel;

import br.edu.ifsc.univerg.gui.InternalFrames.IFGerenciarAdmin;
import br.edu.ifsc.univerg.gui.InternalFrames.IFGerenciarAluno;
import br.edu.ifsc.univerg.gui.InternalFrames.IFGerenciarAvaliacoes;
import br.edu.ifsc.univerg.gui.InternalFrames.IFGerenciarCursos;
import br.edu.ifsc.univerg.gui.InternalFrames.IFGerenciarDisciplina;
import br.edu.ifsc.univerg.gui.InternalFrames.IFGerenciarNotas;
import br.edu.ifsc.univerg.gui.InternalFrames.IFGerenciarProfessor;
import br.edu.ifsc.univerg.gui.InternalFrames.IFGerenciarTurmas;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAdmin extends JFrame {

	private JImagePanel contentPane;
	private JButton jbtGerenciarAdmin;
	private JButton jbtGerenciarAluno;
	private JButton jbtGerenciarProfessor;
	private JButton jbtGerenciarTurma;
	private JButton jbtGerenciarAvaliacao;
	private JButton jbtGerenciarCurso;
	private JButton jbtGerenciarFrequencia;
	private JButton jbtGerenciarDisciplina;
	private JImagePanel jpBotoes;
	private JImagePanel jpPanel;
	private JButton jbtSair;


	public FrameAdmin() throws Throwable{
		setUndecorated(true);
		setTitle("Login - UNIVERG");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JImagePanel(loadImage("back.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(getJpBotoes(), GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addComponent(getJpPanel(), GroupLayout.PREFERRED_SIZE, 1045, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(getJpBotoes(), GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(50, Short.MAX_VALUE)
					.addComponent(getJpPanel(), GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private static BufferedImage loadImage(String file) throws IOException {
		return ImageIO.read(new File(file));
	}

	private JButton getJbtGerenciarAdmin() {
		if (jbtGerenciarAdmin == null) {
			jbtGerenciarAdmin = new JButton("Gerenciar Admin");
			jbtGerenciarAdmin.setBounds(0, 0, 183, 45);
			jbtGerenciarAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					IFGerenciarAdmin test;
					try {
						test = new IFGerenciarAdmin();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
			});
			jbtGerenciarAdmin.setForeground(new Color(255, 255, 255));
			jbtGerenciarAdmin.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtGerenciarAdmin.setBackground(new Color(0, 153, 51));
		}
		return jbtGerenciarAdmin;
	}
	private JButton getJbtGerenciarAluno() {
		if (jbtGerenciarAluno == null) {
			jbtGerenciarAluno = new JButton("Gerenciar Aluno");
			jbtGerenciarAluno.setBounds(0, 51, 183, 45);
			jbtGerenciarAluno.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					IFGerenciarAluno test;
					try {
						test = new IFGerenciarAluno();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
			});
			jbtGerenciarAluno.setForeground(new Color(255, 255, 255));
			jbtGerenciarAluno.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtGerenciarAluno.setBackground(new Color(0, 153, 51));
		}
		return jbtGerenciarAluno;
	}
	private JButton getJbtGerenciarProfessor() {
		if (jbtGerenciarProfessor == null) {
			jbtGerenciarProfessor = new JButton("Gerenciar Professor");
			jbtGerenciarProfessor.setBounds(0, 102, 183, 45);
			jbtGerenciarProfessor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					IFGerenciarProfessor test;
					try {
						test = new IFGerenciarProfessor();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jbtGerenciarProfessor.setForeground(new Color(255, 255, 255));
			jbtGerenciarProfessor.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtGerenciarProfessor.setBackground(new Color(0, 153, 51));
		}
		return jbtGerenciarProfessor;
	}
	private JButton getJbtGerenciarTurma() {
		if (jbtGerenciarTurma == null) {
			jbtGerenciarTurma = new JButton("Gerenciar Turma");
			jbtGerenciarTurma.setBounds(0, 153, 183, 45);
			jbtGerenciarTurma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					IFGerenciarTurmas test;
					try {
						test = new IFGerenciarTurmas();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jbtGerenciarTurma.setForeground(new Color(255, 255, 255));
			jbtGerenciarTurma.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtGerenciarTurma.setBackground(new Color(0, 153, 51));
		}
		return jbtGerenciarTurma;
	}
	private JButton getJbtGerenciarAvaliacao() {
		if (jbtGerenciarAvaliacao == null) {
			jbtGerenciarAvaliacao = new JButton("Gerenciar Avaliação");
			jbtGerenciarAvaliacao.setBounds(0, 204, 183, 45);
			jbtGerenciarAvaliacao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IFGerenciarAvaliacoes test;
					try {
						test = new IFGerenciarAvaliacoes();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jbtGerenciarAvaliacao.setForeground(new Color(255, 255, 255));
			jbtGerenciarAvaliacao.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtGerenciarAvaliacao.setBackground(new Color(0, 153, 51));
		}
		return jbtGerenciarAvaliacao;
	}
	private JButton getJbtGerenciarCurso() {
		if (jbtGerenciarCurso == null) {
			jbtGerenciarCurso = new JButton("Gerenciar Curso");
			jbtGerenciarCurso.setBounds(0, 255, 183, 45);
			jbtGerenciarCurso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IFGerenciarCursos test;
					try {
						test = new IFGerenciarCursos();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			jbtGerenciarCurso.setForeground(new Color(255, 255, 255));
			jbtGerenciarCurso.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtGerenciarCurso.setBackground(new Color(0, 153, 51));
		}
		return jbtGerenciarCurso;
	}
	private JButton getJbtGerenciarFrequencia() {
		if (jbtGerenciarFrequencia == null) {
			jbtGerenciarFrequencia = new JButton("Gerenciar Notas");
			jbtGerenciarFrequencia.setBounds(0, 311, 183, 45);
			jbtGerenciarFrequencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IFGerenciarNotas test;
					try {
						test = new IFGerenciarNotas();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jbtGerenciarFrequencia.setForeground(new Color(255, 255, 255));
			jbtGerenciarFrequencia.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtGerenciarFrequencia.setBackground(new Color(0, 153, 51));
		}
		return jbtGerenciarFrequencia;
	}
	private JButton getJbtGerenciarDisciplina() {
		if (jbtGerenciarDisciplina == null) {
			jbtGerenciarDisciplina = new JButton("Gerenciar Disciplina");
			jbtGerenciarDisciplina.setBounds(0, 367, 183, 45);
			jbtGerenciarDisciplina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IFGerenciarDisciplina test;
					try {
						test = new IFGerenciarDisciplina();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			jbtGerenciarDisciplina.setForeground(new Color(255, 255, 255));
			jbtGerenciarDisciplina.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtGerenciarDisciplina.setBackground(new Color(0, 153, 51));
		}
		return jbtGerenciarDisciplina;
	}
	private JImagePanel getJpBotoes()  throws Throwable{
		if (jpBotoes == null) {
			jpBotoes = new JImagePanel((loadImage("bot.jpg")));
			jpBotoes.setLayout(null);
			jpBotoes.add(getJbtGerenciarAdmin());
			jpBotoes.add(getJbtGerenciarAluno());
			jpBotoes.add(getJbtGerenciarProfessor());
			jpBotoes.add(getJbtGerenciarTurma());
			jpBotoes.add(getJbtGerenciarAvaliacao());
			jpBotoes.add(getJbtGerenciarCurso());
			jpBotoes.add(getJbtGerenciarDisciplina());
			jpBotoes.add(getJbtGerenciarFrequencia());
			jpBotoes.add(getJbtSair());
		}
		return jpBotoes;
	}
	private JImagePanel getJpPanel() throws Throwable{
		if (jpPanel == null) {
			jpPanel = new JImagePanel(loadImage("panel1.png"));
			jpPanel.setLayout(new BorderLayout(0, 0));
		}
		return jpPanel;
	}
	private JButton getJbtSair() {
		if (jbtSair == null) {
			jbtSair = new JButton("Sair");
			jbtSair.setBounds(0, 691, 183, 45);
			jbtSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					try {
						new FrameSelecao().setVisible(true);;
					} catch (Throwable f) {
						// TODO Auto-generated catch block
						f.printStackTrace();
					}
					
				}
			});
			jbtSair.setForeground(Color.WHITE);
			jbtSair.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtSair.setBackground(new Color(0, 153, 51));
		}
		return jbtSair;
	}
}