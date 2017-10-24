package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Book;

/*
 * curl http://localhost:8080/
 * curl http://localhost:8080/books
 * 
 * ********************
 * To add a new book
 * ********************
 * curl -i -X POST -H "Content-Type:application/json" -d "{  \"name\" : \"PM_102\",  \"price\" : 200 }" http://localhost:8080/books
 * 
 * curl http://localhost:8080/books/search
 * curl http://localhost:8080/books/search/findByName?name=PM_101
 * 
 * 
 * ********************
 * To update a book
 * ********************
 * curl -X PUT -H "Content-Type:application/json" -d "{  \"name\" : \"PM_101\",  \"price\" : 300 }" http://localhost:8080/books/1
 * curl -X PUT -H "Content-Type:application/json" -d "{  \"name\" : \"PM_101\",  \"price\" : 1000 }" http://localhost:8080/books/1
 * 
 * ********************
 * To delete a book
 * ********************
 *  curl -X DELETE http://localhost:8080/books/2
 *  curl -X DELETE http://localhost:8080/books
 *  
 * hypermedia-driven interface 
 * https://spring.io/understanding/HATEOAS
 * 
 * More examples: https://spring.io/guides/gs/accessing-data-rest/
 * 
 * 
 * 
 */
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    List<Book> findByName(@Param("name") String name);

	
}