package ro.unidocs.splab.difexamples;

import org.springframework.stereotype.Component;

/**
 * Componenta Spring cu ciclu de viata Singleton (implicit).
 * Containerul Spring va gestiona o instanta unica a acestei clase.
 */
@Component
public class SingletonComponent {

    public SingletonComponent() {
        System.out.println("SingletonComponent::SingletonComponent = " + this);
    }

    public void operation() {
        System.out.println("Invoked SingletonComponent::operation() on " + this);
    }
}
