package br.com.amcom.TesteSeniorSB.model.baseinterface;

import br.com.amcom.TesteSeniorSB.model.baseinterface.Runs.ActionFiltrar;

public interface IBaseDaoInterface<T> {
	void inserir(T model);

	void merge(T model);

	void alterar(T model);

	void excluir(T model);

	T obterPorChave(int parametros);

	Iterable<T> obter(ActionFiltrar filtrar);

	Iterable<T> obterTodos();
}