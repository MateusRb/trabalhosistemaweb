package br.com.caelum.vraptor.controller;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.ExceptionDao.MinhaExceptionDAO;
import br.edu.unoesc.dao.UsuarioDAO;
import br.edu.unoesc.model.Elo;
import br.edu.unoesc.model.Rota;
import br.edu.unoesc.model.Usuario;

@Controller
@Path("/usuario")
public class UsuarioController {

	@Inject
	private Result result;
	@Inject
	private UsuarioDAO usuarioDao;

	private Usuario usuarioSelecionado;

	@Get("/formulario")
	public void formulario() {
		result.include("usuario", this.usuarioSelecionado);
		result.include("elo", Arrays.asList(Elo.values()));
		result.include("rota", Arrays.asList(Rota.values()));
	}

	@Get("/listar")
	public void listar() {
		result.include("resultado", usuarioDao.listar(Usuario.LISTAR, Usuario.class));
	}
	
	@Get("/listar2")
	public void listar2() {
		result.include("resultado", usuarioDao.listar(Usuario.LISTAR, Usuario.class));
	}


	@Post("/salvar")
	public void listar(Usuario usuario) {
		if (usuario != null) {
			try {
				usuarioDao.salvar(usuario);
			} catch (MinhaExceptionDAO e) {
				result.include("erro", e.getMessage());
			}
		}
		result.forwardTo(LoginController.class).index(usuario.getNickname(), usuario.getSenha());
	}

	public void listar(List<Usuario> usuarios) {
		result.include("resultado", usuarios);
	}

	@Post("/buscarDuo")
	public void buscarDuo(Elo elo, Rota rota) {
		List<Usuario> usuarios = usuarioDao.pesquisarDuo(elo, rota, Usuario.BUSCAR_DUO, Usuario.class);
		result.forwardTo(UsuarioController.class).listar(usuarios);
	}

	@Post("/buscarMentor")
	public void buscarMentor(Elo elo, Rota rota) {
		List<Usuario> usuarios = usuarioDao.pesquisarMentor(elo, rota, Usuario.BUSCAR_MENTOR, Usuario.class);
		result.forwardTo(UsuarioController.class).listar(usuarios);
	}

	@Get("/excluir/{codigo}")
	public void excluir(Long codigo) {
		Usuario usr = new Usuario();
		usr.setCodigo(codigo);
		try {
			usuarioDao.excluir(usr, Usuario.class);
		} catch (MinhaExceptionDAO e) {

			e.printStackTrace();
		}
		result.forwardTo(UsuarioController.class).listar();
	}

	@Get("/editar/{codigo}")
	public void editar(Long codigo) {
		this.usuarioSelecionado = usuarioDao.pesquisarPorCodigo(codigo, Usuario.PESQUISAR_POR_CODIGO, Usuario.class);
		result.forwardTo(UsuarioController.class).formulario();
	}

}
