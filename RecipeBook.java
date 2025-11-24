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
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private String name;
    private Parser parser;

    /**
     * Constructor for objects of class RecipeBook
     */
    public RecipeBook(String name)
    {
        this.name = name;
        recipes.add(new Recipe("Mac and Cheese", "Aimal Shah", "A simple yet delectable dish.",
        4));
        parser = new Parser();
        printWelcome();
        
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("See you next time! :D");
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
            case EXIT -> wantToQuit = exit(command);
            default -> System.out.println("Invalid Command");
        }
        return wantToQuit;
    }
    
    private boolean exit(Command command)
    {
        return true;
    }
    
    public void printWelcome()
    {
        HashMap<String, Recipe> listOfRecipes = new HashMap<>();
        System.out.print("--- " + name + " 's Recipe Book ---" + "\n" + "\n");
        if(!recipes.isEmpty()){
            for(Recipe recipe : recipes)
            {
                int index = 0;
                listOfRecipes.put(String.valueOf(index), recipe);
                index++;
            }
        
            for(String index : listOfRecipes.keySet())
            {
                System.out.println((index + 1) + "." + listOfRecipes.get(index).getName());
            }
        }
    }
    
    public void addRecipe(Recipe recipe)
    {
        recipes.add(recipe);
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
