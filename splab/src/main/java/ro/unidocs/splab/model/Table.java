package ro.unidocs.splab.model;

import jakarta.persistence.Entity;
import ro.unidocs.splab.model.visitor.Visitor;

/**
 * Reprezinta un tabel dintr-un capitol al cartii.
 * Entitate JPA ce stocheaza titlul tabelului.
 */
@Entity(name = "BookTable")
public class Table extends Element {
    private String title;

    public Table() {
        this("");
    }

    public Table(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void render() {
        System.out.println("Table with Title: " + this.title);
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
