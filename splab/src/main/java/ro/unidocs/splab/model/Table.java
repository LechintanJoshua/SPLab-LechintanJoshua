package ro.unidocs.splab.model;

/**
 * Reprezinta un tabel dintr-un capitol al cartii.
 */
public class Table extends Element {
    private String title;

    public Table(String title) {
        super();
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Table with Title: " + this.title);
    }
}
