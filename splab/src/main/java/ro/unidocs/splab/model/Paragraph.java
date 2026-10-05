package ro.unidocs.splab.model;

/**
 * Paragraph reprezinta un paragraph dintr-un capitol al cartii
 */
public class Paragraph extends Element {
    private String text;

    public Paragraph(String text) {
        super();
        this.text = text;
    }

    /**
     * Afiseaza continutul paragrafului
     */
    public void print() {
        System.out.println("Paragraph: " + this.text);
    }
}
