package bebop.command;

/**
 * Parses all the command to the Ui
 */
public class Parser {

    /**
     * parses command string into command type
     *
     * @param command command being processed
     * @return command of Command class
     */
    public Command parse(String command) {
        String[] inputs = command.split(" ");
        return switch (inputs[0]) {
            case "bye" -> new ExitCommand();
            case "list" -> new ListCommand();
            case "mark" -> new MarkCommand(true, command);
            case "unmark" -> new MarkCommand(false, command);
            case "todo" -> new AddCommand("t", command);
            case "deadline" -> new AddCommand("d", command);
            case "event" -> new AddCommand("e", command);
            case "delete" -> new DeleteCommand(command);
            default -> new InvalidCommand();
        };
    }


}
