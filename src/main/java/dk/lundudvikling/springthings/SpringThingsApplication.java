package dk.lundudvikling.springthings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringThingsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringThingsApplication.class, args);
	}
}
