package ro.unidocs.splab.model;

/**
 * Element reprezinta orice componenta individuala
 * sau compusa a cartii.
 */
public abstract class Element {
    private Element parent = null;

    public abstract void print();

    public Element getParent() {
        return this.parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    /**
     * Metoda default pentru adaugarea unui Element.
     * @param el Elementul care va fi adaugat.
     * @throws UnsupportedOperationException implicit, deoarece nodurile de tip frunza nu accepta elemente copil.
     */
    public void add(Element el) {
        throw new UnsupportedOperationException("Cannot add an element here.");
    }

    /**
     * Metoda default pentru stergerea unui Element.
     * @param el Elementul care va fi sters.
     * @throws UnsupportedOperationException implicit.
     */
    public void remove(Element el) {
        throw new UnsupportedOperationException("Cannot remove an element from here.");
    }

    /**
     * Metoda default pentru gasirea unui Element de la un anumit index.
     * @param idx Indexul elementului cautat.
     * @return Elementul la acea pozitie.
     * @throws UnsupportedOperationException implicit.
     */
    public Element get(int idx) {
        throw new UnsupportedOperationException("Cannot get an element from here.");
    }
}
