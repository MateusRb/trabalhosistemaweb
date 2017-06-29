package br.edu.unoesc.model;

public enum Rota {

	atirador("Atirador"), suporte("Suporte"), cacador("Caçador"), meio("Meio"), topo("Topo");

	private String descricao;

	private Rota(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	// public List<Rota> getDescricao() {
	// return new ArrayList<Rota>(Arrays.asList(Rota.values()));
	// }

}
