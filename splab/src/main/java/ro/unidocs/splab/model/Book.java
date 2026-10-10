package ro.unidocs.splab.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezinta o carte
 */
public class Book {
    private String title;
    private List<Author> authors;
    private List<Element> chapters;

    public Book (String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.chapters = new ArrayList<>();
    }

    /**
     * Adauga un autor in lista de autori ai cartii
     * @param author Autorul care va fi adaugat
     */
    public void addAuthor (Author author) {
        this.authors.add(author);
    }

    /**
     * Adauga un element (ce reprezinta o sectiune, un paragraf, o imagine
     * sau un capitol) in carte
     * @param el Elementul care va fi adaugat
     */
    public void addContent (Element el) {
        this.chapters.add(el);
    }

    /**
     * Afiseaza informatiile cartii
     */
    public void print() {
        System.out.println("Book: " + this.title);

        System.out.println("\nAuthors:");
        this.authors.forEach(Author::print);

        System.out.println();
        this.chapters.forEach(Element::print);
    }
}