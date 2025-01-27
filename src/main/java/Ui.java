import java.util.Scanner;

public class Ui {
    Scanner scan;
    public Ui() {
        scan = new Scanner(System.in);
    }

    public void welcomeGuest() {
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
        System.out.println("\tTODO : todo EVENTNAME");
        System.out.println("\tDEADLINE : deadline EVENTNAME /by ENDTIME");
        System.out.println("\tEVENT : event EVENTNAME /from STARTTIME /to ENDTIME");
    }

    public void divider() {
        System.out.println("\t__________________________________");
    }

    public String readCommand() {
        return scan.nextLine();
    }

    public void showError(String m) {
        System.out.println("ERROR");
        System.out.println("m");
    }

}
