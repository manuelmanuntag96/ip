package duke;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Task class is the Parent class of Todo, Event, and Deadline Classes.
 *
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;
    protected String by;
    protected LocalDate date;

    /**
     * Task constructor that establishes description, isDone and taskType members
     *
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.taskType = "T";
    }

    /**
     * markAsDone method takes in the taskList and desired taskNum and makes the isDone member as true
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param taskNum the index where the task to be marked is located
     *
     */
    public static void markAsDone(ArrayList<Task> taskList, int taskNum) {
        (taskList.get(taskNum)).isDone = true;
        Storage.WriteToFile(taskList);

        if ((taskList.get(taskNum)).taskType.equals("T")) {
            System.out.println(" Nice! I've marked this task as done:\n" + "  [" + (taskList.get(taskNum)).taskType + "][" + (taskList.get(taskNum)).getStatusIcon() + "] " + (taskList.get(taskNum)).description);
        } else if ((taskList.get(taskNum)).taskType.equals("D")) {
            System.out.println(" Nice! I've marked this task as done:\n" + "  [" + (taskList.get(taskNum)).taskType + "][" + (taskList.get(taskNum)).getStatusIcon() + "] " + (taskList.get(taskNum)).description + " (" + (taskList.get(taskNum)).by + ")");
        } else if ((taskList.get(taskNum)).taskType.equals("E")) {
            System.out.println(" Nice! I've marked this task as done:\n" + "  [" + (taskList.get(taskNum)).taskType + "][" + (taskList.get(taskNum)).getStatusIcon() + "] " + (taskList.get(taskNum)).description + " (" + (taskList.get(taskNum)).by + ")");
        }

    }

    /**
     * taskListToString method takes in all the tasks in the taskList converts them all into a String so that it can be stored in a save file
     *
     * @param taskList the ArrayList that contains all the existing tasks
     *
     * @return taskListString
     *
     */
    public static String taskListToString(ArrayList<Task> taskList) {
        String taskListString = "";

        for(int i = 0; i < taskList.size(); i++) {
            if((taskList.get(i)).taskType.equals("T")) {
                taskListString = taskListString + ((taskList.get(i)).isDone ? "1" : "0") + " " + (taskList.get(i)).taskType + " " + (taskList.get(i)).description + "\n";
            } else {
                taskListString = taskListString + ((taskList.get(i)).isDone ? "1" : "0") + " " + (taskList.get(i)).taskType + " " + (taskList.get(i)).description + " /" + (taskList.get(i)).by  + "\n";
            }
        }

        return taskListString;
    }

    /**
     * printDeadlines method takes in the taskList and the desired date to be searched to print out all tasks with the same date
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param key the desired date for searching
     *
     */
    public static void printDeadlines(ArrayList<Task> taskList, String key) throws DukeException {
        LocalDate dKey = LocalDate.parse(key);
        int count = 1;
        boolean hasMatch = false;

        System.out.println(" Here are the matching dates in your list:");

        for (int i = 0; i < taskList.size(); i++) {
            if (!(taskList.get(i)).taskType.equals("T")) {
                if(dKey.equals((taskList.get(i)).date)) {
                    hasMatch = true;
                    System.out.println(" " + (count) + ".[" + (taskList.get(i)).taskType + "][" + (taskList.get(i)).getStatusIcon() + "] " + (taskList.get(i)).description + " (" + (taskList.get(i)).by + ") "  + (taskList.get(i)).date.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
                    count++;
                }
            }
        }

        if (!hasMatch) {
            throw new DukeException();
        }

    }

    /**
     * getStatusIcon method checks the status of the isDone and return corresponding tick or X symbols
     *
     * @return tick or X symbols
     *
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * find method takes in the taskList and the desired keyword to be searched to print out all tasks with the same name
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param key the desired keyword for searching
     *
     */
    public static void find(ArrayList<Task> taskList, String key) throws DukeException {
        int count = 1;
        boolean hasMatch = false;

        System.out.println(" Here are the matching tasks in your list:");

        for (int i = 0 ; i < taskList.size(); i++) {
            if ((taskList.get(i)).description.contains(key)) {
                hasMatch = true;
                if((taskList.get(i)).taskType.equals("T")) {
                    System.out.println(" " + count +".[" + (taskList.get(i)).taskType + "][" + (taskList.get(i)).getStatusIcon() + "] " + (taskList.get(i)).description);
                } else if((taskList.get(i)).taskType.equals("D")) {
                    System.out.println(" " + count +".[" + (taskList.get(i)).taskType + "]["+ (taskList.get(i)).getStatusIcon() + "] " + (taskList.get(i)).description + " (" + (taskList.get(i)).by + ")");
                } else if((taskList.get(i)).taskType.equals("E")) {
                    System.out.println(" " + count +".[" + (taskList.get(i)).taskType + "]["+ (taskList.get(i)).getStatusIcon() + "] " + (taskList.get(i)).description + " (" + (taskList.get(i)).by + ")");
                }
                count++;
            }
        }

        if (!hasMatch) {
            throw new DukeException();
        }
    }

    /**
     * setDate method converts the by string member of the task and turns it into a LocalDate member of the task
     *
     * @param taskList the ArrayList that contains all the existing tasks
     *
     */
    public static void setDate(ArrayList<Task> taskList) throws DateTimeParseException {
        String byLine = (taskList.get(taskList.size()-1)).by;
        int dividerPosition = byLine.indexOf(" ");
        String byLineNew = byLine.substring(dividerPosition + 1);

        if(byLineNew.contains(" ")) {
            int dividerPositionNew = byLineNew.indexOf(" ");
            String byLineDate = byLineNew.substring(0,dividerPositionNew);

            (taskList.get(taskList.size()-1)).date = LocalDate.parse(byLineDate);
        } else {

            (taskList.get(taskList.size()-1)).date = LocalDate.parse(byLineNew);
        }
    }
}