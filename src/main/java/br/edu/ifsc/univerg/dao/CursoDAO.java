package br.edu.ifsc.univerg.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.edu.ifsc.univerg.model.CursoModel;

public class CursoDAO {
	public void incluir (CursoModel curso){
		Connection con;
		try {
			con=Conexao.abrir();
			String sql = "insert into curso (nome) VALUES (?)";  
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, curso.getNome());
				ps.execute();
				ps.close();
				JOptionPane.showMessageDialog(null, "Curso Cadastrado");
				
			} catch (Exception e) {
				
			}
		} catch (Exception e) {
			
		}
	}
}
