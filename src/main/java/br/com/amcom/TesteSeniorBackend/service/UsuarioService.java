package br.com.amcom.TesteSeniorBackend.service;

import java.io.Serializable;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.amcom.TesteSeniorBackend.controller.UserController;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService extends UserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2062694015106081136L;

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("login") String login,@FormParam("senha") String senha) {
		try {
			return Response.status(200).entity(autenticar(login, senha)).build();
		} catch (Exception ex) {
			return Response.status(500).entity(ex).build();
		}
	}

}
