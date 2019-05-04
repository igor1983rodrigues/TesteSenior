package br.com.amcom.TesteSeniorSB.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.google.common.base.Objects;
import com.querydsl.core.types.PredicateOperation;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DslExpression;
import com.querydsl.core.types.dsl.SimpleExpression;

import br.com.amcom.TesteSeniorSB.model.baserepository.BaseDaoRepository;
import br.com.amcom.TesteSeniorSB.model.entities.QSolicitacao;
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

	@Override
	public Page<Solicitacao> findByFilter(Pageable page, Map<String, Object> filtro) {
		final QSolicitacao root = QSolicitacao.solicitacao;
		List<BooleanExpression> predicates = new ArrayList<BooleanExpression>();
		filtro.forEach((key, value) -> {
			if (value != null) {
				if ("isPendente".equalsIgnoreCase(key) && Boolean.FALSE.toString().equalsIgnoreCase(value.toString())) {
					predicates.add(root.dtAprovadoSolicitacao.isNotNull()
							.or(root.dtReprovadoSolicitacao.isNotNull()));
				} else if ("isAprovado".equalsIgnoreCase(key)
						&& Boolean.FALSE.toString().equalsIgnoreCase(value.toString())) {
					predicates.add(root.dtAprovadoSolicitacao.isNull());
				} else if ("isReprovado".equalsIgnoreCase(key)
						&& Boolean.FALSE.toString().equalsIgnoreCase(value.toString())) {
					predicates.add(root.dtReprovadoSolicitacao.isNull());
				} else if ("nomeSolicitante".equalsIgnoreCase(key)) {
					String v = String.format("%%%s%%", value).toLowerCase();
					predicates.add(root.solicitanteSolicitacao.lower().like(v));
				} else if ("emailSolicitante".equalsIgnoreCase(key)) {
					String v = String.format("%%%s%%", value).toLowerCase();
					predicates.add(root.emailSolicitacao.lower().like(v));
				} else if ("descricao".equalsIgnoreCase(key)) {
					String v = String.format("%%%s%%", value).toLowerCase();
					predicates.add(root.descricaoItemSolicitacao.lower().like(v));
				}
			}
		});
		
		BooleanExpression expression = null;
		for (BooleanExpression booleanExpression : predicates) {
			if (java.util.Objects.isNull(expression)) {
				expression = booleanExpression;
			} else {
				expression = expression.and(booleanExpression);
			}
		}
		
		if (!java.util.Objects.isNull(expression)) {
			return this.getRepository().findAll(expression, page);
		} else {
			return this.getRepository().findAll(page);
		}
	}
}
