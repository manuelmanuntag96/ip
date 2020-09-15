package duke;

import java.util.ArrayList;

public class Deadline extends Task {

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        taskType = "D";
    }

    public static int addTask(ArrayList taskList, int taskCount, String taskName, String taskBy) throws DukeException {
        if(!taskBy.contains("by ")) {
            throw new DukeException();
        } else {
            taskList.add(new Deadline(taskName, taskBy));

            System.out.println(" Got it. I've added this task:\n" + "  [" + ((Task)taskList.get(taskCount)).taskType + "]["+ ((Task)taskList.get(taskCount)).getStatusIcon() + "] " + ((Task)taskList.get(taskCount)).description + " (" + ((Task)taskList.get(taskCount)).by + ")"  + "\n" + " Now you have " + (taskCount+1) + " tasks in the list.");

            taskCount++;
            return taskCount;
        }
    }

    public static void taskList(ArrayList taskList, int taskCount) {
        for(int i=0; i<taskList.size();i++) {
            if(((Task)taskList.get(i)).taskType == "T") {
                System.out.println(" " + (i + 1) + ".[" + ((Task)taskList.get(i)).taskType + "][" + ((Task)taskList.get(i)).getStatusIcon() + "] " + ((Task)taskList.get(i)).description);
            } else {
                System.out.println(" " + (i + 1) + ".[" + ((Task)taskList.get(i)).taskType + "][" + ((Task)taskList.get(i)).getStatusIcon() + "] " + ((Task)taskList.get(i)).description + " (" + ((Task)taskList.get(i)).by + ")");
            }
        }
    }



}