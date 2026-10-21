package ro.unidocs.splab.model.visitor;

import ro.unidocs.splab.model.*;

/**
 * Concrete Visitor responsabil cu generarea cuprinsului cartii (Table of Contents).
 * Parcurge structura arborescenta a cartii si extrage titlurile fiecarei sectiuni.
 */
public class GenerateToC implements Visitor {
    private TableOfContents toc;

    public GenerateToC() {
        this.toc = new TableOfContents();
    }

    public TableOfContents getToC() {
        return this.toc;
    }

    @Override
    public void visit(Book book) {
        // Book-ul poate fi ignorat sau mentionat in cuprins
    }

    @Override
    public void visit(Section section) {
        this.toc.addEntry(section.getTitle());
    }

    @Override
    public void visit(Paragraph paragraph) {
        // Paragrafele nu apar in cuprins
    }

    @Override
    public void visit(Image image) {
        // Imaginile nu apar in cuprins
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        // Proxy-urile de imagine nu apar in cuprins
    }

    @Override
    public void visit(Table table) {
        // Tabelele nu sunt adaugate in cuprinsul general de sectiuni
    }

    @Override
    public void visit(TableOfContents toc) {
        // Nu vizitam un alt TableOfContents in generarea curenta
    }
}
