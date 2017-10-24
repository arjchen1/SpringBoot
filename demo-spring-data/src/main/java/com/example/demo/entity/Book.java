package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;


//@Data //Using Lombok
//@Getter @Setter
@Entity
@Table(name = "tbl_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;
    private String isbn;
    
    
    @OneToOne 
    @JoinColumn(name="author_id") 
    private Author author;
    //private Long author_id;

    @JsonCreator
    public Book() {
    	
    }
    
    @JsonCreator
	public Book( String title, 
			 Double price, 
			 String isbn, 
			 Author author) {
		this.title = title;
		this.price = price;
		this.isbn = isbn;
		this.author = author;
	}



    @Override
    public String toString() {
    		return String.format(
                "Book[id=%d, name='%s', price='%s']",
                id, title, price);

    }


	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
  
}
