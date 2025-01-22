import java.util.Objects;
import java.util.Scanner;

public class Bebop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String logo = "\tWhat can I do for you today? \n" +
                "\t__________________________________";
        System.out.println("\tHowdy! How's it going? \n" + logo);
        while (true) {
            String input = s.nextLine();
            if (Objects.equals(input, "bye")) {
                System.out.println("\tHave a nice day :D, see you soon!");
                break;
            } else {
                System.out.println("\t" + input +
                        "\n\t__________________________________");
            }
        }
    }
}
