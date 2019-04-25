package br.com.amcom.TesteSeniorSB.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.amcom.TesteSeniorSB.model.entities.Solicitacao;
import br.com.amcom.TesteSeniorSB.model.repositories.SolicitacaoRepositorio;

public class SolicitacaoController {

	@Autowired
	private SolicitacaoRepositorio solicitacaoRepositorio;

	public Object salvar(Solicitacao model) {
		final Solicitacao salvo = this.solicitacaoRepositorio.save(model);
		Map<String, Object> map = new HashMap<>();
		
		map.put("id", salvo.getIdSolicitacao());
		map.put("message", "Solicitação registrada no sistema!");
		return map;
	}
	
}
