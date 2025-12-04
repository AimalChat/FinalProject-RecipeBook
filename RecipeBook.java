import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Write a description of class RecipeBook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecipeBook
{
    // instance variables - replace the example below with your own
    private int maxWidth = 50;
    private HashMap<String, Recipe> listOfRecipes = new HashMap<>();
    private ArrayList<Recipe> favorites = new ArrayList<>();
    private HashMap<String, Recipe> listOfFavorites = new HashMap<>();
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
        if(currentState == RecipeBookState.RECIPE_VIEW)
        {
            switch (commandWord) 
            {
                //commands available only when a recipe is selected
                case BACK -> back();
                case CONVERT -> convert(command);
                case FAVORITE -> favorite();
                case COMMENT -> comment();
                case VIEW -> view(command);
                case EXIT -> wantToQuit = exit(command);
                case UNKNOWN -> System.out.println("Invalid Command");
                case HELP -> help();
            }
        }

        if(currentState == RecipeBookState.MENU)
        {
            switch (commandWord) 
            {
                //commands for the menu.
                case CREATE -> create();
                case SELECT -> select(command);
                case EXIT -> wantToQuit = exit(command);
                case UNKNOWN -> System.out.println("Invalid Command");
                case HELP -> help();
                case FAVORITES -> favoritesList();
            }
        }
        
        if(currentState == RecipeBookState.FAVORITES){
            switch (commandWord){
                case CREATE -> create();
                case SELECT -> select(command);
                case EXIT -> wantToQuit = exit(command);
                case UNKNOWN -> System.out.println("Invalid Command");
                case HELP -> help();
                case BACK -> back();
            }
        }
        
        if(currentState == RecipeBookState.CREATE)
        {
            switch(commandWord)
            {
                case ADD -> add(command);
                case EDIT -> edit(command);
                case REMOVE -> remove(command);
                case UNKNOWN -> System.out.println("Invalid Command");
                case HELP -> help();
            }
        }
        return wantToQuit;
    }
    
    public void help(){
        if(currentState == RecipeBookState.RECIPE_VIEW){
            System.out.println("Back: return to the menu.");
            System.out.println("Convert: shows the amount of ingredients needed for a"+
            "\n" + "certain amount of people that the user imputs in.");
            System.out.println("favorite: set the recipe you're currently on inside"+
            "\n"+ "the favorites list, or remove it if it is already there.");
            System.out.println("Comment: add a coment and rating.");
            System.out.println("View: allow you to see various details of the recipe.");
            System.out.println("Exit: exit the recipe book and save the changes"+
            "\n"+ "inside an object.");
            System.out.println("Help: shows all possible commands that you can use.");
        }
        if(currentState == RecipeBookState.MENU){
            System.out.println("Create: create a new recipe.");
            System.out.println("Select: view inside a recipe of your choice.");
            System.out.println("Exit: exit the recipe book and save the changes"+
            "\n"+ "inside an object.");
            System.out.println("favorites: see all of the recipes that you added"+
            "\n" + "inside the favorites list.");
            System.out.println("Help: shows all possible commands that you can use.");
        }
        if(currentState == RecipeBookState.CREATE){
            System.out.println("Add: add something to the recipe if it's available.");
            System.out.println("Edit: modify something inside the recipe.");
            System.out.println("Remove: remove something from the recipe.");
            System.out.println("Help: shows all possible commands that you can use.");
        }
        if(currentState == RecipeBookState.FAVORITES){
            System.out.println("Create: create a new recipe.");
            System.out.println("Select: view inside a recipe of your choice.");
            System.out.println("Back: return to the menu.");
            System.out.println("Exit: exit the recipe book and save the changes"+
            "\n"+ "inside an object.");
            System.out.println("Help: shows all possible commands that you can use.");
        }
    }
    
    public void remove(Command command)
    {
        
    }
    
    public void edit(Command command)
    {
        
    }
    
    public void add(Command command)
    {
        
    }

    public void view(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("What would you like to view?" +"\n"+
            "- Comments" + "\n"+
            "- Steps" + "\n"+
            "- Ingredients" + "\n"+
            "- Details" + "\n"+
            "- Recipe" + "\n");
            return;
        }
        String viewing = command.getSecondWord().trim();
        switch(viewing)
        {
            case "comments" -> currentRecipe.printComments();
            case "steps" -> currentRecipe.printSteps();
            case "ingredients" -> currentRecipe.printIngredientsList();
            case "details" -> currentRecipe.printDetails();
            case "recipe" -> currentRecipe.printRecipe();
            default -> System.out.println("What would you like to view?");
        }
    }

    public void create()
    {
        currentState = RecipeBookState.CREATE;
        currentRecipe = new Recipe(null, name, null, 0);
        //recipes.add(currentRecipe);
        System.out.println("--Create Mode--" + "\n" +
        AutoWrapper.wrapTextByWidth("You are currently in the creation view of your own recipe!" + "\n" +
        "Before doing much else, it would be best if you were to initialize the description and name of your recipe." + "\n" +
        "To add an ingredient, a step or a note, please follow this format: " + "\n" +
        "add ___________", maxWidth));
        
        Command command = parser.getCommand();
        if(!command.hasSecondWord())
        {
            System.out.println("What is it you would like to add?" +
            "\n" + "-Description" +
            "\n" + "-Name" +
            "\n" + "-Ingredient" +
            "\n" + "-Step" +
            "\n" + "-Note" +
            "\n" + "-Hot, cold or normal temperature" +
            "\n" + "-Bake/Cook/Chill time");
        }
        
        String adding = command.getSecondWord();
        switch(adding)
        {
            //IMPORTANT! NOT ACTUALLY CORRECT YET!
            case "description" -> parser.getLine();
            case "name" -> parser.getCommand();
            case "ingredient" -> parser.getLine();
            case "step" -> parser.getLine();
            case "note" -> parser.getLine();
            case "hot temperature" -> parser.getLine();
            case "cold temperature" -> parser.getLine();
            case "normal temperature" -> parser.getLine();
            case "bake time" -> parser.getLine();
            case "cook time" -> parser.getLine();
            case "chill time" -> parser.getLine();
        }
    }

    public void comment()
    {
        System.out.println(AutoWrapper.wrapTextByWidth("Please write your comment in this specific format: rating, comment." 
        + "\n" + "  Note: Rating must be within the range of 1 to 5, inclusive.", maxWidth));

        String[] ratingAndComment = parser.getComment();
        if(ratingAndComment.length <= 1 || ratingAndComment[1].trim().equals(""))
        {
            System.out.println("Comment not found.");
            return;
        }
        else if(ratingAndComment.length >= 1)
        {
            ratingAndComment[1] = String.join(",", Arrays.copyOfRange(ratingAndComment, 1, ratingAndComment.length)).trim();
        }
        int rating;
        String comment = ratingAndComment[1];

        try{
            rating = Integer.parseInt(ratingAndComment[0]);
        } catch(NumberFormatException e)
        {
            System.out.println("First value found is not a number.");
            return;
        }
        if(rating > 5 || rating <= 0)
        {
            System.out.println("Invalid rating, out of range");
            return;
        } 

        currentRecipe.getComments().add(new Comment(name,comment,rating));
    }

    public void favorite()
    {
        if(favorites.contains(currentRecipe))
        {
            favorites.remove(currentRecipe);
            listOfFavorites.remove(currentRecipe);
        }
        else
        {
            favorites.add(currentRecipe);
            for(String index : listOfRecipes.keySet())
            {
                if(listOfRecipes.get(index).equals(currentRecipe)){
                    listOfFavorites.put(index, currentRecipe);
                }
            }
        }
    }

    public void favoritesList()
    {
        currentState = RecipeBookState.FAVORITES;
        getFavoritedRecipes();
    }
    
    public void getFavoritedRecipes()
    {
        if(!favorites.isEmpty()){
            for(Recipe recipe : favorites)
            {
                int index = 1;
                listOfFavorites.put(String.valueOf(index), recipe);
                index++;
            }

            for(String index : listOfRecipes.keySet())
            {
                System.out.println((index) + "." + listOfFavorites.get(index).getName());
            }
        }
        else{
            System.out.println("Your favorite list is empty.");
        }
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
            for(RecipeIngredient ingredient : currentRecipe.getConvertedIngredients((int) desiredYield))
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
    
    public void printFavorites()
    {
        if(!favorites.isEmpty()){
            for(Recipe recipe : favorites)
            {
                int index = 1;
                if(listOfFavorites.get(index) != null){
                    listOfRecipes.put(String.valueOf(index), recipe);
                }
                index++;
            }

            for(String index : listOfFavorites.keySet())
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
            System.out.println("Which recipe would you like to select?" + "\n");
            if(currentState == RecipeBookState.MENU){
                for(String index : listOfRecipes.keySet())
                {
                    System.out.println((index) + "." + listOfRecipes.get(index).getName());
                }
            }
            if(currentState == RecipeBookState.FAVORITES){
                for(String index : listOfFavorites.keySet())
                {
                    System.out.println((index) + "." + listOfFavorites.get(index).getName());
                }
            }
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
                    listOfRecipes.get(index).printRecipe();
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
        if(currentState == RecipeBookState.FAVORITES){
            for(String index : listOfFavorites.keySet())
            {
                if(index.equals(selection))
                {
                    currentState = RecipeBookState.RECIPE_VIEW;
                    listOfFavorites.get(index).printRecipe();
                    currentRecipe = listOfFavorites.get(index);
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
