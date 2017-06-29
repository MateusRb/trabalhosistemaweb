package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.ExceptionDao.MinhaExceptionDAO;
import br.edu.unoesc.dao.CidadeDAO;
import br.edu.unoesc.dao.PessoaDAO;
import br.edu.unoesc.model.Cidade;
import br.edu.unoesc.model.Pessoa;

@Controller
@Path("/pessoa")
public class PessoaController {

	@Inject
	private Result result;

	@Inject
	private PessoaDAO pessoaDao;

	@Inject
	private CidadeDAO cidadeDao;

	private Pessoa pessoaSelecionada;

	@Get("/formulario")
	public void formulario() {
		result.include("pessoa", this.pessoaSelecionada);
		result.include("cidades", cidadeDao.listar(Cidade.LISTAR, Cidade.class));
	}

	@Get("/listar")
	public void listar() {
		result.include("resultado", pessoaDao.listar(Pessoa.LISTAR, Pessoa.class));
	}

	@Post("/salvar")
	public void listar(Pessoa pessoa) {
		if (pessoa != null) {
			try {
				pessoaDao.salvar(pessoa);
			} catch (MinhaExceptionDAO e) {
				e.printStackTrace();
			}
		}
		result.include("resultado", pessoaDao.listar(Pessoa.LISTAR, Pessoa.class));
	}

	public void listar(List<Pessoa> pessoas) {
		result.include("resultado", pessoas);
	}

	@Post("/pesquisar")
	public void pesquisar(String filtro) {
		List<Pessoa> temp = pessoaDao.pesquisarPorNome(filtro, Pessoa.PESQUISAR_POR_NOME, Pessoa.class);
		result.forwardTo(PessoaController.class).listar(temp);
	}

	@Get("/excluir/{codigo}")
	public void excluir(Long codigo) {
		Pessoa pessoa = pessoaDao.pesquisarPorCodigo(codigo, Pessoa.PESQUISAR_POR_CODIGO, Pessoa.class);
		try {
			pessoaDao.excluir(pessoa, Pessoa.class);
		} catch (MinhaExceptionDAO e) {
			e.printStackTrace();
		}
		result.forwardTo(PessoaController.class).listar();
	}

	@Get("/editar/{codigo}")
	public void editar(Long codigo) {
		this.pessoaSelecionada = pessoaDao.pesquisarPorCodigo(codigo, Pessoa.PESQUISAR_POR_CODIGO, Pessoa.class);
		result.forwardTo(PessoaController.class).formulario();
	}

}
