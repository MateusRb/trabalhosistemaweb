package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller // classe controladora da tela
public class CalculadoraController {

	// injeção de dependencia
	// inversao de controle
	@Inject
	private Result result;
	
	@Get("/formulario")
	public void formulario() {
	}
	
	@Get("/somar")
	public void somar(int numero1, int numero2) {
		int soma = numero1 + numero2;
		result.include("resultado", soma);
	}
	
	
}
