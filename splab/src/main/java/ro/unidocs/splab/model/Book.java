package ro.unidocs.splab.model;

import ro.unidocs.splab.model.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezinta o carte.
 * Actioneaza ca radacina/agregator principal al continutului si autorilor.
 */
public class Book {
    private String title;
    private List<Author> authors;
    private List<Element> chapters;

    public Book(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.chapters = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public List<Element> getChapters() {
        return this.chapters;
    }

    /**
     * Adauga un autor in lista de autori ai cartii.
     * @param author Autorul care va fi adaugat.
     */
    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    /**
     * Adauga un element (sectiune, paragraf etc.) ca si continut in carte.
     * @param el Elementul care va fi adaugat.
     */
    public void addContent(Element el) {
        this.chapters.add(el);
    }

    /**
     * Afiseaza informatiile cartii.
     */
    public void print() {
        System.out.println("Book: " + this.title);

        System.out.println("\nAuthors:");
        this.authors.forEach(Author::print);

        System.out.println();
        this.chapters.forEach(Element::render);
    }

    public void render() {
        print();
    }

    /**
     * Permite vizitarea intregii carti si a capitolelor ei de catre un Visitor.
     * @param vis Vizitatorul aplicat pe structura cartii.
     */
    public void accept(Visitor vis) {
        vis.visit(this);
        this.chapters.forEach(ch -> ch.accept(vis));
    }
}
