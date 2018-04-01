package com.phng.graphqldemo.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.phng.graphqldemo.model.Book;
import com.phng.graphqldemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLQueryResolver {
    private BookRepository bookRepository;

    @Autowired
    public BookResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
