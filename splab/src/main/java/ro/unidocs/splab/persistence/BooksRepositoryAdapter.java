package ro.unidocs.splab.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unidocs.splab.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * Adapter in sablonul Adapter.
 * Adapteaza interfata BooksRepository (Spring Data JPA) la interfata noastra CrudRepository.
 */
@Component
public class BooksRepositoryAdapter implements CrudRepository<Book, Integer> {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksRepositoryAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public Book save(Book entity) {
        return this.booksRepository.save(entity);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return this.booksRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return this.booksRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        this.booksRepository.deleteById(id);
    }
}
