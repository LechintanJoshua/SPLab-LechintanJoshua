package ro.unidocs.splab.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import ro.unidocs.splab.model.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezinta un capitol/subcapitol dintr-o carte.
 * Entitate JPA compozita ce contine alte elemente copil.
 */
@Entity
public class Section extends Element {
    private String title;

    @OneToMany(targetEntity = Element.class, cascade = CascadeType.ALL)
    private List<Element> elements;

    public Section() {
        this("");
    }

    public Section(String title) {
        super();
        this.title = title;
        this.elements = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Element> getElements() {
        return this.elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public void add(Element el) {
        if (el.getParent() != null) {
            throw new UnsupportedOperationException("Element already belongs to a section");
        }

        this.elements.add(el);
        el.setParent(this);
    }

    @Override
    public void remove(Element el) {
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

    @Override
    public void render() {
        System.out.println(this.title);
        this.elements.forEach(Element::render);
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
        this.elements.forEach(el -> el.accept(vis));
    }
}
