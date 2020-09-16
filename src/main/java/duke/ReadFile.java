package duke;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    public static int main(ArrayList<Task> taskList, int taskCount) {
        try {
            File myObj = new File("D:\\Documents\\Modules\\Sem 03\\CS2113\\iP\\data\\duke.txt"); //D:\Documents\Modules\Sem 03\CS2113\iP\data
            Scanner myReader = new Scanner(myObj);
            /*while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }*/

            taskCount = Task.readToArray(myReader, taskList, taskCount);

            myReader.close();
        } catch (FileNotFoundException | DukeException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return taskCount;
    }
}

