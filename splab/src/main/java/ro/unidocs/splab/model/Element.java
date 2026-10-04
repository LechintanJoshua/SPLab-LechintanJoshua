package ro.unidocs.splab.model;

import java.lang.String;
import java.lang.StringBuffer;

/**
 * Interfata Element reprezinta orice componenta individuala
 * sau compusa a cartii
 */
public interface Element {
    void print();

    default void add(Element el) {
        throw new UnsupportedOperationException("Cannot add an element here.");
    }

    default void remove(Element el) {
        throw new UnsupportedOperationException("Cannot remove an element from here.");
    }

    default Element get(int idx) {
        throw new UnsupportedOperationException("Cannot get an element from here.");
    }
}
