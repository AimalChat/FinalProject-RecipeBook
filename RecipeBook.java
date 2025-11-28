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
    private HashMap<String, Recipe> listOfRecipes = new HashMap<>();
    private ArrayList<Recipe> favorites = new ArrayList<>();
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private String name;
    private Parser parser;
    private Recipe currentRecipe = null;
    private RecipeBookState currentState = RecipeBookState.MENU;

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
        printMenu();

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
        if(currentState == RecipeBookState.RECIPE_VIEW){
            switch (commandWord) {
                //commands available only when a recipe is selected
                case BACK -> back();
                case CONVERT -> convert(command);
                case FAVORITE -> favorite();
                case COMMENT -> comment();
                case VIEW -> currentRecipe.printRecipeDetails();
                case CREATE -> create();
                default -> System.out.println("Invalid Command");
            }
        }    

        if(currentState == RecipeBookState.MENU){
            switch (commandWord) {
                //commands for the menu.
                case SELECT -> select(command);
                case EXIT -> wantToQuit = exit(command);
                default -> System.out.println("Invalid Command");
            }
            }
        return wantToQuit;
    }
    
    public void create()
    {
        
    }
    
    public void comment()
    {
        
    }
    
    public void favorite()
    {
        if(favorites.contains(currentRecipe))
        {
            favorites.remove(currentRecipe);
        }
        else
        {
            favorites.add(currentRecipe);
        }
    }
    
    public void getFavoritedRecipes()
    {
        
    }
    
    public void convert(Command command)
    {
        double desiredYield;
        if(!command.hasSecondWord())
        {
            System.out.println("Please enter a value that corresponds to"
            + " the amount of servings you desire.");
            return;
        }
        try{
            desiredYield = Double.parseDouble(command.getSecondWord());
        } catch(NumberFormatException e)
        {
            System.out.println("Not a valid number." +
            "\n" +
            "Please enter a valid number");
            return;
        }
        if(desiredYield >= 1)
        {
            System.out.println("--Ingredient List for " + desiredYield + " people.--");
            for(RecipeIngredient ingredient : currentRecipe.getConvertedIngredients(desiredYield))
            {
                System.out.println(ingredient.getRecipeIngredient());
            }
        }
    }
    
    public void back()
    {
        currentState = RecipeBookState.MENU;
        printWelcome();
    }

    private boolean exit(Command command)
    {
        return true;
    }

    public void printMenu()
    {
        if(!recipes.isEmpty()){
            for(Recipe recipe : recipes)
            {
                int index = 1;
                listOfRecipes.put(String.valueOf(index), recipe);
                index++;
            }

            for(String index : listOfRecipes.keySet())
            {
                System.out.println((index) + "." + listOfRecipes.get(index).getName());
            }
        }
    }

    public void printWelcome()
    {
        System.out.print("--- " + name + " 's Recipe Book ---" + "\n" + "\n");
        System.out.println("New Features" + "\n" + "IMP." + "\n");
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
        if(!command.hasSecondWord())
        {
            System.out.println("Please select a valid option.");
            return;
        }

        String selection = command.getSecondWord();
        boolean selected = false;
        if(currentState == RecipeBookState.MENU){
            for(String index : listOfRecipes.keySet())
            {
                if(index.equals(selection))
                {
                    currentState = RecipeBookState.RECIPE_VIEW;
                    listOfRecipes.get(index).printRecipeDetails();
                    currentRecipe = listOfRecipes.get(index);
                    selected = true;
                    break;
                }
            }
            if(!selected)
            {
                System.out.println("Invalid index, please enter a valid number to select.");
            }
        }
    }
}
