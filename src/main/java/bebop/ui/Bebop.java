package bebop.ui;

import java.io.IOException;

import bebop.command.Command;
import bebop.command.Parser;
import bebop.exception.BebopException;
import bebop.task.TaskList;

/**
 * A chatbot made to store tasks to be done. A <code>Bebop</code> object allows
 * you to insert, delete and mark formatted tasks.
 */

public class Bebop {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    /**
     * Bebop Constructor.
     * @param filePath filepath of the data in format data/Bebop.txt.
     * @throws IOException If the filepath given is invalid.
     */
    public Bebop(String filePath) throws IOException {
        ui = new Ui();
        parser = new Parser();
        storage = new Storage(filePath);
        tasks = new TaskList();
        tasks = storage.load(tasks);
    }

    /**
     * Runs the main Bebop program.
     */
    public void run() throws IOException, BebopException {
        ui.welcomeGuest();
        boolean isContinuing = true;
        try {
            while (isContinuing) {
                String command = ui.readCommand();
                ui.divider();
                Command c = parser.parse(command);
                isContinuing = c.execute(tasks, ui, storage);
            }
        } catch (BebopException e) {
            System.out.println(e.getMessage());
        }
        storage.deload(tasks);
    }

    public static void main(String[] args) throws BebopException, IOException {
        new Bebop("data/Bebop.txt").run();
    }

}
