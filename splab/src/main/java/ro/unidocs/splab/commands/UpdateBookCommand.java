package ro.unidocs.splab.commands;

import ro.unidocs.splab.model.Book;

/**
 * Comanda concreta pentru actualizarea unei carti existente in baza de date.
 */
public class UpdateBookCommand implements Command<Book> {
    private final CommandContext context;
    private final int id;
    private final Book book;

    public UpdateBookCommand(CommandContext context, int id, Book book) {
        this.context = context;
        this.id = id;
        this.book = book;
    }

    @Override
    public Book execute() {
        if (this.context.getBooksRepository().findById(this.id).isEmpty()) {
            return null;
        }
        this.book.setId(this.id);
        return this.context.getBooksRepository().save(this.book);
    }
}
