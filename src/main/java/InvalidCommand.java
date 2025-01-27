public class InvalidCommand extends Command{
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) {
        System.out.println("\tSorry that's not a valid command :D, please use an appropriate format");
        return true;
    }
}
