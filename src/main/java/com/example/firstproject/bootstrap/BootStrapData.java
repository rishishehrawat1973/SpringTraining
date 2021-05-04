package com.example.firstproject.bootstrap;

import com.example.firstproject.domain.Author;
import com.example.firstproject.domain.Book;
import com.example.firstproject.domain.Publisher;
import com.example.firstproject.repositories.AuthorRepository;
import com.example.firstproject.repositories.BookRepository;
import com.example.firstproject.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inside run()");
        Author author = new Author("Rishi","Shehrawat");
        Book book = new Book("Living Life","1234");
        author.getBooks().add(book);
        book.getAuthors().add(author);
        Publisher publisher = new Publisher("Jorhat Publishers");
        publisher.getBooks().add(book);
      //  book.setPublisher(publisher);
        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);
        System.out.println("Authors in database : "+authorRepository.count());
        System.out.println("Books in database : "+bookRepository.count());
        System.out.println("Publisher in database : "+publisherRepository.count());




    }
}
