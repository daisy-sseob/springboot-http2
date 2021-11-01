package me.sseob.http2;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Http2Application {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring sseob !";
	}

	public static void main(String[] args) {
		SpringApplication.run(Http2Application.class, args);
	}
	
	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();

		tomcatServletWebServerFactory.addAdditionalTomcatConnectors(createStandartConnector());
		return tomcatServletWebServerFactory;
	}

	private Connector createStandartConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setPort(8080);
		return connector;
	}
}
