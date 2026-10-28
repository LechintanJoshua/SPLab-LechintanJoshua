package ro.unidocs.splab.commands;

import ro.unidocs.splab.services.BooksService;

/**
 * Comanda concreta pentru stergerea unei carti dupa ID.
 */
public class DeleteBookCommand implements Command<Boolean> {
    private final BooksService booksService;
    private final int id;

    public DeleteBookCommand(BooksService booksService, int id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        return this.booksService.deleteBook(this.id);
    }
}
