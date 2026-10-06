package ro.unidocs.splab.model;

import java.util.concurrent.TimeUnit;

/**
 * Reprezinta o imagine dintr-un capitol al cartii.
 * Resursa "heavy" a carei instantiere este intarziata.
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

    @Override
    public void print() {
        System.out.println("Image with name: " + this.url);
    }
}
