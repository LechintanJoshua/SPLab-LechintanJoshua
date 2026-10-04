package ro.unidocs.splab.model;

/**
 * Reprezinta un autor al unei carti
 */
public class Author {
    private String name;

    public Author (String name) {
        this.name = name;
    }

    /**
     * Afiseaza detalii despre autor
     */
    public void print() {
        System.out.println("Author: " + this.name);
    }
}
