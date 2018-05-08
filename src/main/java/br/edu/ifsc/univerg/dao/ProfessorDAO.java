package br.edu.ifsc.univerg.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import br.edu.ifsc.univerg.dao.Conexao;
import br.edu.ifsc.univerg.model.ProfessorModel;


public class ProfessorDAO {
	public ProfessorDAO(ProfessorModel pm) throws Exception {
		Connection con = (Connection) Conexao.abrir();
		String sql = "insert into (nome, cpf,rg,fone,cep,nascimento,endereco,cidade,email,especializacao,matricula,login,senha)"
				+ "values ('?','?','?','?','?','?','?','?','?','?','?','?','?')";
		try {
			PreparedStatement stmt = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
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
			stmt.setString(11, pm.getMatricula());
			stmt.setString(12, pm.getLogin());
			stmt.setString(13, pm.getSenha());
			stmt.execute(); // executa comando
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

}