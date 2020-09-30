package duke;

import java.util.ArrayList;

public class TaskList {
    public static int delete(ArrayList<Task> taskList, int taskCount, int taskNum) {

        if((taskList.get(taskNum)).taskType == "T") {
            System.out.println(" Noted. I've removed this task:\n" + "  [" + (taskList.get(taskNum)).taskType + "]["+ (taskList.get(taskNum)).getStatusIcon() + "] " + (taskList.get(taskNum)).description + "\n" + " Now you have " + (taskCount - 1) + " tasks in the list.");
        } else if ((taskList.get(taskNum)).taskType == "D") {
            System.out.println(" Noted. I've removed this task:\n" + "  [" + (taskList.get(taskNum)).taskType + "][" + (taskList.get(taskNum)).getStatusIcon() + "] " + (taskList.get(taskNum)).description + " (" + (taskList.get(taskNum)).by + ")" + "\n" + " Now you have " + (taskList.size()-1) + " tasks in the list.");
        } else if ((taskList.get(taskNum)).taskType == "E") {
            System.out.println(" Noted. I've removed this task:\n" + "  [" + (taskList.get(taskNum)).taskType + "][" + (taskList.get(taskNum)).getStatusIcon() + "] " + (taskList.get(taskNum)).description + " (" + (taskList.get(taskNum)).by + ")" + "\n" + " Now you have " + (taskList.size()-1) + " tasks in the list.");
        }

        taskList.remove(taskNum);
        Storage.WriteToFile(taskList);
        taskCount--;
        return taskCount;
    }

    public static int addTask(ArrayList taskList, int taskCount, String taskName) throws DukeException {
        if (taskName.contains("todo")) {
            throw new DukeException();
        } else {
            taskList.add(new Todo(taskName));

            System.out.println(" Got it. I've added this task:\n" + "  [" + ((Task)taskList.get(taskCount)).taskType + "][" + ((Task)taskList.get(taskCount)).getStatusIcon() + "] " + ((Task)taskList.get(taskCount)).description + "\n" + " Now you have " + (taskCount + 1) + " tasks in the list.");

            Storage.WriteToFile(taskList);

            taskCount++;
            return taskCount;
        }
    }

}
