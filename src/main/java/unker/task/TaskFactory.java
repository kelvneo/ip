package unker.task;

import java.util.regex.Matcher;
import unker.util.StringUtil;

public class TaskFactory {

    /**
     * Create a {@link unker.task.ToDo} task based on string data.
     * 
     * @param data The description of the task.
     * @return A new {@link unker.task.ToDo} task.
     */
    public static ToDo createToDoTask(String data) {
        return new ToDo(data);
    }

    /**
     * Create a {@link unker.task.Deadline} task based on string data.
     * 
     * The format of the string is to be:
     * [description] /by [YYYY-MM-DD] [HH:mm]
     * 
     * For example:
     * CS2113T project /by 2021-12-12 23:59
     *
     * @param data The description of the task, along with the deadline.
     * @return A new {@link unker.task.Deadline} task.
     */
    public static Deadline createDeadlineTask(String data) {
        Matcher deadlineMatcher = StringUtil.parseUserInput(Deadline.DEADLINE_DATA_PATTERN, data);
        if (deadlineMatcher != null) {
            return new Deadline(deadlineMatcher.group(1), deadlineMatcher.group(2));
        } else {
            return null;
        }
    }

    /**
     * Create a {@link unker.task.Event} task based on string data.
     *
     * The format of the string is to be:
     * [description] /at [YYYY-MM-DD] [HH:mm]-[HH:mm]
     *
     * For example:
     * Google Fireside Chat /at 2021-12-12 16:00-18:45
     *
     * @param data The description of the task, along with the date, start time and end time.
     * @return A new {@link unker.task.Event} task.
     */
    public static Event createEventTask(String data) {
        Matcher eventMatcher = StringUtil.parseUserInput(Event.EVENT_DATA_PATTERN, data);
        if (eventMatcher != null) {
            return new Event(eventMatcher.group(1), eventMatcher.group(2));
        } else {
            return null;
        }
    }
    
}
