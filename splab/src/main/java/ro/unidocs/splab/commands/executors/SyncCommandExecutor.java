package ro.unidocs.splab.commands.executors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ro.unidocs.splab.commands.Command;

/**
 * Invoker sincron: executa comanda imediat pe thread-ul curent.
 */
@Component
@Primary
public class SyncCommandExecutor implements CommandExecutor {

    @Override
    public <T> T execute(Command<T> command) {
        return command.execute();
    }
}
