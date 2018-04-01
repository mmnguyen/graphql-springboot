package com.phng.graphqldemo.repository;

import com.phng.graphqldemo.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Optional<Author> findById (String id);
    Iterable<Author> findAuthorByFirstNameOrLastName (String firstName, String lastName);
}
