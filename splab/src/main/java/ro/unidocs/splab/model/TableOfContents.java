package ro.unidocs.splab.model;

import ro.unidocs.splab.model.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezinta cuprinsul cartii (Table of Contents).
 * Poate contine o colectie de intrari reprezentand sectiunile si capitolele cartii.
 */
public class TableOfContents extends Element {
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

    @Override
    public void print() {
        System.out.println("Table of Contents:");
        for (String entry : this.entries) {
            System.out.println(" - " + entry);
        }
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
