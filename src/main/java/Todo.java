public class Todo extends Task {
    public Todo(String d) {
        super(d);
    }

    @Override
    public String printTask() {
        return "[T]" + this.getStatus() + " " + this.description;
    };
}
