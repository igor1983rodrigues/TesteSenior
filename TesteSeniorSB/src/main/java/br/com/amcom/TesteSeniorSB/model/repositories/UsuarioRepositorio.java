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
	@Query("select		u \r\n" + 
			"from		br.com.amcom.TesteSeniorSB.model.entities.Usuario u \r\n" + 
			"where		u.emailUsuario = ?1 \r\n" + 
			"and		u.senhaUsuario = ?2 \r\n" + 
			"and		u.idUsuario = u.idUsuario \r\n" + 
			"and		u.dataExcluidoUsuario is null")
	Set<Usuario> getUsuario(String login, String senha);
	
}
