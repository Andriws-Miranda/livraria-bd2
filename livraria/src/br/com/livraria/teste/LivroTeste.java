package br.com.livraria.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.livraria.dao.LivrariaDAO;
import br.com.livraria.dao.LivroDAO;
import br.com.livraria.entidades.Livraria;
import br.com.livraria.entidades.Livro;

public class LivroTeste {
	
	public static void main(String[] args) {
		inserirTeste();
		atualizarTeste();
		obterTodosTeste();
		deletarTeste();
	}

	private static void inserirTeste() {
		inserirLivraria();
		Livro livro = new Livro();
		
		livro.setNome("Dom Quixote");
		livro.setAutor("Miguel De Cervantes");
		livro.setEditora("Pé da Letra");
		livro.setPreco(16.00);
		livro.setIsbn("8595200858");
		livro.setCodigoLivraria(1);

		LivroDAO livroDAO = null;
		
		try {
			livroDAO = new LivroDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		livroDAO.inserir(livro);
	}
	
	private static void atualizarTeste() {

		Livro livro = new Livro();

		livro.setNome("Dom Quixote - Edição de Bolso");
		livro.setCodigoLivro(1);
		
		LivroDAO livroDAO = null;

		try {
			livroDAO = new LivroDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		livroDAO.atualizar(livro);
	}
	
	public static void deletarTeste() {
		
		Livro livro = new Livro();
		livro.setCodigoLivro(1);
		
		LivroDAO livroDAO = null;

		try {
			livroDAO = new LivroDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		deletarLivraria();
		livroDAO.deletar(livro.getCodigoLivro());
	}
	
	public static void obterTodosTeste() {
		
		LivroDAO livroDAO = null;
		
		try {
			livroDAO = new LivroDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Livro> livros = livroDAO.obterLivros();
		for (Livro l : livros) {
		
		System.out.println("Código do livro: "+ l.getCodigoLivro()
		+ " Nome: " + l.getNome()
		+ "Autor: " + l.getAutor()
		+ "Editora: " + l.getEditora()
		+ "Preço: " + l.getPreco()
		+ "ISBN: " + l.getIsbn()
		+ "Livraria " + l.getCodigoLivraria());
		}
	}
	
	private static void inserirLivraria() {

		Livraria livraria = new Livraria();
		livraria.setNome("Teste");
		livraria.setEndereco("Endereco");
		livraria.setCnpj("00000000000000");

		LivrariaDAO dao = null;
		
		try {
			dao = new LivrariaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		dao.inserir(livraria);
	}
	
	private static void deletarLivraria() {
		
		Livraria livraria = new Livraria();
		livraria.setCodigoLivraria(1);
		
		LivrariaDAO dao = null;

		try {
			dao = new LivrariaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		dao.deletar(livraria.getCodigoLivraria());
	}
}
