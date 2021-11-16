package br.com.livraria.teste;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import br.com.livraria.dao.LivroDAO;
import br.com.livraria.dao.VendaDAO;
import br.com.livraria.entidades.Livro;
import br.com.livraria.entidades.Venda;

public class VendaTeste {

	public static void main(String[] args) {
		testarInsert();
		testarUpdate();
		testarSelectAll();
		testarSelectUnico();
		testarDelete();
	}

	public static void testarInsert() {
		inserirLivro();
		Venda venda = new Venda();
		venda.setCodigoVenda(1);
		venda.setCodigoLivro(1);
		String str = "2001-12-29";
		Date date = Date.valueOf(str);
		venda.setDataVenda(date);

		VendaDAO vendaDAO = null;

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		vendaDAO.inserirVenda(venda);
	}

	public static void testarUpdate() {
		Venda venda = new Venda();
		venda.setCodigoVenda(1);
		venda.setCodigoLivro(1);
		String str = "2001-12-29";
		Date date = Date.valueOf(str);
		venda.setDataVenda(date);
		VendaDAO vendaDAO = null;

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		vendaDAO.atualizarVenda(venda);
	}

	public static void testarSelectAll() {
		VendaDAO vendaDAO = null;

		try {
			vendaDAO = new VendaDAO();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Venda> resultList = vendaDAO.obterTodos();

		for (Venda v : resultList) {
			System.out.println("Codigo venda: " + v.getCodigoVenda() + "\n" + "Livro: " + v.getCodigoLivro() + "\n"
					+ "Data da Venda: " + v.getDataVenda());
		}
	}

	public static void testarSelectUnico() {
		VendaDAO vendaDAO = null;
		int idValido = 1;
		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Venda venda = vendaDAO.obterVenda(idValido);
		System.out.println("Codigo venda - " + venda.getCodigoVenda() + "\n"
				+ "Codigo Livro - " + venda.getCodigoLivro() + "\n"
				+ "Data da venda - " + venda.getDataVenda());
	}

	public static void testarDelete() {
		Integer id = 1;
		VendaDAO vendaDAO = null;

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		deletarLivro();
		vendaDAO.deletarVenda(id);
	}
	
	private static void inserirLivro() {

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
	
	
	private static void deletarLivro() {
		
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

		livroDAO.deletar(livro.getCodigoLivro());
	}

}
