package ro.unidocs.splab.model;

import ro.unidocs.splab.model.strategy.AlignStrategy;
import ro.unidocs.splab.model.visitor.Visitor;

/**
 * Paragraph reprezinta un paragraph dintr-un capitol al cartii.
 * Actioneaza drept Context pentru Strategy Pattern.
 */
public class Paragraph extends Element {
    private String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        super();
        this.text = text;
        this.alignStrategy = null;
    }

    public String getText() {
        return this.text;
    }

    public AlignStrategy getAlignStrategy() {
        return this.alignStrategy;
    }

    /**
     * Schimba algoritmul curent de formatare/aliniere a textului.
     * @param strategy Noua strategie de aliniere.
     */
    public void setAlignStrategy(AlignStrategy strategy) {
        this.alignStrategy = strategy;
    }

    /**
     * Afiseaza continutul paragrafului delegand logica de randare catre strategie,
     * daca o strategie este setata. Altfel, afiseaza standard.
     */
    @Override
    public void print() {
        if (this.alignStrategy != null) {
            this.alignStrategy.render(this.text);
        } else {
            System.out.println("Paragraph: " + this.text);
        }
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
