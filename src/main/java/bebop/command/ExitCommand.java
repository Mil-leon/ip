package bebop.command;

import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

/**
 * Exits the Chatbot.
 */

public class ExitCommand extends Command {

    /**
     * exits the ui.
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
        return "Have a nice day :D, see you soon!";
    }
}
