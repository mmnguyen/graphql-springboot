package com.phng.graphqldemo.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.phng.graphqldemo.model.Author;
import com.phng.graphqldemo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation implements GraphQLMutationResolver {
    AuthorRepository authorRepository;

    @Autowired
    public AuthorMutation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author newAuthor (String lastName, String firstName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return authorRepository.save(author);
    }
}
