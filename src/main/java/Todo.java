public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public static int addTask(Task[] taskList, int taskCount, String taskName) throws DukeException {
        if (taskName.contains("todo")) {
            throw new DukeException();
        } else {
            taskList[taskCount] = new Todo(taskName);

            System.out.println(" Got it. I've added this task:\n" + "  [" + taskList[taskCount].taskType + "][" + taskList[taskCount].getStatusIcon() + "] " + taskList[taskCount].description + "\n" + " Now you have " + (taskCount + 1) + " tasks in the list.");
            taskCount++;
            return taskCount;
        }
    }
}