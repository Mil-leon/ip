import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class Bebop {
    public static void main(String[] args) throws BebopException, IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>(100);
        String[] todos;
        String[] deadlines;
        String[] events;
        File directory = new File("data");
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
        while (true) {
            String input = scan.nextLine();
            String[] inputs = input.split(" ");
            int taskNum;
            switch(inputs[0]) {
            case "bye":
                System.out.println("\tHave a nice day :D, see you soon!");
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
                try {
                    checkToDo(todos, "t");
                } catch (BebopException b) {
                    System.out.println(b.getMessage());
                    continue;
                }
                Todo t = new Todo(todos[1]);
                taskList.add(t);
                System.out.println("\tYou got it buddy, get it done quick :D\n\t" +
                        t.printTask());
                System.out.println("\t" + taskList.size() + " tasks to be done");
                System.out.println("\t__________________________________");
                continue;
            case "deadline":
                todos = input.split("deadline ");
                try {
                    checkToDo(todos, "d");
                } catch (BebopException b) {
                    System.out.println(b.getMessage());
                    continue;
                }
                deadlines = todos[1].split(" /by");
                try {
                    checkToDo(deadlines, "d");
                } catch (BebopException b) {
                    System.out.println(b.getMessage());
                    continue;
                }

                Deadline d = new Deadline(deadlines[0], deadlines[1]);
                taskList.add(d);
                System.out.println("\tDeadlines, shag ah bro ;(.\n\t" +
                        d.printTask());
                System.out.println("\t" + taskList.size() + " tasks to be done");
                System.out.println("\t__________________________________");
                continue;
            case "event":
                todos = input.split("event ");
                try {
                    checkToDo(todos, "e");
                } catch (BebopException b) {
                    System.out.println(b.getMessage());
                    continue;
                }
                deadlines = todos[1].split(" /from");
                try {
                    checkToDo(deadlines, "e");
                } catch (BebopException b) {
                    System.out.println(b.getMessage());
                    continue;
                }
                events = deadlines[1].split(" /to");
                try {
                    checkToDo(events, "e");
                } catch (BebopException b) {
                    System.out.println(b.getMessage());
                    continue;
                }
                Event e = new Event(deadlines[0], events[0], events[1]);
                taskList.add(e);
                System.out.println("\tYippee, hope it's a fun even :D\n\t" +
                        e.printTask());
                System.out.println("\t" + taskList.size() + " tasks to be done");
                System.out.println("\t__________________________________");
            case "delete":
                taskNum = Integer.parseInt(inputs[1]);
                System.out.println("\tAlright! Congrats on finishing your task:)\n\t" +
                        taskList.get(taskNum - 1).printTask());
                System.out.println("\t__________________________________");
                taskList.remove(taskNum - 1);
                continue;
            default:
                System.out.println("\tSorry that's not a valid command :(");
            }
        }
    }

    public static void checkToDo(String[] arr, String s) throws BebopException{
        if (arr.length <= 1) {
            switch (s) {
            case "t":
                throw new BebopException("\tPlease give a valid todo format \"todo EVENTNAME\"");
            case "d":
                throw new BebopException("\tPlease give a valid deadline format \"deadline EVENTNAME /by ENDTIME\"");
            case "e":
                throw new BebopException("\tPlease give a valid event format \"event EVENTNAME /from STARTTIME /to ENDTIME\"" );
            }
        }
    }

    public static void readFile() {

    }

}
