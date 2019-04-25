package br.com.amcom.TesteSeniorSB.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amcom.TesteSeniorSB.configuration.Uteis.Respostas;
import br.com.amcom.TesteSeniorSB.controller.SolicitacaoController;
import br.com.amcom.TesteSeniorSB.model.entities.Solicitacao;

@RestController
@RequestMapping(path = "/api/solicitacao")
@CrossOrigin(origins = "*")
public class SolicitacaoService extends SolicitacaoController {

	@PostMapping
	public Object SalvarSolicitacao(@RequestBody Solicitacao solicitacao) {
		try {
			return Respostas.ok(salvar(solicitacao));
		}catch (Exception ex) {
			return Respostas.internalServerError(ex);
		}
	}
}
