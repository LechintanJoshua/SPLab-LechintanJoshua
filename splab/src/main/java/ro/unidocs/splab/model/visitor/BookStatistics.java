package ro.unidocs.splab.model.visitor;

import ro.unidocs.splab.model.*;

/**
 * Visitor responsabil cu colectarea statisticilor despre carte
 * contorizeaza numarul de paragrafe, imagini si tabele.
 */
public class BookStatistics implements Visitor {
    private int imagesCount = 0;
    private int tablesCount = 0;
    private int paragraphsCount = 0;

    @Override
    public void visit(Book book) { }

    @Override
    public void visit(Section section) { }

    @Override
    public void visit(Paragraph paragraph) {
        this.paragraphsCount++;
    }

    @Override
    public void visit(Image image) {
        this.imagesCount++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        this.imagesCount++;
    }

    @Override
    public void visit(Table table) {
        this.tablesCount++;
    }

    @Override
    public void visit(TableOfContents toc) { }

    /**
     * Afiseaza statisticile colectate in formatul cerut de cerinta.
     */
    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + this.imagesCount);
        System.out.println("*** Number of tables: " + this.tablesCount);
        System.out.println("*** Number of paragraphs: " + this.paragraphsCount);
    }
}
