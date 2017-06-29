package br.edu.unoesc.model;

public enum Nota {
	
	um("1"), dois("2"), tres("3"), quatro("4"), cinco("5");
	
	private String descricao;

	private Nota(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
