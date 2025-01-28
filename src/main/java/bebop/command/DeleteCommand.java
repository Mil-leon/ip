package bebop.command;
import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

public class DeleteCommand extends Command {
    String command;
    public DeleteCommand(String command) {
        this.command = command;
    }
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws BebopException {
        String[] input = this.command.split(" ");
        if (input.length == 1 || input.length > 2 || !isInteger(input[1])
                || Integer.parseInt(input[1]) > (tasks.size() - 1)) {
            throw new BebopException("\tDelete only accepts valid integers");
        }
        int taskNum = Integer.parseInt(input[1]);
        System.out.println("\tAlright! Congrats on finishing your task:)\n\t" +
                tasks.getTask(taskNum - 1).printTask());
        tasks.deleteTask(taskNum - 1);
        return true;
    }

}
