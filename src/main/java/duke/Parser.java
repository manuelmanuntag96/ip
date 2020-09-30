package duke;

public class Parser {
    public static String parseTodo(String line) {
        int dividerPosition = line.indexOf(" ");
        String taskName = line.substring(dividerPosition+1);
        return taskName;
    }

    public static String parseDeadlineName(String line) {
        int dividerPosition = line.indexOf(" ");
        int dividerBy = line.indexOf("/");
        String taskName = line.substring(dividerPosition + 1, dividerBy - 1);

        return taskName;
    }

    public static String parseDeadlineBy(String line) {
        int dividerBy = line.indexOf("/");
        String taskBy = line.substring(dividerBy + 1);

        return taskBy;
    }

    public static String parseEventName(String line) {
        int dividerPosition = line.indexOf(" ");
        int dividerBy = line.indexOf("/");
        String taskName = line.substring(dividerPosition+1, dividerBy-1);

        return taskName;
    }

    public static String parseEventAt(String line) {
        int dividerBy = line.indexOf("/");
        String taskAt = line.substring(dividerBy+1);

        return taskAt;
    }

    public static int parseDoneNum(String line) {
        int dividerPosition = line.indexOf(" ");
        int taskNum = Integer.parseInt(line.substring(dividerPosition+1)) - 1;

        return taskNum;
    }

    public static int parseDeleteNum(String line) {
        int dividerPosition = line.indexOf(" ");
        int taskNum = Integer.parseInt(line.substring(dividerPosition+1)) - 1;

        return taskNum;
    }

    public static String parseFindKey(String line) {
        int dividerPosition = line.indexOf(" ");
        String key = line.substring(dividerPosition+1);

        return key;
    }

    public static String parseReadDataType(String data) {
        int dividerPosition = data.indexOf(" ");
        String taskNameType = data.substring(dividerPosition+1);

        return taskNameType;
    }

    public static int parseReadDividerPosition2(String data) {
        int dividerPosition2 = data.indexOf(" ");

        return dividerPosition2;
    }

    public static String parseReadTodo(String taskNameType, int dividerPosition2) {
        String taskName = taskNameType.substring(dividerPosition2+1);

        return taskName;
    }

    public static String parseReadDeadlineName(String taskNameType, int dividerPosition2) {
        int dividerBy = taskNameType.indexOf("/");
        String taskName = taskNameType.substring(dividerPosition2+1, dividerBy - 1);

        return taskName;
    }

    public static String parseReadDeadlineBy(String taskNameType) {
        int dividerBy = taskNameType.indexOf("/");
        String taskBy = taskNameType.substring(dividerBy + 1);

        return taskBy;
    }

    public static String parseReadEventName(String taskNameType, int dividerPosition2) {
        int dividerBy = taskNameType.indexOf("/");
        String taskName = taskNameType.substring(dividerPosition2+1, dividerBy-1);

        return taskName;
    }

    public static String parseReadEventAt(String taskNameType) {
        int dividerBy = taskNameType.indexOf("/");
        String taskAt = taskNameType.substring(dividerBy+1);

        return taskAt;
    }
}
