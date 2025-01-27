public class MarkCommand extends Command {
    int index;
    boolean isDone;
    public MarkCommand(Boolean isDone, String command) {
        String[] temp = command.split(" ");
        this.index = Integer.parseInt(temp[1]);
        this.isDone = isDone;
    }
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) {
        if (this.isDone) {
            tasks.setTaskDone(this.index);
            System.out.println("\tGood Job! I've marked the task as done!\n\t");
        } else {
            tasks.setTaskNotDone(this.index);
            System.out.println("\tAlright! Let's get this done soon :)\n\t");
        }
        tasks.printTask(index);
        return true;
    }

}
