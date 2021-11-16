package br.com.livraria.entidades;

public class Livro {
	
	private Integer codigoLivro;
	private String nome;
	private String autor;
	private String editora;
	private Double preco;
	private String isbn;
	private Integer codigoLivraria;
	
	
	public Livro() {}

	public Livro(String nome, String autor, String editora, Double preco,
			String isbn, Integer codigoLivraria) {
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
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


	public Integer getCodigoLivraria() {
		return codigoLivraria;
	}
	
	public void setCodigoLivraria(Integer codigoLivraria) {
		this.codigoLivraria = codigoLivraria;
	}

}