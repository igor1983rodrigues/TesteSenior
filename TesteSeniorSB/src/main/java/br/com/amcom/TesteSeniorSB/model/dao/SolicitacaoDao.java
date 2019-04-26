package br.com.amcom.TesteSeniorSB.model.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import br.com.amcom.TesteSeniorSB.model.baserepository.BaseDaoRepository;
import br.com.amcom.TesteSeniorSB.model.entities.Solicitacao;
import br.com.amcom.TesteSeniorSB.model.idao.ISolicitacaoDao;
import br.com.amcom.TesteSeniorSB.model.repositories.SolicitacaoRepositorio;

public class SolicitacaoDao extends BaseDaoRepository<Solicitacao, SolicitacaoRepositorio> implements ISolicitacaoDao {

	public SolicitacaoDao(SolicitacaoRepositorio repositorio) {
		super(Solicitacao.class, repositorio);
	}

	public SolicitacaoDao(SolicitacaoRepositorio repository, EntityManagerFactory factory) {
		super(Solicitacao.class, repository, factory);
	}

	public SolicitacaoDao(SolicitacaoRepositorio repository, EntityManagerFactory factory,
			EntityManager entityManager) {
		super(Solicitacao.class, repository, factory, entityManager);
	}

	@Override
	public List<Solicitacao> findByFilter(Map<String, Object> filtro) {
		return obter((predicates, criteriaBuilder, root) -> filtro.forEach((key, value) -> {
			if (value != null) {
				if ("isPendente".equalsIgnoreCase(key) && Boolean.FALSE.toString().equalsIgnoreCase(value.toString())) {
					Predicate dtAprovadoSolicitacaoNotNull = root.get("dtAprovadoSolicitacao").isNotNull();
					Predicate dtReprovadoSolicitacaoNotNull = root.get("dtReprovadoSolicitacao").isNotNull();
					Predicate ou = criteriaBuilder.or(dtAprovadoSolicitacaoNotNull, dtReprovadoSolicitacaoNotNull);
					predicates.add(ou);
				} else if ("isAprovado".equalsIgnoreCase(key)
						&& Boolean.FALSE.toString().equalsIgnoreCase(value.toString())) {
					predicates.add(root.get("dtAprovadoSolicitacao").isNull());
				} else if ("isReprovado".equalsIgnoreCase(key)
						&& Boolean.FALSE.toString().equalsIgnoreCase(value.toString())) {
					predicates.add(criteriaBuilder.and(root.get("dtReprovadoSolicitacao").isNull()));
				} else if ("nomeSolicitante".equalsIgnoreCase(key)) {
					String v = String.format("%%%s%%", value).toLowerCase();
					Expression<String> campo = criteriaBuilder.lower(root.get("solicitanteSolicitacao"));
					predicates.add(criteriaBuilder.like(campo, v));
				} else if ("emailSolicitante".equalsIgnoreCase(key)) {
					String v = String.format("%%%s%%", value).toLowerCase();
					Expression<String> campo = criteriaBuilder.lower(root.get("emailSolicitacao"));
					predicates.add(criteriaBuilder.like(campo, v));
				} else if ("descricao".equalsIgnoreCase(key)) {
					String v = String.format("%%%s%%", value).toLowerCase();
					Expression<String> campo = criteriaBuilder.lower(root.get("descricaoItemSolicitacao"));
					predicates.add(criteriaBuilder.like(campo, v));
				}
			}
		}));
	}
}
