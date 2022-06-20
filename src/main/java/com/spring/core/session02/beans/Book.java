package com.spring.core.session02.beans;

public class Book {

	private String name;
	
	private Integer price;
	
	private Author author;

	
	
	public Book() {
		
	}

    public Book(String name, Integer price, Author author) {
		this.name = name;
		this.price = price;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	
}
