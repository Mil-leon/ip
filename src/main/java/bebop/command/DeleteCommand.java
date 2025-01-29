package bebop.command;
import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

/**
 * Deletes tasks from the tasklist
 */
public class DeleteCommand extends Command {
    String command;

    /**
     * DeleteCommand Constructor
     *
     * @param command command being deleted
     */
    public DeleteCommand(String command) {
        this.command = command;
    }

    /**
     * deletes the command from TaskList
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
        String[] input = this.command.split(" ");
        if (input.length == 1 || input.length > 2 || !isInteger(input[1])
                || Integer.parseInt(input[1]) > (tasks.size())) {
            throw new BebopException("\tDelete only accepts valid integers");
        }
        int taskNum = Integer.parseInt(input[1]);
        System.out.println("\tAlright! Congrats on finishing your task:)\n\t" +
                tasks.getTask(taskNum - 1).printTask());
        tasks.deleteTask(taskNum - 1);
        return true;
    }

}
