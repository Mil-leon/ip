public class DeleteCommand extends Command {
    String command;
    public DeleteCommand(String command) {
        this.command = command;
    }
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) {
        String[] input = this.command.split(" ");
        int taskNum = Integer.parseInt(input[1]);
        System.out.println("\tAlright! Congrats on finishing your task:)\n\t" +
                tasks.getTask(taskNum - 1).printTask());
        System.out.println("\t__________________________________");
        tasks.deleteTask(taskNum - 1);
        return true;
    }
}
