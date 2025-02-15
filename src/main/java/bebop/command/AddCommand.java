package bebop.command;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import bebop.exception.BebopException;
import bebop.task.Deadline;
import bebop.task.Event;
import bebop.task.TaskList;
import bebop.task.Todo;
import bebop.ui.Storage;
import bebop.ui.Ui;


/**
 * Adds Todo, Deadline and Event Classes into Tasklist.
 */

public class AddCommand extends Command {
    private final String type;
    private final String command;

    /**
     * AddCommand Constructor.
     *
     * @param type type of Task added.
     * @param command command being stored.
     */
    public AddCommand(String type, String command) {
        this.type = type;
        this.command = command;
    }

    /**
     * adds the command into TaskList.
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
        String output = "";
        if (this.type.equals("t")) {
            return executeTodo(tasks, this.command);
        } else if (this.type.equals("d")) {
            return executeDeadline(tasks, this.command);
        } else {
            return executeEvent(tasks, this.command);
        }
    }

    public static String executeTodo(TaskList tasks, String command) {
        String[] todos = command.split("todo ");
        if (isFormatted(todos, "t")) {
            Todo t = new Todo(todos[1], false);
            tasks.addTask(t);
            return t.printSuccess(tasks.size());
        }
        return stringFormat("t");
    }

    public static String executeDeadline(TaskList tasks, String command) {
        String[] todos = command.split("deadline ");
        if (!isFormatted(todos, "d")) {
            return stringFormat("d");
        }
        String[] deadlines = todos[1].split(" /by ");
        if (!isFormatted(deadlines, "d")) {
            return stringFormat("d");
        }
        if (isValidLocalDateTime(deadlines[1])) {
            Deadline d = new Deadline(deadlines[0], false, deadlines[1]);
            tasks.addTask(d);
            return d.printSuccess(tasks.size());
        } else {
            return "Incorrect time format! Valid time format is YYYY-MM-DD HH:MM";
        }
    }

    public static String executeEvent(TaskList tasks, String command) {
        String[] todos = command.split("event ");
        if (!isFormatted(todos, "e")) {
            return stringFormat("e");
        }
        String[] deadlines = todos[1].split(" /from ");
        if (!isFormatted(deadlines, "e")) {
            return stringFormat("e");
        }
        String[] events = deadlines[1].split(" /to ");
        if (!isFormatted(events, "e")) {
            return stringFormat("e");
        }
        if (isValidLocalDateTime(events[0]) && isValidLocalDateTime(events[1])) {
            Event e = new Event(deadlines[0], false, events[0], events[1]);
            tasks.addTask(e);
            return e.printSuccess(tasks.size());
        } else {
            return "Incorrect time format! Valid time format is YYYY-MM-DD HH:MM";
        }
    }


    public static String stringFormat(String format) {
        if (format.equals("t")) {
            return "Please give a valid todo format: "
                    + "\"todo EVENTNAME\"";
        } else if (format.equals("d")) {
            return "Please give a valid deadline format: "
                    + "\"deadline EVENTNAME /by ENDTIME\"";
        } else {
            return "Please give a valid event format: "
                    + "\"event EVENTNAME /from STARTTIME /to ENDTIME\"";
        }
    }

    /**
     * checks if the command is formatted correctly.
     *
     * @param list list seperated by dates.
     * @param type type of task.
     *
     * @return boolean if it is correctly formatted.
     */
    public static boolean isFormatted(String[] list, String type) {
        try {
            checkToDo(list, type);
            return true;
        } catch (BebopException b) {
            System.out.println(b.getMessage());
            return false;
        }
    }

    /**
     * checks if the command is formatted correctly.
     *
     * @param arr list seperated by dates.
     * @param s type of task.
     * */
    public static void checkToDo(String[] arr, String s) throws BebopException {
        if (arr.length <= 1) {
            switch (s) {
            case "t":
                throw new BebopException("\tPlease give a valid todo format: "
                        + "\"todo EVENTNAME\"");
            case "d":
                throw new BebopException("\tPlease give a valid deadline format: "
                        + "\"deadline EVENTNAME /by ENDTIME\"");
            case "e":
                throw new BebopException("\tPlease give a valid event format: "
                        + "\"event EVENTNAME /from STARTTIME /to ENDTIME\"");
            default:
                break;
            }
        }
    }

    /**
     * checks if the dateTime is formatted correctly.
     *
     * @param dateTimeStr formatted dateTime.
     *
     * @return boolean if it is correctly formatted.
     */
    public static boolean isValidLocalDateTime(String dateTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            LocalDateTime.parse(dateTimeStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
