package br.edu.ifsc.univerg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifsc.univerg.model.AlunoModel;
import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.ProfessorModel;

public class AlunoDAO {
	public void incluirAluno (ProfessorModel professor){
		Connection con;
		try {
			con=Conexao.abrir();
			String sql = "INSERT INTO `aluno` (`nome`, `cpf`, `rg`, `fone`, `cep`, `nasc`, `endereco`, `cidade`, `email`,"
					+ " `id_turma`, `login`, `senha`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"; 
			try {
				PreparedStatement ps =con.prepareStatement(sql);
				/*ps.setString(1, professor.getNome());
				ps.setString(2,professor.getCep());
				ps.setString(3, professor.getRg());
				ps.setString(4,professor.getFone());
				ps.setString(5, professor.getCep());
				ps.setString(6,professor.getNascimento());
				ps.setString(7, professor.getEndereco());
				ps.setString(8,professor.getCidade());
				ps.setString(9, professor.getEmail());
				ps.setString(10,professor.get);
				ps.setString(1, professor.getLogin());
				ps.setString(2,professor.getCep());*/
				ps.execute();
				ps.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Aluno Cadastrado");
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<AlunoModel> selectAluno(){
		Connection con;
		List<AlunoModel > result = new ArrayList<AlunoModel>();
		try {
			con=Conexao.abrir();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT nome, CONCAT (prefix,id) AS matricula FROM aluno");
				while (rs.next()){
					AlunoModel alunoModel = new AlunoModel(
							rs.getString("nome"),
							rs.getString("matricula")
					);
			        result.add(alunoModel);
				}
				rs.close();
		        st.close();
		        con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result; 
	}
	public void excluirAluno(String matricula){
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "DELETE FROM aluno WHERE CONCAT (prefix,id) = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, matricula);
				ps.execute();
				ps.close();
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
