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
import br.edu.ifsc.univerg.model.AvaliacaoModel;
import br.edu.ifsc.univerg.model.NotasModel;

public class NotasDAO {
	public void erro(String msg){
		JOptionPane erro = new JOptionPane(msg,JOptionPane.ERROR_MESSAGE);
		JDialog jd = erro.createDialog("Ocorreu um Erro!");
		jd.setAlwaysOnTop(true);
		jd.setVisible(true);
	}
	public void alterar(NotasModel notasmodel) {
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "UPDATE nota SET id_aluno = (SELECT aluno.id FROM aluno where CONCAT (aluno.prefix,aluno.id)=?), "
					+ "id_turma = (SELECT turma.id FROM turma where  CONCAT (turma.prefix,turma.id)=?), "
					+ "id_disciplina=(SELECT disciplina.id FROM disciplina where  disciplina.nome=?), "
					+ "nota1=?, nota2=?, nota3=?  WHERE id_aluno= (SELECT aluno.id FROM aluno where CONCAT (aluno.prefix,aluno.id)=?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, notasmodel.getMatriculaAluno());
				ps.setString(2, notasmodel.getTurma());
				ps.setString(3, notasmodel.getDisciplina());
				ps.setFloat(4, notasmodel.getNota1());
				ps.setFloat(5, notasmodel.getNota2());
				ps.setFloat(6, notasmodel.getNota3());
				ps.setString(7, notasmodel.getMatriculaAluno());
				ps.execute();
				ps.close();
				JOptionPane.showMessageDialog(null, "Nota Alterada!");
				AuxClass.setAux("");
				AuxClass.setVal(false);

			} catch (SQLException e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e1) {
			erro(e1.getMessage().toString());
		}
	}

	
	
	public void incluir(NotasModel notasmodel) {
		Connection con = null;
		try {
			con = Conexao.abrir();
			String sql = "INSERT INTO nota (id_aluno,id_turma,id_disciplina,nota1,nota2,nota3) "
					+ "VALUES ((SELECT aluno.id FROM aluno where CONCAT (aluno.prefix,aluno.id)=?),"
					+ "(SELECT turma.id FROM turma where  CONCAT (turma.prefix,turma.id)=?),"
					+ "(SELECT disciplina.id FROM disciplina where  disciplina.nome=?),?,?,?)";
			// TEST
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, notasmodel.getMatriculaAluno());
				stmt.setString(2, notasmodel.getTurma());
				stmt.setString(3, notasmodel.getDisciplina());
				stmt.setFloat(4, notasmodel.getNota1());
				stmt.setFloat(5, notasmodel.getNota2());
				stmt.setFloat(6, notasmodel.getNota3());
				stmt.execute(); // executa comando
				stmt.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setAux2("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Nota Cadastrada!");
			} catch (SQLException u) {
				erro(u.getMessage().toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erro(e.getMessage().toString());
		}

	}
	public List<String> busca_disciplina() {
		List<String> strList = new ArrayList<String>();
		try {
			Connection con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT disciplina.nome as nomeDisc from disciplina "
						+ "INNER JOIN turma INNER JOIN curso where turma.id_curso=curso.id and disciplina.id_curso=curso.id and "
						+ "CONCAT (turma.prefix,turma.id)='"+ AuxClass.getAux() + "'");
				while (rs.next()) {
					strList.add(rs.getString("nomeDisc"));
				}
				rs.close();
				st.close();
				AuxClass.setAux("");

			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}
		

		return strList;
	}
	public List<NotasModel> busca_aluno() {
		List<NotasModel> strList =  new ArrayList<NotasModel>();
		try {
			Connection con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT aluno.nome as nomeALuno ,CONCAT (aluno.prefix,aluno.id) as matricula , nota.nota1, nota.nota2,nota.nota3 from aluno INNER JOIN turma INNER JOIN curso INNER JOIN disciplina INNER JOIN nota where turma.id_curso=curso.id and disciplina.id_curso=curso.id and aluno.id_turma=turma.id and nota.id_aluno=aluno.id and disciplina.nome='"+ AuxClass.getAux() + "'");
				while (rs.next()) {
					NotasModel nm =new NotasModel(rs.getString("nomeALuno"),rs.getString("matricula"),rs.getFloat("nota.nota1"),rs.getFloat("nota.nota2"),rs.getFloat("nota.nota3"));
					strList.add(nm);
				}
				rs.close();
				st.close();
				AuxClass.setAux("");

			} catch (Exception e) {
				erro(e.getMessage().toString());
			}
		} catch (Exception e) {
			erro(e.getMessage().toString());
		}
		

		return strList;
	}
	public List<String> busca_turma() {
		List<String> strList = new ArrayList<String>();
		try {
			Connection con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT CONCAT (prefix,id) AS cod FROM turma ORDER BY cod ASC");
				while (rs.next()) {
					strList.add(rs.getString("cod"));
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

}
