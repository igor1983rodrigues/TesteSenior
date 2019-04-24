package br.com.amcom.TesteSeniorSB.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.amcom.TesteSeniorSB.model.entities.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{
	
}
