package duke;

import java.util.ArrayList;

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

    public static int addTask(ArrayList taskList, int taskCount, String taskName) throws DukeException {
        taskList.add(new Task(taskName));

        System.out.println(" added: " + ((Task)taskList.get(taskCount)).description);

        taskCount++;
        return taskCount;
    }

    public static void taskList(Task[] taskList, int taskCount) {
        for(int i=0; i<taskCount;i++) {
            System.out.println(" " + (i+1) + ".[" + taskList[i].taskType + "][" + taskList[i].getStatusIcon() + "] " + taskList[i].description);
        }
    }

    public static void markAsDone(ArrayList taskList, int taskCount, int taskNum) {
        ((Task) taskList.get(taskNum)).isDone = true;
        if (((Task) taskList.get(taskNum)).taskType == "T") {
            System.out.println(" Nice! I've marked this task as done:\n" + "  [" + ((Task) taskList.get(taskNum)).taskType + "][" + ((Task) taskList.get(taskNum)).getStatusIcon() + "] " + ((Task) taskList.get(taskNum)).description);
        } else if (((Task) taskList.get(taskNum)).taskType == "D") {
            System.out.println(" Nice! I've marked this task as done:\n" + "  [" + ((Task) taskList.get(taskNum)).taskType + "][" + ((Task) taskList.get(taskNum)).getStatusIcon() + "] " + ((Task) taskList.get(taskNum)).description + " (" + ((Task) taskList.get(taskNum)).by + ")");
        } else if (((Task) taskList.get(taskNum)).taskType == "E") {
            System.out.println(" Nice! I've marked this task as done:\n" + "  [" + ((Task) taskList.get(taskNum)).taskType + "][" + ((Task) taskList.get(taskNum)).getStatusIcon() + "] " + ((Task) taskList.get(taskNum)).description + " (" + ((Task) taskList.get(taskNum)).by + ")");
        }

    }

    public static int delete(ArrayList<Task> taskList, int taskCount, int taskNum) {

        if(((Task)taskList.get(taskNum)).taskType == "T") {
            System.out.println(" Noted. I've removed this task:\n" + "  [" + ((Task)taskList.get(taskNum)).taskType + "]["+ ((Task)taskList.get(taskNum)).getStatusIcon() + "] " + ((Task)taskList.get(taskNum)).description + "\n" + " Now you have " + (taskCount - 1) + " tasks in the list.");
        } else if (((Task)taskList.get(taskNum)).taskType == "D") {
            System.out.println(" Noted. I've removed this task:\n" + "  [" + ((Task)taskList.get(taskNum)).taskType + "][" + ((Task)taskList.get(taskNum)).getStatusIcon() + "] " + ((Task)taskList.get(taskNum)).description + " (" + ((Task) taskList.get(taskNum)).by + ")" + "\n" + " Now you have " + (taskList.size()-1) + " tasks in the list.");
        } else if (((Task)taskList.get(taskNum)).taskType == "E") {
            System.out.println(" Noted. I've removed this task:\n" + "  [" + ((Task)taskList.get(taskNum)).taskType + "][" + ((Task)taskList.get(taskNum)).getStatusIcon() + "] " + ((Task)taskList.get(taskNum)).description + " (" + ((Task) taskList.get(taskNum)).by + ")" + "\n" + " Now you have " + (taskList.size()-1) + " tasks in the list.");
        }

        taskList.remove(taskNum);
        taskCount--;
        return taskCount;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    //...
}