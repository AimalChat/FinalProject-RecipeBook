import java.util.Arrays;

/**
 * To validate input from user.
 *
 * @author Aimal
 * @version (a version number or a date)
 */
public class Validator
{
    private RecipeIngredient rI = new RecipeIngredient();

    /**
     * Constructor for objects of class Validator
     */
    public Validator()
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public RecipeIngredient validateIngredient(String[] ingredient)
    {   
        if(!rI.validMeasurement(ingredient[1]) && ingredient.length >= 2)
        {
            //without measurement
            if(ingredient[1].equals(""))
            {
                System.out.println("Ingredient not found.");
                return null;
            } 
            else if(ingredient.length >= 2)
            {
                ingredient[1] = String.join(",", Arrays.copyOfRange(ingredient, 1, ingredient.length)).trim();
            }
            
            double amount;
            String ingredientToBe = ingredient[1];
            
            try{
                amount = Double.parseDouble(ingredient[0]);
            } 
            catch(NumberFormatException e)
            {
                System.out.println("Not a valid amount." +
                    "\n" +
                    "Please enter a valid amount for the ingredient");
                return null;
            }
            
            return new RecipeIngredient(amount, ingredientToBe);
            
        } 
        else if(rI.validMeasurement(ingredient[1]) && ingredient.length >= 3)
        {
            //with measurement
            if(ingredient[1].equals("") || ingredient[2].equals(""))
            {
                System.out.println("Ingredient not found.");
                return null;
            } 
            else if(ingredient.length >= 3)
            {
                ingredient[2] = String.join(",", Arrays.copyOfRange(ingredient, 2, ingredient.length)).trim();
            }
            
            double amount;
            String measurement = ingredient[1];
            String ingredientToBe = ingredient[2];
            
            try{
                amount = Double.parseDouble(ingredient[0]);
            } 
            catch(NumberFormatException e)
            {
                System.out.println("Not a valid amount." +
                    "\n" +
                    "Please enter a valid amount for the ingredient");
                return null;
            }
            
            return new RecipeIngredient(amount,measurement, ingredientToBe);
        }
        else
        {
            return null;
        }
    }
    
    public RecipeStep validateStep(String input)
    {
        if(input.equals(""))
        {
            System.out.println("Please input valid step.");
            return null;
        }else
        {
            return new RecipeStep(input);
        }
    }
    
    public String validateType(String input)
    {
        if(input.equals("hot") || input.equals("cold") || input.equals("regular"))
        {
            return input;
        } else
        {
            System.out.println("Please input valid type.");
            return null;
        }
    }
    
    public int validateServingAmount(String servingAmt)
    {
        int servings;
        
        try{
            servings = Integer.parseInt(servingAmt);
        } catch(NumberFormatException e)
        {
            System.out.println("First value found is not a number.");
            return 0;
        }
        
        if(servings <= 0)
        {
            System.out.println("Invalid serving amount detected, below 0.");
            return 0;
        } 
        
        return servings;
    }
}
