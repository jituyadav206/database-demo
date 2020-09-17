package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jdbc.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger=  LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}",dao.findAllCustomRowMapper());
		logger.info("user id 1001 -> {}",dao.findById(1001));
		logger.info("deleting 1002 -> No of row deleted- {}",dao.deleteById(1002));
		logger.info("Inserting 1004-> {}", dao.insert(new Person(1004,"Dola","Khagaria",new Date())));
		logger.info("Updating 1003-> {}", dao.update(new Person(1003, "Anurag","Bangalore",new Date())));


	}
}
