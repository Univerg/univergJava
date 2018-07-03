package br.edu.ifsc.univerg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.ifsc.univerg.model.CursoModel;
import br.edu.ifsc.univerg.model.AuxClass;

public class CursoDAO {
	public void erro(String msg){
		JOptionPane erro = new JOptionPane(msg,JOptionPane.ERROR_MESSAGE);
		JDialog jd = erro.createDialog("Ocorreu um Erro!");
		jd.setAlwaysOnTop(true);
		jd.setVisible(true);
	}

	public void incluir(CursoModel curso) {
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "insert into curso (nome) VALUES (?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, curso.getNome());
				ps.execute();
				ps.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Curso Cadastrado");

			} catch (Exception e) {
				erro(e.getMessage().toString());

			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}
	}

	public List<CursoModel> selectCurso(){
		Connection con;
		List<CursoModel> result = new ArrayList<CursoModel>();
		try {
			con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT id,nome FROM curso");
				while (rs.next()) {
					CursoModel curso = new CursoModel(
							rs.getLong("id"),
							rs.getString("nome")
							
						);
					result.add(curso);
				
			}
				rs.close();
				st.close();
				con.close();
			}catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}
		
		return result;
	}
	public void excluirCurso(String id) {
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "DELETE FROM curso WHERE id= ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1,Long.parseLong(id));
				ps.execute();
				ps.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Curso Deletado!");
			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			erro(e1.getMessage().toString());
		}

	}
	public void alterarCurso (CursoModel curso, String var){
		Connection con;
		try {
			con= Conexao.abrir();
			String sql =  "UPDATE curso SET nome = ? WHERE id =? ";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, curso.getNome());
				ps.setString(2, var);
				ps.execute();
				ps.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Curso Alterado!");
			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}
	}
	public List<CursoModel> buscarAlteracoes() {
		Connection con;
		List<CursoModel> result = new ArrayList<CursoModel>();
		try {
			con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT nome FROM curso WHERE id= '" + AuxClass.getAux() + "'");
				while (rs.next()) {
					CursoModel curso = new CursoModel(rs.getString("nome"));
					result.add(curso);
				}
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			erro(e1.getMessage().toString());
		}
		return result;
	}
	}
		

