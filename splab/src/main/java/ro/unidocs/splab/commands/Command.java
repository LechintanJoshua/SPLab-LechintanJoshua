package ro.unidocs.splab.commands;

/**
 * Interfata generica pentru Command Pattern.
 * @param <T> Tipul de rezultat intors la executia comenzii.
 */
public interface Command<T> {
    T execute();
}
