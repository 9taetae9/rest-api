package com.example.demo.book.db.service;

import com.example.demo.book.db.entity.BookEntity;
import com.example.demo.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //create, update
    public BookEntity create(BookEntity book){
        return bookRepository.save(book);
    }

    //read (all)
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }
    //delete

    //findone
}
