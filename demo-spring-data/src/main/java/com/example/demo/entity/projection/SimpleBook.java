package com.example.demo.entity.projection;

import com.example.demo.entity.Book;

/* Spring Projection:
 * 
 * What is we just need a few fields from Book Entity? isbn and title?
 * Sometimes we need to alter the view of the model for various reasons.
 * 
 * Example: https://github.com/roberthunt/spring-data-native-query-projection
 */
@Projection(name = "simple", types = { Book.class })
public interface SimpleBook {

}
