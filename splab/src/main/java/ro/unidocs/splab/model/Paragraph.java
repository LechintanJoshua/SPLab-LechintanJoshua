package ro.unidocs.splab.model;

/**
 * Paragraph reprezinta un paragraph dintr-un capitol al cartii
 */
public class Paragraph implements Element {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("Paragraph: " + this.text);
    }
}
