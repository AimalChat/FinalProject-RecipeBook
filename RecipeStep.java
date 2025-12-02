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
    private String step;

    /**
     * Constructor for objects of class RecipeSteps
     */
    public RecipeStep(String step)
    {
        this.step = step;
    }
    
    public void setStep(String step)
    {
        this.step = step;
    }

    public String getStep()
    {
        return step;
    }
}
