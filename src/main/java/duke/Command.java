package duke;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Command class deals with executing the commands
 *
 */
public class Command {

    /**
     * TodoCommand method executes the add todo into the taskList command
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param taskCount current number of tasks in the taskList
     * @param line user's input
     *
     * @return taskCount
     *
     */
    public static int TodoCommand(String line, ArrayList<Task> taskList, int taskCount) throws DukeException {
        String taskName = Parser.parseTodo(line);

        Ui.printDivider();

        taskCount = TaskList.addTask(taskList, taskCount, taskName);

        Ui.printDivider();

        return taskCount;
    }

    /**
     * deadlineCommand method executes the add deadline into the taskList command
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param taskCount current number of tasks in the taskList
     * @param line user's input
     *
     * @return taskCount
     *
     */
    public static int deadlineCommand(String line, ArrayList<Task> taskList, int taskCount) throws DukeException, DateTimeParseException {
        String taskName = Parser.parseDeadlineName(line);
        String taskBy = Parser.parseDeadlineBy(line);

        Ui.printDivider();

        taskCount = Deadline.addTask(taskList, taskCount, taskName, taskBy);
        Task.setDate(taskList);

        Ui.printDivider();

        return taskCount;
    }

    /**
     * eventCommand method executes the add event into the taskList command
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param taskCount current number of tasks in the taskList
     * @param line user's input
     *
     * @return taskCount
     *
     */
    public static int eventCommand(String line, ArrayList<Task> taskList, int taskCount) throws DukeException, DateTimeParseException {
        String taskName = Parser.parseEventName(line);
        String taskAt = Parser.parseEventAt(line);

        Ui.printDivider();

        taskCount = Event.addTask(taskList, taskCount, taskName, taskAt);
        Task.setDate(taskList);

        Ui.printDivider();

        return taskCount;
    }

    /**
     * doneCommand method executes the make task as done command
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param line user's input
     *
     */
    public static void doneCommand(String line, ArrayList<Task> taskList) {
        int taskNum = Parser.parseDoneNum(line);

        Ui.printDivider();

        Task.markAsDone(taskList, taskNum);

        Ui.printDivider();
    }

    /**
     * deleteCommand method executes the delete task command
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param line user's input
     * @param taskCount current number of tasks in the taskList
     *
     */
    public static int deleteCommand(String line, ArrayList<Task> taskList, int taskCount) {
        int taskNum = Parser.parseDeleteNum(line);

        Ui.printDivider();

        taskCount = TaskList.delete(taskList, taskCount, taskNum);

        Ui.printDivider();

        return taskCount;
    }

    /**
     * findCommand method executes the find task command
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param line user's input
     *
     */
    public static void findCommand(String line, ArrayList<Task> taskList) throws DukeException {
        String key = Parser.parseFindKey(line);

        Ui.printDivider();

        Task.find(taskList, key);

        Ui.printDivider();
    }

    /**
     * printCommand method executes the print deadline/event command
     *
     * @param taskList the ArrayList that contains all the existing tasks
     * @param line user's input
     *
     */
    public static void printCommand(String line, ArrayList<Task> taskList) throws DukeException, DateTimeParseException {
        String key = Parser.parseFindKey(line);

        Ui.printDivider();

        Task.printDeadlines(taskList, key);

        Ui.printDivider();
    }

    /**
     * listCommand method executes the print taskList command
     *
     * @param taskList the ArrayList that contains all the existing tasks
     *
     */
    public static void listCommand(ArrayList<Task> taskList) throws DateTimeParseException {
        Ui.printDivider();

        System.out.println(" List");

        Deadline.taskList(taskList);

        Ui.printDivider();
    }
}
