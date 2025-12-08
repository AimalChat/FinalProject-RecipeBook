import java.util.Scanner;
import java.util.Arrays;

/**
 * Write a description of class Parser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parser
{
    // instance variables - replace the example below with your own
    private static Scanner reader;
    private CommandWords commands;

    /**
     * Constructor for objects of class Parser
     */
    public Parser()
    {
        // initialise instance variables
        reader = new Scanner(System.in);
        commands = new CommandWords();
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        // The full input line.
        String inputLine;
        String word1 = null;
        String word2 = null;

        // print prompt
        System.out.print("> ");     

        inputLine = reader.nextLine().trim().toLowerCase();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
                // note: we just ignore the rest of the input line.
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }
    
    public String[] getIngredient()
    {
        // The full input line.
        String inputLine;
        
        System.out.print("> ");
        
        inputLine = reader.nextLine().trim().toLowerCase();
        String[] ingredient = inputLine.split(",");
        
        return ingredient;
    }
    
    public String[] getComment()
    {
        // The full input line.
        String inputLine;
        int rating = 0;
        // print prompt
        System.out.print("> ");     

        inputLine = reader.nextLine().trim().toLowerCase();
        String[] ratingAndComment = inputLine.split(",");
        
        return ratingAndComment;
    }
    
    public String getLine()
    {
        // The full input line.
        String inputLine;
        // print prompt
        System.out.print("> ");     

        inputLine = reader.nextLine().trim().toLowerCase();
        return inputLine;
    }
    
    public static String getName()
    {
        Scanner reader = new Scanner(System.in);
        // The full input line.
        String inputLine;
        // print prompt
        System.out.print("> ");     

        inputLine = reader.nextLine().trim();
        return inputLine;
    }
    
    /**
     * Print out a list of valid command words.
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
