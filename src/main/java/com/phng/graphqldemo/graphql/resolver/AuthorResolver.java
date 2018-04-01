package com.phng.graphqldemo.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.phng.graphqldemo.model.Author;
import com.phng.graphqldemo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver implements GraphQLQueryResolver{
    AuthorRepository authorRepository;

    @Autowired
    public AuthorResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> findAllAuthors(String firstName, String lastName) {
        if (firstName != null || lastName != null) {
            return this.authorRepository.findAuthorByFirstNameOrLastName(firstName, lastName);
        }
        return this.authorRepository.findAll();
    }

    public Author author(String id) {
        return this.authorRepository.findById(id).get();
    }
}
