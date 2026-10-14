package ro.unidocs.splab.model;

import ro.unidocs.splab.model.visitor.Visitor;

import java.util.concurrent.TimeUnit;

/**
 * Reprezinta o imagine dintr-un capitol al cartii.
 */
public class Image extends Element {
    private String url;

    public Image(String url) {
        super();
        this.url = url;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + this.url);
    }

    @Override
    public void accept(Visitor vis) {
        vis.visit(this);
    }
}
