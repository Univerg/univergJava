package br.edu.ifsc.univerg.gui;

import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import com.towel.swing.img.JImagePanel;

import br.edu.ifsc.univerg.model.AuxClass;

import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FrameSelecao extends JFrame {

	private JImagePanel contentPane;
	private JLabel jlAdmin;
	private JLabel jlProfessor;
	private JLabel jlAluno;


	public FrameSelecao() throws Throwable {
		setUndecorated(true);
		setTitle("Seleção - UNIVERG");
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
					.addGap(399)
					.addComponent(getJlAdmin(), GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
					.addGap(43)
					.addComponent(getJlProfessor(), GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(39)
					.addComponent(getJlAluno())
					.addGap(503))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(323)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getJlProfessor())
						.addComponent(getJlAdmin())
						.addComponent(getJlAluno()))
					.addContainerGap(409, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private static BufferedImage loadImage(String file) throws IOException {
		return ImageIO.read(new File(file));
	}
	private JLabel getJlAdmin() {
		if (jlAdmin == null) {
			jlAdmin = new JLabel("Admin");
			jlAdmin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						AuxClass.setAux("1");
						dispose();
						new FrameLogin();
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			jlAdmin.setFont(new Font("SansSerif", Font.BOLD, 20));
			jlAdmin.setForeground(new Color(0, 153, 51));
			jlAdmin.setIcon(new ImageIcon("admin.png"));
		}
		return jlAdmin;
	}
	private JLabel getJlProfessor() {
		if (jlProfessor == null) {
			jlProfessor = new JLabel("Professor");
			jlProfessor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						AuxClass.setAux("2");
						dispose();
						new FrameLogin();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jlProfessor.setFont(new Font("SansSerif", Font.BOLD, 20));
			jlProfessor.setForeground(new Color(0, 153, 51));
			jlProfessor.setIcon(new ImageIcon("professor.png"));
		}
		return jlProfessor;
	}
	private JLabel getJlAluno() {
		if (jlAluno == null) {
			jlAluno = new JLabel("Aluno");
			jlAluno.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						AuxClass.setAux("3");
						dispose();
						new FrameLogin();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jlAluno.setFont(new Font("SansSerif", Font.BOLD, 20));
			jlAluno.setForeground(new Color(0, 153, 51));
			jlAluno.setIcon(new ImageIcon("aluno.png"));
		}
		return jlAluno;
	}
}
