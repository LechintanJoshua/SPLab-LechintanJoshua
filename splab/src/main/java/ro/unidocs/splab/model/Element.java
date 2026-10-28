package ro.unidocs.splab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ro.unidocs.splab.model.visitor.Visitor;

/**
 * Element reprezinta radacina ierarhiei de elemente din carte.
 * Entitate JPA configurata cu strategia de mostenire JOINED.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Transient
    @JsonIgnore
    private Element parent = null;

    public Element() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void render();

    @JsonIgnore
    public Element getParent() {
        return this.parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    /**
     * Metoda default pentru adaugarea unui Element.
     * @param el Elementul care va fi adaugat.
     */
    public void add(Element el) {
        throw new UnsupportedOperationException("Cannot add an element here.");
    }

    /**
     * Metoda default pentru stergerea unui Element.
     * @param el Elementul care va fi sters.
     */
    public void remove(Element el) {
        throw new UnsupportedOperationException("Cannot remove an element from here.");
    }

    /**
     * Metoda default pentru gasirea unui Element de la un anumit index.
     * @param idx Indexul elementului cautat.
     * @return Elementul la acea pozitie.
     */
    public Element get(int idx) {
        throw new UnsupportedOperationException("Cannot get an element from here.");
    }

    public abstract void accept(Visitor vis);
}
