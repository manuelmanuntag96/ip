package duke;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Storage class deals with loading tasks from the file and saving tasks in the file
 *
 */
public class Storage {

    /**
     * ReadFile method accesses the save file and moves the data into the taskList
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param taskCount the current number of tasks in the taskList
     *
     * @return taskCount
     *
     */
    public static int ReadFile(ArrayList<Task> taskList, int taskCount) {
        try {
            File myObj = new File("D:\\Documents\\Modules\\Sem 03\\CS2113\\iP\\data\\duke.txt"); //D:\Documents\Modules\Sem 03\CS2113\iP\data
            Scanner myReader = new Scanner(myObj);

            taskCount = Storage.readToArray(myReader, taskList, taskCount);

            myReader.close();
        } catch (FileNotFoundException | DukeException e) {
            System.out.println("_______________An error occurred_______________");
            e.printStackTrace();
        }
        return taskCount;
    }

    /**
     * WriteToFile method saves taskList entries into the save file
     *
     * @param taskList the ArrayList that contains all the existing tasks
     *
     */
    public static void WriteToFile(ArrayList taskList) {
        try {
            FileWriter myWriter = new FileWriter("D:\\Documents\\Modules\\Sem 03\\CS2113\\iP\\data\\duke.txt");
            myWriter.write(Task.taskListToString(taskList));
            myWriter.close();
            System.out.println("_______________Successfully wrote to the file_______________");
        } catch (IOException e) {
            System.out.println("_______________An error occurred_______________");
            e.printStackTrace();
        }
    }

    /**
     * CreateFile method creates a save file for the program to save data into
     *
     */
    public static void CreateFile() {
        try {
            Files.createDirectories(Paths.get("D:\\Documents\\Modules\\Sem 03\\CS2113\\iP\\data"));
            File myObj = new File("D:\\Documents\\Modules\\Sem 03\\CS2113\\iP\\data\\duke.txt"); //D:\Documents\Modules\Sem 03\CS2113\iP\data
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * readToArray method moves the data from the save file into the taskList
     *
     * @param myReader the current line of data read by ReadFile method
     * @param taskList the ArrayList that contains all the existing tasks
     * @param taskCount the current number of tasks in the taskList
     *
     * @return taskCount
     */
    public static int readToArray(Scanner myReader, ArrayList<Task> taskList, int taskCount) throws DukeException {
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String taskNameType = Parser.parseReadDataType(data);
            int dividerPosition2 = Parser.parseReadDividerPosition2(data);

            if(taskNameType.contains("T ")) {
                String taskName = Parser.parseReadTodo(taskNameType, dividerPosition2);

                taskCount = TaskList.addTask(taskList, taskCount, taskName);
            } else if (taskNameType.contains("D ")) {
                String taskName = Parser.parseReadDeadlineName(taskNameType, dividerPosition2);
                String taskBy = Parser.parseReadDeadlineBy(taskNameType);

                taskCount = Deadline.addTask(taskList, taskCount, taskName, taskBy);
                try {
                    Task.setDate(taskList);
                } catch (DateTimeParseException e) {
                    System.out.println("☹ OOPS!!! Wrong format of date.");
                }
            } else if (taskNameType.contains("E ")) {
                String taskName = Parser.parseReadEventName(taskNameType, dividerPosition2);
                String taskAt = Parser.parseReadEventAt(taskNameType);

                taskCount = Event.addTask(taskList, taskCount, taskName, taskAt);
                try {
                    Task.setDate(taskList);
                } catch (DateTimeParseException e) {
                    System.out.println("☹ OOPS!!! Wrong format of date.");
                }
            }

            if ( data.charAt(0) == '1' ) {
                taskList.get(taskList.size()-1).isDone=true;
            }
        }
        return taskCount;
    }
}
