import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a description of class RecipeBook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecipeBook
{
    // instance variables - replace the example below with your own
    private ArrayList<Recipe> recipes;
    private String name;
    private Parser parser;

    /**
     * Constructor for objects of class RecipeBook
     */
    public RecipeBook(String name)
    {
        this.name = name;
        printWelcome();
        
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
    }
    
    
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case SELECT -> select(command);
            default -> System.out.println("Invalid Command");
        }
        return wantToQuit;
    }
    
    public void printWelcome()
    {
        HashMap<String, Recipe> listOfRecipes = new HashMap<>();
        System.out.print("--- " + name + " 's Recipe Book ---" + "\n" + "\n");
        for(Recipe recipe : recipes)
        {
            int index = 0;
            listOfRecipes.put(String.valueOf(index), recipe);
            index++;
        }
        
        for(String index : listOfRecipes.keySet())
        {
            System.out.println(index + "." + listOfRecipes.get(index).getName());
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void select(Command command)
    {
        if(command.hasSecondWord())
        {
            
        }
    }
    
    // public void printSteps()
    // {
        // for(String step : recipeSteps)
        // {
            // System.out.println(step);
        // }
    // }
    
    // public void addRecipeStep(String step)
    // {
        // recipeSteps.add(recipeCounter + step);
        // recipeCounter++;
    // }
}
