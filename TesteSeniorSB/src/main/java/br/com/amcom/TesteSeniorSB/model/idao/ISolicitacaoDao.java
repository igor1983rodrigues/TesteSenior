package br.com.amcom.TesteSeniorSB.model.idao;

import java.util.List;
import java.util.Map;
import br.com.amcom.TesteSeniorSB.model.baseinterface.IBaseDaoInterface;
import br.com.amcom.TesteSeniorSB.model.entities.Solicitacao;

public interface ISolicitacaoDao extends IBaseDaoInterface<Solicitacao> {

	List<Solicitacao> findByFilter(Map<String, Object> filtro);
}
