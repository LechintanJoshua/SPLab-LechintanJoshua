package ro.unidocs.splab.model;

/**
 * Proxy virtual pentru clasa Image.
 * Instantierea imaginii reale este amanata pana la momentul folosirii acesteia.
 */
public class ImageProxy extends Element {
    private String url;
    private Image realImage;

    public ImageProxy(String url) {
        super();
        this.url = url;
        this.realImage = null; // Imaginea grea ramane neincarcata initial
    }

    /**
     * Incarca imaginea reala doar daca ea nu exista deja in memorie.
     * @return instanta reala de Image
     */
    public Image loadImage() {
        if (this.realImage == null) {
            this.realImage = new Image(this.url);
        }
        return this.realImage;
    }

    @Override
    public void print() {
        // La apelul print(), proxy-ul forteaza incarcarea si apoi deleaga catre instanta reala
        loadImage().print();
    }
}
