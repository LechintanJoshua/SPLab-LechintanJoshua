package ro.unidocs.splab.model.strategy;

/**
 * Interfata de baza pentru Strategy Pattern.
 * Decuplata de clasa Paragraph - primeste direct textul (String) pentru formatare.
 */
public interface AlignStrategy {
    /**
     * Randeaza (afiseaza) textul cu un anumit aliniament.
     * 
     * @param text Textul ce urmeaza a fi formatat si afisat.
     */
    void render(String text);
}
