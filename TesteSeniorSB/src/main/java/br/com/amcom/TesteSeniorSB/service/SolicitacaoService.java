package br.com.amcom.TesteSeniorSB.service;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/solicitacao")
public class SolicitacaoService {

	@PostMapping
	public Object SalvarSolicitacao(Map<String, Object> solicitacao) {
		return solicitacao;
	}
}
