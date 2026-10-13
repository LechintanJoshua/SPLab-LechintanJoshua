package ro.unidocs.splab.model.strategy;

/**
 * ConcreteStrategy: Implementeaza algoritmul pentru alinierea pe centru.
 */
public class AlignCenter implements AlignStrategy {
    
    @Override
    public void render(String text) {
        System.out.println("                    " + text);
    }
}
