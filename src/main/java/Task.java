public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String d) {
        this.description = d;
        this.isDone = false;
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
}
