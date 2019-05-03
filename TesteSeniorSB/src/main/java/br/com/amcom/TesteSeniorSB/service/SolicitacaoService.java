package br.com.amcom.TesteSeniorSB.service;

import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping
	@Override
	public Object listarTodos(Pageable page) {
		try {
			return Respostas.ok(super.listarTodos(page));
		} catch (Exception ex) {
			return Respostas.internalServerError(ex);
		}
	}

	@GetMapping("/emaberto")
	@Override
	public Object listarEmAberto(Pageable page) {
		try {
			return Respostas.ok(super.listarEmAberto(page));
		} catch (Exception ex) {
			return Respostas.internalServerError(ex);
		}
	}

	@GetMapping("/filtro")
	@Override
	public Object listarFiltrado(Pageable page, @RequestParam Map<String, Object> filtro) {
		try {
			return Respostas.ok(super.listarFiltrado(page, filtro));
		} catch (Exception ex) {
			return Respostas.internalServerError(ex);
		}
	}

	@GetMapping("/{id}")
	public Object getSolicitacaoId(@PathVariable("id") long id) {
		try {
			return Respostas.ok(super.getId(id));
		} catch (Exception ex) {
			return Respostas.internalServerError(ex);
		}
	}

	@PostMapping
	public Object SalvarSolicitacao(@RequestBody Solicitacao solicitacao) {
		try {
			return Respostas.ok(salvar(solicitacao));
		} catch (Exception ex) {
			return Respostas.internalServerError(ex);
		}
	}

	@PutMapping("/{id}")
	public Object SalvarSolicitacao(@PathVariable("id") long id, @RequestBody Solicitacao solicitacao) {
		try {
			return Respostas.ok(salvar(id, solicitacao));
		} catch (Exception ex) {
			return Respostas.internalServerError(ex);
		}
	}
}
