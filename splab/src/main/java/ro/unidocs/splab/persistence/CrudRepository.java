package ro.unidocs.splab.persistence;

import java.util.List;
import java.util.Optional;

/**
 * Interfata generica de persistenta (Target in sablonul Adapter).
 * Abstractizeaza operatiile CRUD de acces la date pentru straturile superioare.
 *
 * @param <T>  Tipul entitatii.
 * @param <ID> Tipul cheii primare.
 */
public interface CrudRepository<T, ID> {
    T save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    void deleteById(ID id);
}
