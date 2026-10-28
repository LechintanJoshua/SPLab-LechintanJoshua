package ro.unidocs.splab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.unidocs.splab.difexamples.ClientComponent;

/**
 * Controller REST ce expune un endpoint pe radacina aplicatiei
 * si demonstreaza injectarea componentei ClientComponent.
 */
@RestController
public class HelloController {
    private final ClientComponent clientComponent;

    @Autowired
    public HelloController(ClientComponent clientComponent) {
        this.clientComponent = clientComponent;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from ClientComponent = " + this.clientComponent;
    }
}
