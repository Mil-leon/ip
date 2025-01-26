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
}
