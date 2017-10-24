package com.example.demo.controller;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

/*
 * More examples:
 * https://github.com/spring-projects/spring-data-examples/tree/master/jpa
 */

@RestController
@RequestMapping("skoob")
public class BookController {
	
	public BookRepository repo;
	
	//Spring 4, you can skip @Autowired
	public BookController(BookRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/all") 
	public Iterable<Book> findAll() {
		return repo.findAll();
	}
	
	@GetMapping("/id") 
	public Book findById() {
		return repo.findOne(1L);
	}
	
	//Example of using projection
	@GetMapping("/proj")
	public Book proj() {
		return repo.findOne(1L);
		//repo.findSimpleBookById(1L);

	}
	
	//Example of using "Query By Example"
	@GetMapping("qbe")
	public Iterable<Book> qbe() {
	
		Author author = new Author("John", "Smith");
		Book book = new Book(null, null, null, author);
		
		ExampleMatcher matcher = ExampleMatcher.matchingAll().
				withIgnoreCase("author.firstName").
				withIgnoreCase("author.lastName");
		
		//You can create custom matcher
		Example<Book> example = Example.of(book, matcher);
		
		//Behind the scene, JPA will bake query
		return repo.findAll(example);
	}


}
