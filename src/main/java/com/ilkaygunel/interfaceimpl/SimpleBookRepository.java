package com.ilkaygunel.interfaceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.ilkaygunel.interfaces.BookRepository;
import com.ilkaygunel.springcaching.pojo.Book;

@Component
public class SimpleBookRepository implements BookRepository {

	private Map<String, String> isbnBooksMap;
	private Map<String, String> titleBooksMap;

	public SimpleBookRepository() {
		isbnBooksMap = new HashMap<String, String>();
		isbnBooksMap.put("isbn-1", "1984");
		isbnBooksMap.put("isbn-2", "Hayvan Çiftliği");
		isbnBooksMap.put("isbn-3", "Kuyucaklı Yusuf");

		titleBooksMap = new HashMap<String, String>();
		titleBooksMap.put("1984", "isbn-1");
		titleBooksMap.put("Hayvan Çiftliği", "isbn-2");
		titleBooksMap.put("Kuyucaklı Yusuf", "isbn-3");

	}

	@Override
	@Cacheable("books")
	public Book getByIsbn(String isbn) {
		simulateSlowService();
		return new Book(isbn, isbnBooksMap.get(isbn));
	}

	@Override
	@Cacheable(value = "book", condition = "#title.length() > 6")
	public Book getByTitle(String title) {
		simulateSlowService();
		return new Book(titleBooksMap.get(title), title);
	}

	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}
