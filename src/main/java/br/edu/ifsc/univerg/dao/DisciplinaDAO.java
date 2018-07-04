package br.edu.ifsc.univerg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.DisciplinaModel;
import br.edu.ifsc.univerg.model.TurmaModel;

public class DisciplinaDAO {
	public void erro(String msg){
		JOptionPane erro = new JOptionPane(msg,JOptionPane.ERROR_MESSAGE);
		JDialog jd = erro.createDialog("Ocorreu um Erro!");
		jd.setAlwaysOnTop(true);
		jd.setVisible(true);
	}
	public void alterarEmenta(DisciplinaModel disciplinaModel, String var) {
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "UPDATE disciplina SET ementa= ? WHERE id= ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, disciplinaModel.getEmenta());
				ps.setString(2, var);
				ps.execute();
				ps.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setAux2("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Ementa Cadastrada/Alterada!");

			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			erro(e1.getMessage().toString());
		}

	}
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
				incluirAlunosDisc();
				AuxClass.setAux("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Disciplina Cadastrada");

			} catch (Exception e) {
				erro(e.getMessage().toString());

			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}
		
	}
	public void incluirAlunosDisc (){
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "INSERT INTO `univerg`.`nota` (`id_aluno`, `id_turma`, `id_disciplina`, `nota1`, `nota2`, `nota3`) "
					+ "SELECT  DISTINCT aluno.id,turma.id,disciplina.id,'0','0','0' from aluno INNER JOIN turma ON (aluno.id_turma=turma.id) "
					+ "INNER JOIN curso ON (turma.id_curso=curso.id) "
					+ "INNER JOIN disciplina ON (disciplina.id_curso=curso.id)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.execute();
				ps.close();
				con.close();

			} catch (Exception e) {
				erro(e.getMessage().toString());

			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}
		
	}
	public void deletarrAlunosDisc (){
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "DELETE a FROM nota AS a, nota AS b WHERE a.id_aluno=b.id_aluno AND "
					+ "a.id_turma=b.id_turma AND "
					+ "a.id_disciplina=b.id_disciplina AND "
					+ "a.id < b.id";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.execute();
				ps.close();
				con.close();
				deletarrAlunosDisc();

			} catch (Exception e) {
				erro(e.getMessage().toString());

			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
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
				erro(e.getMessage().toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erro(e.getMessage().toString());
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
				erro(e.getMessage().toString());
			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
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
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			erro(e1.getMessage().toString());
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
					erro(e.getMessage().toString());
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			erro(e1.getMessage().toString());
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
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			erro(e1.getMessage().toString());
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
					JOptionPane.showMessageDialog(null, "Disciplina Alterado!");

				} catch (Exception e) {
					erro(e.getMessage().toString());
				}
			} catch (Exception e1) {
				erro(e1.getMessage().toString());
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
					erro(e.getMessage().toString());
				}
			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
			return result;

		}
		
		
}
