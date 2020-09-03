public class Deadline extends Task {

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        taskType = "D";
    }

    public static int addTask(Task[] taskList, int taskCount, String taskName, String taskBy) {
        taskList[taskCount] = new Deadline(taskName, taskBy);

        System.out.println(" Got it. I've added this task:\n" + "  [" + taskList[taskCount].taskType + "]["+ taskList[taskCount].getStatusIcon() + "] " + taskList[taskCount].description + " (" + taskList[taskCount].by + ")"  + "\n" + " Now you have " + (taskCount+1) + " tasks in the list.");

        taskCount++;
        return taskCount;
    }

    public static void taskList(Task[] taskList, int taskCount) {
        for(int i=0; i<taskCount;i++) {
            if(taskList[i].taskType == "T") {
                System.out.println(" " + (i + 1) + ".[" + taskList[i].taskType + "][" + taskList[i].getStatusIcon() + "] " + taskList[i].description);
            } else {
                System.out.println(" " + (i + 1) + ".[" + taskList[i].taskType + "][" + taskList[i].getStatusIcon() + "] " + taskList[i].description + " (" + taskList[i].by + ")");
            }
        }
    }



}