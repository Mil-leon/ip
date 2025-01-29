package bebop.command;
import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

/**
 * Marks/Unmark item as done
 */

public class MarkCommand extends Command {
    int index;
    boolean isDone;
    boolean isValid;

    /**
     * MarkCommand Constructor
     *
     * @param isDone status of the task
     * @param command command being changed
     */
    public MarkCommand(Boolean isDone, String command) {
        String[] temp = command.split(" ");
        isValid = temp.length == 2 || isInteger(temp[1]);
        this.index = isValid ? Integer.parseInt(temp[1]) : -1;
        this.isDone = isDone;
    }

    /**
     * command that marks/unmark the Task
     *
     * @param tasks Tasklist storing tasks
     * @param ui Ui to print commands
     * @param storage stores task into Bebop.txt
     *
     * @return boolean if the program will continue or not
     * @throws BebopException checks for correct command format
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws BebopException {
        if (!isValid || index > tasks.size()) {
            throw new BebopException("\t Mark/Unmark command can only be done with an integer index");
        }
        if (this.isDone) {
            tasks.setTaskDone(this.index);
            System.out.println("\tGood Job! I've marked the task as done!\n\t");
        } else {
            tasks.setTaskNotDone(this.index);
            System.out.println("\tAlright! Let's get this done soon :)\n\t");
        }
        tasks.printTask(index);
        return true;
    }

}
