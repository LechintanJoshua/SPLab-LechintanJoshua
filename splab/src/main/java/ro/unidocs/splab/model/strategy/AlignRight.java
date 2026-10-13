package ro.unidocs.splab.model.strategy;

/**
 * ConcreteStrategy: Implementeaza algoritmul pentru alinierea la dreapta.
 */
public class AlignRight implements AlignStrategy {
    
    @Override
    public void render(String text) {
        System.out.println("                                        " + text);
    }
}
