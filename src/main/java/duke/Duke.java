package duke;

import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.zip.DataFormatException;


/**
 * Duke class is the main class where inputs taken and sent to other classes.
 *
 */
public class Duke {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static int taskCount = 0;

    /**
     * Main method handles all inputs and sends them to the Parser class to make sense of the inputs
     * then sends the commands and data to the Command class to execute them.
     *
     * Tells the Storage class to either create a new save file or access the existing save file.
     *
     */
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);

        Ui.showIntroduction();

        Storage.CreateFile();

        taskCount = Storage.ReadFile(taskList, taskCount);

        do{
            line = in.nextLine();
            if(line.contains("list")) {
                Command.listCommand(taskList);
            } else if(line.contains("todo")) {
                try {
                    taskCount = Command.TodoCommand(line, taskList, taskCount);
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                }
            } else if(line.contains("deadline")) {
                try {
                    taskCount = Command.deadlineCommand(line, taskList, taskCount);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! The deadline by cannot be empty.");
                } catch (DateTimeParseException e) {
                    System.out.println("☹ OOPS!!! Wrong format of date.");
                }
            } else if(line.contains("event")) {
                try {
                    taskCount = Command.eventCommand(line, taskList, taskCount);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! The event by cannot be empty.");
                } catch (DateTimeParseException e) {
                    System.out.println("☹ OOPS!!! Wrong format of date.");
                }
            } else if(line.contains("done")) {
                try {
                    Command.doneCommand(line, taskList);
                } catch (NullPointerException | NumberFormatException e) {
                    System.out.println("☹ OOPS!!! The number cannot be invalid.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The number cannot be out of bounds.");
                }
            } else if(line.contains("delete")) {
                try {
                    taskCount = Command.deleteCommand(line, taskList, taskCount);
                } catch (NullPointerException | NumberFormatException e) {
                    System.out.println("☹ OOPS!!! The number cannot be invalid.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The number cannot be out of bounds.");
                }
            } else if(line.contains("find")) {
                try {
                    Command.findCommand(line, taskList);
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! No matching tasks exist.");
                }
            } else if(line.contains("print")) {
                try {
                    Command.printCommand(line, taskList);
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! No tasks occurring on specified date.");
                }  catch (DateTimeParseException e) {
                    System.out.println("☹ OOPS!!! Wrong format of date.");
                }

            } else if (!line.contains("bye") & !line.contains("todo") & !line.contains("event") & !line.contains("deadline") & !line.contains("list") & !line.contains("done") & !line.contains("delete")){
                try {
                    Ui.invalidInput();
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }

            }
        } while(!line.contains("bye"));

        Ui.showOutro();
    }
}
