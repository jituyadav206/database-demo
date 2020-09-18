package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jdbc.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class JPADatabaseDemoApplication implements CommandLineRunner {

	private Logger logger=  LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(JPADatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//logger.info("All users -> {}",dao.findAllCustomRowMapper());
		logger.info("user id 1001 -> {}",repository.findById(1001));
		//logger.info("deleting 1002 -> No of row deleted- {}",dao.deleteById(1002));
		logger.info("Inserting ", repository.insert(new Person("Dola","Khagaria",new Date())));
		logger.info("Updating 1003-> {}", repository.update(new Person(1003, "Anurag","Bangalore",new Date())));


	}
}
