package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.configuracao.Conexao;
import br.com.livraria.entidades.Livro;
import br.com.livraria.entidades.Venda;

public class VendaDAO {
	private Connection con;
	
	public VendaDAO() throws SQLException, ClassNotFoundException {
		con = Conexao.criarConexao();
	}
	
	public void inserirVenda(Venda venda) {
		String sql = "INSERT INTO VENDA (codigo_livro, data_venda) values (?,?)";
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setObject(1, venda.getCodigoLivro());
			preparator.setDate(2, venda.getDataVenda());
			
			preparator.execute();
			preparator.close();
			System.out.println("Cadatro realizado com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void atualizarVenda(Venda venda) {
		String sql = "UPDATE VENDA SET data_venda = ? WHERE codigo_venda = ?";
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setDate(1, venda.getDataVenda());
			preparator.setInt(2, venda.getCodigoVenda());

			preparator.execute();
			preparator.close();
			System.out.println("Atualizado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void deletarVenda(Integer id) {
		String sql = "DELETE FROM VENDA WHERE codigo_venda = ?";
		
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, id);
			
			preparator.execute();
			preparator.close();
			System.out.println("Deletado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public List<Venda> obterTodos() {
		String sql = "SELECT * FROM VENDA";
		
		List<Venda> lista = new ArrayList<Venda>();
		
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			
			ResultSet result = preparator.executeQuery();
			while(result.next()) {
				Venda venda = new Venda();
				venda.setCodigoVenda(result.getInt("codigo_venda"));
				venda.setDataVenda(result.getDate("data_venda"));
				venda.setCodigoLivro(result.getInt("codigo_livro"));
				lista.add(venda);
			}
		}catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return lista;
	}
	
	public Venda obterVenda(int id) {
		String sql = "SELECT * FROM VENDA WHERE codigo_venda = ?";
		Venda venda = new Venda();
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, id);
			ResultSet result = preparator.executeQuery();
			while(result.next()) {
				venda.setCodigoVenda(result.getInt("codigo_venda"));
				venda.setCodigoLivro(result.getInt("codigo_livro"));
				venda.setDataVenda(result.getDate("data_venda"));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return venda;
	}
}
