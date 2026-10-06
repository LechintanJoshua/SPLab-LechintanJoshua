package ro.unidocs.splab.model.strategy;

import ro.unidocs.splab.model.Paragraph;

/**
 * Interfata de baza pentru Strategy Pattern.
 * Permite interschimbarea algoritmilor de aliniere a textului dintr-un paragraf.
 */
public interface AlignStrategy {
    /**
     * Randeaza (afiseaza) textul paragrafului cu un anumit aliniament.
     * Daca decuplam de Context, cum sugereaza PDF-ul la pct 9d, parametrul
     * poate fi direct String, dar conform diagramei initiale ramane Paragraph.
     * 
     * @param p Paragraful (Context-ul) ce contine textul de printat.
     */
    void render(Paragraph p);
}
