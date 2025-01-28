package bebop.task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String d, boolean isDone) {
        this.description = d;
        this.isDone = isDone;
    }

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

    public abstract void printSuccess(int size);

    public String printDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    };

    public String getDescription() {
        return description;
    }

}
