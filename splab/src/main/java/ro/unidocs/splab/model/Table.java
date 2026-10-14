package ro.unidocs.splab.model;

import ro.unidocs.splab.model.visitor.Visitor;

/**
 * Reprezinta un tabel dintr-un capitol al cartii.
 */
public class Table extends Element {
    private String title;

    public Table(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public void print() {
        System.out.println("Table with Title: " + this.title);
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
