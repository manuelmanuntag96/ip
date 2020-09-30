package duke;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;
    protected String by;
    protected LocalDate date;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.taskType = "T";
    }

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

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

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

    public static void setDate(ArrayList<Task> taskList) {
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