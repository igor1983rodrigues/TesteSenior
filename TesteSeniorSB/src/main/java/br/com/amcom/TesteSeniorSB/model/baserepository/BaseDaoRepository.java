package br.com.amcom.TesteSeniorSB.model.baserepository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.amcom.TesteSeniorSB.model.baseinterface.IBaseDaoInterface;
import br.com.amcom.TesteSeniorSB.model.baseinterface.Runs.ActionFiltrar;

@Service
public class BaseDaoRepository<T, R extends CrudRepository<T, Long>> implements IBaseDaoInterface<T> {

//	@Autowired
	protected final EntityManagerFactory factory;

//	@PersistenceContext
	protected EntityManager entityManager;

//	@Autowired // This means to get the bean called taskRepository
	private R repository;

	private final Class<T> type;
	
	public BaseDaoRepository() {
		this(null, null);
	}

	public BaseDaoRepository(Class<T> type) {
		this(type, null);
	}

	public BaseDaoRepository(Class<T> type, EntityManagerFactory factory) {
		this.type = type;
		this.factory = factory;
	}

	@Override
	public void inserir(T model) {
		this.repository.save(model);
	}

	@Override
	public void merge(T model) {

	}

	@Override
	public void alterar(T model) {
		this.repository.save(model);
	}

	@Override
	public void excluir(T model) {
		this.repository.delete(model);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T obterPorChave(int parametros) {
		return (T) this.repository.findById((long) parametros);
	}

	@Override
	public List<T> obter(ActionFiltrar filtrar) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
		Root<T> root = criteriaQuery.from(type);

		List<Predicate> predicates = new ArrayList<Predicate>();

		filtrar.run(predicates, criteriaBuilder, root);

		if (!predicates.isEmpty()) {
			criteriaQuery.where(predicates.toArray(new Predicate[] {}));
		}

		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Iterable<T> obterTodos() {
		return this.repository.findAll();
	}
}