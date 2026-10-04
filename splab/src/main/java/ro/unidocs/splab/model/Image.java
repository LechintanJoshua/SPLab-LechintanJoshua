package ro.unidocs.splab.model;

/**
 * Reprezinta o ilustratie grafica / o imagine dintr-o carte
 */
public class Image implements Element {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    /**
     * Afiseaza detalii despre imagine
     */
    public void print () {
        System.out.println("Image with name: " + this.url);
    }
}
