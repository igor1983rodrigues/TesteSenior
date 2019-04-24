package br.com.amcom.TesteSeniorBackend.model.dao;

import java.util.List;

import javax.persistence.criteria.Predicate;

import br.com.amcom.TesteSeniorBackend.model.baserepository.BaseDaoRepository;
import br.com.amcom.TesteSeniorBackend.model.entity.Usuario;
import br.com.amcom.TesteSeniorBackend.model.idao.IUsuarioDao;

public class UsuarioDao extends BaseDaoRepository<Usuario> implements IUsuarioDao {

	public UsuarioDao() {
		super("PERSISTENCE");
	}

	@Override
	public Usuario validar(String usuario, String senha) {
		
		List<Usuario> lista = this.obter((builder, criterio, variableRoot)-> {
			Predicate[] params = new Predicate[2];
			
			params[0] = builder.and(builder.equal(variableRoot.get("emailUsuario"), usuario));
			params[1] = builder.and(builder.equal(variableRoot.get("senhaUsuario"), senha));
			
			criterio.where(params);
		});		
		
		if (lista.size() > 0)
			return lista.get(0);
		
		return null;	
	}

}
