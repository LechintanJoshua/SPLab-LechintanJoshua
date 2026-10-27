package ro.unidocs.splab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ro.unidocs.splab.difexamples.ClientComponent;
import ro.unidocs.splab.difexamples.SingletonComponent;
import ro.unidocs.splab.difexamples.TransientComponent;

@SpringBootApplication
public class SplabApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SplabApplication.class, args);

        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        c = (ClientComponent) context.getBean("clientComponent");
        c.operation();
    }
}
