package br.com.livraria.entidades;

public class Livraria {
	
	private Integer codigoLivraria;
	private String nome;
	private String endereco;
	private String cnpj;
	private Integer estoque;
	
	public Livraria() {
		
	}

	public Livraria(String nome, String endereco, String cnpj, Integer estoque) {
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.estoque = estoque;
	}
	
	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	public Integer getCodigoLivraria() {
		return codigoLivraria;
	}
	public void setCodigoLivraria(Integer codigoLivraria) {
		this.codigoLivraria = codigoLivraria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
