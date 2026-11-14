package ro.unidocs.splab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import ro.unidocs.splab.model.strategy.AlignStrategy;
import ro.unidocs.splab.model.visitor.Visitor;

/**
 * Paragraph reprezinta un paragraf de text dintr-o carte.
 * Entitate JPA ce stocheaza textul paragrafului.
 */
@Entity
public class Paragraph extends Element {
    private String text;

    @Transient
    @JsonIgnore
    private AlignStrategy alignStrategy;

    public Paragraph() {
        this("");
    }

    public Paragraph(String text) {
        super();
        this.text = text;
        this.alignStrategy = null;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AlignStrategy getAlignStrategy() {
        return this.alignStrategy;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.alignStrategy = strategy;
    }

    @Override
    public void render() {
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
