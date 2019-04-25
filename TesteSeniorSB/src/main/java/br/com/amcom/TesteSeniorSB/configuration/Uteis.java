package br.com.amcom.TesteSeniorSB.configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

public class Uteis {
	public static class DateTime {
		public static Date toDate(LocalDateTime localDateTime) {
			return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		}
	}

	public static class Respostas {

		public static BodyBuilder ok() {
			return ResponseEntity.ok();
		}

		public static <T> ResponseEntity<T> ok(T entity) {
			return ResponseEntity.ok(entity);
		}

		public static <T extends Exception> ResponseEntity<T> unauthorized(T ex) {
//			Map<String, String> map = new HashMap<>();
//			map.put("Message", ex.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex);
		}
}
}
