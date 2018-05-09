package br.edu.ifsc.univerg.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.univerg.dao.Conexao;
import br.edu.ifsc.univerg.model.AdminModel;

public class adminDAO {
	public void incluir(AdminModel am) {
		
		Connection con = null;
		try {
			con = Conexao.abrir();
			String sql = "INSERT INTO admin(nome,login,senha) VALUES(?,?,?)";
			//TEST
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, am.getNome());
				stmt.setString(2, am.getLogin());
				stmt.setString(3, am.getSenha());
				stmt.execute(); // executa comando
				stmt.close();
				con.close();
			} catch (SQLException u) {
				throw new RuntimeException(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	 public List<AdminModel> selectAdmin(){
		   Connection con;
		   List<AdminModel> result = new ArrayList<AdminModel>();
		try {
			con = Conexao.abrir();
			
		       
		       try {
		           Statement st = con.createStatement();
		           ResultSet rs = st.executeQuery("select nome,login from admin");
		           while(rs.next()){
		        	   AdminModel am = new AdminModel(
		                       rs.getString("nome"), 
		                       rs.getString("login")
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
	 public void excluirAdmin (String login){
		   Connection con;
		try {
			con = Conexao.abrir();
			String sql = "DELETE FROM admin WHERE  login= ?";
		   	try {
		   		PreparedStatement ps = con.prepareStatement(sql);
		   		ps.setNString(1, login);
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
