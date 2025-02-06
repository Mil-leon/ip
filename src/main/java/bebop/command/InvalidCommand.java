package bebop.command;
import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

/**
 * Check command for all invalid inputs.
 */
public class InvalidCommand extends Command {

    /**
     * executes invalid command.
     *
     * @param tasks Tasklist storing tasks.
     * @param ui Ui to print commands.
     * @param storage stores task into Bebop.txt.
     *
     * @return boolean if the program will continue or not.
     * @throws BebopException checks for correct command format.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws BebopException {
        System.out.println("\tSorry that's not a valid command :D, please use an appropriate format");
        return true;
    }
}
