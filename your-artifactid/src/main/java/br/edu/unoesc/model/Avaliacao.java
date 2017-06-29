package br.edu.unoesc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({

		@NamedQuery(name = Avaliacao.LISTAR, query = "select a from Avaliacao a"),

		@NamedQuery(name = Avaliacao.PESQUISAR_POR_CODIGO, query = "select a from Avaliacao a where a.codigo = :CODIGO")

})

@Entity
public class Avaliacao implements Serializable, MeuModelo {

	private static final long serialVersionUID = 3513121907430336108L;

	public static final String LISTAR = "avaliacao.listar";
	public static final String PESQUISAR_POR_CODIGO = "avaliacao.pesquisar_por_codigo";

	@Id
	@GeneratedValue
	private Long codigo;

	@ManyToOne
	private Usuario usuario;

	private String comentario;

	private Nota nota;

	public Avaliacao(Long codigo, Usuario usuario, String comentario, Nota nota) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.comentario = comentario;
		this.nota = nota;
	}

	public Avaliacao() {
		super();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

}
