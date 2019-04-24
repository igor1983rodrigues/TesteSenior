package br.com.amcom.TesteSeniorBackend.model.baserepository;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.amcom.TesteSeniorBackend.configure.HibernateUtil;
import br.com.amcom.TesteSeniorBackend.model.baseinterface.IBaseDaoInterface;
import br.com.amcom.TesteSeniorBackend.model.baseinterface.RunnableInterfaces.ICriteriaFiltro;
import br.com.amcom.TesteSeniorBackend.model.baseinterface.RunnableInterfaces.ICriteriaQueryJoin;
import br.com.amcom.TesteSeniorBackend.model.baseinterface.RunnableInterfaces.ICriteriaQueryJoinResultado;

public class BaseDaoRepository<T> implements IBaseDaoInterface<T> {
	private final Class<T> tipoClasse;
	private String persistenceName;

	protected String getPersistenceName() {
		return persistenceName;
	}

	@SuppressWarnings("unchecked")
	public BaseDaoRepository(String persistenceName) {
		this.persistenceName = persistenceName;
		this.tipoClasse = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public <T1, T2, TResult> List<TResult> queryJoin(ICriteriaQueryJoin<T1, T2> fnCriterio,
			ICriteriaQueryJoinResultado<T1, T2, TResult> fnResposta, Class<T1> c1, Class<T2> c2,
			Class<TResult> cResult) {

		List<TResult> retorno = new ArrayList<>();
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);

			Root<T1> rootT1 = criteriaQuery.from(c1);
			Root<T2> rootT2 = criteriaQuery.from(c2);
			criteriaQuery.multiselect(rootT1, rootT2);

			fnCriterio.executar(builder, criteriaQuery, rootT1, rootT2);

			Query<Object[]> query = session.createQuery(criteriaQuery);

			for (Object[] objetos : query.getResultList()) {
				retorno.add(fnResposta.executar(c1.cast(objetos[0]), c2.cast(objetos[1])));
			}

			transaction.commit();

		} catch (HibernateException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return retorno;
	}

	@Override
	public void merge(T model) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory(persistenceName);
			manager = factory.createEntityManager();

			manager.getTransaction().begin();
			// manager.persist(model);
			manager.merge(model);
			manager.getTransaction().commit();

		} catch (Exception ex) {
			if (manager != null) {
				manager.getTransaction().rollback();
			}
			throw ex;
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}

	@Override
	public void inserir(T model) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory(persistenceName);
			manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.persist(model);
			manager.getTransaction().commit();

		} catch (Exception ex) {
			if (manager != null) {
				manager.getTransaction().rollback();
			}
			throw ex;
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
//		int idResult = 0;
//		Session session = null;
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Transaction transaction = null;
//		try {
//			session = sessionFactory.openSession();
//
//			transaction = session.beginTransaction();
//
//			idResult = (int) session.save(model);
//
//			transaction.commit();
//
//		} catch (HibernateException ex) {
//			ex.printStackTrace();
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			throw ex;
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//
//		return idResult;
	}

	@Override
	public void alterar(T model) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory(persistenceName);
			manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.merge(model);
			manager.getTransaction().commit();

		} catch (Exception ex) {
			if (manager != null) {
				manager.getTransaction().rollback();
			}
			throw ex;
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
//		Session session = null;
//		Transaction transaction = null;
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		try {
//			session = sessionFactory.openSession();
//
//			transaction = session.beginTransaction();
//
//			session.saveOrUpdate(model);
//
//			transaction.commit();
//
//		} catch (HibernateException ex) {
//			ex.printStackTrace();
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			throw ex;
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
	}

	@Override
	public void excluir(T model) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory(persistenceName);
			manager = factory.createEntityManager();

			manager.getTransaction().begin();
			T c = manager.merge(model);
			manager.remove(c);
			manager.getTransaction().commit();

		} catch (Exception ex) {
			if (manager != null) {
				manager.getTransaction().rollback();
			}
			throw ex;
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
//		Session session = null;
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Transaction transaction = null;
//		try {
//			session = sessionFactory.openSession();
//
//			transaction = session.beginTransaction();
//
//			session.delete(model);
//
//			transaction.commit();
//
//		} catch (HibernateException ex) {
//			ex.printStackTrace();
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			throw ex;
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
	}

	@Override
	public T obterPorChave(int parametros) {
		T model = null;

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory(persistenceName);
			manager = factory.createEntityManager();

			model = manager.find(tipoClasse, parametros);

			System.out.println(model);

			return model;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			if (manager != null) {
				manager.getTransaction().rollback();
			}
			throw ex;
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
//		Session session = null;
//		Transaction transaction = null;
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//		try {
//			session = sessionFactory.openSession();
//			transaction = session.beginTransaction();
//			model = (T) session.get(tipoClasse, parametros);
//			transaction.commit();
//		} catch (HibernateException ex) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			throw ex;
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//
//		return model;
	}

	@Override
	public List<T> obter(ICriteriaFiltro<T> filtrar) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory(getPersistenceName());
			manager = factory.createEntityManager();

			CriteriaBuilder builder = manager.getCriteriaBuilder();

			CriteriaQuery<T> criterio = builder.createQuery(tipoClasse);

			Root<T> variableRoot = criterio.from(tipoClasse);
			criterio.select(variableRoot);

			filtrar.executar(builder, criterio, variableRoot);

			return manager.createQuery(criterio).getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw ex;
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}

	private String getQuery() {
		int beginIndex = this.tipoClasse.getName().lastIndexOf('.');
		String name = this.tipoClasse.getName().substring(beginIndex + 1);
		return String.format("from %s where 1=1\n", name);
	}

	@Override
	public List<T> obterTodos() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory(persistenceName);
			manager = factory.createEntityManager();

			@SuppressWarnings("unchecked")
			List<T> result = manager.createQuery(getQuery()).getResultList();
			System.out.println(result);
			return result;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}

//		List<T> retorno = null;
//		Session session = null;
//		Transaction transaction = null;
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		try {
//			session = sessionFactory.openSession();
//			transaction = session.beginTransaction();
//
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<T> criterio = builder.createQuery(tipoClasse);
//			Root<T> variableRoot = criterio.from(tipoClasse);
//			criterio.select(variableRoot);
//			retorno = session.createQuery(criterio).getResultList();
//
//			transaction.commit();
//
//		} catch (Exception ex) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			throw ex;
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//
//		return retorno;
	}

}