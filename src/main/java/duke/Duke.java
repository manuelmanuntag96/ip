package duke;

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static int taskCount = 0;

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);

        Ui.showIntroduction();

        CreateFileDir.CreateFile();

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
                }
            } else if(line.contains("event")) {
                try {
                    taskCount = Command.eventCommand(line, taskList, taskCount);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! The event by cannot be empty.");
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
