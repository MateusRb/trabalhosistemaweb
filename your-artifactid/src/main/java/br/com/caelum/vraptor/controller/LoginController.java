package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.UsuarioDAO;
import br.edu.unoesc.model.DadosLogin;
import br.edu.unoesc.model.Usuario;

@Controller
@Path("/login")
public class LoginController {

	@Inject
	private UsuarioDAO usuarioDao;

	@Inject
	private Result result;

	@Get("")
	public void index(String nickname, String senha) {
		try {
			usuarioDao.pesquisarPorNicknameESenha(nickname, senha, Usuario.PESQUISAR_POR_NICKNAME_E_SENHA,
					Usuario.class);
			
		} catch (Exception e) {
			result.forwardTo(LoginController.class).erro();
		}
		DadosLogin dadosLogin = new DadosLogin();
		dadosLogin.setNick(nickname);
	}

	@Get("/erro")
	public void erro() {

	}

}