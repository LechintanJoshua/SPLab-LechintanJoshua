package ro.unidocs.splab.commands;

import ro.unidocs.splab.model.Book;
import ro.unidocs.splab.services.BooksService;

/**
 * Comanda concreta pentru obtinerea unei carti dupa ID.
 */
public class GetBookByIdCommand implements Command<Book> {
    private final BooksService booksService;
    private final int id;

    public GetBookByIdCommand(BooksService booksService, int id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Book execute() {
        return this.booksService.getBookById(this.id);
    }
}
