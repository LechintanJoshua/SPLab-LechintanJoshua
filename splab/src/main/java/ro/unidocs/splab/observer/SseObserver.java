package ro.unidocs.splab.observer;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.unidocs.splab.model.Book;

import java.io.IOException;

/**
 * ConcreteObserver ce trimite notificarile catre clientul web prin Server-Sent Events (SSE).
 */
public class SseObserver implements Observer {
    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            this.emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            this.emitter.completeWithError(e);
        }
    }
}
