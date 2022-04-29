package com.example.postgresdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@ComponentScan ({"com.example.postgresdemo", "com.example.postgresdemo.service"})
@EnableJpaAuditing
public class PostgresDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(PostgresDemoApplication.class, args);
	}
}
