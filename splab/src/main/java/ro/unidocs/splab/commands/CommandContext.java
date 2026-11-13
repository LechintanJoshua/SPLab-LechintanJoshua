package ro.unidocs.splab.commands;

import ro.unidocs.splab.model.Book;
import ro.unidocs.splab.persistence.CrudRepository;

/**
 * Context ce stocheaza dependentele externe (persistenta) necesare executiei comenzilor,
 * utilizand interfata abstracta CrudRepository conform cerintei 9 din laborator.
 */
public class CommandContext {
    private final CrudRepository<Book, Integer> booksRepository;

    public CommandContext(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public CrudRepository<Book, Integer> getBooksRepository() {
        return this.booksRepository;
    }
}
