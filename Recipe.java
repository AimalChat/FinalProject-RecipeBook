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
    private String recipeName;
    private String recipeAuthor;
    private int recipeStepCounter = 1;
    private int recipeIngredientCounter = 1;
    private HashMap<Integer, RecipeStep> recipeSteps;
    private HashMap<Integer,RecipeIngredient> recipeIngredients;
    private String description;
    private int servingAmt;
    protected int maxWidth = 40;
    private ArrayList<Comment> comments;

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
    
    public Recipe()
    {
        recipeSteps = new HashMap<>();
        recipeIngredients = new HashMap<>();
        comments = new ArrayList<>();
    }
    
    public Recipe(String recipeAuthor)
    {
        this.recipeAuthor = recipeAuthor;
        recipeSteps = new HashMap<>();
        recipeIngredients = new HashMap<>();
        comments = new ArrayList<>();
    }
    
    public int getStepsSize()
    {
        return recipeSteps.size();
    }
    
    public int getIngredientsSize()
    {
        return recipeIngredients.size();
    }
    
    public int getCommentsSize()
    {
        return comments.size();
    }
    
    public void setServingAmt(int servingAmt)
    {
        this.servingAmt = servingAmt;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public void setRecipeAuthor(String recipeAuthor)
    {
        this.recipeAuthor = recipeAuthor;
    }
    
    public void setRecipeName(String recipeName)
    {
        this.recipeName = recipeName;
    }
    
    public void addComment(Comment comment)
    {
        comments.add(comment);
    }
    
    public void printDetails()
    {
        System.out.println("Author: " + recipeAuthor + "\n" +
        "Recipe: " + recipeName + "\n" +
        "Serves " + servingAmt + " people.\n" +
        "Description: " + description + "\n" +
        "Overall Rating: " + getAverageRating());
    }
    
    public ArrayList<RecipeIngredient> getConvertedIngredients(int desiredServings)
    {
        ArrayList<RecipeIngredient> convertedIngredients = new ArrayList<>();
        for(RecipeIngredient ingredient : recipeIngredients.values()){
            double newAmount = ingredient.getAmount() * (desiredServings / servingAmt);
            if(ingredient.getMeasurement().equals(null))
            {
                RecipeIngredient convertedIngredient = new RecipeIngredient(newAmount, ingredient.getIngredient());
                convertedIngredients.add(convertedIngredient);
            }else
            {
                RecipeIngredient convertedIngredient = new RecipeIngredient(newAmount, ingredient.getMeasurement(), ingredient.getIngredient());
                convertedIngredients.add(convertedIngredient);
            }
        }
        return convertedIngredients;
    }
    
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
    
    public ArrayList<Comment> getComments()
    {
        return comments;
    }
    
    public HashMap<Integer, RecipeIngredient> getIngredients()
    {
        return recipeIngredients;
    }
    
    public HashMap<Integer, RecipeStep> getSteps()
    {
        return recipeSteps;
    }
    
    public String getAuthor()
    {
        return recipeAuthor;
    }
    
    public String getName()
    {
        return recipeName;
    }    
    
    public void printRecipe()
    {
        System.out.println("--- " + recipeName + " ---" + 
        "\n" + "Author: " + recipeAuthor + "\n");
        printIngredientsList();
        System.out.println("\n");
        printSteps();
    }
    
    public void printDescription()
    {
        System.out.println(AutoWrapper.wrapTextByWidth(description, maxWidth));
        
        System.out.println("Recipe serves " + (int) servingAmt + " people.");
    }
    
    public void printIngredientsList()
    {
        int counter = 1;
        System.out.println("--Ingredient List--" + 
        "\n");
        for(RecipeIngredient ingredient : recipeIngredients.values())
        {
            if(ingredient.getMeasurement() == null)
            {
                System.out.println(counter + ". " + AutoWrapper.wrapTextByWidth(ingredient.getRecipeIngredient(),maxWidth));
                counter++;
            }else
            {
                if( (int) ((Math.abs(ingredient.getAmount()) * 10) % 10) == 0)
                {
                    System.out.println(counter + ". " + AutoWrapper.wrapTextByWidth(ingredient.getWholeIntRegRecipeIngredient(),maxWidth));
                    counter++;
                }else
                {
                    System.out.println(counter + ". " + AutoWrapper.wrapTextByWidth(ingredient.getRegRecipeIngredient(),maxWidth));
                    counter++;
                }
            }
        }
    }
    
    public void addIngredients(double amount, String measurement, String ingredient, boolean needsMeasurement)
    {
        if(amount > 0)
        {
            recipeIngredients.put(recipeIngredientCounter, new RecipeIngredient(amount, measurement, ingredient));
            recipeIngredientCounter++;
        }else if(needsMeasurement == false)
        {
            recipeIngredients.put(recipeIngredientCounter,new RecipeIngredient(amount, ingredient));
            recipeIngredientCounter++;
        }
        else{
            System.out.println("invalid value for mesurements detected." + 
            "\n"+
            "Please enter valid value.");
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
    
    public void printSteps()
    {
        int counter = 0;
        System.out.println("--Recipe Steps--" + "\n");
        for(RecipeStep step : recipeSteps.values())
        {
            System.out.println(counter + ". " + AutoWrapper.wrapTextByWidth(step.getStep(), maxWidth) + "\n");
            counter++;
        }
    }
    
    public void addRecipeStep(RecipeStep step)
    {
        recipeSteps.put(recipeStepCounter, step);
        recipeStepCounter++;
    }
    
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
