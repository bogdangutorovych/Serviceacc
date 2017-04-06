package ua.com.foxminded.serviceacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@ComponentScan("ua.com.foxminded.serviceacc")
public class ServiceAccountingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAccountingApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder
	configure(SpringApplicationBuilder application) {
		return application.sources(ServiceAccountingApplication.class);
	}

	@Bean
	public FacesServlet facesServlet() {
		return new FacesServlet();
	}

	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration =
				new ServletRegistrationBean(facesServlet(), "*.xhtml");
		registration.setName("FacesServlet");
		return registration;
	}
}
