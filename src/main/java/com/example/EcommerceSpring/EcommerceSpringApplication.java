package com.example.EcommerceSpring;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Set;

@SpringBootApplication
@EnableJpaAuditing
public class EcommerceSpringApplication {


	public static void main(String[] args) {

		//Load environment variables from dotenv files
		Dotenv dotenv =Dotenv.configure().load();

		//Set system properties from environment variables and set them
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);

		SpringApplication.run(EcommerceSpringApplication.class, args);
	}

}
