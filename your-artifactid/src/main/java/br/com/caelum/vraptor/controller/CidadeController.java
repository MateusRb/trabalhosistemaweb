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
import br.edu.unoesc.model.Cidade;

@Controller
@Path("/cidade")
public class CidadeController {

	@Inject
	private Result result;
	
	@Inject
	private CidadeDAO cidadeDao;
	
	private Cidade cidadeSelecionada;
	
	@Get("/formulario")
	public void formulario() {
		result.include("cidade", this.cidadeSelecionada);
	}
	
	@Get("/listar")
	public void listar() {
		result.include("resultado", cidadeDao.listar(Cidade.LISTAR, Cidade.class) );
	}
	
	@Post("/salvar")
	public void listar(Cidade cidade) {
		if (cidade != null) {
			try {
				cidadeDao.salvar(cidade);	
			} catch (MinhaExceptionDAO e) {
				result.include("erro", e.getMessage());
			}
		}
		result.include("resultado", cidadeDao.listar(Cidade.LISTAR, Cidade.class) );
	}

	public void listar(List<Cidade> cidades) {
		result.include("resultado", cidades);
	}
	
	@Post("/pesquisar")
	public void pesquisar(String filtro) {
		List<Cidade> cidades = cidadeDao.pesquisarPorNome(filtro, 
				Cidade.PESQUISAR_POR_NOME, Cidade.class);
		result.forwardTo(CidadeController.class).listar(cidades);
	}
	
	@Get("/excluir/{codigo}")
	public void excluir(Long codigo) {
		Cidade cid = new Cidade();
		cid.setCodigo(codigo);
		try {
			cidadeDao.excluir(cid, Cidade.class);
		} catch (MinhaExceptionDAO e) {
			e.printStackTrace();
		}
		result.forwardTo(CidadeController.class).listar();
	}
	
	@Get("/editar/{codigo}")
	public void editar(Long codigo) {
		this.cidadeSelecionada = 
			(Cidade) cidadeDao.pesquisarPorCodigo(codigo, Cidade.PESQUISAR_POR_CODIGO, Cidade.class);
		result.forwardTo(CidadeController.class).formulario();
	}
	
}