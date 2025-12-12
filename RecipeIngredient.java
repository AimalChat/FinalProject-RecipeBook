import java.util.HashMap;
import java.text.DecimalFormat;

/**
 * A representation of a ingredient needed in a recipe.
 * It is to be storred in a recipe object and have its
 * contents printed for the user to see.
 *
 * @author Alex
 * @version 12/11/2025
 */
public class RecipeIngredient
{
    // instance variables - replace the example below with your own 
    private DecimalFormat formatForWholeUnits = new DecimalFormat("#");
    private double amount;
    private String measurement;
    private String ingredient;

    /**
     * Constructor for objects of class RecipeIngredients
     * 
     * @param double amount, the qty.
     * @param String measurement
     * @param String ingredient
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
     * Set the measurement of the recipe Ingredient
     * 
     * @param String measurement
     */
    public void setMeasurement(String measurement)
    {
        if(validMeasurement(measurement) == true)
        {
            this.measurement = measurement;
        }
    }

    /**
     * Set the ingredient of the recipe Ingredient
     * 
     * @param String ingredient
     */
    public void setIngredient(String ingredient)
    {
        this.ingredient = ingredient;
    }

    /**
     * Set the amount of the recipe Ingredient
     * 
     * @param double amount
     */
    public void setAmount(double amount)
    {
        if(amount > 0)
        {
            this.amount = amount;
        }
        else
        {
            System.out.println("invalid value for amount detected." + 
                "\n"+
                "Please enter valid value.");
            return;
        }
    }

    /**
     * Validate the measurement receieved.
     * 
     * @param String measurement
     * @return boolean valid, true if measurement is in the list
     *                        false if not in the list.
     */
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
            case "unit" -> valid = true;
            case "units" -> valid = true;
            default -> valid = false;
        }
        return valid;
    }

    /**
     * Formats the measurement of the recipe Ingredient
     * 
     * @return formated measurement
     */
    public String formattedMeasurement() 
    {
        if(amount == 1 || amount < 1)
        {
            return measurement; // singular
        }
        else if(measurement.equals("unit")) 
        {
            return "units"; // special case
        }
        else if(measurement.endsWith("s"))
        {
            return measurement; // already plural
        }
        else 
        {
            return measurement + "s"; // add plural s
        }
    }

    /**
     * returns the String form of the recipe Ingredient
     * 
     * @return String recipeIngredient, as a string.
     */
    public String toString()
    {
        return amount + " " + formattedMeasurement() + " " + ingredient;
    }

    /**
     * Return the ingredient of the recipe Ingredient
     * 
     * @return String ingredient
     */
    public String getIngredient()
    {
        return ingredient;
    }

    /**
     * Return the measurement of the recipe Ingredient
     * 
     * @return String measurement
     */
    public String getMeasurement()
    {
        return measurement;
    }

    /**
     * Return the amount of the recipe Ingredient
     * 
     * @return double amount
     */
    public double getAmount()
    {
        return amount;
    }
}
