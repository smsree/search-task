package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/book/{name}")
	public List<Book> getbyName(@PathVariable("name") String name){
		return repository.findByTitleContaining(name);
	}
	
	@PostMapping("/book")
	public Book postBook(@RequestBody Book book) {
		return repository.save(book);
	}

}
