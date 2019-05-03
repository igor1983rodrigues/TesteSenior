package br.com.amcom.TesteSeniorSB.model.idao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.amcom.TesteSeniorSB.model.baseinterface.IBaseDaoInterface;
import br.com.amcom.TesteSeniorSB.model.entities.Solicitacao;

public interface ISolicitacaoDao extends IBaseDaoInterface<Solicitacao> {

	List<Solicitacao> findByFilter(Map<String, Object> filtro);

	Page<Solicitacao> findByFilter(Pageable page, Map<String, Object> filtro);
}
