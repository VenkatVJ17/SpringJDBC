package com.venkatcodes.springdatajpa;

import com.venkatcodes.springjdbc.PlayerDao;
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
	PlayerRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//insert players
		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player("Djokovic", "Serbia", new Date(System.currentTimeMillis()), 81)));
		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player("Monfils", "France", new Date(System.currentTimeMillis()), 10)));
		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player("Thiem", "Austria",
						new Date(System.currentTimeMillis()), 17)));
		//update player
		logger.info("\n\n>> Updating Player with Id 3: {}\n", repo.updatePlayer(
				new Player(3, "Thiem", "Austria", new Date(System.currentTimeMillis()), 17)));
		//get player
		logger.info("\n\n>> Player with id 3: {}\n", repo.getPlayerById(3));
		//delete player
		repo.deletePlayerById(2);

		//get all players
		logger.info("\n\n>> All Players Data: {}", repo.getAllPlayers());
	}
}