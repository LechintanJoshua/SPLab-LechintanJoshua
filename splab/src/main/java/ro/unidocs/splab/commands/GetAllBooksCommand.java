package ro.unidocs.splab.commands;

import ro.unidocs.splab.model.Book;
import ro.unidocs.splab.services.BooksService;

import java.util.List;

/**
 * Comanda concreta pentru obtinerea tuturor cartilor.
 */
public class GetAllBooksCommand implements Command<List<Book>> {
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return this.booksService.getAllBooks();
    }
}
