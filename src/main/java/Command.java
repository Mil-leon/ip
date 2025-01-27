public abstract class Command {
    public abstract boolean execute(TaskList tasks, Ui ui, Storage storage) throws BebopException;

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
