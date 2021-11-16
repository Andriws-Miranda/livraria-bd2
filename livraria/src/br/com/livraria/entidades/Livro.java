package br.com.livraria.entidades;

public class Livro {
	
	private Integer codigoLivro;
	private String nome;
	private String autor;
	private String editora;
	private Integer estoque;
	private Double preco;
	private String isbn;
	private Livraria codigoLivraria;
	
	
	public Livro() {}

	public Livro(String nome, String autor, String editora, Integer estoque, Double preco,
			String isbn, Livraria codigoLivraria) {
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.estoque = estoque;
		this.preco = preco;
		this.isbn = isbn;
		this.codigoLivraria = codigoLivraria;
	}

	public Integer getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Integer codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Livraria getCodigoLivraria() {
		return codigoLivraria;
	}
	
	public void setCodigoLivraria(Livraria codigoLivraria) {
		this.codigoLivraria = codigoLivraria;
	}

}
