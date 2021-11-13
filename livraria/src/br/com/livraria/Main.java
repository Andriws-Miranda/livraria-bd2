package br.com.livraria;

import java.sql.SQLException;

import br.com.livraria.teste.ConexaoTeste;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConexaoTeste conexao = new ConexaoTeste();
		conexao.executar();
	}

}

