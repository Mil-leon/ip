public class Deadline extends Task {
    String start;
    public Deadline(String d, String start) {
        super(d);
        this.start = start;
    }

    public String printDL() {
        return "(by: " + this.start + ")";
    }
    @Override
    public String printTask() {
        return "[D]" + this.getStatus() + " " + this.description + " "  + "(by:" + this.start +  ")";
    };
}
