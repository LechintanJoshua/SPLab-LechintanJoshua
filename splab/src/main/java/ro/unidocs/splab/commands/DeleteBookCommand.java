package ro.unidocs.splab.commands;

/**
 * Comanda concreta pentru stergerea unei carti din baza de date dupa ID.
 */
public class DeleteBookCommand implements Command<Boolean> {
    private final CommandContext context;
    private final int id;

    public DeleteBookCommand(CommandContext context, int id) {
        this.context = context;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        if (this.context.getBooksRepository().findById(this.id).isEmpty()) {
            return false;
        }
        this.context.getBooksRepository().deleteById(this.id);
        return true;
    }
}
