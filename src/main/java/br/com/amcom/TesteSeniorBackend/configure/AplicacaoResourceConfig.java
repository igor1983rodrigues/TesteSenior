package br.com.amcom.TesteSeniorBackend.configure;

import org.glassfish.jersey.server.ResourceConfig;

public class AplicacaoResourceConfig extends ResourceConfig {
	public AplicacaoResourceConfig() {
		packages(CorsFilter.class.getPackage().getName());
		register(CorsFilter.class);
		register(new AplicacaoResourceBinder());
//        register(RequestContextFilter.class);
//        register(JacksonFeature.class);
//        register(CustomerResource.class);
//        register(Initializer.class);
//        register(JerseyResource.class);
//        register(SpringSingletonResource.class);
//        register(SpringRequestResource.class);
//        register(CustomExceptionMapper.class);
//		packages(true, "br.com.amcom.TesteSeniorBackend.service", "br.com.amcom.TesteSeniorBackend.controller");
	}
}
