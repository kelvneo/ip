package unker.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import unker.ui.UI;
import unker.Unker;

/**
 * A generic Command class to handle commands sent by the user.
 */
public abstract class Command {

    private final String name;
    private final String format;

    public static final String INVALID_FORMAT_MESSAGE =
            "Sorry, Unker need you to type this way for me to understand arh (no need brackets):";
    public static final String ADDED_TASK_MESSAGE = "Okay Unker help you add this to your to-do list:";

    protected Command(String name) {
        this(name, name);
    }
    
    protected Command(String name, String format) {
        this.name = name;
        this.format = format;
    }

    /**
     * Get the name of the command.
     *
     * @return The name of the command.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the input format of the command.
     * 
     * @return The input format of the command.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Return a {@link java.util.regex.Matcher} based on the data provided.
     * 
     * Returns null if the whole pattern is not matched.
     *  
     * @param commandPattern The regular expression pattern to match
     * @param data The data to handle.
     * @return A {@link java.util.regex.Matcher} with the results from the pattern.
     */
    protected Matcher parseUserInput(String commandPattern, String data) {
        if (data == null) {
            return null;
        }
        Pattern pattern = Pattern.compile(commandPattern);
        Matcher matcher = pattern.matcher(data);

        // Only return the Matcher if the input is valid
        if (matcher.matches()) {
            return matcher;
        } else {
            return null;
        }
    }
    
    /**
     * Executes the command provided by the user.
     *
     * @param ui The UI instance that is executing the command.
     * @param unker The task manager Unker that will be read from and updated to.
     * @param data The command line data (excluding the command name).
     */
    public abstract void execute(UI ui, Unker unker, String data) throws InvalidCommandException;

}