package ro.unidocs.splab.model;

import ro.unidocs.splab.model.visitor.Visitor;

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
        this.realImage = null;
    }

    public String getUrl() {
        return this.url;
    }

    public Image loadImage() {
        if (this.realImage == null) {
            this.realImage = new Image(this.url);
        }
        return this.realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
