package br.edu.unoesc.model;

public class DadosLogin {

	private String nick;

	public DadosLogin() {
		super();
	}

	public DadosLogin(String nick) {
		super();
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

}
