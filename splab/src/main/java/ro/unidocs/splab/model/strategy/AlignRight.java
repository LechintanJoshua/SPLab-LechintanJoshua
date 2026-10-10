package ro.unidocs.splab.model.strategy;

import ro.unidocs.splab.model.Paragraph;

/**
 * ConcreteStrategy: Implementeaza algoritmul pentru alinierea la dreapta.
 */
public class AlignRight implements AlignStrategy {
    
    @Override
    public void render(Paragraph p) {
        // hardcodat ~40 spatii
        System.out.println("                                        " + p.getText());
    }
}
