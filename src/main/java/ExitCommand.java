public class ExitCommand extends Command {

    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) {
        System.out.println("\tHave a nice day :D, see you soon!");
        return false;
    }
}
