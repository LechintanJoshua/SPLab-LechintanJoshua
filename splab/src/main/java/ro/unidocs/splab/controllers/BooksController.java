package ro.unidocs.splab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unidocs.splab.commands.*;
import ro.unidocs.splab.commands.executors.CommandExecutor;
import ro.unidocs.splab.model.Book;
import ro.unidocs.splab.persistence.CrudRepository;

import java.util.List;

/**
 * Controller REST pentru gestionarea cartilor prin comenzi si stratul de persistenta
 * abstractizat CrudRepository conform cerintelor 7-9 din laborator.
 */
@RestController
public class BooksController {
    private final CrudRepository<Book, Integer> booksRepository;
    private final CommandExecutor commandExecutor;

    @Autowired
    public BooksController(CrudRepository<Book, Integer> booksRepository, CommandExecutor commandExecutor) {
        this.booksRepository = booksRepository;
        this.commandExecutor = commandExecutor;
    }

    /**
     * GET /books - returneaza toate cartile din baza de date.
     */
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        CommandContext context = new CommandContext(this.booksRepository);
        Command<List<Book>> cmd = new GetAllBooksCommand(context);
        List<Book> books = this.commandExecutor.execute(cmd);
        return ResponseEntity.ok(books);
    }

    /**
     * GET /books/{id} - returneaza detaliile despre cartea cu id-ul specificat.
     */
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        CommandContext context = new CommandContext(this.booksRepository);
        Command<Book> cmd = new GetBookByIdCommand(context, id);
        Book book = this.commandExecutor.execute(cmd);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    /**
     * POST /books - creaza o carte noua si o salveaza in baza de date.
     */
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        CommandContext context = new CommandContext(this.booksRepository);
        Command<Book> cmd = new CreateBookCommand(context, book);
        Book created = this.commandExecutor.execute(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * PUT /books/{id} - inlocuieste reprezentarea cartii specificate in baza de date.
     */
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        CommandContext context = new CommandContext(this.booksRepository);
        Command<Book> cmd = new UpdateBookCommand(context, id, book);
        Book updated = this.commandExecutor.execute(cmd);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    /**
     * DELETE /books/{id} si DELETE /book/{id} - sterge cartea cu id-ul specificat din baza de date.
     */
    @DeleteMapping({"/books/{id}", "/book/{id}"})
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        CommandContext context = new CommandContext(this.booksRepository);
        Command<Boolean> cmd = new DeleteBookCommand(context, id);
        boolean deleted = this.commandExecutor.execute(cmd);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
