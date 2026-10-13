package ro.unidocs.splab.model.strategy;

/**
 * ConcreteStrategy: Implementeaza algoritmul pentru alinierea la stanga.
 */
public class AlignLeft implements AlignStrategy {
    
    @Override
    public void render(String text) {
        System.out.println(text);
    }
}
