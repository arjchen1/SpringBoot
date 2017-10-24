package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.demo.entity.Book;

//Support Query By Example Matcher. An Example takes a probe to define the example. 
//Behind the scene, JPA will bake query
public interface BookRepository extends CrudRepository<Book, Long>, QueryByExampleExecutor<Book>{

}
