import java.util.ArrayList;

/**
 * Write a description of class RecipeSteps here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecipeStep
{
    // instance variables - replace the example below with your own
    private ArrayList<String> recipeSteps;
    private String step;
    private int recipeCounter = 0;

    /**
     * Constructor for objects of class RecipeSteps
     */
    public RecipeStep(String step)
    {
        recipeSteps = new ArrayList<>();
        this.step = step;
        recipeSteps.add(step);
    }

    public String getStep()
    {
        return step;
    }
}
