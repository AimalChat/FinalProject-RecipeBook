import java.util.ArrayList;

/**
 * A simple String meant to represent a step.
 *
 * @author Alex
 * @version 12/11/2025
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
    
    /**
     * Set the step of the recipe step.
     * 
     * @param String step
     */
    public void setStep(String step)
    {
        this.step = step;
    }

    /**
     * Return the step of the recipe step.
     * 
     * @return String step
     */
    public String getStep()
    {
        return step;
    }
}
