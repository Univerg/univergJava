package br.edu.ifsc.univerg.gui;


import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.towel.swing.img.JImagePanel;

import br.edu.ifsc.univerg.gui.InternalFrames.IFAvaliacoes;
import br.edu.ifsc.univerg.gui.InternalFrames.IFEmentas;
import br.edu.ifsc.univerg.gui.InternalFrames.IFNotas;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAluno extends JFrame {

	private JImagePanel contentPane;
	private JButton jbtAvaliacoes;
	private JButton jbtEmentas;
	private JButton jbtNotas;
	private JImagePanel jpBotoes;
	private JImagePanel jpPanel;
	private JButton jbtSair;


	public FrameAluno() throws Throwable{
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

	private JButton getJbtAvaliacoes() {
		if (jbtAvaliacoes == null) {
			jbtAvaliacoes = new JButton("Avaliações");
			jbtAvaliacoes.setBounds(0, 0, 183, 45);
			jbtAvaliacoes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IFAvaliacoes test;
					try {
						jpPanel.removeAll();
						test = new IFAvaliacoes();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			jbtAvaliacoes.setForeground(new Color(255, 255, 255));
			jbtAvaliacoes.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtAvaliacoes.setBackground(new Color(0, 153, 51));
		}
		return jbtAvaliacoes;
	}
	private JButton getJbtEmentas() {
		if (jbtEmentas == null) {
			jbtEmentas = new JButton("Ementas");
			jbtEmentas.setBounds(0, 51, 183, 45);
			jbtEmentas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					IFEmentas test;
					try {
						jpPanel.removeAll();
						test = new IFEmentas();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jbtEmentas.setForeground(new Color(255, 255, 255));
			jbtEmentas.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtEmentas.setBackground(new Color(0, 153, 51));
		}
		return jbtEmentas;
	}
	private JButton getJbtNotas() {
		if (jbtNotas == null) {
			jbtNotas = new JButton("Notas");
			jbtNotas.setBounds(0, 102, 183, 45);
			jbtNotas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IFNotas test;
					try {
						jpPanel.removeAll();
						test = new IFNotas();
						jpPanel.add(test);
						test.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			jbtNotas.setForeground(new Color(255, 255, 255));
			jbtNotas.setFont(new Font("SansSerif", Font.BOLD, 13));
			jbtNotas.setBackground(new Color(0, 153, 51));
		}
		return jbtNotas;
	}
	private JImagePanel getJpBotoes()  throws Throwable{
		if (jpBotoes == null) {
			jpBotoes = new JImagePanel((loadImage("bot.jpg")));
			jpBotoes.setLayout(null);
			jpBotoes.add(getJbtAvaliacoes());
			jpBotoes.add(getJbtEmentas());
			jpBotoes.add(getJbtNotas());
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
					} catch (Throwable g) {
						// TODO Auto-generated catch block
						g.printStackTrace();
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
