package duke;

/**
 * Ui class deals with interactions with the user
 *
 */
public class Ui {

    /**
     * showIntroduction method contains and prints out all the introduction to the Duke program when the program
     * is started
     *
     */
    public static void showIntroduction() {
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

    /**
     * showOutro method contains and prints out all the outro to the Duke program when program is exited
     *
     */
    public static void showOutro() {
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    /**
     * invalidInput method handles the error when Duke cannot make sense of the input
     *
     */
    public static void invalidInput() throws DukeException  {
        throw new DukeException();
    }

    /**
     * printDivider method prints out the divider to make the UI easier to read
     *
     */
    public static void printDivider() {
        System.out.println("____________________________________________________________");
    }
}
