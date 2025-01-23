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
        String[] t_list;
        String[] d_list;
        String[] e_list;
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
                        System.out.println("\t" + (i + 1) + " " + task.printTask());
                        i++;
                    }
                    System.out.println("\t__________________________________");
                    continue;
                case "mark":
                    taskNum = Integer.parseInt(i_list[1]);
                    taskList.get(taskNum).markDone();
                    System.out.println("\tGood Job! I've marked the task as done!\n\t" +
                            taskList.get(taskNum - 1).printTask());
                    System.out.println("\t__________________________________");
                    continue;
                case "unmark":
                    taskNum = Integer.parseInt(i_list[1]);
                    taskList.get(taskNum).unmarkDone();
                    System.out.println("\tAlright! Let's get this done soon :)\n\t" +
                            taskList.get(taskNum).printTask());
                    System.out.println("\t__________________________________");
                    continue;
                case "todo":
                    t_list = input.split("todo ");
                    Todo t = new Todo(t_list[1]);
                    taskList.add(t);
                    System.out.println("\tYou got it buddy, get it done quick :D\n\t" +
                            t.printTask());
                    System.out.println("\t" + taskList.size() + " tasks to be done");
                    System.out.println("\t__________________________________");
                    continue;
                case "deadline":
                    t_list = input.split("deadline ");
                    d_list = t_list[1].split(" /by");
                    Deadline d = new Deadline(d_list[0], d_list[1]);
                    taskList.add(d);
                    System.out.println("\tDeadlines, shag ah bro ;(. \n\t" +
                            d.printTask());
                    System.out.println("\t" + taskList.size() + " tasks to be done");
                    System.out.println("\t__________________________________");
                    continue;
                case "event":
                    t_list = input.split("event ");
                    d_list = t_list[1].split(" /from");
                    e_list = d_list[1].split(" /to");
                    Event e = new Event(d_list[0], e_list[0], e_list[1]);
                    taskList.add(e);
                    System.out.println("\tYippee, hope it's a fun even :D\n\t" +
                            e.printTask());
                    System.out.println("\t" + taskList.size() + " tasks to be done");
                    System.out.println("\t__________________________________");
            }
        }
    }
}
