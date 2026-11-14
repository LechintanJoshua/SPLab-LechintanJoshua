package ro.unidocs.splab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unidocs.splab.model.Book;
import ro.unidocs.splab.persistence.CrudRepository;

import java.util.List;

/**
 * Service Layer ce utilizeaza stratul de persistenta CrudRepository (JPA).
 */
@Service
public class BooksService {
    private final CrudRepository<Book, Integer> booksRepository;

    @Autowired
    public BooksService(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return this.booksRepository.findAll();
    }

    public Book getBookById(int id) {
        return this.booksRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        return this.booksRepository.save(book);
    }

    public Book updateBook(int id, Book book) {
        if (this.booksRepository.findById(id).isEmpty()) {
            return null;
        }
        book.setId(id);
        return this.booksRepository.save(book);
    }

    public boolean deleteBook(int id) {
        if (this.booksRepository.findById(id).isEmpty()) {
            return false;
        }
        this.booksRepository.deleteById(id);
        return true;
    }
}
