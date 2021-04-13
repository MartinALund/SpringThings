package dk.lundudvikling.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}
}
