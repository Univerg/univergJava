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

import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.AvaliacaoModel;
import br.edu.ifsc.univerg.model.DisciplinaModel;
import br.edu.ifsc.univerg.model.TurmaModel;

public class AvaliacaoDAO {
	public void erro(String msg){
		JOptionPane erro = new JOptionPane(msg,JOptionPane.ERROR_MESSAGE);
		JDialog jd = erro.createDialog("Ocorreu um Erro!");
		jd.setAlwaysOnTop(true);
		jd.setVisible(true);
	}
	public List<AvaliacaoModel> selectAvaliacaoAluno() {
		Connection con;
		List<AvaliacaoModel> result = new ArrayList<AvaliacaoModel>();
		try {
			con = Conexao.abrir();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select avaliacao.data1 ,disciplina.nome from avaliacao inner join disciplina where avaliacao.id_turma='"+AuxClass.getAuxaluno()+"'");
				while (rs.next()) {
					AvaliacaoModel avaliacaoModel = new AvaliacaoModel(rs.getString("avaliacao.data1"),rs.getString("disciplina.nome"));
					result.add(avaliacaoModel);
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
	public void incluir(AvaliacaoModel avaliacaoModel) {
		Connection con = null;
		try {
			con = Conexao.abrir();
			String sql = "INSERT INTO avaliacao (data1,id_turma,id_disciplina) "
					+ " VALUES (?,(SELECT turma.id AS id_turma FROM turma WHERE CONCAT (turma.prefix,turma.id)= ?),"
					+ "(SELECT disciplina.id AS id_disciplina FROM disciplina WHERE disciplina.nome= ?))";
			// TEST
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, avaliacaoModel.getData());
				stmt.setString(2, avaliacaoModel.getCod_Turma());
				stmt.setString(3, avaliacaoModel.getNome_Disciplina());
				stmt.execute(); // executa comando
				stmt.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setAux2("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Avaliação Cadastrada!");
			} catch (SQLException u) {
				erro(u.getMessage().toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erro(e.getMessage().toString());
		}

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
			// TODO Auto-generated catch block
			erro(e.getMessage().toString());
		}

		return strList;
	}
	public List<String> busca_disciplina() {
		List<String> strList = new ArrayList<String>();
		try {
			Connection con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT disciplina.nome FROM disciplina ORDER BY nome ASC");
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
	public List<AvaliacaoModel> selectAvaliacao() {
		Connection con;
		List<AvaliacaoModel> result = new ArrayList<AvaliacaoModel>();
		try {
			con = Conexao.abrir();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT avaliacao.id as id_avaliacao, avaliacao.data1 as dataAvaliacao,"
						+ " CONCAT(turma.prefix,turma.id) as nomeTurma, disciplina.nome as nomeDisciplina FROM avaliacao "
						+ "inner join turma INNER JOIN disciplina WHERE avaliacao.id_turma= turma.id and  avaliacao.id_disciplina= disciplina.id");
				while (rs.next()) {
					AvaliacaoModel avaliacaoModel = new AvaliacaoModel(rs.getInt("id_avaliacao"), rs.getString("dataAvaliacao"),rs.getString("nomeTurma"), rs.getString("nomeDisciplina"));
					result.add(avaliacaoModel);
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
	public void excluir_avaliacao(int id){
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "DELETE FROM avaliacao WHERE  id = ?";
		   	try {
		   		PreparedStatement ps = con.prepareStatement(sql);
		   		ps.setInt(1, id);
		   		ps.execute();
		   		ps.close();
		   		con.close();
		   		JOptionPane.showMessageDialog(null, "Avaliação Excluída!");
				} catch (Exception e) {
					erro(e.getMessage().toString());
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			erro(e1.getMessage().toString());
		}
	}
	public List<AvaliacaoModel> buscarAlteracoes() {

		Connection con;
		List<AvaliacaoModel> result = new ArrayList<AvaliacaoModel>();
		try {
			con = Conexao.abrir();
			try {
				
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("SELECT avaliacao.id as id_avaliacao, avaliacao.data1 as dataAvaliacao, "
								+ "CONCAT(turma.prefix,turma.id) as nomeTurma, disciplina.nome as nomeDisciplina "
								+ "FROM avaliacao inner join turma INNER JOIN disciplina where avaliacao.id ='"+AuxClass.getAux2()+ "' "+"and"
								+ " avaliacao.id_turma= turma.id and  avaliacao.id_disciplina= disciplina.id");
				
				while (rs.next()) {
					AvaliacaoModel avaliacaoModel = new AvaliacaoModel(rs.getString("dataAvaliacao"), rs.getString("nomeTurma"), rs.getString("nomeDisciplina"));
					result.add(avaliacaoModel);
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
	public void alterarAvalicao(AvaliacaoModel avaliacaoModel, String var) {
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "UPDATE avaliacao SET data1=?, id_turma=(SELECT turma.id AS id_turma FROM"
					+ " turma WHERE CONCAT (turma.prefix,turma.id)=?) , id_disciplina= "
					+ "(SELECT disciplina.id AS id_disciplina FROM disciplina WHERE disciplina.nome= ?) WHERE avaliacao.id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,avaliacaoModel.getData());
				ps.setString(2, avaliacaoModel.getCod_Turma());
				ps.setString(3, avaliacaoModel.getNome_Disciplina());
				ps.setString(4, var);
				ps.execute();
				ps.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setAux2("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Avaliação Alterada!");

			} catch (Exception e) {
				erro(e.getMessage().toString());
				// TODO: handle exception
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			erro(e1.getMessage().toString());
		}

	}
	

}
