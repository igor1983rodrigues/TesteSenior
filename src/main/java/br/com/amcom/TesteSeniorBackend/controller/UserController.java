package br.com.amcom.TesteSeniorBackend.controller;

import javax.crypto.KeyGenerator;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.HttpHeaders;

import br.com.amcom.TesteSeniorBackend.configure.Autenticator;
import br.com.amcom.TesteSeniorBackend.configure.Autenticator.Headers;

public class UserController {

	public Object autenticar(String usuario, String senha) throws Throwable {
        // Authenticate the user using the credentials provided
        authenticate(usuario, senha);

        // Issue a token for the user
        String token = issueToken(usuario);

        // Return the token on the response
        return "Bearer " + token;
	}
	
	//-- https://antoniogoncalves.org/2016/10/03/securing-jax-rs-endpoints-with-jwt/
    private String issueToken(String login) {
        Key key = KeyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return jwtToken;
    }
}
