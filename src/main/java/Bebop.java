import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Bebop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> taskList = new ArrayList(100);
        String logo = "\tWhat can I do for you today? \n" +
                "\t__________________________________";
        System.out.println("\tHowdy! How's it going? \n" + logo);
        while (true) {
            String input = scan.nextLine();
            if (Objects.equals(input, "bye")) {
                System.out.println("\tHave a nice day :D, see you soon!");
                break;
            } else if (Objects.equals(input, "list")) {
                int i = 0;
                for (String task : taskList) {
                    System.out.println("\t" + (i + 1) + ": "  + taskList.get(i));
                    i++;
                }
                System.out.println("\t__________________________________");
            } else {
                taskList.add(input);
                System.out.println("\t" + "added: " + input +
                        "\n\t__________________________________");
            }
        }
    }
}
