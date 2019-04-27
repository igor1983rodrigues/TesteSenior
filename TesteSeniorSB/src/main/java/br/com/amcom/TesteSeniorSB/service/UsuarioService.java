package br.com.amcom.TesteSeniorSB.service;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amcom.TesteSeniorSB.configuration.Uteis.Respostas;
import br.com.amcom.TesteSeniorSB.controller.UsuarioController;
import br.com.amcom.TesteSeniorSB.model.repositories.UsuarioRepositorio;

@RestController
@RequestMapping(path = "/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioService extends UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2062694015106081136L;

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	public UsuarioService() {
		System.out.println("UsuarioService");
	}

	@PostMapping("/login")
	public Object login(@RequestBody Map<String, String> body) {
		try {
			String login = body.get("login"), senha = body.get("senha");
			return Respostas.ok(autenticar(login, senha));
		} catch (Exception ex) {
			return Respostas.unauthorized(ex);
		}
	}

}
