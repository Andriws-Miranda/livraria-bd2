package br.com.livraria.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.livraria.configuracao.Conexao;

public final class ConexaoTeste{
	
	public void executar(){
		try {
			Connection con = Conexao.criarConexao();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
}