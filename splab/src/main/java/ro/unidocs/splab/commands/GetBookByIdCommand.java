package ro.unidocs.splab.commands;

import ro.unidocs.splab.model.Book;

/**
 * Comanda concreta pentru cautarea unei carti dupa ID in baza de date.
 */
public class GetBookByIdCommand implements Command<Book> {
    private final CommandContext context;
    private final int id;

    public GetBookByIdCommand(CommandContext context, int id) {
        this.context = context;
        this.id = id;
    }

    @Override
    public Book execute() {
        return this.context.getBooksRepository().findById(this.id).orElse(null);
    }
}
