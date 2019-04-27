package br.com.amcom.TesteSeniorBackend.configure;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import br.com.amcom.TesteSeniorBackend.service.UsuarioService;

public class AplicacaoResourceBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(UsuarioService.class).to(UsuarioService.class);
	}

}
