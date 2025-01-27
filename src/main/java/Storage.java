import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
    }

    public TaskList load(TaskList tasks) throws IOException {
        File directory = new File("data");
        String[] todos;
        String[] deadlines;
        String[] events;

        if (!directory.exists()) {
            directory.mkdirs();
        }
        File file = new File(directory, "Bebop.txt");
        FileWriter fw = new FileWriter(this.fileName, true);
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

        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String[] tempStr = fileScanner.nextLine().split(" \\| ");
            boolean isDone = !tempStr[1].equals(" [ ]");
            switch (tempStr[0]) {
            case "T":
                tasks.addTask(new Todo(tempStr[2], isDone));
                continue;
            case "D":
                tasks.addTask(new Deadline(tempStr[2], isDone, tempStr[3]));
                continue;
            case "E":
                tasks.addTask(new Event(tempStr[2], isDone, tempStr[3], tempStr[4]));
            }
        }
        fw.close();
        return tasks;
    }

    public void deload(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(this.fileName, false);
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.getTask(i) instanceof Todo t) {
                fw.write("T | " + t.getStatus() + " | " + t.description + "\n");
            } else if (tasks.getTask(i) instanceof Deadline d) {
                fw.write("D | " + d.getStatus() + " | " + d.description + " | " + d.start + "\n");
            } else {
                Event e = (Event) tasks.getTask(i);
                fw.write("E | " + e.getStatus() + " | " + e.description + " | " + e.start + " | " + e.end + "\n");
            }
        }
        fw.close();
    }

}
