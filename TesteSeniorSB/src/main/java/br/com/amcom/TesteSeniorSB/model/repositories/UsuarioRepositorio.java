package br.com.amcom.TesteSeniorSB.model.repositories;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.amcom.TesteSeniorSB.model.entities.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

	@Modifying
	@Transactional
	@Query("select u from br.com.amcom.TesteSeniorSB.model.entities.Usuario u where u.emailUsuario = ?1 and u.senhaUsuario = ?2 and u.idUsuario = u.idUsuario")
	Set<Usuario> getUsuario(String login, String senha);
	
}
