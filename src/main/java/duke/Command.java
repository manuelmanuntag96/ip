package duke;

import java.util.ArrayList;

public class Command {
    public static int TodoCommand(String line, ArrayList<Task> taskList, int taskCount) throws DukeException {
        String taskName = Parser.parseTodo(line);

        Ui.printDivider();

        taskCount = TaskList.addTask(taskList, taskCount, taskName);

        Ui.printDivider();

        return taskCount;
    }

    public static int deadlineCommand(String line, ArrayList<Task> taskList, int taskCount) throws DukeException {
        String taskName = Parser.parseDeadlineName(line);
        String taskBy = Parser.parseDeadlineBy(line);

        Ui.printDivider();

        taskCount = Deadline.addTask(taskList, taskCount, taskName, taskBy);
        Task.setDate(taskList);

        Ui.printDivider();

        return taskCount;
    }

    public static int eventCommand(String line, ArrayList<Task> taskList, int taskCount) throws DukeException {
        String taskName = Parser.parseEventName(line);
        String taskAt = Parser.parseEventAt(line);

        Ui.printDivider();

        taskCount = Event.addTask(taskList, taskCount, taskName, taskAt);
        Task.setDate(taskList);

        Ui.printDivider();

        return taskCount;
    }

    public static void doneCommand(String line, ArrayList<Task> taskList) {
        int taskNum = Parser.parseDoneNum(line);

        Ui.printDivider();

        Task.markAsDone(taskList, taskNum);

        Ui.printDivider();
    }

    public static int deleteCommand(String line, ArrayList<Task> taskList, int taskCount) {
        int taskNum = Parser.parseDeleteNum(line);

        Ui.printDivider();

        taskCount = TaskList.delete(taskList, taskCount, taskNum);

        Ui.printDivider();

        return taskCount;
    }

    public static void findCommand(String line, ArrayList<Task> taskList) throws DukeException {
        String key = Parser.parseFindKey(line);

        Ui.printDivider();

        Task.find(taskList, key);

        Ui.printDivider();
    }

    public static void printCommand(String line, ArrayList<Task> taskList) throws DukeException {
        String key = Parser.parseFindKey(line);

        Ui.printDivider();

        Task.printDeadlines(taskList, key);

        Ui.printDivider();
    }

    public static void listCommand(ArrayList<Task> taskList) {
        Ui.printDivider();

        System.out.println(" List");

        Deadline.taskList(taskList);

        Ui.printDivider();
    }
}
