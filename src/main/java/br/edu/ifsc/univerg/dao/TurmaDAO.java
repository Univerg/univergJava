package br.edu.ifsc.univerg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
	public List<String> busca_curso(){
		List<String> strList = new ArrayList<String>();
		   try {
			Connection con = Conexao.abrir();
			 try {
		           Statement st = con.createStatement();
		           ResultSet rs = st.executeQuery("SELECT curso.nome FROM curso ORDER BY nome ASC");
		           while(rs.next()){
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

}
