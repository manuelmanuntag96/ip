package duke;

import java.util.ArrayList;
import java.util.Scanner;

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
        WriteToFile.main(taskList);
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
        WriteToFile.main(taskList);
        taskCount--;
        return taskCount;
    }

    public static String taskListToString(ArrayList taskList) {
        String taskListString = "";

        for(int i = 0; i < taskList.size(); i++) {
            if(((Task)taskList.get(i)).taskType == "T") {
                taskListString = taskListString + (((Task) taskList.get(i)).isDone ? "1" : "0") + " " + ((Task) taskList.get(i)).taskType + " " + ((Task) taskList.get(i)).description + "\n";
            } else {
                taskListString = taskListString + (((Task) taskList.get(i)).isDone ? "1" : "0") + " " + ((Task) taskList.get(i)).taskType + " " + ((Task) taskList.get(i)).description + " /" + ((Task)taskList.get(i)).by  + "\n";
            }
        }

        return taskListString;
    }

    public static int readToArray(Scanner myReader, ArrayList<Task> taskList, int taskCount) throws DukeException {
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            int dividerPosition = data.indexOf(" ");
            String taskNameType = data.substring(dividerPosition+1);
            int dividerPosition2 = data.indexOf(" ");
            if(taskNameType.contains("T ")) {
                String taskName = taskNameType.substring(dividerPosition2+1);
                taskCount = Todo.addTask(taskList, taskCount, taskName);
            } else if (taskNameType.contains("D ")) {
                int dividerBy = taskNameType.indexOf("/");
                String taskName = taskNameType.substring(dividerPosition2+1, dividerBy - 1);
                String taskBy = taskNameType.substring(dividerBy + 1);
                taskCount = Deadline.addTask(taskList, taskCount, taskName, taskBy);
            } else if (taskNameType.contains("E ")) {
                int dividerBy = taskNameType.indexOf("/");
                String taskName = taskNameType.substring(dividerPosition2+1, dividerBy-1);
                String taskAt = taskNameType.substring(dividerBy+1);
                taskCount = Event.addTask(taskList, taskCount, taskName, taskAt);
            }

            if (data.contains("1 ")) {
                taskList.get(taskList.size()-1).isDone=true;
            }
        }
        return taskCount;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    //...
}