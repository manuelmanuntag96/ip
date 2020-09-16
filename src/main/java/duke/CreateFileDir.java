package duke;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateFileDir {
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
}
