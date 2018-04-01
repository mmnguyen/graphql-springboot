package com.phng.graphqldemo.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.phng.graphqldemo.model.Book;
import com.phng.graphqldemo.repository.AuthorRepository;
import com.phng.graphqldemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    @Autowired
    public BookMutation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book newBook(String title, String isbn, Integer pageCount, String authorId) {
        Book book = new Book();
        book.setPageCount(0);
        book.setAuthor(authorRepository.findById(authorId).get());
        book.setIsbn(isbn);
        book.setTitle(title);
        return bookRepository.save(book);
    }
}
