package br.edu.ifsc.univerg.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifsc.univerg.dao.Conexao;
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
		           
		       } catch (Exception e) {
		           e.printStackTrace();
		       }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		     
	       
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
				} catch (Exception e) {
					e.printStackTrace();
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   	
	   }
	

}