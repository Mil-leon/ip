package bebop.command;
import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

public class InvalidCommand extends Command{
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws BebopException{
        System.out.println("\tSorry that's not a valid command :D, please use an appropriate format");
        return true;
    }
}
