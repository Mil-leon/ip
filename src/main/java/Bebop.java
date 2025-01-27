import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class Bebop {
    public static void main(String[] args) throws BebopException, IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>(100);
        boolean isContinuing = true;
        File directory = new File("data");
        String[] todos;
        String[] deadlines;
        String[] events;
        String logo = "\t _          _\n" +
                "\t| |        | |\n" +
                "\t| |__   ___| |__   ___  _ __\n" +
                "\t| '_ \\ / _ \\ '_ \\ / _ \\| '_ \\\n" +
                "\t| |_) |  __/ |_) | (_) | |_) |\n" +
                "\t|_.__/ \\___|_.__/ \\___/| .__/\n" +
                "\t                       | |\n" +
                "\t                       |_|" + "\n\tWhat will you be doing today?\n" +
                "\t__________________________________";
        System.out.println("\tHowdy! How's it going?\n" + logo);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File file = new File(directory, "Bebop.txt");
        FileWriter fw = new FileWriter("data/Bebop.txt", true);
        // check if the file has any words
        try {
            boolean c = file.createNewFile();
            if (c) {
                System.out.println("\tA new save file has been created");
            } else {
                System.out.println("\tSaved task are still remembered");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
        }
        // add the tasks into the TaskList
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String[] tempStr = fileScanner.nextLine().split(" \\| ");
            boolean isDone = !tempStr[1].equals(" [ ]");
            switch (tempStr[0]) {
            case "T":
                taskList.add(new Todo(tempStr[2], isDone));
                continue;
            case "D":
                taskList.add(new Deadline(tempStr[2], isDone, tempStr[3]));
                continue;
            case "E":
                taskList.add(new Event(tempStr[2], isDone, tempStr[3], tempStr[4]));
            }
        }
        fw = new FileWriter(file, false);
        while (isContinuing) {
            String input = scan.nextLine();
            String[] inputs = input.split(" ");
            int taskNum;
            switch(inputs[0]) {
            case "bye":
                System.out.println("\tHave a nice day :D, see you soon!");
                isContinuing = false;
                break;
            case "list":
                int i = 0;
                for (Task task : taskList) {
                    System.out.println("\t" + (i + 1) + " " + task.printTask());
                    i++;
                }
                System.out.println("\t__________________________________");
                continue;
            case "mark":
                taskNum = Integer.parseInt(inputs[1]);
                taskList.get(taskNum - 1).markDone();
                System.out.println("\tGood Job! I've marked the task as done!\n\t" +
                        taskList.get(taskNum - 1).printTask());
                System.out.println("\t__________________________________");
                continue;
            case "unmark":
                taskNum = Integer.parseInt(inputs[1]);
                taskList.get(taskNum - 1).unmarkDone();
                System.out.println("\tAlright! Let's get this done soon :)\n\t" +
                        taskList.get(taskNum - 1).printTask());
                System.out.println("\t__________________________________");
                continue;
            case "todo":
                todos = input.split("todo ");
                if (!isFormatted(todos, "t")) {
                    continue;
                }
                Todo t = new Todo(todos[1], false);
                taskList.add(t);
                t.printSuccess(taskList.size());
                continue;
            case "deadline":
                todos = input.split("deadline ");
                if (!isFormatted(todos, "d")) {
                    continue;
                }
                deadlines = todos[1].split(" /by ");
                if (!isFormatted(deadlines, "d")) {
                    continue;
                }
                if (isValidLocalDateTime(deadlines[1])) {
                    Deadline d = new Deadline(deadlines[0], false, deadlines[1]);
                    taskList.add(d);
                    d.printSuccess(taskList.size());
                } else {
                    System.out.println("Incorrect time format! Valid time format is YYYY-MM-DD HH:MM");
                }
                continue;
            case "event":
                todos = input.split("event ");
                if (!isFormatted(todos, "e")) {
                    continue;
                }
                deadlines = todos[1].split(" /from ");
                if (!isFormatted(deadlines, "e")) {
                    continue;
                }
                events = deadlines[1].split(" /to ");
                if (!isFormatted(events, "e")) {
                    continue;
                }
                if (isValidLocalDateTime(events[0]) && isValidLocalDateTime(events[1])) {
                    Event e = new Event(deadlines[0], false, events[0], events[1]);
                    taskList.add(e);
                    e.printSuccess(taskList.size());
                } else {
                    System.out.println("Incorrect time format! Valid time format is YYYY-MM-DD HH:MM");
                }
                continue;
            case "delete":
                taskNum = Integer.parseInt(inputs[1]);
                System.out.println("\tAlright! Congrats on finishing your task:)\n\t" +
                        taskList.get(taskNum - 1).printTask());
                System.out.println("\t__________________________________");
                taskList.remove(taskNum - 1);
                continue;
            default:
                System.out.println("\tSorry that's not a valid command :D, please use an appropriate format");
            }
        }

        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i) instanceof Todo t) {
                fw.write("T | " + t.getStatus() + " | " + t.description + "\n");
            } else if (taskList.get(i) instanceof Deadline d) {
                fw.write("D | " + d.getStatus() + " | " + d.description + " | " + d.start + "\n");
            } else {
                Event e = (Event) taskList.get(i);
                fw.write("E | " + e.getStatus() + " | " + e.description + " | " + e.start + " | " + e.end + "\n");
            }
        }
        fw.close();
        scan.close();
    }

    public static void checkToDo(String[] arr, String s) throws BebopException{
        if (arr.length <= 1) {
            switch (s) {
            case "t":
                throw new BebopException("\tPlease give a valid todo format: " +
                        "\"todo EVENTNAME\"");
            case "d":
                throw new BebopException("\tPlease give a valid deadline format: " +
                        "\"deadline EVENTNAME /by ENDTIME\"");
            case "e":
                throw new BebopException("\tPlease give a valid event format: " +
                        "\"event EVENTNAME /from STARTTIME /to ENDTIME\"" );
            }
        }
    }

    public static void readFile() {

    }

    public static boolean isFormatted(String[] list, String type) {
        try {
            checkToDo(list, type);
            return true;
        } catch (BebopException b) {
            System.out.println(b.getMessage());
            return false;
        }
    }

    public static boolean isValidLocalDateTime(String dateTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            LocalDateTime.parse(dateTimeStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


}
