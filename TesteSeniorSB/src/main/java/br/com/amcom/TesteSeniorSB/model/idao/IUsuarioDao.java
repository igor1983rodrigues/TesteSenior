package br.com.amcom.TesteSeniorSB.model.idao;

import br.com.amcom.TesteSeniorSB.model.baseinterface.IBaseDaoInterface;
import br.com.amcom.TesteSeniorSB.model.entities.Usuario;

public interface IUsuarioDao extends IBaseDaoInterface<Usuario> {

	Usuario validar(String usuarioNome, String senha);

}
