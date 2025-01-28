package bebop.task;
public class Todo extends Task {
    public Todo(String description, Boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String printTask() {
        return "[T]" + this.getStatus() + " " + this.description;
    };


    @Override
    public void printSuccess(int size) {
        System.out.println("\tYou got it buddy, get it done quick :D\n\t" +
                this.printTask());
        System.out.println("\t" + size + " tasks to be done");
    }

}
