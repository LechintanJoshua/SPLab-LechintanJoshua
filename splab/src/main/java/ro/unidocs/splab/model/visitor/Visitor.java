package ro.unidocs.splab.model.visitor;

import ro.unidocs.splab.model.*;

/**
 * Interfata de baza pentru Visitor Pattern.
 * Defineste operatia de vizitare pentru fiecare tip concret de element din carte.
 */
public interface Visitor {
    void visit(Book book);
    void visit(Section section);
    void visit(Paragraph paragraph);
    void visit(Image image);
    void visit(ImageProxy imageProxy);
    void visit(Table table);
    void visit(TableOfContents toc);
}
