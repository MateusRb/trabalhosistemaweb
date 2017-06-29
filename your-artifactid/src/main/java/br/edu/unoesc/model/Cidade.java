package br.edu.unoesc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({

	@NamedQuery(name=Cidade.LISTAR, query="select c from Cidade c"),
	@NamedQuery(name=Cidade.PESQUISAR_POR_NOME, 
	  query="select c from Cidade c where c.nome like :NOME"),
	@NamedQuery(name=Cidade.PESQUISAR_POR_CODIGO,
		query="select c from Cidade c where c.codigo = :CODIGO")
		
}) 
@Entity
public class Cidade implements Serializable, MeuModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -219725246936127865L;
	public static final String LISTAR = "cidade.listar";
	public static final String PESQUISAR_POR_NOME 
	   = "cidade.pesquisar_por_nome";
	public static final String PESQUISAR_POR_CODIGO = 
			"cidade.pesquisar_por_codigo";
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(nullable=false)
	private String nome;

	public Cidade() {
	}

	public Cidade(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
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
	
}