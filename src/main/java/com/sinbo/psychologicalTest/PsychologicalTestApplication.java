package com.sinbo.psychologicalTest;

import com.sinbo.psychologicalTest.entity.user.User;
import com.sinbo.psychologicalTest.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PsychologicalTestApplication {

	private static final Logger log = LoggerFactory.getLogger(PsychologicalTestApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PsychologicalTestApplication.class, args);
	}

}
