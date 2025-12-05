
/**
 * Write a description of class ColdRecipe here.
 *
 * @author Aimal
 * @version (a version number or a date)
 */
public class ColdRecipe extends Recipe
{
    // instance variables - replace the example below with your own
    private int chillTime;

    /**
     * Constructor for objects of class ColdRecipe
     */
    public ColdRecipe(String recipeName, String recipeAuthor, String description, int servingAmt)
    {
        super(recipeName, recipeAuthor, description, servingAmt);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setChillTime(int chillTime)
    {
        if(chillTime < 0)
        {
            return;
        }
        else
        {
            this.chillTime = chillTime;
        }
    }
    
    public int getChillTime()
    {
        return chillTime;
    }
}
