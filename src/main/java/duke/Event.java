package duke;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Event class allows the creation of Event Tasks
 *
 */
public class Event extends Task {

    /**
     * Event constructor inherits the description, sets the by member and sets the taskType as "E"
     *
     * @param description the name of the task
     * @param taskAt is the time of the event
     *
     */
    public Event(String description, String taskAt) {
        super(description);
        this.by = taskAt;
        taskType = "E";
        this.date = LocalDate.parse("0000-01-01");
    }

    /**
     * addTask method adds the event into the taskList
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param taskCount current number of tasks in the taskList
     * @param taskName name of the Event
     * @param taskAt date of the Event
     *
     */
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