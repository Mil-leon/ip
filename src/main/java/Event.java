import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Event extends Task{
    String start;
    String end;
    LocalDateTime startDate;
    LocalDateTime endDate;
    public Event(String description, boolean isDone, String start, String end){
        super(description, isDone);
        this.start = start;
        this.end = end;
        String[] startTemp = this.start.split(" ");
        LocalTime t1 = LocalTime.parse(startTemp[1]);
        this.startDate = LocalDate.parse(startTemp[0]).atTime(t1);
        String[] endTemp = this.end.split(" ");
        LocalTime t2 = LocalTime.parse(endTemp[1]);
        this.endDate = LocalDate.parse(endTemp[0]).atTime(t2);
    }

    @Override
    public String printTask() {
        return "[E]" + this.getStatus() + " " + this.description + " "  +
                "(from: " + super.printDate(startDate) + " to: " + printDate(endDate) + ")";
    };

    @Override
    public void printSuccess(int size) {
        System.out.println("\tYippee, hope it's a fun event :D\n\t" +
                this.printTask());
        System.out.println("\t" + size + " tasks to be done");
        System.out.println("\t__________________________________");
    }



}
