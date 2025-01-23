public class Event extends Task{
    String start;
    String end;
    public Event(String d, String start, String end) {
        super(d);
        this.start = start;
        this.end = end;
    }

    @Override
    public String printTask() {
        return "[E]" + this.getStatus() + " " + this.description + " "  +
                "(from:" + this.start +  " to:" + this.end + ")";
    };
}
