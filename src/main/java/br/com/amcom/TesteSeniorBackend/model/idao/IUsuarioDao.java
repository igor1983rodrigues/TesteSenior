package br.com.amcom.TesteSeniorBackend.model.idao;

import br.com.amcom.TesteSeniorBackend.model.baseinterface.IBaseDaoInterface;
import br.com.amcom.TesteSeniorBackend.model.entity.Usuario;

public interface IUsuarioDao extends IBaseDaoInterface<Usuario>{

	Usuario validar(String usuario, String senha);
}
