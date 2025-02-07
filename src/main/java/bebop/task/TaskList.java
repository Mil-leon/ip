package bebop.task;
import java.util.ArrayList;

/**
 * TaskList to store all the tasks.
 */

public class TaskList {
    private final ArrayList<Task> tasks;
    private int size;

    /**
     * TaskList constructor.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
        size = 0;
    }

    /**
     * prints all the task in TaskList.
     */
    public String printAllTask() {
        StringBuilder output = new StringBuilder();
        int i = 0;
        for (Task task : tasks) {
            output.append(i + 1).append(" ").append(task.printTask());
            i++;
        }
        output.append("__________________________________");
        return output.toString();
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
     * adds Task to the taskList.
     *
     * @param t task to be added.
     */
    public void addTask(Task t) {
        tasks.add(t);
        size++;
    }

    /**
     * get Task of the specified index.
     *
     * @param index index of task.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * deletes Task of the specified index.
     *
     * @param index index of task.
     */
    public void deleteTask(int index) {
        tasks.remove(index);
        size--;
    }

    /**
     * returns size of the TaskList.
     *
     * @return size of the TaskList.
     */
    public int size() {
        return this.size;
    }

    /**
     * finds the Task
     *
     * @param taskName name of the Task.
     */
    public String findTask(String taskName) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).description.contains(taskName)) {
                output.append(tasks.get(i).printTask()).append("\n");
            }
        }
        if (output.length() == 0) {
            return "Task not found";
        }
        return output.toString();
    }
}
