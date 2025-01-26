public class Event extends Task{
    String start;
    String end;
    public Event(String description, boolean isDone, String start, String end) {
        super(description, isDone);
        this.start = start;
        this.end = end;
    }

    @Override
    public String printTask() {
        return "[E]" + this.getStatus() + " " + this.description + " "  +
                "(from:" + this.start +  " to:" + this.end + ")";
    };
}
