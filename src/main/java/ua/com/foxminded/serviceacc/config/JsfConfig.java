package ua.com.foxminded.serviceacc.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.faces.webapp.FacesServlet;

/**
 * Created by andreb on 07.04.17.
 */
@Configuration
public class JsfConfig {

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
