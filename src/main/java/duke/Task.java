package duke;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;
    protected String by;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.taskType = "T";
    }

    public static int addTask(Task[] taskList, int taskCount, String taskName) throws DukeException {
        taskList[taskCount] = new Task(taskName);

        System.out.println(" added: " + taskList[taskCount].description);

        taskCount++;
        return taskCount;
    }

    public static void taskList(Task[] taskList, int taskCount) {
        for(int i=0; i<taskCount;i++) {
            System.out.println(" " + (i+1) + ".[" + taskList[i].taskType + "][" + taskList[i].getStatusIcon() + "] " + taskList[i].description);
        }
    }

    public static void markAsDone(Task[] taskList, int taskCount, int taskNum) {
        taskList[taskNum-1].isDone = true;
        System.out.println(" Nice! I've marked this task as done:\n" + "   [" + taskList[taskNum-1].getStatusIcon() + "] " + taskList[taskNum-1].description );
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    //...
}