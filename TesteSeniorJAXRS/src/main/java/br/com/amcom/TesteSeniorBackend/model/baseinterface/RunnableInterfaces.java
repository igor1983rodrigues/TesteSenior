package br.com.amcom.TesteSeniorBackend.model.baseinterface;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;

public class RunnableInterfaces {
	public interface ICriteriaFiltro<T> {
		void executar(CriteriaBuilder builder, CriteriaQuery<T> criterio, Root<T> variableRoot);

	}

	public interface ICriteriaQueryJoin<T1, T2> {
		void executar(CriteriaBuilder builder, CriteriaQuery<Object[]> criteriaQuery, Root<T1> rootT1, Root<T2> rootT2);
	}

	public interface ICriteriaQueryJoinResultado<T1, T2, TResult> {
		TResult executar(T1 obj1, T2 obj2);
	}

	public interface ICriteriaRestrictions {
		Criterion executar(Disjunction disjunction);
	}
}
