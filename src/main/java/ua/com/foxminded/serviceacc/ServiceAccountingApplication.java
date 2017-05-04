package ua.com.foxminded.serviceacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ua.com.foxminded.serviceacc")
public class ServiceAccountingApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServiceAccountingApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceAccountingApplication.class, args);
    }
}
