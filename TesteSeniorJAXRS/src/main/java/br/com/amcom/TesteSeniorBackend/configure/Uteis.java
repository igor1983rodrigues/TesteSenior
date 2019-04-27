package br.com.amcom.TesteSeniorBackend.configure;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

public class Uteis {
	public static class DateTime {
		public static Date toDate(LocalDateTime localDateTime) {
			return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		}
	}

	public static class Respostas {
		private static ResponseBuilder getCors(Status status) {
			return Response.status(status).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		}

		public static Response Ok() {
			return Respostas.getCors(Status.OK).build();
		}

		public static <T> Response Ok(T entity) {
			return Respostas.getCors(Status.OK).entity(entity).build();
		}

		public static <T extends Exception> Response Unauthorized(T ex) {
			return Respostas.getCors(Status.UNAUTHORIZED).entity(ex).build();
		}
}
}
