package br.edu.ifsc.univerg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.univerg.model.AdminModel;
import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.NotasModel;

public class NotasDAO {
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
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return strList;
	}
	public List<NotasModel> busca_aluno() {
		List<NotasModel> strList =  new ArrayList<NotasModel>();
		try {
			Connection con = Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT aluno.nome as nomeALuno ,CONCAT (aluno.prefix,aluno.id) as matricula from aluno INNER JOIN turma INNER JOIN curso INNER JOIN disciplina where turma.id_curso=curso.id and disciplina.id_curso=curso.id and aluno.id_turma=turma.id and disciplina.nome='"+ AuxClass.getAux() + "'");
				while (rs.next()) {
					NotasModel nm =new NotasModel(rs.getString("nomeALuno"),rs.getString("matricula"));
					strList.add(nm);
				}
				rs.close();
				st.close();
				AuxClass.setAux("");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strList;
	}

}
