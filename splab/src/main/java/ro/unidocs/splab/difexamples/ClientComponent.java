package ro.unidocs.splab.difexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Componenta client ce demonstreaza Dependency Injection prin constructor.
 * Injecteaza o instanta de TransientComponent si una de SingletonComponent.
 */
@Component
public class ClientComponent {
    private final TransientComponent tc;
    private final SingletonComponent sc;

    @Autowired
    public ClientComponent(TransientComponent tc, SingletonComponent sc) {
        this.tc = tc;
        this.sc = sc;
        System.out.println("ClientComponent::ClientComponent = " + this);
        System.out.println(" o SingletonComponent = " + sc);
        System.out.println(" o TransientComponent = " + tc);
    }

    public void operation() {
        System.out.println("Invoked ClientComponent::operation() on " + this);
        System.out.println(" o SingletonComponent = " + sc);
        System.out.println(" o TransientComponent = " + tc);
    }
}
