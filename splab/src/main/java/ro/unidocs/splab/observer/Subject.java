package ro.unidocs.splab.observer;

/**
 * Interfata Subject din sablonul Observer.
 * Gestioneaza inregistrarea, dezabonarea si notificarea observatorilor.
 */
public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}
