package bebop.task;

import java.io.IOException;

/**
 * todo task to store the description
 */

public class Todo extends Task {

    /**
     * Todo Constructor
     *
     * @param description task that is meant to be done
     * @param isDone status of whether task has been completed
     */
    public Todo(String description, Boolean isDone) {

        super(description, isDone);
    }

    /**
     * returns the Todo Task
     *
     * @return Todo task formatted
     */
    @Override
    public String printTask() {
        return "[T]" + this.getStatus() + " " + this.description;
    };

    /**
     * prints Successful adding into TaskList
     *
     * @param size number of Task in the taskList
     */
    @Override
    public void printSuccess(int size) {
        System.out.println("\tYou got it buddy, get it done quick :D\n\t" +
                this.printTask());
        System.out.println("\t" + size + " tasks to be done");
    }

}
