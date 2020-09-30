package duke;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Duke {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static int taskCount = 0;

    public static void main(String[] args) throws DukeException {
        String line;
        Scanner in = new Scanner(System.in);

        showIntroduction();

        CreateFileDir.CreateFile();

        taskCount = ReadFile.main(taskList, taskCount);

        do{
            line = in.nextLine();
            if(line.contains("list")) {
                System.out.println("____________________________________________________________");
                System.out.println(" List");
                Deadline.taskList(taskList,taskCount);
                System.out.println("____________________________________________________________");
            } else if(line.contains("todo")) {
                try {
                    int dividerPosition = line.indexOf(" ");
                    String taskName = line.substring(dividerPosition+1);
                    System.out.println("____________________________________________________________");
                    taskCount = Todo.addTask(taskList, taskCount, taskName);
                    System.out.println("____________________________________________________________");
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                }
            } else if(line.contains("deadline")) {
                try {
                    int dividerPosition = line.indexOf(" ");
                    int dividerBy = line.indexOf("/");
                    String taskName = line.substring(dividerPosition + 1, dividerBy - 1);
                    String taskBy = line.substring(dividerBy + 1);
                    System.out.println("____________________________________________________________");
                    taskCount = Deadline.addTask(taskList, taskCount, taskName, taskBy);
                    Task.setDate(taskList);
                    System.out.println("____________________________________________________________");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! The deadline by cannot be empty.");
                }
            } else if(line.contains("event")) {
                try {
                    int dividerPosition = line.indexOf(" ");
                    int dividerBy = line.indexOf("/");
                    String taskName = line.substring(dividerPosition+1, dividerBy-1);
                    String taskAt = line.substring(dividerBy+1);
                    System.out.println("____________________________________________________________");
                    taskCount = Event.addTask(taskList, taskCount, taskName, taskAt);
                    Task.setDate(taskList);
                    System.out.println("____________________________________________________________");
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! The event by cannot be empty.");
                }
            } else if(line.contains("done")) {
                try {
                    int dividerPosition = line.indexOf(" ");
                    int taskNum = Integer.parseInt(line.substring(dividerPosition+1)) - 1;
                    System.out.println("____________________________________________________________");
                    Task.markAsDone(taskList, taskCount, taskNum);
                    System.out.println("____________________________________________________________");
                } catch (NullPointerException e) {
                    System.out.println("☹ OOPS!!! The number cannot be invalid.");
                } catch (NumberFormatException e) {
                    System.out.println("☹ OOPS!!! The number cannot be invalid.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The number cannot be out of bounds.");
                }
            } else if(line.contains("delete")) {
                try {
                    int dividerPosition = line.indexOf(" ");
                    int taskNum = Integer.parseInt(line.substring(dividerPosition+1)) - 1;
                    System.out.println("____________________________________________________________");
                    taskCount = Task.delete(taskList, taskCount, taskNum);
                    System.out.println("____________________________________________________________");
                } catch (NullPointerException e) {
                    System.out.println("☹ OOPS!!! The number cannot be invalid.");
                } catch (NumberFormatException e) {
                    System.out.println("☹ OOPS!!! The number cannot be invalid.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The number cannot be out of bounds.");
                }
            } else if(line.contains("find")) {
                int dividerPosition = line.indexOf(" ");
                String key = line.substring(dividerPosition+1);
                System.out.println("____________________________________________________________");
                Task.find(taskList, key);
                System.out.println("____________________________________________________________");

            } else if(line.contains("print")) {
                int dividerPosition = line.indexOf(" ");
                String key = line.substring(dividerPosition+1);
                System.out.println("____________________________________________________________");
                Task.printDeadlines(taskList, key);
                System.out.println("____________________________________________________________");

            } else if (!line.contains("bye") & !line.contains("todo") & !line.contains("event") & !line.contains("deadline") & !line.contains("list") & !line.contains("done") & !line.contains("delete")){
                try {
                    invalidInput();
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }

            }
        } while(!line.contains("bye"));

        showOutro();
    }

    private static void invalidInput() throws DukeException  {
        throw new DukeException();
    }

    private static void showIntroduction() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm duke.Duke");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    private static void showOutro() {
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
