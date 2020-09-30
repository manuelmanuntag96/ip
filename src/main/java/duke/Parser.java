package duke;

/**
 * Parser class deals with making sense of the user command
 *
 */
public class Parser {

    /**
     * parseTodo method converts the input into a Todo taskName
     *
     * @param line the input of the user
     *
     * @return taskName
     *
     */
    public static String parseTodo(String line) {
        int dividerPosition = line.indexOf(" ");
        String taskName = line.substring(dividerPosition+1);
        return taskName;
    }

    /**
     * parseTodo method converts the input into a Deadline taskName
     *
     * @param line the input of the user
     *
     * @return taskName
     *
     */
    public static String parseDeadlineName(String line) {
        int dividerPosition = line.indexOf(" ");
        int dividerBy = line.indexOf("/");
        String taskName = line.substring(dividerPosition + 1, dividerBy - 1);

        return taskName;
    }

    /**
     * parseTodo method converts the input into a Deadline taskBy
     *
     * @param line the input of the user
     *
     * @return taskBy
     *
     */
    public static String parseDeadlineBy(String line) {
        int dividerBy = line.indexOf("/");
        String taskBy = line.substring(dividerBy + 1);

        return taskBy;
    }

    /**
     * parseEventName method converts the input into a Event taskName
     *
     * @param line the input of the user
     *
     * @return taskName
     *
     */
    public static String parseEventName(String line) {
        int dividerPosition = line.indexOf(" ");
        int dividerBy = line.indexOf("/");
        String taskName = line.substring(dividerPosition+1, dividerBy-1);

        return taskName;
    }

    /**
     * parseEventAt method converts the input into a Event taskAt
     *
     * @param line the input of the user
     *
     * @return taskAt
     *
     */
    public static String parseEventAt(String line) {
        int dividerBy = line.indexOf("/");
        String taskAt = line.substring(dividerBy+1);

        return taskAt;
    }

    /**
     * parseDoneNum method converts the input into a desired taskNum to be marked
     *
     * @param line the input of the user
     *
     * @return taskNum
     *
     */
    public static int parseDoneNum(String line) {
        int dividerPosition = line.indexOf(" ");
        int taskNum = Integer.parseInt(line.substring(dividerPosition+1)) - 1;

        return taskNum;
    }

    /**
     * parseDoneNum method converts the input into a desired taskNum to be deleted
     *
     * @param line the input of the user
     *
     * @return taskNum
     *
     */
    public static int parseDeleteNum(String line) {
        int dividerPosition = line.indexOf(" ");
        int taskNum = Integer.parseInt(line.substring(dividerPosition+1)) - 1;

        return taskNum;
    }

    /**
     * parseDoneNum method converts the input into a desired keyword to be searched
     *
     * @param line the input of the user
     *
     * @return key
     *
     */
    public static String parseFindKey(String line) {
        int dividerPosition = line.indexOf(" ");
        String key = line.substring(dividerPosition+1);

        return key;
    }

    /**
     * parseReadDataType method converts the save file data into the task's type
     *
     * @param data the task information from the save file
     *
     * @return taskNameType
     *
     */
    public static String parseReadDataType(String data) {
        int dividerPosition = data.indexOf(" ");
        String taskNameType = data.substring(dividerPosition+1);

        return taskNameType;
    }

    /**
     * parseReadDividerPosition2 method converts the save file data into dividerPosition2
     *
     * @param data the task information from the save file
     *
     * @return dividerPosition2
     *
     */
    public static int parseReadDividerPosition2(String data) {
        int dividerPosition2 = data.indexOf(" ");

        return dividerPosition2;
    }

    /**
     * parseReadTodo method converts the save file data into Todo taskName
     *
     * @param taskNameType the name and type of the task
     * @param dividerPosition2 the index where to divide the taskNameType into task name and type
     *
     * @return taskName
     *
     */
    public static String parseReadTodo(String taskNameType, int dividerPosition2) {
        String taskName = taskNameType.substring(dividerPosition2+1);

        return taskName;
    }

    /**
     * parseReadTodo method converts the save file data into Deadline taskName
     *
     * @param taskNameType the name and type of the task
     * @param dividerPosition2 the index where to divide the taskNameType into task name and type
     *
     * @return taskName
     *
     */
    public static String parseReadDeadlineName(String taskNameType, int dividerPosition2) {
        int dividerBy = taskNameType.indexOf("/");
        String taskName = taskNameType.substring(dividerPosition2+1, dividerBy - 1);

        return taskName;
    }

    /**
     * parseReadDeadlineBy method converts the save file data into Deadline taskBy
     *
     * @param taskNameType the name and type of the task
     *
     * @return taskBy
     *
     */
    public static String parseReadDeadlineBy(String taskNameType) {
        int dividerBy = taskNameType.indexOf("/");
        String taskBy = taskNameType.substring(dividerBy + 1);

        return taskBy;
    }

    /**
     * parseReadEventName method converts the save file data into Event taskName
     *
     * @param taskNameType the name and type of the task
     *
     * @return taskName
     *
     */
    public static String parseReadEventName(String taskNameType, int dividerPosition2) {
        int dividerBy = taskNameType.indexOf("/");
        String taskName = taskNameType.substring(dividerPosition2+1, dividerBy-1);

        return taskName;
    }

    /**
     * parseReadEventAt method converts the save file data into Event taskBy
     *
     * @param taskNameType the name and type of the task
     *
     * @return taskBy
     *
     */
    public static String parseReadEventAt(String taskNameType) {
        int dividerBy = taskNameType.indexOf("/");
        String taskAt = taskNameType.substring(dividerBy+1);

        return taskAt;
    }
}
