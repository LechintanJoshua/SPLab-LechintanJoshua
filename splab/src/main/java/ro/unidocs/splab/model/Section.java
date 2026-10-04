package ro.unidocs.splab.model;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private List<Element> elements;

    public Section(String title) {
        this.title = title;
        this.elements = new ArrayList<>();
    }

    @Override
    public void add (Element el) {
        if (el == null) {
            throw new IllegalArgumentException("Cannot add a null element to the Section.");
        }

        this.elements.add(el);
    }

    @Override
    public void remove (Element el) {
        if (el == null) {
            throw new IllegalArgumentException("Cannot remove null.");
        }

        this.elements.remove(el);
    }

    @Override
    public Element get(int idx) {
        if (idx < 0 || idx >= this.elements.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        return this.elements.get(idx);
    }

    public void print() {
        System.out.println("Titlu sectiune: " + this.title);

        this.elements.forEach(Element::print);
    }
}
