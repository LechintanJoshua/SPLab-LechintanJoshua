package ro.unidocs.splab.difexamples;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Componenta Spring cu ciclu de viata Prototype (transient).
 * De fiecare data cand este ceruta o instanta, containerul va crea una noua.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransientComponent {

    public TransientComponent() {
        System.out.println("TransientComponent::TransientComponent = " + this);
    }

    public void operation() {
        System.out.println("Invoked TransientComponent::operation() on " + this);
    }
}
