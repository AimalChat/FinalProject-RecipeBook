import java.util.HashMap;

/**
 * Write a description of class RecipeIngredients here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecipeIngredient
{
    // instance variables - replace the example below with your own
    private int ammount;
    private String measurement;
    private String ingredient;
    private HashMap<Integer, String> ingredients;

    /**
     * Constructor for objects of class RecipeIngredients
     */
    public RecipeIngredient(int ammount,String measurement, String ingredient)
    {
        if(ammount > 0)
        {
            this.ammount = ammount;
            this.measurement = measurement;
            this.ingredient = ingredient;
        }else
        {
            System.out.println("invalid value for ammount detected." + 
            "/n"+
            "Please enter valid value.");
        }
    }
    
    public String getRecipeIngredient()
    {
        return ammount + " " + measurement + " " + ingredient;
    }
    
    public String getIngredient()
    {
        return ingredient;
    }
    
    public String getMeasurement()
    {
        return measurement;
    }

    public int getAmmount()
    {
        return ammount;
    }
}
