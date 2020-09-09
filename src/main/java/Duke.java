import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    public static final int MAX_SIZE = 100;
    private static Task[] taskList = new Task[MAX_SIZE];
    private static int taskCount = 0;

    public static void main(String[] args) throws DukeException {
        String line;
        Scanner in = new Scanner(System.in);

        showIntroduction();

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
                    System.out.println("____________________________________________________________");
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                } catch (DukeException e) {
                    System.out.println("☹ OOPS!!! The event by cannot be empty.");
                }
            } else if(line.contains("done")) {
                int dividerPosition = line.indexOf(" ");
                int taskNum = Integer.parseInt(line.substring(dividerPosition+1));
                System.out.println("____________________________________________________________");
                Task.markAsDone(taskList, taskCount, taskNum);
                System.out.println("____________________________________________________________");
            } else if (!line.contains("bye") & !line.contains("todo") & !line.contains("event") & !line.contains("deadline") & !line.contains("list") & !line.contains("done")){
                System.out.println("____________________________________________________________");
                System.out.println(" Blah");
                System.out.println("____________________________________________________________");
            }
        } while(!line.contains("bye"));

        showOutro();
    }

    private static void showIntroduction() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    private static void showOutro() {
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
