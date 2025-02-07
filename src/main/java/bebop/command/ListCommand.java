package bebop.command;
import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

/**
 * List all the items in the taskList.
 */

public class ListCommand extends Command {

    /**
     * command that prints all the task in the TaskList.
     *
     * @param tasks Tasklist storing tasks.
     * @param ui Ui to print commands.
     * @param storage stores task into Bebop.txt.
     *
     * @return boolean if the program will continue or not.
     * @throws BebopException checks for correct command format.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws BebopException {
        return tasks.printAllTask();
    }
}
