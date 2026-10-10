package ro.unidocs.splab.model.strategy;

import ro.unidocs.splab.model.Paragraph;

/**
 * ConcreteStrategy: Implementeaza algoritmul pentru alinierea la stanga.
 */
public class AlignLeft implements AlignStrategy {
    
    @Override
    public void render(Paragraph p) {
        System.out.println(p.getText());
    }
}
