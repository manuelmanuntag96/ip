public class Event extends Task {

    public Event(String description, String taskAt) {
        super(description);
        this.by = taskAt;
        taskType = "E";
    }

    public static int addTask(Task[] taskList, int taskCount, String taskName, String taskAt) {
            taskList[taskCount] = new Event(taskName, taskAt);

            System.out.println(" Got it. I've added this task:\n" + "  [" + taskList[taskCount].taskType + "]["+ taskList[taskCount].getStatusIcon() + "] " + taskList[taskCount].description + " (" + taskList[taskCount].by + ")"  + "\n" + " Now you have " + (taskCount+1) + " tasks in the list.");

            taskCount++;
            return taskCount;
    }

}