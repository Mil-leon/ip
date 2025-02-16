package bebop.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import bebop.exception.BebopException;
import bebop.task.TaskList;
import bebop.ui.Storage;
import bebop.ui.Ui;

public class AddCommandTest {
    @Test
    public void todoCommandTestSuccess() throws BebopException {
        AddCommand a = new AddCommand("t", "todo world");
        assertEquals("You got it buddy, get it done quick :D\n"
                + "[T] [ ] world" + "\n\n" + 1 + " tasks to be done", a.execute(new TaskList(), new Ui(), new Storage("data/bebop.txt")));
    }

}