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
    private ArrayList<String> recipeSteps;
    private ArrayList<String> recipeIngredients;
    private String description;
    private int servingAmt;
    

    /**
     * Constructor for objects of class Recipe
    */
    public Recipe(String recipeName, String recipeAuthor, String description, int servingAmt,ArrayList<String> recipeSteps,ArrayList<String> recipeIngredients)
    {
        this.recipeName = recipeName;
        this.recipeAuthor = recipeAuthor;
        this.description = description;
        this.servingAmt = servingAmt;
        this.recipeSteps = recipeSteps;
        this.recipeIngredients = recipeIngredients;
    }
    
    public void printRecipeDetails()
    {
        System.out.println("--- " + recipeName + " ---" + 
        "\n" + "Author: " + recipeAuthor + "\n");
        printIngredientsList();
        printSteps();
    }
    
    public void printDescription(int servingAmt, String description)
    {
        
    }
    
    public void printIngredientsList()
    {
        for(String ingredient : recipeIngredients)
        {
            System.out.println(ingredient);
        }
    }
    
    public void addIngredients(String ingredient, int measurement)
    {
        if(measurement > 0)
        {
            recipeIngredients.add(measurement + ingredient);
        }else
        {
            System.out.println("invalid value for mesurements detected." + 
            "/n"+
            "Please enter valid value.");
        }
    }
    
    public void printSteps()
    {
        for(String step : recipeSteps)
        {
            System.out.println(step);
        }
    }
    
    public void addRecipeStep(String step)
    {
        recipeSteps.add(recipeCounter + step);
        recipeCounter++;
    }
}
