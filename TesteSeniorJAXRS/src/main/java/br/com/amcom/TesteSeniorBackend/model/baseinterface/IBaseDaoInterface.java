package br.com.amcom.TesteSeniorBackend.model.baseinterface;

import java.util.Collection;

import br.com.amcom.TesteSeniorBackend.model.baseinterface.RunnableInterfaces.ICriteriaFiltro;

public interface IBaseDaoInterface<T> {
	void inserir(T model);

	void merge(T model);

	void alterar(T model);

	void excluir(T model);

	T obterPorChave(int parametros);

	Collection<T> obter(ICriteriaFiltro<T> filtrar);

	Collection<T> obterTodos();
}
