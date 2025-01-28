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

public class AddCommandTest {
    @Test
    public void addCommandTestSuccess() throws BebopException {
        AddCommand a = new AddCommand("t", "todo world");
        assertEquals(true, a.execute(new TaskList(), new Ui(), new Storage("data/bebop.txt")));
    }
}