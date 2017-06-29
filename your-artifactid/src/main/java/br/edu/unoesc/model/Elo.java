package br.edu.unoesc.model;

public enum Elo {

	naoRanqueado("Não Ranqueado"), bronze("Bronze"), prata("Prata"), ouro("Ouro"), platina("Platina"), diamante(
			"Diamante"), mestre("Mestre"), desafiante("Desafiante");

	private String descricao;

	private Elo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

//	public List<Elo> getDescricao() {
//		return new ArrayList<Elo>(Arrays.asList(Elo.values()));
//	}

}
