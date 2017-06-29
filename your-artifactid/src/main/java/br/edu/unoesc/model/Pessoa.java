package br.edu.unoesc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({

	@NamedQuery(name=Pessoa.LISTAR, query="select p from Pessoa p"),
	@NamedQuery(name=Pessoa.PESQUISAR_POR_NOME, 
	  query="select p from Pessoa p where p.nome like :NOME"),
	@NamedQuery(name=Pessoa.PESQUISAR_POR_CODIGO,
		query="select p from Pessoa p where p.codigo = :CODIGO")
		
}) 
@Entity
public class Pessoa  implements Serializable, MeuModelo {

	private static final long serialVersionUID = 8367051080865662568L;
	
	public static final String LISTAR = "pessoa.listar";
	public static final String PESQUISAR_POR_NOME 
	   = "pessoa.pesquisar_por_nome";
	public static final String PESQUISAR_POR_CODIGO = 
			"pessoa.pesquisar_por_codigo";
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Double altura;
	
	@ManyToOne(targetEntity=Cidade.class)
	@JoinColumn(name="codcidade", nullable=false)
	private Cidade cidade = new Cidade();

	public Pessoa() {
	}

	public Pessoa(Long codigo, String nome, Double altura) {
		this.codigo = codigo;
		this.nome = nome;
		this.altura = altura;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	
}
