package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.ExceptionDao.MinhaExceptionDAO;
import br.edu.unoesc.dao.AvaliacaoDAO;
import br.edu.unoesc.dao.UsuarioDAO;
import br.edu.unoesc.model.Avaliacao;
import br.edu.unoesc.model.Usuario;

@Controller
@Path("/avaliacao")
public class AvaliacaoController {

	@Inject
	private Result result;

	@Inject
	private AvaliacaoDAO avaliacaoDao;

	@Inject
	private UsuarioDAO usuarioDAO;

	private Avaliacao avaliacaoSelecionada;

	@Get("/formulario/")
	public void formulario() {
		result.include("avaliacao", this.avaliacaoSelecionada);
		result.include("usuarios", usuarioDAO.listar(Usuario.LISTAR, Usuario.class));
	}

	@Get("/listar")
	public void listar() {
		result.include("resultado", avaliacaoDao.listar(Avaliacao.LISTAR, Avaliacao.class));
	}

	@Post("/salvar")
	public void listar(Avaliacao avaliacao) {
		if (avaliacao != null) {
			try {
				avaliacaoDao.salvar(avaliacao);
			} catch (MinhaExceptionDAO e) {
				e.printStackTrace();
			}
		}
		result.include("resultado", avaliacaoDao.listar(Avaliacao.LISTAR, Avaliacao.class));
	}

	public void listar(List<Avaliacao> avaliacoes) {
		result.include("resultado", avaliacoes);
	}

	// @Post("/pesquisar")
	// public void pesquisar(String filtro) {
	// List<Avaliacao> temp = avaliacaoDao.pesquisarPorNome(filtro,
	// Pessoa.PESQUISAR_POR_NOME, Pessoa.class);
	// result.forwardTo(PessoaController.class).listar(temp);
	// }

	@Get("/excluir/{codigo}")
	public void excluir(Long codigo) {
		Avaliacao avaliacao = avaliacaoDao.pesquisarPorCodigo(codigo, Avaliacao.PESQUISAR_POR_CODIGO, Avaliacao.class);
		try {
			avaliacaoDao.excluir(avaliacao, Avaliacao.class);
		} catch (MinhaExceptionDAO e) {
			e.printStackTrace();
		}
		result.forwardTo(AvaliacaoController.class).listar();
	}

	// @Get("/editar/{codigo}")
	// public void editar(Long codigo) {
	// this.avaliacaoSelecionada = avaliacaoDao.pesquisarPorCodigo(codigo,
	// Avaliacao.PESQUISAR_POR_CODIGO,
	// Avaliacao.class);
	// result.forwardTo(AvaliacaoController.class).formulario();
	// }

}
