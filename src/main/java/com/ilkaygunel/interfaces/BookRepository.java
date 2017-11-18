package com.ilkaygunel.interfaces;

import com.ilkaygunel.springcaching.pojo.Book;

public interface BookRepository {

	Book getByIsbn(String isbn);
	
	Book getByTitle(String title);

}
