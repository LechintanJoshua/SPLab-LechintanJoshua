package ro.unidocs.splab.commands.executors;

import ro.unidocs.splab.commands.Command;

/**
 * Invoker in sablonul Command.
 * Decupleaza declansatorul (Controller) de executia propriu-zisa a comenzilor.
 */
public interface CommandExecutor {
    <T> T execute(Command<T> command);
}
