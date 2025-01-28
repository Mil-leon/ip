package bebop.command;
import bebop.exception.BebopException;
import bebop.task.Deadline;
import bebop.task.Event;
import bebop.task.TaskList;
import bebop.task.Todo;
import bebop.ui.Storage;
import bebop.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AddCommand extends Command {
    String type;
    String command;
    public AddCommand(String type, String command) {
        this.type = type;
        this.command = command;
    }

    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws BebopException {
        if (this.type.equals("t")) {
            String[] todos = command.split("todo ");
            if (isFormatted(todos, "t")) {
                Todo t = new Todo(todos[1], false);
                tasks.addTask(t);
                t.printSuccess(tasks.size());
            }

        } else if (this.type.equals("d")) {
            String[] todos = command.split("deadline ");
            if (!isFormatted(todos, "d")) {
                return true;
            }
            String[] deadlines = todos[1].split(" /by ");
            if (!isFormatted(deadlines, "d")) {
                return true;
            }
            if (isValidLocalDateTime(deadlines[1])) {
                Deadline d = new Deadline(deadlines[0], false, deadlines[1]);
                tasks.addTask(d);
                d.printSuccess(tasks.size());
            } else {
                System.out.println("Incorrect time format! Valid time format is YYYY-MM-DD HH:MM");
            }
        } else {
            String[] todos = command.split("event ");
            if (!isFormatted(todos, "e")) {
                return true;
            }
            String[] deadlines = todos[1].split(" /from ");
            if (!isFormatted(deadlines, "e")) {
                return true;
            }
            String[] events = deadlines[1].split(" /to ");
            if (!isFormatted(events, "e")) {
                return true;
            }
            if (isValidLocalDateTime(events[0]) && isValidLocalDateTime(events[1])) {
                Event e = new Event(deadlines[0], false, events[0], events[1]);
                tasks.addTask(e);
                e.printSuccess(tasks.size());
            } else {
                System.out.println("Incorrect time format! Valid time format is YYYY-MM-DD HH:MM");
            }
        }
        return true;
    }

    public static boolean isFormatted(String[] list, String type) {
        try {
            checkToDo(list, type);
            return true;
        } catch (BebopException b) {
            System.out.println(b.getMessage());
            return false;
        }
    }

    public static void checkToDo(String[] arr, String s) throws BebopException{
        if (arr.length <= 1) {
            switch (s) {
            case "t":
                throw new BebopException("\tPlease give a valid todo format: " +
                        "\"todo EVENTNAME\"");
            case "d":
                throw new BebopException("\tPlease give a valid deadline format: " +
                        "\"deadline EVENTNAME /by ENDTIME\"");
            case "e":
                throw new BebopException("\tPlease give a valid event format: " +
                        "\"event EVENTNAME /from STARTTIME /to ENDTIME\"" );
            }
        }
    }

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
