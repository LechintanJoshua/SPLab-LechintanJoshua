package ro.unidocs.splab.model;

public class Image implements Element {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    public void print () {
        System.out.println("Image with name: " + this.url);
    }
}
