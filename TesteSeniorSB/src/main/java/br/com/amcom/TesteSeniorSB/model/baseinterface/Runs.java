package br.com.amcom.TesteSeniorSB.model.baseinterface;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class Runs {
	public interface ActionFiltrar {
		void run(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root<?> root);
	}
}
