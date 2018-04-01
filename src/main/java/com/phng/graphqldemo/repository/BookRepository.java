package com.phng.graphqldemo.repository;

import com.phng.graphqldemo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findById (String id);
}
