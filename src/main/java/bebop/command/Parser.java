package bebop.command;

public class Parser {

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
            case "find" -> new FindCommand(command);
            default -> new InvalidCommand();
        };
    }


}
