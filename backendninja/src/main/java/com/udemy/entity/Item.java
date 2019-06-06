package com.udemy.entity;

public class Item {

	private int quantidade;
	private String formato;
	private String codigo;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Item [quantidade=" + quantidade + ", formato=" + formato + ", codigo=" + codigo + "]";
	}

	
	
}
