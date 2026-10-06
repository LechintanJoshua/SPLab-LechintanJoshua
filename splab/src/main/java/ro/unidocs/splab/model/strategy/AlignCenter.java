package ro.unidocs.splab.model.strategy;

import ro.unidocs.splab.model.Paragraph;

/**
 * ConcreteStrategy: Implementeaza algoritmul pentru alinierea pe centru.
 */
public class AlignCenter implements AlignStrategy {
    
    @Override
    public void render(Paragraph p) {
        // Aliniere la centru: hardcodat ~20 spatii
        System.out.println("                    " + p.getText());
    }
}
