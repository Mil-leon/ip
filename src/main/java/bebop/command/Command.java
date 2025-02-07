package bebop.command;

import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;
/**
 * Abstract class for all commands.
 */

public abstract class Command {

    /**
     * executes command.
     *
     * @param tasks Tasklist storing tasks.
     * @param ui Ui to print commands.
     * @param storage stores task into Bebop.txt.
     *
     * @return boolean if the program will continue or not.
     * @throws BebopException checks for correct command format.
     */
    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws BebopException;

    /**
     * check if the string is an Integer.
     *
     * @param str string to be converted to integer.
     * @return boolean to check if isInteger.
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
