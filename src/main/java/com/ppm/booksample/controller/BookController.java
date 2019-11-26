package com.ppm.booksample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ppm.booksample.model.Book;

@RestController
public class BookController {

	private static final Book[] books = { new Book(1L, "Java", "Joe"), new Book(2L, "Python", "Dan"),
			new Book(3L, "C#", "Manj") };

	@GetMapping(value = "/books", produces = { "application/json" })
	public Book[] books() {
		return books;
	}

	@GetMapping(value = "/books/{id}", produces = { "application/json" })
	public Book book(@PathVariable int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
	}

}
