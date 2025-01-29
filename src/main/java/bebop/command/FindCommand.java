package bebop.command;

import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

public class FindCommand extends Command {
    String command;

    public FindCommand(String command) {
        this.command = command;
    }

    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws BebopException {
        String[] input = command.split(" ");
        if (input.length != 2) {
            throw new BebopException("Invalid find command, needs a subject to find");
        }
        tasks.findTask(input[1]);
        return true;
    }

}
