package br.edu.ifsc.univerg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.DisciplinaModel;
import br.edu.ifsc.univerg.model.TurmaModel;

public class DisciplinaDAO {
	public void incluir (DisciplinaModel disciplinaModel){
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "insert into disciplina (nome,id_curso, ementa) VALUES (?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, disciplinaModel.getNome());
				ps.setLong(2, selectIDCurso());
				ps.setString(3, disciplinaModel.getEmenta());
				ps.execute();
				ps.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Disciplina Cadastrada");

			} catch (Exception e) {
				throw new RuntimeException(e);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strList;
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
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

	}
	public List<DisciplinaModel> selectDisciplina() {
		Connection con;
		List<DisciplinaModel> result = new ArrayList<DisciplinaModel>();
		try {
			con = Conexao.abrir();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select disciplina.id as idDisciplina, curso.nome as nomeCurso, disciplina.nome as nomeDisciplina FROM disciplina inner join curso where disciplina.id_curso=curso.id");
				while (rs.next()) {
					
					DisciplinaModel dm = new DisciplinaModel(rs.getInt("idDisciplina"), rs.getString("nomeCurso"), rs.getString("nomeDisciplina"));
					result.add(dm);
				}
				rs.close();
				st.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}
	
	public void exclui_disciplina(int id){
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "DELETE FROM disciplina WHERE  id = ?";
		   	try {
		   		PreparedStatement ps = con.prepareStatement(sql);
		   		ps.setInt(1, id);
		   		ps.execute();
		   		ps.close();
		   		con.close();
		   		JOptionPane.showMessageDialog(null, "Disciplina Excluída!");
				} catch (Exception e) {
					e.printStackTrace();
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public List<DisciplinaModel> buscarAlteracoes() {
		Connection con;
		List<DisciplinaModel> result = new ArrayList<DisciplinaModel>();
		try {
			con = Conexao.abrir();
			try {
				
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("SELECT disciplina.nome AS nomeDisciplina, curso.nome AS nomeCurso, disciplina.ementa as ementaDisciplina from disciplina INNER JOIN curso WHERE disciplina.id_curso = curso.id and disciplina.id=  '" + AuxClass.getAux2() + "'");
				
				while (rs.next()) {
					DisciplinaModel disciplinaModel = new DisciplinaModel(rs.getString("nomeDisciplina"), rs.getString("nomeCurso"),rs.getString("ementaDisciplina"));
					result.add(disciplinaModel);
				}
				rs.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}
		public void alterarDisciplina(DisciplinaModel disciplinaModel, String var) {
			Connection con;
			try {
				con = Conexao.abrir();
				String sql = "UPDATE disciplina SET nome = ?, id_curso = ? , ementa= ? WHERE id= ?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,disciplinaModel.getNome());
					ps.setString(2, selectIDCurso().toString());
					ps.setString(3, disciplinaModel.getEmenta());
					ps.setString(4, var);
					ps.execute();
					ps.close();
					con.close();
					AuxClass.setAux("");
					AuxClass.setAux2("");
					AuxClass.setVal(false);
					JOptionPane.showMessageDialog(null, "Admin Alterado!");

				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		public String selectEmenta() {
			Connection con;
			String result= "";
			try {
				con = Conexao.abrir();
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT ementa FROM disciplina where id ='"+AuxClass.getAux2()+"'");
					
					while (rs.next()) {
						result=rs.getString("ementa");
					}
					rs.close();
					st.close();
					AuxClass.setAux("");
					AuxClass.setAux2("");
					AuxClass.setVal(false);
					JOptionPane.showMessageDialog(null, "Ementa Gerada!");
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return result;

		}
		
		
}
