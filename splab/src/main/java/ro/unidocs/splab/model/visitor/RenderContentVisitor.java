package ro.unidocs.splab.model.visitor;

import ro.unidocs.splab.model.*;

/**
 * Visitor responsabil cu randarea continutului
 * fiecarui tip de element din structura cartii.
 */
public class RenderContentVisitor implements Visitor {

    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle());
    }

    @Override
    public void visit(Section section) {
        System.out.println(section.getTitle());
    }

    @Override
    public void visit(Paragraph paragraph) {
        if (paragraph.getAlignStrategy() != null) {
            paragraph.getAlignStrategy().render(paragraph.getText());
        } else {
            System.out.println("Paragraph: " + paragraph.getText());
        }
    }

    @Override
    public void visit(Image image) {
        System.out.println("Image with name: " + image.getUrl());
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        imageProxy.loadImage().print();
    }

    @Override
    public void visit(Table table) {
        System.out.println("Table with Title: " + table.getTitle());
    }

    @Override
    public void visit(TableOfContents toc) {
        System.out.println("Table of Contents:");
    }
}
