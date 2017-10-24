package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.BookRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*
	 * http://spring.io/guides/tutorials/bookmarks/
	 * Instead of using data.sql, you can use CommandLineRunner to load data which is applicable to
	 * Cassandra and MangoDB
	 */
//	@Bean
//	CommandLineRunner init(BookRepository bookRepository) {
//		return null;
//		
//	}
}
