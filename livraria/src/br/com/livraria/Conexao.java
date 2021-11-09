package br.com.livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static final String URL = "jdbc:postgresql://localhost:5433/livraria";
	public static final String USER = "postgres";
	public static final String PASSWORD = "admin";
	
	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection conecta = DriverManager.getConnection(URL, USER, PASSWORD);
		if(conecta != null) {
			System.out.println("Conexão realizada com sucesso! Bem vindo!");
			return conecta;
		}
		return null;
	}
}
