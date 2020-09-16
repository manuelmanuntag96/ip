package duke;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;


public class WriteToFile {
    public static void main(ArrayList taskList) {
        try {
            FileWriter myWriter = new FileWriter("D:\\Documents\\Modules\\Sem 03\\CS2113\\iP\\data\\duke.txt");
            myWriter.write(Task.taskListToString(taskList));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

