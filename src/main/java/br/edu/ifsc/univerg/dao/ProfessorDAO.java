package br.edu.ifsc.univerg.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifsc.univerg.dao.Conexao;
import br.edu.ifsc.univerg.model.AuxClass;
import br.edu.ifsc.univerg.model.ProfessorModel;

public class ProfessorDAO {
	public void incluir(ProfessorModel pm){
		Connection con;
		try {
			con = Conexao.abrir();
			String sql = "INSERT INTO `professor` (`nome`, `cpf`, `rg`, `fone`, `cep`, `nascimento`, `endereco`, `cidade`, `email`, `especializacao`, `login`, `senha`)"
					+"VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, pm.getNome());
				stmt.setString(2, pm.getCpf());
				stmt.setString(3, pm.getRg());
				stmt.setString(4, pm.getFone());
				stmt.setString(5, pm.getCep());
				stmt.setString(6, pm.getNascimento());
				stmt.setString(7, pm.getEndereco());
				stmt.setString(8, pm.getCidade());
				stmt.setString(9, pm.getEmail());
				stmt.setString(10, pm.getEspecializacao());
				stmt.setString(11, pm.getLogin());
				stmt.setString(12, pm.getSenha());
				stmt.execute(); // executa comando
				stmt.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Professor Cadastrado!");
			} catch (SQLException u) {
				throw new RuntimeException(u);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<ProfessorModel> selectProfessor(){
		   Connection con;
		   List<ProfessorModel> result = new ArrayList<ProfessorModel>();
		try {
			con =  Conexao.abrir();			
		       try {
		           Statement st = con.createStatement();
		           ResultSet rs = st.executeQuery("SELECT nome, CONCAT (prefix,id) AS matricula FROM professor");
		           while(rs.next()){
		        	   ProfessorModel am = new ProfessorModel(
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
	public List<ProfessorModel> buscarAlteracoes(){
		
		   Connection con;
		   List<ProfessorModel> result = new ArrayList<ProfessorModel>();
		try {
			con =  Conexao.abrir();			
		       try {
		           Statement st = con.createStatement();
		           ResultSet rs = st.executeQuery("SELECT nome,cpf,rg,fone,cep,nascimento,endereco,cidade,email,especializacao,login,senha FROM professor WHERE CONCAT (prefix,id)=  '"+AuxClass.getAux()+"'");
		           
		           while(rs.next()){
		        	   ProfessorModel am = new ProfessorModel(
		                       rs.getString("nome"), 
		                       rs.getString("cpf"),
		                       rs.getString("rg"), 
		                       rs.getString("fone"),
		                       rs.getString("cep"), 
		                       rs.getString("nascimento"),
		                       rs.getString("endereco"), 
		                       rs.getString("cidade"),
		                       rs.getString("email"), 
		                       rs.getString("especializacao"),
		                       rs.getString("login"), 
		                       rs.getString("senha")
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
		     
	       System.out.println(result);
	       return result;
	   }
	public void excluir_Professor (String matricula){
		   Connection con;
		try {
			con = Conexao.abrir();
			String sql = "DELETE FROM professor WHERE  CONCAT (prefix,id)= ?";
		   	try {
		   		PreparedStatement ps = con.prepareStatement(sql);
		   		ps.setNString(1, matricula);
		   		ps.execute();
		   		ps.close();
		   		con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   	
	   }
	public void alterarProfessor ( ProfessorModel professor ,String var){
		   Connection con;
		try {
			con = Conexao.abrir();
			String sql = "UPDATE professor SET nome = ?, cpf = ?, rg = ?, fone = ?, cep = ?, nascimento = ?"+
			",endereco=?, cidade=?, email=? ,especializacao=?, login=?, senha=?  WHERE  CONCAT (prefix,id)=?";
		   	try {
		   		PreparedStatement ps = con.prepareStatement(sql);
		   		ps.setString(1, professor.getNome());
		   		ps.setString(2, professor.getCpf());
		   		ps.setString(3, professor.getRg());
		   		ps.setString(4, professor.getFone());
		   		ps.setString(5, professor.getCep());
		   		ps.setString(6, professor.getNascimento());
		   		ps.setString(7, professor.getEndereco());
		   		ps.setString(8, professor.getCidade());
		   		ps.setString(9, professor.getEmail());
		   		ps.setString(10, professor.getEspecializacao());
		   		ps.setString(11, professor.getLogin());
		   		ps.setString(12, professor.getSenha());
		   		ps.setString(13, var);
		   		ps.execute();
		   		ps.close();
				con.close();
				AuxClass.setAux("");
				AuxClass.setVal(false);
				JOptionPane.showMessageDialog(null, "Professor Alterado!");
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