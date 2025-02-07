package bebop.task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Abstract Task.
 */

public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Task Constructor.
     *
     * @param description task that is meant to be done.
     * @param isDone status of whether task has been completed.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * gets current status of the task.
     *
     * @return String to validate if task is done.
     */
    public String getStatus() {
        return (isDone ? " [X]" : " [ ]");
    }

    public void markDone() {
        isDone = true;
    }

    public void unmarkDone() {
        isDone = false;
    }

    public abstract String printTask();

    public abstract String printSuccess(int size);

    /**
     * prints the date the task is associated with.
     *
     * @param date LocalDateTime for the task.
     * @return formatted string for the dateTime.
     */
    public String printDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    };

    /**
     * returns description.
     *
     *
     * @return description.
     */
    public String getDescription() {
        return description;
    }

}
