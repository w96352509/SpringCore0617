package com.spring.core.session02.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.core.session02.beans.Author;

@Configuration
public class AuthorConfig {

	@Bean(name="author")
	public Author getAuthor() {
		// DI依賴注入的建構子注入 
		Author author = new Author("John" , 'm' ,18);
		return author;
	}
	
}
