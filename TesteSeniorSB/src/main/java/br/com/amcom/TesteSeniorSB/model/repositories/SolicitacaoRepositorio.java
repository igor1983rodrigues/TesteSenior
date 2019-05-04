package br.com.amcom.TesteSeniorSB.model.repositories;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.amcom.TesteSeniorSB.model.entities.Solicitacao;

@Repository
public interface SolicitacaoRepositorio extends CrudRepository<Solicitacao, Long>,
		PagingAndSortingRepository<Solicitacao, Long>, QuerydslPredicateExecutor<Solicitacao> {

	@Query("select	s\r\n" + "from	br.com.amcom.TesteSeniorSB.model.entities.Solicitacao s\r\n"
			+ "where	s.idSolicitacao = s.idSolicitacao\r\n" + "and		s.dtAprovadoSolicitacao is null\r\n"
			+ "and		s.dtReprovadoSolicitacao is null")
	Set<Solicitacao> listarEmAberto();

	@Query("select	s\r\n" + "from	br.com.amcom.TesteSeniorSB.model.entities.Solicitacao s\r\n"
			+ "where	s.idSolicitacao = s.idSolicitacao\r\n" + "and		s.dtAprovadoSolicitacao is null\r\n"
			+ "and		s.dtReprovadoSolicitacao is null")
	Page<Solicitacao> listarEmAberto(Pageable page);
}
