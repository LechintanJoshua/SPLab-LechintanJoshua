package ro.unidocs.splab.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezinta un capitol/subcapitol dintr-o carte.
 * Functioneaza ca un nod Compozit care poate contine alte Elemente.
 */
public class Section implements Element {
    private String title;
    private List<Element> elements;

    public Section(String title) {
        this.title = title;
        this.elements = new ArrayList<>();
    }

    /**
     * Adauga un nou element (imagine, paragraf, sectiune) acestui capitol.
     * @param el Elementul care va fi adaugat.
     * @throws IllegalArgumentException daca elementul furnizat este null.
     */
    @Override
    public void add (Element el) {
        if (el == null) {
            throw new IllegalArgumentException("Cannot add a null element to the Section.");
        }

        this.elements.add(el);
    }

    /**
     * Sterge un element din sectiunea aferenta.
     * @param el Elementul care va fi sters.
     * @throws IllegalArgumentException daca elementul furnizat este null.
     */
    @Override
    public void remove (Element el) {
        if (el == null) {
            throw new IllegalArgumentException("Cannot remove null.");
        }

        this.elements.remove(el);
    }

    /**
     * Obtine un element din sectiunea curenta, pe baza de index.
     * @param idx Indexul elementului cautat (0-indexed).
     * @return Elementul aferent indexului.
     * @throws IllegalArgumentException daca indexul este in afara marginilor listei.
     */
    @Override
    public Element get(int idx) {
        if (idx < 0 || idx >= this.elements.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        return this.elements.get(idx);
    }

    /**
     * Afiseaza toate detaliile Sectiunii respective,
     * parcurgand recursiv prin polimorfism toate elementele din interiorul ei.
     */
    public void print() {
        System.out.println(this.title);

        this.elements.forEach(Element::print);
    }
}
