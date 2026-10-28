package ro.unidocs.splab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import ro.unidocs.splab.model.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezinta o carte.
 * Entitate JPA ce aggrega autorii si capitolele (elementele) sale.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors;

    @OneToMany(targetEntity = Element.class, cascade = CascadeType.ALL)
    private List<Element> chapters;

    public Book() {
        this("");
    }

    public Book(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.chapters = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Element> getChapters() {
        return this.chapters;
    }

    public void setChapters(List<Element> chapters) {
        this.chapters = chapters;
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
