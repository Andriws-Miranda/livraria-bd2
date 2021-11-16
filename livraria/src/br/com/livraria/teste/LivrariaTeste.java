package br.com.livraria.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.livraria.dao.LivrariaDAO;
import br.com.livraria.entidades.Livraria;

public class LivrariaTeste {
	
	public static void main(String[] args) {
		inserirTeste();
		atualizarTeste();
		obterTodosTeste();
		deletarTeste();
	}

	private static void inserirTeste() {

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
	
	private static void atualizarTeste() {

		Livraria livraria = new Livraria();

		livraria.setCodigoLivraria(1);
		livraria.setNome("Novo nome");
		livraria.setEndereco("Endereco");
		livraria.setCnpj("00000000000001");
		
		LivrariaDAO dao = null;

		try {
			dao = new LivrariaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		dao.atualizar(livraria);
	}
	
	public static void deletarTeste() {
		
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
	
	public static void obterTodosTeste() {
		
		LivrariaDAO dao = null;
		
		try {
			dao = new LivrariaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Livraria> livrarias = dao.obterTodos();
		for (Livraria l : livrarias) {
		
		System.out.println("Código do livraria: "+ l.getCodigoLivraria()
		+ "Nome: " + l.getNome()
		+ "Endereço: " + l.getEndereco()
		+ "CNPJ: " + l.getCnpj()
		+ "Estoque: " + l.getEstoque());
		}
	}
}
