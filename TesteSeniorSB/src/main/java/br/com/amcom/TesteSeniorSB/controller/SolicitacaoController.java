package br.com.amcom.TesteSeniorSB.controller;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import br.com.amcom.TesteSeniorSB.model.dao.SolicitacaoDao;
import br.com.amcom.TesteSeniorSB.model.entities.Solicitacao;
import br.com.amcom.TesteSeniorSB.model.idao.ISolicitacaoDao;
import br.com.amcom.TesteSeniorSB.model.repositories.SolicitacaoRepositorio;

public class SolicitacaoController {

	@Autowired
	private SolicitacaoRepositorio solicitacaoRepositorio;

	@Autowired
	protected EntityManagerFactory factory;

	@PersistenceContext
	protected EntityManager entityManager;
	
	public Object salvar(Solicitacao model) {
		final Solicitacao salvo = this.solicitacaoRepositorio.save(model);
		Map<String, Object> map = new HashMap<>();
		
		map.put("id", salvo.getIdSolicitacao());
		map.put("message", "Solicitação registrada no sistema!");
		return map;
	}

	public Object salvar(long id, Solicitacao model) throws Exception {

		if (id > 0) {
			model.setIdSolicitacao(id);
			return salvar(model);
		}
		
		throw new Exception("Esta solicitação não existe ainda.");
	}

	public Object listarTodos(Pageable page) {
		return this.solicitacaoRepositorio.findAll(page);
	}

	public Object listarEmAberto(Pageable page) {
		return this.solicitacaoRepositorio.listarEmAberto(page);
	}

	public Object getId(long id) {
		return this.solicitacaoRepositorio.findById(id);
	}

	public Object listarFiltrado(Pageable page, Map<String, Object> filtro) {
		ISolicitacaoDao dao = new SolicitacaoDao(solicitacaoRepositorio, factory, entityManager);
		return dao.findByFilter(page, filtro);
	}
	
}
