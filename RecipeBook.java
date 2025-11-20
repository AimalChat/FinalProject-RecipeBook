import java.util.ArrayList;

/**
 * Write a description of class RecipeBook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecipeBook
{
    // instance variables - replace the example below with your own
    private ArrayList<Recipe> recipes;
    private String name;

    /**
     * Constructor for objects of class RecipeBook
     */
    public RecipeBook(String name)
    {
        this.name = name;
        System.out.print(printTitle());
    }
    
    public String printTitle()
    {
        return "--- " + name + " 's Recipe Book ---";
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
