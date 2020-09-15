package duke;


import java.util.ArrayList;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public static int addTask(ArrayList taskList, int taskCount, String taskName) throws DukeException {
        if (taskName.contains("todo")) {
            throw new DukeException();
        } else {
            taskList.add(new Todo(taskName));

            System.out.println(" Got it. I've added this task:\n" + "  [" + ((Task)taskList.get(taskCount)).taskType + "][" + ((Task)taskList.get(taskCount)).getStatusIcon() + "] " + ((Task)taskList.get(taskCount)).description + "\n" + " Now you have " + (taskCount + 1) + " tasks in the list.");
            taskCount++;
            return taskCount;
        }
    }
}