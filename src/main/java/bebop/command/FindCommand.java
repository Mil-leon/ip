package bebop.command;

import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

/**
 * Finds commands with matching string.
 */

public class FindCommand extends Command {
    private final String command;

    public FindCommand(String command) {
        this.command = command;
    }

    /**
     * Find tasks with matching names.
     *
     * @param tasks Tasklist storing tasks.
     * @param ui Ui to print commands.
     * @param storage stores task into Bebop.txt.
     *
     * @return boolean if the program will continue or not.
     * @throws BebopException checks for correct command format.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws BebopException {
        String[] input = command.split(" ");
        assert input.length > 0;
        String output = "";
        if (input.length != 2) {
            output = "Invalid find command, needs a subject to find";
            return output;
        }
        output = tasks.findTask(input[1]);
        return output;
    }
}
