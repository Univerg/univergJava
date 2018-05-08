package br.edu.ifsc.univerg.gui;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import com.towel.swing.img.JImagePanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameLogin extends JFrame {

	private JImagePanel contentPane;
	private JImagePanel jpLogin;
	private JTextField jtfLogin;
	private JPasswordField jtfSenha;
	private JLabel jlLogin;
	private JLabel jlSenha;
	private JButton jbtCancelar;
	private JButton jbtLogin;
	


	public FrameLogin() throws Throwable  {
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
					.addGap(399)
					.addComponent(getJpLogin(), GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(456, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(210)
					.addComponent(getJpLogin(), GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(212, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private static BufferedImage loadImage(String file) throws IOException {
		return ImageIO.read(new File(file));
	}
	private JImagePanel getJpLogin() throws Throwable{
		if (jpLogin == null) {
			jpLogin = new JImagePanel(loadImage("login.jpg"));
			jpLogin.setLayout(null);
			jpLogin.add(getJtfLogin());
			jpLogin.add(getJtfSenha());
			jpLogin.add(getJlLogin());
			jpLogin.add(getJlSenha());
			jpLogin.add(getJbtCancelar());
			jpLogin.add(getJbtLogin());
		}
		return jpLogin;
	}
	private JTextField getJtfLogin() {
		if (jtfLogin == null) {
			jtfLogin = new JTextField();
			jtfLogin.setBounds(158, 107, 265, 22);
			jtfLogin.setColumns(10);
		}
		return jtfLogin;
	}
	private JPasswordField getJtfSenha() {
		if (jtfSenha == null) {
			jtfSenha = new JPasswordField();
			jtfSenha.setBounds(158, 141, 265, 22);
		}
		return jtfSenha;
	}
	private JLabel getJlLogin() {
		if (jlLogin == null) {
			jlLogin = new JLabel("Login:");
			jlLogin.setForeground(new Color(0, 128, 0));
			jlLogin.setFont(new Font("Dialog", Font.BOLD, 16));
			jlLogin.setBounds(74, 105, 66, 22);
		}
		return jlLogin;
	}
	private JLabel getJlSenha() {
		if (jlSenha == null) {
			jlSenha = new JLabel("Senha:");
			jlSenha.setForeground(new Color(0, 128, 0));
			jlSenha.setFont(new Font("Dialog", Font.BOLD, 16));
			jlSenha.setBounds(74, 139, 66, 22);
		}
		return jlSenha;
	}
	private JButton getJbtCancelar() {
		if (jbtCancelar == null) {
			jbtCancelar = new JButton("Cancelar");
			jbtCancelar.setForeground(new Color(0, 128, 0));
			jbtCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
			jbtCancelar.setBounds(333, 202, 90, 24);
		}
		return jbtCancelar;
	}
	private JButton getJbtLogin() {
		if (jbtLogin == null) {
			jbtLogin = new JButton("Login");
			jbtLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(jtfLogin.getText().equals("1")){
						try {
							dispose();
							new FrameAdmin();
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if (jtfLogin.getText().equals("2")){
						try {
							dispose();
							new FrameProfessor();
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else{
						try {
							dispose();
							new FrameAluno();
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			jbtLogin.setForeground(new Color(0, 128, 0));
			jbtLogin.setFont(new Font("Dialog", Font.BOLD, 14));
			jbtLogin.setBounds(216, 202, 96, 24);
		}
		return jbtLogin;
	}
}
