package ro.unidocs.splab.commands;

import ro.unidocs.splab.model.Book;

import java.util.List;

/**
 * Comanda concreta pentru obtinerea tuturor cartilor din baza de date.
 */
public class GetAllBooksCommand implements Command<List<Book>> {
    private final CommandContext context;

    public GetAllBooksCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public List<Book> execute() {
        return this.context.getBooksRepository().findAll();
    }
}
