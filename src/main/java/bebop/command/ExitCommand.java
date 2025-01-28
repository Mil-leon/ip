package bebop.command;

import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;
public class ExitCommand extends Command {

    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws BebopException{
        System.out.println("\tHave a nice day :D, see you soon!");
        return false;
    }
}
