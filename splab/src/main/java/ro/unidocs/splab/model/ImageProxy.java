package ro.unidocs.splab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import ro.unidocs.splab.model.visitor.Visitor;

/**
 * Proxy virtual pentru clasa Image.
 * Entitate JPA ce intarzie instantierea obiectului Image real pana la folosire.
 */
@Entity
public class ImageProxy extends Element {
    private String url;

    @Transient
    @JsonIgnore
    private Image realImage;

    public ImageProxy() {
        this("");
    }

    public ImageProxy(String url) {
        super();
        this.url = url;
        this.realImage = null;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image loadImage() {
        if (this.realImage == null) {
            this.realImage = new Image(this.url);
        }
        return this.realImage;
    }

    @Override
    public void render() {
        loadImage().render();
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
