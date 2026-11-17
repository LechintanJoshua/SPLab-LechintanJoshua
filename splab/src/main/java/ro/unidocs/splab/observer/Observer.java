package ro.unidocs.splab.observer;

import ro.unidocs.splab.model.Book;

/**
 * Interfata Observer din sablonul Observer.
 * Defineste metoda de notificare apelata atunci cand starea subiectului se schimba.
 */
public interface Observer {
    void update(Book book);
}
