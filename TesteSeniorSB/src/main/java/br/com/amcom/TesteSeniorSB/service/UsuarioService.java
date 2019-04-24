package br.com.amcom.TesteSeniorSB.service;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.amcom.TesteSeniorSB.controller.UsuarioController;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioService extends UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2062694015106081136L;

	@PostMapping(path = "/login")
	public Object login(@RequestBody Map<String, String> body) {
		try {
			String login = body.get("login"), senha = body.get("senha");
			return autenticar(login, senha);
		} catch (Exception ex) {
			return ex;
		}
	}

}
