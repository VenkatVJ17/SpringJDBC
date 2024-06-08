package com.venkatcodes.springdatajpareal;

import com.venkatcodes.springdatajpa.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerSpringDataRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		logger.info("\n\n>>Inserting Player: {}\n", repo.save(new Player("Djokovic", "Serbia", new Date(System.currentTimeMillis()), 81)));
		logger.info("\n\n>>Inserting Player: {}\n", repo.save(new Player("Monfils", "France", new Date(System.currentTimeMillis()), 10)));
		logger.info("\n\n>>Inserting Player: {}\n", repo.save(new Player("Thiem", "Austria", new Date(System.currentTimeMillis()), 17)));
		logger.info("\n\n>>Updating Player with Id 3: {}\n", repo.save(new Player(3, "Thiem", "Austria", new Date(System.currentTimeMillis()), 17)));
		logger.info("\n\n>>Player with Id 2: {}\n", repo.findById(2));
		repo.deleteById(2);
		logger.info("\n\n>>All Players Data: {}\n", repo.findAll());
	}
}