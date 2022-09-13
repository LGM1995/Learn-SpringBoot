package com.example.clone_quizlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // 잠시 spring security 설정을 끈다!
public class CloneQuizletApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneQuizletApplication.class, args);
	}

}
