package ro.unidocs.splab.commands;

import ro.unidocs.splab.model.Book;

/**
 * Comanda concreta pentru salvarea unei carti noi in baza de date via JPA.
 */
public class CreateBookCommand implements Command<Book> {
    private final CommandContext context;
    private final Book book;

    public CreateBookCommand(CommandContext context, Book book) {
        this.context = context;
        this.book = book;
    }

    @Override
    public Book execute() {
        return this.context.getBooksRepository().save(this.book);
    }
}
