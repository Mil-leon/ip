package bebop.task;
import java.util.ArrayList;

/**
 * TaskList to store all the tasks
 */

public class TaskList {
    ArrayList<Task> tasks;
    int size;

    /**
     * TaskList constructor
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
        size = 0;
    }

    /**
     * prints all the task in TaskList
     */
    public void printAllTask() {
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

    /**
     * adds Task to the taskList
     *
     * @param t task to be added
     */
    public void addTask(Task t) {
        tasks.add(t);
        size++;
    }

    /**
     * get Task of the specified index
     *
     * @param index index of task
     */
    public Task getTask(int index) {

        return tasks.get(index);
    }

    /**
     * deletes Task of the specified index
     *
     * @param index index of task
     */
    public void deleteTask(int index) {
        tasks.remove(index);
        size--;
    }

    /**
     * returns size of the TaskList
     *
     * @return size of the TaskList
     */
    public int size() {

        return this.size;
    }
}
