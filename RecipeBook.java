import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Write a description of class RecipeBook here.
 *
 * @author Alex
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
    private SourceRecipes basics = new SourceRecipes();
    private Validator V = new Validator();

    /**
     * Constructor for objects of class RecipeBook
     */
    public RecipeBook (String name)
    {
        this.name = name;
        for(Recipe recipe : basics.getRecipes())
        {
            recipes.add(recipe);
        }
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
     * Allows other form of command menus to use the RecipeBook
     */
    public static void main(String[] args)
    {
        System.out.println("Please input your name.");
        
        new RecipeBook(Parser.getName());        
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
                case EXIT -> wantToQuit = exit(command);
                case CONFIRM -> confirm();
            }
        }
        return wantToQuit;
    }
    
    /**
     * Shows a list of all the commands that the user can currently use
     * alongside a short description of what they do.
     */
    public void help(){
        if(currentState == RecipeBookState.RECIPE_VIEW){
            System.out.println("Back: return to the menu." + "\n");
            System.out.println("Convert: shows the amount of ingredients needed for a"+
            "\n" + "certain amount of people that the user imputs in." + "\n");
            System.out.println("Favorite: set the recipe you're currently on inside"+
            "\n"+ "the favorites list, or remove it if it is already there." + "\n");
            System.out.println("Comment: add a coment and rating.");
            System.out.println("View: allow you to see various details of the recipe." + "\n");
            System.out.println("Exit: exit the recipe book" + "\n");
            System.out.println("Help: shows all possible commands that you can use." + "\n");
            System.out.println("For more help, simply write the command." + "\n");
        }
        
        if(currentState == RecipeBookState.MENU){
            System.out.println("Create: create a new recipe." + "\n");
            System.out.println("Select: view inside a recipe of your choice." + "\n");
            System.out.println("Exit: exit the recipe book" + "\n");
            System.out.println("favorites: see all of the recipes that you added"+
            "\n" + "inside the favorites list." + "\n");
            System.out.println("Help: shows all possible commands that you can use." + "\n");
            System.out.println("For more help, simply write the command." + "\n");
        }
        
        if(currentState == RecipeBookState.CREATE){
            System.out.println("Add: add something to the recipe if it's available." + "\n");
            System.out.println("Edit: modify something inside the recipe." + "\n");
            System.out.println("Remove: remove something from the recipe." + "\n");
            System.out.println("Help: shows all possible commands that you can use." + "\n");
            System.out.println("Exit: exit the recipe book" + "\n");
            System.out.println("Confirm: Comfirms the recipe that you want do add"+
            "\n" + "to the recipe book." + "\n");
            System.out.println("For more help, simply write the command." + "\n");
        }
        
        if(currentState == RecipeBookState.FAVORITES){
            System.out.println("Create: create a new recipe." + "\n");
            System.out.println("Select: view inside a recipe of your choice." + "\n");
            System.out.println("Back: return to the menu." + "\n");
            System.out.println("Exit: exit the recipe book" + "\n");
            System.out.println("Help: shows all possible commands that you can use." + "\n");
            System.out.println("For more help, simply write the command." + "\n");
        }
    }
    
    /**
     * Adds the recipe with the modifications from the add command.
     */
    public void confirm()
    {
        recipes.add(currentRecipe);
        System.out.println("Succesfully created the recipe! Good JOB :DDD");
        currentState = RecipeBookState.MENU;
        printWelcome();
        printMenu();
    }
    
    /**
     * Removes something from the recipe class currently being made if possible.
     */
    public void remove(Command command)
    {
        
    }
    
    /**
     * Modify something from the recipe class currently being made if possible.
     */
    public void edit(Command command)
    {
        
    }
    
    /**
     * Add something to the recipe class currently being made if possible.
     */
    public void add(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("What would you like to add?" + "\n" +
            "- Recipe Name" + "\n" +
            "- Description" + "\n" +
            "- Ingredient" + "\n" +
            "- Step" + "\n" +
            "- Type : Cold, Hot or Normal" + "\n" );
            return;
        }
        
        String adding = command.getSecondWord();
        switch(adding)
        {
            case "servings" :
                System.out.println("Please input how many servings this recipe makes.");
                String servingAmt = parser.getLine();
                if(V.validateServingAmount(servingAmt) != 0)
                {
                    currentRecipe.setServingAmt(V.validateServingAmount(servingAmt));
                    currentRecipe.printDetails();
                    break;
                }else
                {
                    break;
                }
            
            case "recipe name" :
                System.out.println("For the name of your recipe, don't be a skank and put vulgarities.");
                String recipesName = parser.getLine();
                currentRecipe.setRecipeName(recipesName);
                currentRecipe.printRecipe();
                break;
                
            case "name" :
                System.out.println("For the name of your recipe, don't be a skank and put vulgarities.");
                String[] recipeName = parser.getRecipeName();
                if(V.validateRecipeName(recipeName) != null)
                {
                    currentRecipe.setRecipeName(V.validateRecipeName(recipeName));
                    currentRecipe.printRecipe();
                    break;
                }else
                {
                    break;
                }
            
            case "description" :
                System.out.println("For the description of your recipe, don't be a skank and put vulgarities.");
                String description = parser.getLine();
                currentRecipe.setDescription(description);
                currentRecipe.printDetails();
                break;
                
            case "ingredient" : 
                System.out.println(AutoWrapper.wrapTextByWidth("To add an ingredient, please follow this format: " + "\n" +
                "'amount , measurement , ingredient'" + "\n" , maxWidth));
                String[] ingredient = parser.getIngredient();
                if(V.validateIngredient(ingredient) != null)
                {
                    currentRecipe.addIngredient(V.validateIngredient(ingredient));
                    currentRecipe.printRecipe();
                    break;
                }else
                {
                    break;
                }
                
            case "step" : 
                System.out.println("Please enter the step.");
                String step = parser.getLine();
                if(V.validateStep(step) != null)
                {
                    currentRecipe.addRecipeStep(V.validateStep(step));
                    currentRecipe.printRecipe();
                    break;
                }else
                {
                    break;
                }
                
            case "type" : 
                System.out.println("For the type of recipes: "+"\n"+
                "- Hot" + "\n" +
                "- Cold " + "\n" +
                "- Regular" + "\n");
                String type = parser.getLine();
                if(V.validateType(type) != null)
                {
                    switch(type)
                    {
                        case "hot" -> currentRecipe.setType(type);
                        case "cold" -> currentRecipe.setType(type);
                        case "regular" -> currentRecipe.setType(type);
                    }
                    currentRecipe.printDetails();
                    break;
                }else
                {
                    break;
                }
                
        }
    }

    /**
     * Shows a selected detail of the recipe.
     * Details that can be shown include comments, steps, ingredients, details and recipe.
     * @exception prints all words that can follow view if it doesn't have a second word.
     */
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

    /**
     * Sends the user to the create menu and changes the commands accordingly.
     */
    public void create()
    {
        currentState = RecipeBookState.CREATE;
        currentRecipe = new Recipe(name);
        System.out.println("================== Create Mode ==================" + "\n" + "\n" +
        AutoWrapper.wrapTextByWidth("You are currently in the creation view of your own recipe!" + "\n" +
        "Before doing much else, it would be best if you were to initialize the type and name of your recipe.", maxWidth));
        System.out.println("For more help, enter 'help' to view all possible commands.");
    }
    
    /**
     * Adds a comment to the current recipe.
     * It uses an integer between 1 and 5, the name of the user of
     * the recipe book and the comment list.
     * @error If missing a rating or a comment, prints an error code.
     */
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

    /**
     * Adds the recipe to the list of favorite recipes.
     */
    public void favorite()
    {
        if(favorites.contains(currentRecipe))
        {
            favorites.remove(currentRecipe);
            listOfFavorites.remove(currentRecipe);
            System.out.println("Removed from favorites.");
        }
        else
        {
            favorites.add(currentRecipe);
            for(String index : listOfRecipes.keySet())
            {
                if(listOfRecipes.get(index).equals(currentRecipe)){
                    listOfFavorites.put(index, currentRecipe);
                    System.out.println("Added to favorites.");
                }
            }
        }
    }

    /**
     * Sets the Recipe Book state to FAVORITES and gets the list of the user's
     * favorite recipes.
     */
    public void favoritesList()
    {
        currentState = RecipeBookState.FAVORITES;
        getFavoritedRecipes();
    }
    
    /**
     * Prints a list of all the recipes from listOfFavorites.
     */
    public void getFavoritedRecipes()
    {
        System.out.println("========Favorites");
        
        if(!favorites.isEmpty()){
            for(Recipe recipe : favorites)
            {
                int index = 1;
                listOfFavorites.put(String.valueOf(index), recipe);
                index++;
            }

            for(String index : listOfFavorites.keySet())
            {
                System.out.println((index) + "." + listOfFavorites.get(index).getName() + "\n");
            }
        }
        else{
            System.out.println("Your favorite list is empty.");
        }
    }

    /**
     * Imput a int value to receive the amount of the current ingredients
     * required to complete the current recipe.
     * @error Will send an error if the int value is invalid.
     */
    public void convert(Command command)
    {
        int desiredYield;
        if(!command.hasSecondWord())
        {
            System.out.println("Please enter a value that corresponds to"
                + " the amount of servings you desire.");
            return;
        }
        
        try{
            desiredYield = Integer.parseInt(command.getSecondWord());
        } catch(NumberFormatException e)
        {
            System.out.println("Not a valid number." +
                "\n" +
                "Please enter a valid number");
            return;
        }
        
        if(desiredYield >= 1)
        {
            System.out.println("-----Ingredient List for " + desiredYield + " people.-----");
            for(RecipeIngredient ingredient : currentRecipe.getConvertedIngredients(desiredYield))
            {
                System.out.println(ingredient.getRecipeIngredient());
            }
        }
    }

    /**
     * Sends the user to the Main Menu.
     */
    public void back()
    {
        currentState = RecipeBookState.MENU;
        printWelcome();
        printMenu();
    }

    /**
     * Ends the program and stores all values inside an object.
     */
    private boolean exit(Command command)
    {
        return true;
    }

    /**
     * Prints all the recipes from the listOfRecipes.
     */
    public void printMenu()
    {
        if(!recipes.isEmpty()){
            int index = 1;
            for(Recipe recipe : recipes)
            {
                listOfRecipes.put(String.valueOf(index), recipe);
                index++;
            }
            
            for(String indexPointer : listOfRecipes.keySet())
            {
                System.out.println(indexPointer + "." + listOfRecipes.get(indexPointer).getName() + "\n");
            }
        }
    }
    
    /**
     * Prints all the recipes from the listOfFavorites.
     */
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

    /**
     * Prints a welcome message to the user.
     */
    public void printWelcome()
    {
        System.out.print("============ " + name + " 's Recipe Book ============" + "\n" + "\n");
        System.out.println("New Features" + "\n" + "IMP." + "\n");
    }

    /**
     * Adds a recipe to recipes.
     */
    public void addRecipe(Recipe recipe)
    {
        recipes.add(recipe);
    }

    /**
     * View information about a recipe if the user is in 
     * the Main Menu or in Favorites and sends the user to recipe_view.
     * @exception Prints a message explaining how the commands work if the user doesn't
     * write anything after select.
     * @error Prints an error message if the user selects something that the RecipeBook
     * doesn't find listOfRecipes or listOfFavorites.
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
