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
        String[] storeList = new String[100];
        int i = 0;

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        do {
            line = in.nextLine();
            //System.out.println("You said: " + line);

            if (line.equals(bleh)) {
                System.out.println("____________________________________________________________");
                System.out.println(" bleh");
                System.out.println("____________________________________________________________");
            }
            else if(line.equals(list)){
                System.out.println("____________________________________________________________");
                int number = 1;
                while (number <= i) {
                    System.out.println(number + ": " + storeList[number-1]);
                    number++;
                }
                System.out.println("____________________________________________________________");
            } else {
                if(!line.equals(bye)) {
                    storeList[i] = line;
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + line);
                    System.out.println("____________________________________________________________");
                    i++;
                }
            }

        }while (!line.equals(bye));
        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
