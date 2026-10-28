package ro.unidocs.splab.model;

import jakarta.persistence.Entity;
import ro.unidocs.splab.model.visitor.Visitor;

import java.util.concurrent.TimeUnit;

/**
 * Reprezinta o imagine dintr-un capitol al cartii.
 * Entitate JPA ce stocheaza URL-ul imaginii.
 */
@Entity
public class Image extends Element {
    private String url;

    public Image() {
        this("");
    }

    public Image(String url) {
        super();
        this.url = url;
        if (url != null && !url.isEmpty()) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void render() {
        System.out.println("Image with name: " + this.url);
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
