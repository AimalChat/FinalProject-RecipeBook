import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * Write a description of class Recipe here.
 *
 * @author Aimal
 * @version (a version number or a date)
 */
public class Recipe
{
    // instance variables - replace the example below with your own
    private DecimalFormat formatForRating = new DecimalFormat("#.#");
    private String recipeName = "Unknown";
    private String recipeAuthor = "Unknown";
    private int recipeStepCounter = 1;
    private int recipeIngredientCounter = 1;
    private HashMap<Integer, RecipeStep> recipeSteps;
    private HashMap<Integer,RecipeIngredient> recipeIngredients;
    private String description = "Unknown";
    private int servingAmt = 0;
    protected int maxWidth = 40;
    private ArrayList<Comment> comments;
    private String type = "Unknown";

    /**
     * Constructor for objects of class Recipe
    */
    public Recipe(String recipeName, String recipeAuthor, String description, int servingAmt)
    {
        recipeSteps = new HashMap<>();
        recipeIngredients = new HashMap<>();
        comments = new ArrayList<>();
        this.recipeName = recipeName;
        this.recipeAuthor = recipeAuthor;
        this.description = description;
        this.servingAmt = servingAmt;
    }
    
    /**
     * Constructor without an author.
     */
    public Recipe()
    {
        recipeSteps = new HashMap<>();
        recipeIngredients = new HashMap<>();
        comments = new ArrayList<>();
    }
    
    /**
     * Constructor with an author.
     */
    public Recipe(String recipeAuthor)
    {
        this.recipeAuthor = recipeAuthor;
        recipeSteps = new HashMap<>();
        recipeIngredients = new HashMap<>();
        comments = new ArrayList<>();
    }
    
    public int getServingAmount()
    {
        return servingAmt;
    }
    
    public String getRecipeDescription()
    {
        return description;
    }
    
    public String getRecipeType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    /**
     * @return recipeSteps.size
     */
    public int getStepsSize()
    {
        return recipeSteps.size();
    }
    
    /**
     * @return recipeIngredients
     */
    public int getIngredientsSize()
    {
        return recipeIngredients.size();
    }
    
    /**
     * @return comments.size
     */
    public int getCommentsSize()
    {
        return comments.size();
    }
    
    /**
     * @param int servingAmt
     */
    public void setServingAmt(int servingAmt)
    {
        this.servingAmt = servingAmt;
    }
    
    /**
     * @param String description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * @param recipeAuthor
     */
    public void setRecipeAuthor(String recipeAuthor)
    {
        this.recipeAuthor = recipeAuthor;
    }
    
    /**
     * @param recipeName
     */
    public void setRecipeName(String recipeName)
    {
        this.recipeName = recipeName;
    }
    
    /**
     * @param comment
     * Adds comment to comments.
     */
    public void addComment(Comment comment)
    {
        comments.add(comment);
    }
    
    /**
     * Shows details
     */
    public void printDetails()
    {
        System.out.println("Author: " + recipeAuthor + "\n" +
        "Recipe: " + recipeName + "\n" +
        "Type: " + type + " recipe" + "\n" +
        "Serves " + servingAmt + " people.\n" +
        "Description: " + description + "\n" +
        "Overall Rating: " + getAverageRating());
    }
    
    /**
     * @param int desiredServings
     * returns the amount needed for each ingredients in the converted recipe.
     */
    public ArrayList<RecipeIngredient> getConvertedIngredients(int desiredServings)
    {
        ArrayList<RecipeIngredient> convertedIngredients = new ArrayList<>();
        
        for(RecipeIngredient ingredient : recipeIngredients.values())
        {
            
            double ratio = (double) desiredServings / servingAmt;
            double newAmount = ingredient.getAmount() * ratio;
            
            RecipeIngredient converted = new RecipeIngredient(newAmount, ingredient.getMeasurement(), ingredient.getIngredient());
            convertedIngredients.add(converted);
        }
        
        return convertedIngredients;
    }
    
    /**
     * @return average/counter
     * prints an average of all the comments's rating.
     */
    public String getAverageRating()
    {
        double average = 0;
        int counter = 0;
        if(comments.isEmpty())
        {
            return "0";
        }
        for(Comment comment : comments)
        {
            average += comment.getRating();
            counter++;
        }
        
        return formatForRating.format((average/counter));
    }
    
    /**
     * @return comments
     */
    public ArrayList<Comment> getComments()
    {
        return comments;
    }
    
    /**
     * @param Integer, RecipeIngredient
     * @return recipeIngredients
     */
    public HashMap<Integer, RecipeIngredient> getIngredients()
    {
        return recipeIngredients;
    }
    
    /**
     * @param Integer, RecipeStep.
     * @return recipeSteps.
     */
    public HashMap<Integer, RecipeStep> getSteps()
    {
        return recipeSteps;
    }
    
    /**
     * @return recipeAuthor.
     */
    public String getAuthor()
    {
        return recipeAuthor;
    }
    
    /**
     * @return recipeName.
     */
    public String getRecipeName()
    {
        return recipeName;
    }    
    
    /**
     * Prints the complete description of the recipe, including the ingredients and the steps
     */
    public void printRecipe()
    {
        System.out.println("----- " + recipeName + " -----");
        System.out.println("\n");
        printDetails();
        System.out.println("\n");
        printIngredientsList();
        System.out.println("\n");
        printSteps();
    }
    
    /**
     * Prints the description of the recipe
     */
    public void printDescription()
    {
        System.out.println(AutoWrapper.wrapTextByWidth(description, maxWidth));
        
        System.out.println("Recipe serves " + (int) servingAmt + " people.");
    }
    
    /**
     * Prints all the ingredients and their details from recipeIngredients
     */
    public void printIngredientsList()
    {
        int counter = 1;
        System.out.println("-----------Ingredient List-----------" + 
        "\n");
        for(RecipeIngredient ingredient : recipeIngredients.values())
        {
            System.out.println(counter + ". " + AutoWrapper.wrapTextByWidth(ingredient.getRecipeIngredient(),maxWidth));
            counter++;
        }
    }
    
    /**
     * This method is for simplyfying the construction of ingredients in the SourceRecipes!
     * Not a replacement for the one above.
     */
    public void addIngredient(RecipeIngredient ingredient)
    {
        recipeIngredients.put(recipeIngredientCounter,ingredient);
        recipeIngredientCounter++;
    }
    
    /**
     * Prints the steps of the recipe.
     */
    public void printSteps()
    {
        int counter = 1;
        System.out.println("-----------Recipe Steps-----------" + "\n");
        for(RecipeStep step : recipeSteps.values())
        {
            System.out.println(counter + ". " + AutoWrapper.wrapTextByWidth(step.getStep(), maxWidth) + "\n");
            counter++;
        }
    }
    
    /**
     * Adds a recipe step to recipeStep.
     */
    public void addRecipeStep(RecipeStep step)
    {
        recipeSteps.put(recipeStepCounter, step);
        recipeStepCounter++;
    }
    
    /**
     * Prints all the comments and their ratings.
     */
    public void printComments()
    {
        System.out.println("--Thoughts on this recipe.-- "+ "\n");
        for(Comment comment : comments)
        {
            System.out.println(
            "Author: " + comment.getAuthor() + " rates this recipe at " 
            + comment.getRating() + " stars."
            + "\n" + "Time Posted: " + comment.getTimeString() + "\n" +
            AutoWrapper.wrapTextByWidth(comment.getComment(), maxWidth) + "\n");
        }
    }
}
