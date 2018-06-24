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
import br.edu.ifsc.univerg.model.TurmaModel;

public class AlunoDAO {
	//Lista no comboBox as turmas já cadastradas
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
	
	public void incluirAluno (AlunoModel aluno){
		Connection con;
		try {
			con=Conexao.abrir();
			String sql = "INSERT INTO `aluno` (`nome`, `cpf`, `rg`, `fone`, `cep`, `nasc`, `endereco`, `cidade`, `email`,"
					+ " `id_turma`, `login`, `senha`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"; 
			try {
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setString(1, aluno.getNome());
				ps.setString(2,aluno.getCep());
				ps.setString(3, aluno.getRg());
				ps.setString(4,aluno.getFone());
				ps.setString(5, aluno.getCep());
				ps.setString(6,aluno.getNascimento());
				ps.setString(7, aluno.getEndereco());
				ps.setString(8,aluno.getCidade());
				ps.setString(9, aluno.getEmail());
				ps.setLong(10,aluno.getId_turma());
				ps.setString(11, aluno.getLogin());
				ps.setString(12,aluno.getSenha());
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
		   List<AlunoModel> result = new ArrayList<AlunoModel>();
		try {
			con =  Conexao.abrir();			
		       try {
		           Statement st = con.createStatement();
		           ResultSet rs = st.executeQuery("SELECT nome, CONCAT (prefix,id) AS matricula FROM aluno");
		           while(rs.next()){
		        	   AlunoModel am = new AlunoModel(
		                       rs.getString("nome"), 
		                       rs.getString("matricula")
		               );
		               result.add(am);
		           }
		           rs.close();
		           st.close();
		           con.close();
		       } catch (Exception e) {
		           e.printStackTrace();
		       }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
				JOptionPane.showMessageDialog(null, "Aluno Deletado! ");
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<AlunoModel> buscarAlteracoes(){
		
		   Connection con;
		   List<AlunoModel> result = new ArrayList<AlunoModel>();
		try {
			con =  Conexao.abrir();			
		       try {
		           Statement st = con.createStatement();
		           ResultSet rs = st.executeQuery("SELECT aluno.nome,aluno.cpf,aluno.rg,aluno.fone,aluno.cep,aluno.nasc,aluno.endereco,aluno.cidade,aluno.email,aluno.login,aluno.senha, CONCAT (turma.prefix,turma.id) as codturma FROM aluno inner join turma WHERE  turma.id=aluno.id_turma and  CONCAT (aluno.prefix,aluno.id)='"+AuxClass.getAux()+"'");
		           
		           while(rs.next()){
		        	   AlunoModel alunoModel = new AlunoModel(
		                       rs.getString("nome"), 
		                       rs.getString("cpf"),
		                       rs.getString("rg"), 
		                       rs.getString("fone"),
		                       rs.getString("cep"), 
		                       rs.getString("nasc"),
		                       rs.getString("endereco"), 
		                       rs.getString("cidade"),
		                       rs.getString("email"),
		                       rs.getString("login"), 
		                       rs.getString("senha"),
		                       rs.getString("codturma")
		               );
		               result.add(alunoModel);
		           }
		           rs.close();
		           st.close();
		           con.close();
		       } catch (Exception e) {
		           e.printStackTrace();
		       }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		     
	       System.out.println(result);
	       return result;
	   }
	public void alterarAluno ( AlunoModel alunoModel ,String var){
		   Connection con;
		try {
			con = Conexao.abrir();
			String sql = "UPDATE aluno SET nome = ?, cpf = ?, rg = ?, fone = ?, cep = ?, nasc = ?"+
			",endereco=?, cidade=?, email=?, id_turma=?, login=?, senha=?  WHERE  CONCAT (prefix,id)=?";
		   	try {
		   		PreparedStatement ps = con.prepareStatement(sql);
		   		ps.setString(1, alunoModel.getNome());
		   		ps.setString(2, alunoModel.getCpf());
		   		ps.setString(3, alunoModel.getRg());
		   		ps.setString(4, alunoModel.getFone());
		   		ps.setString(5, alunoModel.getCep());
		   		ps.setString(6, alunoModel.getNascimento());
		   		ps.setString(7, alunoModel.getEndereco());
		   		ps.setString(8, alunoModel.getCidade());
		   		ps.setString(9, alunoModel.getEmail());
		   		ps.setLong(10, alunoModel.getId_turma());
		   		ps.setString(11, alunoModel.getLogin());
		   		ps.setString(12, alunoModel.getSenha());
		   		ps.setString(13, var);
		   		ps.execute();
		   		ps.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Aluno Alterado!");
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   	
	   }
}
