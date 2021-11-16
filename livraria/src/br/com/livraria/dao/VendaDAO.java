package br.com.livraria.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.livraria.configuracao.Conexao;
import br.com.livraria.entidades.Livraria;

public class LivrariaDAO {
	
	private Connection conexao;

	public LivrariaDAO() throws SQLException, ClassNotFoundException {
		conexao = Conexao.criarConexao();
	}
	
	public void inserir(Livraria livraria) {
		String sql = "INSERT INTO LIVRARIA(nome, endereco, cnpj) "
				+ "VALUES(?,?,?)";

		try {
			PreparedStatement preparator = conexao.prepareStatement(sql);
			preparator.setString(1, livraria.getNome());
			preparator.setString(2, livraria.getEndereco());
			preparator.setString(3, livraria.getCnpj());

			preparator.execute();
			preparator.close();
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void atualizar(Livraria livraria) {
		String sql = "UPDATE LIVRARIA SET endereco = ? WHERE codigo_livraria = ?";

		try {
			PreparedStatement preparator = conexao.prepareStatement(sql);
			preparator.setString(1, livraria.getEndereco());
			preparator.setInt(2, livraria.getCodigoLivraria());

			preparator.execute();
			preparator.close();
			System.out.println("Atualização realizada!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void deletar(Integer codigoLivraria) {
		String sql = "DELETE FROM LIVRARIA WHERE codigo_livraria = ?";

		try {
			PreparedStatement preparator = conexao.prepareStatement(sql);
			preparator.setInt(1, codigoLivraria);

			preparator.execute();
			preparator.close();
			System.out.println("Deleção realizada!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public List<Livraria> obterTodos(){
		String sql = "SELECT * FROM LIVRARIA";
		List<Livraria> livrarias = new ArrayList<Livraria>();
		
		try {
			PreparedStatement preparator = conexao.prepareStatement(sql);
			
			ResultSet resultados = preparator.executeQuery();
			
			while(resultados.next()) {
				Livraria livraria = new Livraria();
				livraria.setCodigoLivraria(resultados.getInt("codigo_livraria"));
				livraria.setNome(resultados.getString("nome"));
				livraria.setEndereco(resultados.getString("endereco"));
				livraria.setCnpj(resultados.getString("cnpj"));
				livrarias.add(livraria);
			}

			preparator.close();
			System.out.println("Todos resultados obtidos!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return livrarias;
	}
	
}