package ro.unidocs.splab.observer;

import org.springframework.stereotype.Component;
import ro.unidocs.splab.model.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ConcreteSubject in sablonul Observer.
 * Notifica toti observatorii inregistrati atunci cand o carte noua este adaugata.
 */
@Component
public class AllBooksSubject implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private Book latestBook;

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            this.observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    /**
     * Actualizeaza starea subiectului cu noua carte si notifica observatorii.
     * @param book Cartea nou creata.
     */
    public void add(Book book) {
        this.latestBook = book;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.latestBook);
        }
    }
}
