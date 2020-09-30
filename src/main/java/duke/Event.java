package duke;

import java.util.ArrayList;

public class Event extends Task {

    public Event(String description, String taskAt) {
        super(description);
        this.by = taskAt;
        taskType = "E";
    }

    public static int addTask(ArrayList taskList, int taskCount, String taskName, String taskAt) throws DukeException {

        if (!taskAt.contains("@ ")) {
            throw new DukeException();
        } else {
            taskList.add(new Event(taskName, taskAt));

            System.out.println(" Got it. I've added this task:\n" + "  [" + ((Task)taskList.get(taskCount)).taskType + "]["+ ((Task)taskList.get(taskCount)).getStatusIcon() + "] " + ((Task)taskList.get(taskCount)).description + " (" + ((Task)taskList.get(taskCount)).by + ")"  + "\n" + " Now you have " + (taskCount+1) + " tasks in the list.");

            Storage.WriteToFile(taskList);

            taskCount++;
            return taskCount;
        }
    }

}