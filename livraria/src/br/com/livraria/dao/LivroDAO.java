package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.Conexao;
import br.com.livraria.entidades.Livraria;
import br.com.livraria.entidades.Livro;

public class LivroDAO {
	
	private Connection conexao;

	public LivroDAO() throws SQLException, ClassNotFoundException {
		conexao = Conexao.criarConexao();
	}
	
	public void inserir(Livro livro) {
		String sql = "INSERT INTO LIVRO(nome, autor, editora, estoque, preco, isbn, codigoLivraria) "
				+ "VALUES(?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, livro.getNome());
			preparador.setString(2, livro.getAutor());
			preparador.setString(3, livro.getEditora());
			preparador.setInt(4, livro.getEstoque());
			preparador.setDouble(5, livro.getPreco());
			preparador.setString(6,livro.getIsbn());
			preparador.setObject(7, livro.getCodigoLivraria());
			
			preparador.execute();
			preparador.close();
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void atualizar(Livro livro) {
		String sql = "UPDATE LIVRO SET Nome = ? WHERE codigo_livro = ?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, livro.getNome());
			preparador.setInt(2, livro.getCodigoLivro());
			
			preparador.execute();
			preparador.close();
			System.out.println("Alteração realizada!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	
	public void deletar(Integer codigoLivro) {
		String sql = "DELETE FROM LIVRARIA WHERE codigo_livro = ?";

		try {
			
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, codigoLivro);

			preparador.execute();
			preparador.close();
			System.out.println("Deleção realizada!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	
	public List<Livro> obterLivros(){
		String sql = "SELECT * FROM LIVRO";
		List<Livro> livros = new ArrayList<Livro>();
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			
			ResultSet resultados = preparador.executeQuery();
			
			while(resultados.next()) {
				
				Livro livro = new Livro();
				
				livro.setNome(resultados.getString("nome"));
				livro.setAutor(resultados.getString("autor"));
				livro.setEditora(resultados.getString("editora"));
				livro.setEstoque(resultados.getInt("estoque"));
				livro.setPreco(resultados.getDouble("preco"));
				livro.setIsbn(resultados.getString("isbn"));
				livro.setCodigoLivraria((Livraria) resultados.getObject("codigo_livraria"));
				
				livros.add(livro);
			}
			preparador.close();
			System.out.println("Todos resultados obtidos!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return livros;
	}
			
}
