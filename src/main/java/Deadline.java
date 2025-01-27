import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static java.time.LocalDate.now;

public class Deadline extends Task {
    String start;
    LocalDate startDate;
    public Deadline(String description, boolean isDone, String start) {
        super(description, isDone);
        this.start = start;
        startDate = LocalDate.parse(start);
    }

    @Override
    public String printTask() {
        return "[D]" + this.getStatus() + " " + this.description + " "  + "(by: " + printDate(startDate) +  ")";
    };

    public String printDate(LocalDate date) {
        return date.getMonth() + " " + date.getDayOfMonth() + " " + date.getYear();
    }
}
