import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> tasks;
    int size;

    public TaskList() {
        this.tasks = new ArrayList<>();
        size = 0;
    }

    public void printTasks() {
        int i = 0;
        for (Task task : tasks) {
            System.out.println("\t" + (i + 1) + " " + task.printTask());
            i++;
        }
        System.out.println("\t__________________________________");
    }

    public void setTaskDone(int index) {
        this.tasks.get(index).markDone();
    }

    public void setTaskNotDone(int index) {
        this.tasks.get(index).markDone();
    }

    public void printTask(int index) {
        this.tasks.get(index).printTask();
    }

    public void addTask(Task t) {
        tasks.add(t);
        size++;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void deleteTask(int index) {
        tasks.remove(index);
        size--;
    }

    public int size() {
        return this.size;
    }
}
