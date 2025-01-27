import java.time.LocalDate;

public class Event extends Task{
    String start;
    String end;
    LocalDate startDate;
    LocalDate endDate;
    public Event(String description, boolean isDone, String start, String end) {
        super(description, isDone);
        this.start = start;
        this.end = end;
        this.startDate = LocalDate.parse(start);
        this.endDate = LocalDate.parse(end);
    }

    @Override
    public String printTask() {
        return "[E]" + this.getStatus() + " " + this.description + " "  +
                "(from: " + printDate(startDate) + " to: " + printDate(endDate) + ")";
    };

    public String printDate(LocalDate date) {
        return date.getMonth() + " " + date.getDayOfMonth() + " " + date.getYear();
    }

}
