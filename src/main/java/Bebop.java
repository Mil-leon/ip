import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Bebop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>(100);

        String logo = "\t _          _                 \n" +
                "\t| |        | |                \n" +
                "\t| |__   ___| |__   ___  _ __  \n" +
                "\t| '_ \\ / _ \\ '_ \\ / _ \\| '_ \\ \n" +
                "\t| |_) |  __/ |_) | (_) | |_) |\n" +
                "\t|_.__/ \\___|_.__/ \\___/| .__/ \n" +
                "\t                       | |    \n" +
                "\t                       |_|    \t" + "\n\tWhat will you be doing today? \n" +
                "\t__________________________________";
        System.out.println("\tHowdy! How's it going? \n" + logo);
        while (true) {
            String input = scan.nextLine();
            String[] i_list = input.split(" ");
            int taskNum;
            switch(i_list[0]) {
                case "bye":
                    System.out.println("\tHave a nice day :D, see you soon!");
                    break;
                case "list":
                    int i = 0;
                    for (Task task : taskList) {
                        System.out.println("\t" + (i + 1) + task.getStatus() + ": " + taskList.get(i).description);
                        i++;
                    }
                    System.out.println("\t__________________________________");
                    continue;
                case "mark":
                    taskNum = Integer.parseInt(i_list[1]);
                    taskList.get(taskNum).markDone();
                    System.out.println("\tGood Job! I've marked the task as done!\n\t" +
                            taskList.get(taskNum).getStatus() + " " + taskList.get(taskNum).description);
                    System.out.println("\t__________________________________");
                    continue;
                case "unmark":
                    taskNum = Integer.parseInt(i_list[1]);
                    taskList.get(taskNum).unmarkDone();
                    System.out.println("\tAlright! Let's get this done soon :)\n\t" +
                            taskList.get(taskNum).getStatus() + " " + taskList.get(taskNum).description);
                    System.out.println("\t__________________________________");
                    continue;
                default:
                    taskList.add(new Task(input));
                    System.out.println("\t" + "added: " + input +
                            "\n\t__________________________________");
            }
        }
    }
}
