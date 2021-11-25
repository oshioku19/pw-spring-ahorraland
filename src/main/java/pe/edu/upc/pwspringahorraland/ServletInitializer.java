package pe.edu.upc.pwspringahorraland;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder PwSpringAhorralandApplication) {
		return PwSpringAhorralandApplication.sources(PwSpringAhorralandApplication.class);
	}

}
