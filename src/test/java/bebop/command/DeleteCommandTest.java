package bebop.command;

import bebop.exception.BebopException;
import bebop.task.Deadline;
import bebop.task.Event;
import bebop.task.TaskList;
import bebop.task.Todo;
import bebop.ui.Storage;
import bebop.ui.Ui;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteCommandTest {
    @Test
    public void DeleteCommandTestSuccess() throws BebopException {
        DeleteCommand a = new DeleteCommand("delete 3");
        TaskList t = new TaskList();
        t.addTask(new Todo("world", true));
        t.addTask(new Todo("world2", true));
        t.addTask(new Todo("world3", true));
        assertEquals(true, a.execute(t, new Ui(), new Storage("data/bebop.txt")));
    }

    public void DeleteCommandTestFailure() throws BebopException {
        try {
            DeleteCommand a = new DeleteCommand("delete 10");
            TaskList t = new TaskList();
            t.addTask(new Todo("world", true));
            t.addTask(new Todo("world2", true));
            t.addTask(new Todo("world3", true));
            assertEquals(true, a.execute(t, new Ui(), new Storage("data/bebop.txt")));
        } catch (BebopException e) {
            assertEquals("\tDelete only accepts valid integers", e.getMessage());
        }

    }
}