import java.util.ArrayList;

/**
 * Write a description of class Recipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recipe
{
    // instance variables - replace the example below with your own
    private String recipeName;
    private String recipeAuthor;
    private int recipeCounter = 0;
    private ArrayList<RecipeStep> recipeSteps;
    private ArrayList<RecipeIngredient> recipeIngredients;
    private String description;
    private int servingAmt;
    private int maxWidth = 40;
    private ArrayList<Comment> comments;
    private long averageRating;

    /**
     * Constructor for objects of class Recipe
    */
    public Recipe(String recipeName, String recipeAuthor, String description, int servingAmt)
    {
        recipeSteps = new ArrayList<>();
        recipeIngredients = new ArrayList<>();
        comments = new ArrayList<>();
        this.recipeName = recipeName;
        this.recipeAuthor = recipeAuthor;
        this.description = description;
        this.servingAmt = servingAmt;
    }
    
    public long getAverageRating()
    {
        long average = 0;
        int counter = 0;
        for(Comment comment : comments)
        {
            average += comment.getRating();
            counter++;
        }
        
        return (average/counter);
    }
    
    public ArrayList<Comment> getComments()
    {
        return comments;
    }
    
    public ArrayList<RecipeIngredient> getIngredients()
    {
        return recipeIngredients;
    }
    
    public ArrayList<RecipeStep> getSteps()
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
    
    public void printRecipeDetails()
    {
        System.out.println("--- " + recipeName + " ---" + 
        "\n" + "Author: " + recipeAuthor + "\n");
        printIngredientsList();
        printSteps();
    }
    
    public void printDescription()
    {
        AutoWrapper.wrapText(description, maxWidth);
        
        System.out.println("Recipe serves " + servingAmt + " people.");
    }
    
    public void printIngredientsList()
    {
        System.out.println("--Ingredient List--" + 
        "\n");
        for(RecipeIngredient ingredient : recipeIngredients)
        {
            System.out.println(ingredient.getRecipeIngredient());
        }
    }
    
    public void addIngredients(int ammount, String measurement, String ingredient)
    {
        if(ammount > 0)
        {
            recipeIngredients.add(new RecipeIngredient(ammount, measurement, ingredient));
        }else
        {
            System.out.println("invalid value for mesurements detected." + 
            "/n"+
            "Please enter valid value.");
        }
    }
    
    public void printSteps()
    {
        for(RecipeStep step : recipeSteps)
        {
            System.out.println(step.getStep());
        }
    }
    
    public void addRecipeStep(RecipeStep step)
    {
        recipeSteps.add(step);
        recipeCounter++;
    }
    
    public void printComments()
    {
        for(Comment comment : comments)
        {
            System.out.println("Thoughts on this recipe: "
            + "\n" +
            comment.getTimePosted() + "\n" +
            comment.getAuthor() + "\n" +
            comment.getComment());
        }
    }
}
