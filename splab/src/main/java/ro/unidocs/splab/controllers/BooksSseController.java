package ro.unidocs.splab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.unidocs.splab.observer.AllBooksSubject;
import ro.unidocs.splab.observer.SseObserver;

/**
 * Controller REST pentru abonarea clientilor la evenimente Server-Sent Events (SSE).
 */
@RestController
public class BooksSseController {
    private final AllBooksSubject allBooksSubject;

    @Autowired
    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    /**
     * GET /books-sse - deschide un stream SSE si inregistreaza clientul ca observer.
     */
    @RequestMapping("/books-sse")
    public ResponseBodyEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);
        final SseObserver observer = new SseObserver(emitter);
        this.allBooksSubject.attach(observer);

        emitter.onCompletion(() -> this.allBooksSubject.detach(observer));
        emitter.onTimeout(() -> this.allBooksSubject.detach(observer));
        emitter.onError(e -> this.allBooksSubject.detach(observer));

        return emitter;
    }
}
