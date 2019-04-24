package br.com.amcom.TesteSeniorBackend.controller;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import br.com.amcom.TesteSeniorBackend.model.dao.UsuarioDao;
import br.com.amcom.TesteSeniorBackend.model.entity.Usuario;
import br.com.amcom.TesteSeniorBackend.model.idao.IUsuarioDao;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//import java.security.Key;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.logging.Logger;
//
//import javax.crypto.KeyGenerator;
//import javax.enterprise.context.RequestScoped;
//import javax.inject.Inject;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//
//import br.com.amcom.TesteSeniorBackend.configure.Uteis.DateTime;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

//@RequestScoped
public class UsuarioController {

//	@Context
//	protected UriInfo uriInfo;
//
//	@Inject
//	protected Logger logger;
//
//	@Inject
//	protected KeyGenerator keyGenerator;
//
//	protected String autenticar(String usuario, String senha) {
//
//		// Authenticate the user using the credentials provided
//		authenticate(usuario, senha);
//
//		// Issue a token for the user
//		String token = issueToken(usuario);
//
//		// Return the token on the response
//		return String.format("Bearer %s", token);
//	}
//
//	private void authenticate(String usuario, String senha) {
//		// TODO Auto-generated method stub
//
//	}
//
//	// --
//	// https://antoniogoncalves.org/2016/10/03/securing-jax-rs-endpoints-with-jwt/
//	private String issueToken(String login) {
//		Key key = keyGenerator.generateKey();
//		String jwtToken = Jwts.builder().setSubject(login).setIssuer(uriInfo.getAbsolutePath().toString())
//				.setIssuedAt(new Date()).setExpiration(DateTime.toDate(LocalDateTime.now().plusMinutes(15L)))
//				.signWith(SignatureAlgorithm.HS512, key).compact();
//		return jwtToken;
//	}

	private static final String FRASE_SEGREDO = Instant.now().toString();

	private IUsuarioDao iUsuarioDao;

	public UsuarioController() {
		iUsuarioDao = new UsuarioDao();
	}

	protected Object autenticar(String usuarioNome, String senha) throws Exception {

		Usuario usuario = iUsuarioDao.validar(usuarioNome, senha);
		if (Objects.isNull(usuario)) {
			throw new Exception("Usuário ou senha não correspondente");
		}

		Map<String, String> res = new HashMap<>();
		res.put("token", gerarToken(usuario, 1));
		return res;
	}

	private String gerarToken(Usuario usuario, int diasParaExpirar) {
		// Defini qual vai ser o algoritmo da assinatura no caso vai ser o HMAC SHA512
		SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;

		// Data atual que data que o token foi gerado
		Date agora = Date.from(Instant.now());

		// Define até que data o token é pelo quantidade de dias que foi passo pelo
		// parâmetro expiraEmDias
		Calendar expira = Calendar.getInstance();

		expira.add(Calendar.DAY_OF_MONTH, diasParaExpirar);

		// Encoda a frase segredo pra base64 pra ser usada na geração do token
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(FRASE_SEGREDO);

		SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritimoAssinatura.getJcaName());

		// E finalmente utiliza o JWT builder pra gerar o token
		JwtBuilder construtor = Jwts.builder().setIssuedAt(agora)// Data que o token foi gerado
				.setIssuer(usuario.getEmailUsuario())// Coloca o login do usuário mais podia qualquer outra informação
				.signWith(algoritimoAssinatura, key)// coloca o algoritmo de assinatura e frase segredo já encodada
				.setExpiration(expira.getTime());// coloca até que data que o token é valido

		return construtor.compact();// Constrói o token retornando ele como uma String
	}

	public static Claims validaToken(String token) {
		try {
			// JJWT vai validar o token caso o token não seja valido ele vai executar uma
			// exeption
			// o JJWT usa a frase segredo pra descodificar o token e ficando assim possivel
			// recuperar as informações que colocamos no payload
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(FRASE_SEGREDO))
					.parseClaimsJws(token).getBody();

			// Aqui é um exemplo que se o token for valido e descodificado
			// vai imprimir o login que foi colocamos no token
			System.out.println(claims.getIssuer());

			return claims;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
