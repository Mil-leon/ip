public class Todo extends Task {
    public Todo(String description, Boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String printTask() {
        return "[T]" + this.getStatus() + " " + this.description;
    };
}
