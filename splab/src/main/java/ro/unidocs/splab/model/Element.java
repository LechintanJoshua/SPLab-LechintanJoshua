package ro.unidocs.splab.model;

import java.lang.String;
import java.lang.StringBuffer;

/**
 * Interfata Element reprezinta orice componenta individuala
 * sau compusa a cartii.
 */
public interface Element {
    void print();

    /**
     * Metoda default pentru adaugarea unui Element.
     * @param el Elementul care va fi adaugat.
     * @throws UnsupportedOperationException implicit, deoarece nodurile de tip frunza nu accepta elemente copil.
     */
    default void add(Element el) {
        throw new UnsupportedOperationException("Cannot add an element here.");
    }

    /**
     * Metoda default pentru stergerea unui Element.
     * @param el Elementul care va fi sters.
     * @throws UnsupportedOperationException implicit.
     */
    default void remove(Element el) {
        throw new UnsupportedOperationException("Cannot remove an element from here.");
    }

    /**
     * Metoda default pentru gasirea unui Element de la un anumit index.
     * @param idx Indexul elementului cautat.
     * @return Elementul la acea pozitie.
     * @throws UnsupportedOperationException implicit.
     */
    default Element get(int idx) {
        throw new UnsupportedOperationException("Cannot get an element from here.");
    }
}
