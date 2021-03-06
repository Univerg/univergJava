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

import br.edu.ifsc.univerg.model.AdminModel;
import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.TurmaModel;

public class TurmaDAO {
	public void erro(String msg){
		JOptionPane erro = new JOptionPane(msg,JOptionPane.ERROR_MESSAGE);
		JDialog jd = erro.createDialog("Ocorreu um Erro!");
		jd.setAlwaysOnTop(true);
		jd.setVisible(true);
	}
	public List<String> busca_curso() {
		List<String> strList = new ArrayList<String>();
		try {
			Connection con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT curso.nome FROM curso ORDER BY nome ASC");
				while (rs.next()) {
					strList.add(rs.getString("nome"));
				}
				rs.close();
				st.close();

			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}

		return strList;
	}

	public List<TurmaModel> selectTurma() {
		Connection con;
		List<TurmaModel> result = new ArrayList<TurmaModel>();
		try {
			con = Conexao.abrir();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select id,  CONCAT (prefix,id) AS cod from turma");
				while (rs.next()) {
					TurmaModel tm = new TurmaModel(rs.getString("id"), rs.getString("cod"));
					result.add(tm);
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
	public Long selectIDCurso() {
		Connection con;
		long result = 0;
		try {
			con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT id FROM curso where nome ='"+AuxClass.getAux()+"'");
				while (rs.next()) {
					result=rs.getLong("id");
				}
				rs.close();
				st.close();
			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}
		return result;

	}
	public List<TurmaModel> buscarAlteracoes() {
		Connection con;
		List<TurmaModel> result = new ArrayList<TurmaModel>();
		try {
			con = Conexao.abrir();
			try {
				
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("SELECT turma.turno, curso.nome from turma INNER JOIN curso where turma.id_curso= curso.id and turma.id=  '" + AuxClass.getAux2() + "'");
				
				while (rs.next()) {
					TurmaModel tm = new TurmaModel(rs.getString("turma.turno"), rs.getString("curso.nome"));
					result.add(tm);
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
	public void alterarTurma(TurmaModel tm, String var) {
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "UPDATE turma SET turno = ?, id_curso = ? WHERE id= ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,tm.getTurno());
				ps.setString(2, selectIDCurso().toString());
				ps.setString(3, var);
				ps.execute();
				ps.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setAux2("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Turma Alterada!");

			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			erro(e1.getMessage().toString());
		}

	}
	
	public void incluir(TurmaModel tm) {
		Connection con = null;
		try {
			con = Conexao.abrir();
			String sql = "INSERT INTO turma(turno,id_curso) VALUES(?,?)";
			// TEST
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, tm.getTurno());
				stmt.setString(2, selectIDCurso().toString());
				stmt.execute(); // executa comando
				stmt.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setAux2("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Turma Cadastrado!");
			} catch (SQLException u) {
				erro(u.getMessage().toString());
			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}

	}
	public void excluir_turma (int id){
		   Connection con;
		try {
			con = Conexao.abrir();
			String sql = "DELETE FROM turma WHERE  id = ?";
		   	try {
		   		PreparedStatement ps = con.prepareStatement(sql);
		   		ps.setInt(1, id);
		   		ps.execute();
		   		ps.close();
		   		con.close();
		   		JOptionPane.showMessageDialog(null, "Turma Excluída!");
				} catch (Exception e) {
					erro(e.getMessage().toString());
				}
		} catch (Exception e1) {
			erro(e1.getMessage().toString());
		}
	   	
	   }



}
