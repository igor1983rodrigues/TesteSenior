package br.com.amcom.TesteSeniorSB.model.dao;

import br.com.amcom.TesteSeniorSB.model.baserepository.BaseDaoRepository;
import br.com.amcom.TesteSeniorSB.model.entities.Usuario;
import br.com.amcom.TesteSeniorSB.model.idao.IUsuarioDao;
import br.com.amcom.TesteSeniorSB.model.repositories.UsuarioRepositorio;

public class UsuarioDao extends BaseDaoRepository<Usuario, UsuarioRepositorio> implements IUsuarioDao {

	public UsuarioDao() {
		super(Usuario.class);
	}
}
