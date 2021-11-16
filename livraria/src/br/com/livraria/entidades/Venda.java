package br.com.livraria.entidades;

import java.sql.Date;

public class Venda {

	private Integer codigoVenda;
	private Integer codigoLivro;
	private Date dataVenda;
	
	public int getCodigoVenda() {
		return codigoVenda;
	}
	
	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	
	public Date getDataVenda() {
		return dataVenda;
	}
	
	public int getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public Venda() {
		
	}
	
	public Venda(int codigoVenda, int codigoLivro, Date dataVenda) {
		super();
		this.codigoVenda = codigoVenda;
		this.codigoLivro = codigoLivro;
		this.dataVenda = dataVenda;
	}

}
