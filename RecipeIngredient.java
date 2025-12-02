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
    private double amount;
    private String measurement;
    private String ingredient;

    /**
     * Constructor for objects of class RecipeIngredients
     */
    public RecipeIngredient(double amount,String measurement, String ingredient)
    {
        if(validMeasurement(measurement) == false)
        {
            System.out.println("invalid string for measurement dectected." +
            "\n" +
            "Please enter valid measurement.");
            return;
        }
        else if(amount < 0)
        {
            System.out.println("invalid value for amount detected." + 
            "\n"+
            "Please enter valid value.");
            return;
        }
        else if(amount > 0 && validMeasurement(measurement) == true) 
        {
            this.amount = amount;
            this.measurement = measurement;
            this.ingredient = ingredient;
        }
    }
    /**
     * Constructor for objects of class RecipeIngredients
     */
    public RecipeIngredient(double amount, String ingredient)
    {
        if(amount < 0)
        {
            System.out.println("invalid value for amount detected." + 
            "\n"+
            "Please enter valid value.");
            return;
        }
        else if(amount > 0) 
        {
            this.amount = amount;
            this.measurement = measurement;
            this.ingredient = ingredient;
        }
    }    
    
    public boolean validMeasurement(String aMeasurement)
    {
        boolean valid;
        switch(aMeasurement)
        {
            case "teaspoon" -> valid = true;
            case "tablespoon" -> valid = true;
            case "cup" -> valid = true;
            case "quart" -> valid = true;
            case "gallon" -> valid = true;
            case "pinch" -> valid = true;
            case "pint" -> valid = true;
            case "milliliter" -> valid = true;
            case "liter" -> valid = true;
            case "tsp" -> valid = true;
            case "tbsp" -> valid = true;
            case "ml" -> valid = true;
            case "ltr" -> valid = true;
            case "milliliters" -> valid = true;
            case "teaspoons" -> valid = true;
            case "tablespoons" -> valid = true;
            case "cups" -> valid = true;
            case "quarts" -> valid = true;
            case "gallons" -> valid = true;
            case "pinches" -> valid = true;
            case "liters" -> valid = true;
            default -> valid = false;
        }
        return valid;
    }
    
    public String getRecipeIngredient()
    {
        return amount + " " + measurement + " " + ingredient;
    }
    
    public String getIngredient()
    {
        return ingredient;
    }
    
    public String getMeasurement()
    {
        return measurement;
    }

    public double getAmount()
    {
        return amount;
    }
}
