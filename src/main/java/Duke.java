import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        String line;
        String list = "list";
        String bleh = "bleh";
        String bye = "bye";
        Scanner in = new Scanner(System.in);
        Task[] taskList = new Task[100];
        int i = 0;

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        do {
            line = in.nextLine();

            if (line.equals(bleh)) {
                System.out.println("____________________________________________________________");
                System.out.println(" bleh");
                System.out.println("____________________________________________________________");
            } else if(line.equals(list)){
                System.out.println("____________________________________________________________");
                int number = 1;
                System.out.println(" Here are the tasks in your list:");
                while (number <= i) {
                    System.out.println(number + ":[" + taskList[number-1].getStatusIcon()+ "] " + taskList[number-1].description);
                    number++;
                }
                System.out.println("____________________________________________________________");
            } else if(line.contains("done")){
                int dividerPosition = line.indexOf(" ");
                String taskNumber = line.substring(dividerPosition+1);
                int number = Integer.parseInt(taskNumber);
                Task.markAsDone(taskList[number-1]);

                System.out.println("____________________________________________________________");
                System.out.println(" Nice! I've marked this task as done:");
                System.out.println(" [" + taskList[number-1].getStatusIcon()+ "] " + taskList[number-1].description);
                System.out.println("____________________________________________________________");
            } else {
                if(!line.equals(bye)) {
                    taskList[i] = new Task(line);

                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + line);
                    System.out.println("____________________________________________________________");
                    i++;
                }
            }

        } while (!line.equals(bye));
        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    public static class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        }

        public static void markAsDone(Task t) {
            t.isDone = true;
        }
    }
}
