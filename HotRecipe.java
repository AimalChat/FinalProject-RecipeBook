
/**
 * Write a description of class HotRecipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HotRecipe extends Recipe
{
    // instance variables - replace the example below with your own
    private int heatTime;

    /**
     * Constructor for objects of class HotRecipe
     */
    public HotRecipe(String recipeName, String recipeAuthor, String description, int servingAmt, int heatTime)
    {
        super(recipeName, recipeAuthor, description, servingAmt);
        this.heatTime = heatTime;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod(int y)
    {
        // put your code here
    }
}
