package duke;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Deadline class allows the creation of Deadline Tasks
 *
 */
public class Deadline extends Task {

    /**
     * Deadline constructor inherits the description, sets the by member and sets the taskType as "D"
     *
     * @param description the name of the task
     * @param by is the time of the deadline
     *
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        taskType = "D";
        this.date = LocalDate.parse("0000-01-01");
    }

    /**
     * addTask method adds the event into the taskList
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param taskCount current number of tasks in the taskList
     * @param taskName name of the Deadline
     * @param taskBy date of the Deadline
     *
     */
    public static int addTask(ArrayList taskList, int taskCount, String taskName, String taskBy) throws DukeException {

        if(!taskBy.contains("by ")) {
            throw new DukeException();
        } else {
            taskList.add(new Deadline(taskName, taskBy));

            System.out.println(" Got it. I've added this task:\n" + "  [" + ((Task)taskList.get(taskCount)).taskType + "]["+ ((Task)taskList.get(taskCount)).getStatusIcon() + "] " + ((Task)taskList.get(taskCount)).description + " (" + ((Task)taskList.get(taskCount)).by + ")"+ "\n" + " Now you have " + (taskCount+1) + " tasks in the list.");

            Storage.WriteToFile(taskList);;

            taskCount++;
            return taskCount;
        }
    }

    /**
     * taskList method prints the event/deadlines from the taskList
     *
     * @param taskList the ArrayList that contains all the existing tasks
     *
     */
    public static void taskList(ArrayList taskList) {

        for(int i=0; i<taskList.size();i++) {
            if(((Task)taskList.get(i)).taskType == "T") {
                System.out.println(" " + (i + 1) + ".[" + ((Task)taskList.get(i)).taskType + "][" + ((Task)taskList.get(i)).getStatusIcon() + "] " + ((Task)taskList.get(i)).description);
            } else {
                System.out.println(" " + (i + 1) + ".[" + ((Task)taskList.get(i)).taskType + "][" + ((Task)taskList.get(i)).getStatusIcon() + "] " + ((Task)taskList.get(i)).description + " (" + ((Task)taskList.get(i)).by + ") "  + ((Task)taskList.get(i)).date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) );
            }
        }
    }



}