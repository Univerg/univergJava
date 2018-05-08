package br.edu.ifsc.univerg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifsc.univerg.dao.Conexao;
import br.edu.ifsc.univerg.model.AdminModel;

public class adminDAO {
	public adminDAO(AdminModel am) {
		
		Connection con = null;
		try {
			con = Conexao.abrir();
			String sql = "INSERT INTO admin(nome,login,senha) VALUES(?,?,?)";
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

}
