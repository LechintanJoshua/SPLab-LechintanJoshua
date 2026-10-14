package ro.unidocs.splab.model;

import ro.unidocs.splab.model.visitor.Visitor;

/**
 * Reprezinta cuprinsul cartii.
 */
public class TableOfContents extends Element {
    
    public TableOfContents() {
        super();
    }

    @Override
    public void print() {
        System.out.println("Table of Contents:");
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
