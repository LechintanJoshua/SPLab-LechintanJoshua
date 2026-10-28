package ro.unidocs.splab.commands;

import ro.unidocs.splab.model.Book;
import ro.unidocs.splab.services.BooksService;

/**
 * Comanda concreta pentru actualizarea unei carti existente.
 */
public class UpdateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final int id;
    private final Book book;

    public UpdateBookCommand(BooksService booksService, int id, Book book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public Book execute() {
        return this.booksService.updateBook(this.id, this.book);
    }
}
