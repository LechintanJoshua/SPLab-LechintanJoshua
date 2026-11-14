package ro.unidocs.splab.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.unidocs.splab.model.Book;

/**
 * Repository Spring Data JPA pentru entitatea Book.
 * Gestioneaza persistenta cartilor si cascada peste intreaga ierarhie de elemente.
 */
@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
}
