package ua.com.foxminded.serviceacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ua.com.foxminded.serviceacc")
public class ServiceAccountingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAccountingApplication.class, args);
	}
}
