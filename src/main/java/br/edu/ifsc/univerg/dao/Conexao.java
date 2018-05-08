package br.edu.ifsc.univerg.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String USUARIO = "id5621430_root";
    private static final String SENHA = "umasenhaqualquer@";
    private static final String URL = "jdbc:mysql://databases.000webhost.com:3306/id5621430_univerg";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;


    }

}