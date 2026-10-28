package ro.unidocs.splab.commands.executors;

import org.springframework.stereotype.Component;
import ro.unidocs.splab.commands.Command;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Invoker asincron (conform sarcinilor 14-16 din PDF):
 * Utilizeaza un Thread Pool (Executors.newFixedThreadPool) pentru a executa comanda asincron.
 */
@Component
public class AsyncCommandExecutor {
    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public <T> CompletableFuture<T> executeAsync(Command<T> command) {
        return CompletableFuture.supplyAsync(command::execute, this.threadPool);
    }
}
