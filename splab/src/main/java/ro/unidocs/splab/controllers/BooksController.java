package ro.unidocs.splab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unidocs.splab.commands.*;
import ro.unidocs.splab.commands.executors.CommandExecutor;
import ro.unidocs.splab.model.Book;
import ro.unidocs.splab.services.BooksService;

import java.util.List;

/**
 * Controller REST pentru gestionarea cartilor prin cele 5 metode HTTP,
 * utilizand sablonul Command pentru decuplarea logicii de executie.
 */
@RestController
public class BooksController {
    private final BooksService booksService;
    private final CommandExecutor commandExecutor;

    @Autowired
    public BooksController(BooksService booksService, CommandExecutor commandExecutor) {
        this.booksService = booksService;
        this.commandExecutor = commandExecutor;
    }

    /**
     * GET /books - returneaza toate cartile.
     */
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        Command<List<Book>> cmd = new GetAllBooksCommand(this.booksService);
        List<Book> books = this.commandExecutor.execute(cmd);
        return ResponseEntity.ok(books);
    }

    /**
     * GET /books/{id} - returneaza detaliile despre cartea cu id-ul specificat.
     */
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Command<Book> cmd = new GetBookByIdCommand(this.booksService, id);
        Book book = this.commandExecutor.execute(cmd);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    /**
     * POST /books - creaza o carte noua.
     */
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Command<Book> cmd = new CreateBookCommand(this.booksService, book);
        Book created = this.commandExecutor.execute(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * PUT /books/{id} - inlocuieste reprezentarea cartii specificate.
     */
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Command<Book> cmd = new UpdateBookCommand(this.booksService, id, book);
        Book updated = this.commandExecutor.execute(cmd);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    /**
     * DELETE /books/{id} si DELETE /book/{id} - sterge cartea cu id-ul specificat.
     */
    @DeleteMapping({"/books/{id}", "/book/{id}"})
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        Command<Boolean> cmd = new DeleteBookCommand(this.booksService, id);
        boolean deleted = this.commandExecutor.execute(cmd);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
