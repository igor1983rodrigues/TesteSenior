package br.com.amcom.TesteSeniorSB.model.dao;

import java.util.List;

import br.com.amcom.TesteSeniorSB.model.baserepository.BaseDaoRepository;
import br.com.amcom.TesteSeniorSB.model.entities.Usuario;
import br.com.amcom.TesteSeniorSB.model.idao.IUsuarioDao;
import br.com.amcom.TesteSeniorSB.model.repositories.UsuarioRepositorio;

public class UsuarioDao extends BaseDaoRepository<Usuario, UsuarioRepositorio> implements IUsuarioDao {

	public UsuarioDao() {
		super(Usuario.class);
	}

	@Override
	public Usuario validar(String usuarioNome, String senha) {

		List<Usuario> lista = obter((predicate, criteriaBuilder, root) -> {
			predicate.add(criteriaBuilder.equal(root.get("emailUsuario"), usuarioNome));
			predicate.add(criteriaBuilder.equal(root.get("emailUsuario"), usuarioNome));
		});

		if (lista.size() > 0)
			return lista.get(0);

		return null;
	}
}
