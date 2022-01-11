package com.sinbo.psychologicalTest;

import com.sinbo.psychologicalTest.entity.User;
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
	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new User(1l,"Jack", "Bauer"));
			repository.save(new User(2l,"Chloe", "O'Brian"));
			repository.save(new User(3l,"Kim", "Bauer"));
			repository.save(new User(4l,"David", "Palmer"));
			repository.save(new User(5l,"Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			User customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByUsr("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
