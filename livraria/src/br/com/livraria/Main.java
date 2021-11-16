package br.com.livraria;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.livraria.dao.LivrariaDAO;
import br.com.livraria.dao.LivroDAO;
import br.com.livraria.dao.VendaDAO;
import br.com.livraria.entidades.Livraria;
import br.com.livraria.entidades.Livro;
import br.com.livraria.entidades.Venda;
import br.com.livraria.teste.ConexaoTeste;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConexaoTeste conexao = new ConexaoTeste();
		conexao.executar();
		Scanner teclado = new Scanner(System.in);
		System.out.println("O que deseja fazer? \n" + "Opções Livraria(1) \n Opções Livro(2) \n Opções Venda(3)");
		int valor = teclado.nextInt();
		
		if(valor == 1) {
			teclado = new Scanner(System.in);
			System.out.println("Quais opções deseja realizar? \n Inserir(1) \n Atualizar(2) \n Obter(3) \n Deletar(4) ");
			int operacao = teclado.nextInt();
			if(operacao == 1) {
				Livraria livraria = new Livraria();
				teclado = new Scanner(System.in);
				System.out.println("Digite o nome para a Livraria: ");
				String nome = teclado.nextLine();
				livraria.setNome(nome);
				teclado.reset();
				System.out.println("Digite o endereco da Livraria: ");
				String endereco = teclado.nextLine();
				livraria.setEndereco(endereco);
				teclado.reset();
				System.out.println("Digite o cnpj: ");
				String cnpj = teclado.nextLine();
				livraria.setCnpj(cnpj);
				LivrariaDAO dao = new LivrariaDAO();
				dao.inserir(livraria);
			} else if(operacao == 2) {
				Livraria livraria = new Livraria();
				teclado = new Scanner(System.in);
				System.out.println("Digite o novo endereco para ser atualizado: ");
				String endereco = teclado.nextLine();
				livraria.setEndereco(endereco);
				teclado.reset();
				System.out.println("Digite o codigo da Livraria a ser atualizada: ");
				int codigo = teclado.nextInt();
				livraria.setCodigoLivraria(codigo);
				LivrariaDAO dao = new LivrariaDAO();
				dao.atualizar(livraria);
			} else if(operacao == 3) {
				LivrariaDAO dao = new LivrariaDAO();
				List<Livraria> livrarias = dao.obterTodos();
				for (Livraria l : livrarias) {
					System.out.println("Nome: " + l.getNome() + "\n" + "Endereco: " + l.getEndereco() + "\n"
							+ "CNPJ: " + l.getCnpj());
				}
			}else if(operacao == 4) {
				Livraria livraria = new Livraria();
				teclado = new Scanner(System.in);
				System.out.println("Digite o codigo da Livraria a ser deletada: ");
				int codigo = teclado.nextInt();
				livraria.setCodigoLivraria(codigo);
				LivrariaDAO dao = new LivrariaDAO();
				dao.deletar(livraria.getCodigoLivraria());
				
			}else {
				System.out.println("Os valor são: 1, 2, 3 e 4");
			}
		}
		
		else if(valor == 2) {
			teclado = new Scanner(System.in);
			System.out.println("Quais opções deseja realizar? \n Inserir(1) \n Atualizar(2) \n Obter(3) \n Deletar(4) ");
			int operacao = teclado.nextInt();
			if(operacao == 1) {
				Livro livro = new Livro();
				teclado = new Scanner(System.in);
				System.out.println("Digite o nome para o Livro: ");
				String nome = teclado.nextLine();
				livro.setNome(nome);
				teclado.reset();
				System.out.println("Digite o nome do Autor: ");
				String autor = teclado.nextLine();
				livro.setAutor(autor);
				teclado.reset();
				System.out.println("Digite o nome da Editora: ");
				String editora = teclado.nextLine();
				livro.setEditora(editora);
				teclado.reset();
				System.out.println("Digite o preço do Livro: ");
				double preco = teclado.nextDouble();
				livro.setPreco(preco);
				teclado.reset();
				System.out.println("Digite o isbn do Livro: ");
				String isbn = teclado.nextLine();
				livro.setIsbn(isbn);
				teclado.reset();
				System.out.println("Digite o codigo da Livraria em que o Livro ficará: ");
				int codigoLivraria = teclado.nextInt();
				livro.setCodigoLivraria(codigoLivraria);
				teclado.reset();
				LivroDAO dao = new LivroDAO();
				dao.inserir(livro);
			} else if(operacao == 2) {
				Livro livro = new Livro();
				teclado = new Scanner(System.in);
				System.out.println("Digite o novo nome do Livro: ");
				String nome = teclado.nextLine();
				teclado.reset();
				System.out.println("Digite o codigo do livro para ser atualizado: ");
				Integer codigo = teclado.nextInt();
				teclado.reset();
				LivroDAO dao = new LivroDAO();
				dao.atualizar(livro);	
			}else if(operacao == 3) {
				LivroDAO dao = new LivroDAO();
				
				List<Livro> livros = dao.obterLivros();
				for (Livro l : livros) {
					System.out.println("Nome: " + l.getNome() + "\n" + "Autor: " + l.getAutor());
				}
			} else if(operacao == 4) {
				teclado = new Scanner(System.in);
				System.out.println("Digite o codigo do livro para ser deletado: ");
				Integer codigo = teclado.nextInt();
				LivroDAO dao = new LivroDAO();
				dao.deletar(codigo);
			}else {
				System.out.println("As opções são 1, 2, 3 e 4");
			}
		} 
		
		else if (valor == 3 ) {
			teclado = new Scanner(System.in);
			System.out.println("Quais opções deseja realizar? \n Inserir(1) \n Atualizar(2) \n Obter(3) \n Deletar(4) ");
			int operacao = teclado.nextInt();
			if(operacao == 1) {
				Venda venda = new Venda();
				teclado = new Scanner(System.in);
				System.out.println("Digite o codigo do livro vendido: ");
				Integer codigoLivro = teclado.nextInt();
				venda.setCodigoLivro(codigoLivro);
				teclado.reset();
				System.out.println("Digite a data da venda (yyyy-mm-dd): ");
				String data = teclado.nextLine();
				Date date = Date.valueOf(data);
				venda.setDataVenda(date);
				VendaDAO dao = new VendaDAO();
				dao.inserirVenda(venda);
			}
			else if(operacao == 2) {
				Venda venda = new Venda();
				teclado = new Scanner(System.in);
				System.out.println("Digite a data da venda para alterar (yyyy-mm-dd): ");
				String data = teclado.nextLine();
				Date date = Date.valueOf(data);
				venda.setDataVenda(date);
				teclado.reset();
				System.out.println("Digite o codigo da venda para alterar: ");
				Integer codigo = teclado.nextInt();
				venda.setCodigoVenda(codigo);
				VendaDAO dao = new VendaDAO();
				dao.atualizarVenda(venda);
			}
			else if(operacao == 3) {
				teclado = new Scanner(System.in);
				System.out.println("Selecionar Todos (1) \n Selecionar apenas um(2)");
				Integer op = teclado.nextInt();
				if(op == 1) {
					VendaDAO dao = new VendaDAO();
					List<Venda> vendas = dao.obterTodos();
					for (Venda v : vendas) {
						System.out.println("Codigo Livro: " + v.getCodigoLivro() + "\n" + "Data da Venda: " + v.getDataVenda());
					}
				}else if(op == 2) {
					VendaDAO dao = new VendaDAO();
					teclado = new Scanner(System.in);
					System.out.println("Digite um id para buscar: ");
					Integer id = teclado.nextInt();
					Venda venda = dao.obterVenda(id);
					System.out.println("Codigo venda - " + venda.getCodigoVenda() + "\n"
							+ "Codigo Livro - " + venda.getCodigoLivro() + "\n"
							+ "Data da venda - " + venda.getDataVenda());
				}else {
					System.out.println("Os valores são 1 e 2");
				}
			}
			else if(operacao == 4) {
				teclado = new Scanner(System.in);
				System.out.println("Digite um id para ser deletado: ");
				Integer codigo = teclado.nextInt();
				VendaDAO dao = new VendaDAO();
				dao.deletarVenda(codigo);
			}
		}
	}

}