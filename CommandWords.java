import java.util.HashMap;

/**
 * Initializing the Enum class CommandWord by associating
 * each with a string.
 *
 * @author heavily inspired from BlueJ's world of zuul project, Aimal
 * @version 12/11/2025
 */
public class CommandWords
{
    // instance variables - replace the example below with your own
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor for objects of class CommandWords
     */
    public CommandWords()
    {
        //BACK, SELECT, CONVERT, TO, FAVORITE, COMMENT, VIEW, UNKNOWN
        // initialise instance variables
        validCommands = new HashMap<>();
        
        
        validCommands.put("add", CommandWord.ADD);
        validCommands.put("back", CommandWord.BACK);
        validCommands.put("select", CommandWord.SELECT);
        validCommands.put("convert", CommandWord.CONVERT);
        validCommands.put("add", CommandWord.ADD);
        validCommands.put("edit", CommandWord.EDIT);
        validCommands.put("remove", CommandWord.REMOVE);
        validCommands.put("favorite", CommandWord.FAVORITE);
        validCommands.put("comment", CommandWord.COMMENT);
        validCommands.put("view", CommandWord.VIEW);
        validCommands.put("exit", CommandWord.EXIT);
        validCommands.put("create", CommandWord.CREATE);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("favorites", CommandWord.FAVORITES);
        validCommands.put("confirm", CommandWord.CONFIRM);
    }

    /**
     * Find the CommandWord associated with a command string.
     * @param commandWord The word to look up (as a string).
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
    
    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
