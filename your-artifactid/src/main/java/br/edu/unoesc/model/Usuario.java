package br.edu.unoesc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Usuario.LISTAR, query = "select u from Usuario u"),
		@NamedQuery(name = Usuario.BUSCAR_DUO, query = "select u from Usuario u where u.elo like :ELO and u.rota like :ROTA"),
		@NamedQuery(name = Usuario.BUSCAR_MENTOR, query = "select u from Usuario u where u.elo like :ELO and u.rota like :ROTA"),
		@NamedQuery(name = Usuario.PESQUISAR_POR_CODIGO, query = "select u from Usuario u where u.codigo = :CODIGO"),
		@NamedQuery(name = Usuario.PESQUISAR_POR_NICKNAME_E_SENHA, query = "select u from Usuario u where u.nickname like :NICKNAME and  u.senha like :SENHA")
})
@Entity
public class Usuario implements Serializable, MeuModelo {

	private static final long serialVersionUID = 6194127875029224141L;

	public static final String LISTAR = "usuario.listar";
	public static final String BUSCAR_DUO = "usuario.buscarDuo";
	public static final String BUSCAR_MENTOR = "usuario.buscarMentor";
	public static final String PESQUISAR_POR_CODIGO = "usuario.pesquisar_por_codigo";
	public static final String PESQUISAR_POR_NICKNAME_E_SENHA = "usuario.pesquisar_por_nickname_e_senha";
	// public static final String BUSCAR_TIME = "usuario.buscarTime";

	@Id
	@GeneratedValue
	private Long codigo;

	private String nickname;

	private String senha;

	private Rota rota;

	private Elo elo;

	public Usuario() {
		super();
	}

	public Usuario(Long codigo, String nickname, String senha, Rota rota, Elo elo) {
		super();
		this.codigo = codigo;
		this.nickname = nickname;
		this.senha = senha;
		this.rota = rota;
		this.elo = elo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Elo getElo() {
		return elo;
	}

	public void setElo(Elo elo) {
		this.elo = elo;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

}
