package ro.unidocs.splab.services;

import org.springframework.stereotype.Service;
import ro.unidocs.splab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Service Layer (Receiver in sablonul Command).
 * Gestioneaza colectia de carti intr-o structura de date in memorie.
 */
@Service
public class BooksService {
    private final Map<Integer, Book> books = new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public BooksService() {
        // Initializam cu cateva date demo
        Book b1 = new Book("Design Patterns: Elements of Reusable Object-Oriented Software");
        b1.setId(idGenerator.getAndIncrement());
        books.put(b1.getId(), b1);

        Book b2 = new Book("Clean Code: A Handbook of Agile Software Craftsmanship");
        b2.setId(idGenerator.getAndIncrement());
        books.put(b2.getId(), b2);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public Book createBook(Book book) {
        int id = idGenerator.getAndIncrement();
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public Book updateBook(int id, Book book) {
        if (!books.containsKey(id)) {
            return null;
        }
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public boolean deleteBook(int id) {
        return books.remove(id) != null;
    }
}
