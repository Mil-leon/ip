package bebop.task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.LocalDate.now;

public class Deadline extends Task {
    String start;
    LocalDateTime startDate;

    public Deadline(String description, boolean isDone, String start) {
        super(description, isDone);
        String[] startTemp = start.split(" ");
        this.start = start;
        LocalTime t = LocalTime.parse(startTemp[1]);
        startDate = LocalDate.parse(startTemp[0]).atTime(t);
    }

    @Override
    public String printTask() {
        return "[D]" + this.getStatus() + " " + this.description + " "  + "(by: " + printDate(startDate) +  ")";
    };

    @Override
    public void printSuccess(int size) {
        System.out.println("\tDeadlines, shag ah bro ;(.\n\t" +
                this.printTask());
        System.out.println("\t" + size + " tasks to be done");
    }

    public String getStart() {
        return this.start;
    }

}
