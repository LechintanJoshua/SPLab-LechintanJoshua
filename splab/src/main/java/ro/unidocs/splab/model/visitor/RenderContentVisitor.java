package ro.unidocs.splab.model.visitor;

import ro.unidocs.splab.model.*;

/**
 * Concrete Visitor responsabil cu randarea (afisarea) continutului
 * fiecarui tip de element din structura cartii.
 * Conform cerintei 9.d din PDF, fiecare visit(Xxx) apeleaza metoda render() corespunzatoare.
 */
public class RenderContentVisitor implements Visitor {

    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println("\nAuthors:");
        book.getAuthors().forEach(Author::print);
        System.out.println();
    }

    @Override
    public void visit(Section section) {
        System.out.println(section.getTitle());
    }

    @Override
    public void visit(Paragraph paragraph) {
        paragraph.render();
    }

    @Override
    public void visit(Image image) {
        image.render();
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        imageProxy.render();
    }

    @Override
    public void visit(Table table) {
        table.render();
    }

    @Override
    public void visit(TableOfContents toc) {
        toc.render();
    }
}
