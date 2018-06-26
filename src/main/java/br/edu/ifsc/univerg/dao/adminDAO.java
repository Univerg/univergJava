package br.edu.ifsc.univerg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.ifsc.univerg.dao.Conexao;
import br.edu.ifsc.univerg.model.AdminModel;
import br.edu.ifsc.univerg.model.AuxClass;

public class adminDAO {
	public void erro(String msg){
		JOptionPane erro = new JOptionPane(msg,JOptionPane.ERROR_MESSAGE);
		JDialog jd = erro.createDialog("Ocorreu um Erro!");
		jd.setAlwaysOnTop(true);
		jd.setVisible(true);
	}
	public void incluir(AdminModel am) {

		Connection con = null;
		try {
			con = Conexao.abrir();
			String sql = "INSERT INTO admin(nome,login,senha) VALUES(?,?,?)";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, am.getNome());
				stmt.setString(2, am.getLogin());
				stmt.setString(3, am.getSenha());
				stmt.execute(); // executa comando
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Admin Cadastrado!");
				AuxClass.setAux("");
				AuxClass.setVal(false);
			} catch (SQLException u) {
				erro(u.getMessage().toString());
			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}

	}

	public List<AdminModel> selectAdmin() {
		Connection con;
		List<AdminModel> result = new ArrayList<AdminModel>();
		try {
			con = Conexao.abrir();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select nome,login from admin");
				while (rs.next()) {
					AdminModel am = new AdminModel(rs.getString("nome"), rs.getString("login"));
					result.add(am);
				}
				rs.close();
				st.close();

			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			erro(e1.getMessage().toString());
		}

		return result;
	}

	public void excluirAdmin(String login) {
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "DELETE FROM admin WHERE  login= ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setNString(1, login);
				ps.execute();
				ps.close();
				JOptionPane.showMessageDialog(null, "Admin Deletado!");
				
			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			erro(e1.getMessage().toString());
		}

	}

	public void alterarAdmin(AdminModel am, String var) {
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "UPDATE admin SET nome = ?, login = ?, senha = ? WHERE login= ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, am.getNome());
				ps.setString(2, am.getLogin());
				ps.setString(3, am.getSenha());
				ps.setString(4, var);
				ps.execute();
				ps.close();
				JOptionPane.showMessageDialog(null, "Admin Alterado!");
				AuxClass.setAux("");
				AuxClass.setVal(false);

			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			erro(e1.getMessage().toString());
		}

	}

	public List<AdminModel> buscarAlteracoes() {
		Connection con;
		List<AdminModel> result = new ArrayList<AdminModel>();
		try {
			con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT nome,login,senha FROM admin WHERE login=  '" + AuxClass.getAux() + "'");
				while (rs.next()) {
					AdminModel am = new AdminModel(rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
					result.add(am);
				}
				rs.close();
				st.close();
			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			erro(e1.getMessage().toString());
		}
		return result;
	}

}
