package ro.unidocs.splab.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.unidocs.splab.model.Author;

/**
 * Repository Spring Data JPA pentru entitatea Author.
 */
@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}
