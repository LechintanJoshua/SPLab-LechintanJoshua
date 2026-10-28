package ro.unidocs.splab.commands;

import ro.unidocs.splab.model.Book;
import ro.unidocs.splab.services.BooksService;

/**
 * Comanda concreta pentru crearea unei carti noi.
 */
public class CreateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Book book;

    public CreateBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        return this.booksService.createBook(this.book);
    }
}
