package ro.unidocs.splab.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import ro.unidocs.splab.model.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezinta cuprinsul cartii.
 * Entitate JPA ce stocheaza colectia de intrari ale cuprinsului.
 */
@Entity
public class TableOfContents extends Element {
    @ElementCollection
    private List<String> entries;

    public TableOfContents() {
        super();
        this.entries = new ArrayList<>();
    }

    public void addEntry(String entry) {
        this.entries.add(entry);
    }

    public List<String> getEntries() {
        return this.entries;
    }

    public void setEntries(List<String> entries) {
        this.entries = entries;
    }

    @Override
    public void render() {
        System.out.println("Table of Contents:");
        for (String entry : this.entries) {
            System.out.println(" - " + entry);
        }
    }

    public void print() {
        render();
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
