package bebop.command;
import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;
public class ListCommand extends Command {

    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws BebopException{
        tasks.printTasks();
        return true;
    }
}
