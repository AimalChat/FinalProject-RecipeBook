import java.util.Arrays;

/**
 * To validate input from user and return the desired Object the user wishes
 * to create in their own Recipe instance.
 *
 * @author Aimal
 * @version 12/11/2025
 */
public class Validator
{
    private RecipeIngredient rI = new RecipeIngredient(1, "cup", "sadness");

    /**
     * Constructor for objects of class Validator
     */
    public Validator()
    {
        // initialise instance variables
    }
    
    /**
     * Retrieves user input and makes sure that the String given is not empty before
     * sending it back to recipeBook
     */
    public String validateRecipeName(String[] recipeName)
    {
        StringBuilder sb = new StringBuilder();
        
        if(recipeName.length == 0)
        {
            System.out.println("Please write a valid step.");
            return null;
        }else
        {
            for(int i = 0; i < recipeName.length; i++)
            {
                recipeName[i] = recipeName[i].substring(0,1).toUpperCase() + recipeName[i].substring(1);
                sb.append(recipeName[i] + " ");
            }
        }
        return sb.toString().trim();
    }

    /**
     * Retrieves user input from Parser and checks if the input from user is valid
     * to create a recipe ingredient.
     *
     * @param  ingredient An array that may or may not hold the necessary
     *         information to create a RecipeIngredient object.
     *         
     * @return    valid RecipeIngredient if given input has all valid info.
     *            ELSE, Null
     */
    public RecipeIngredient validateIngredient(String[] ingredient)
    {   
        if (ingredient.length < 3) {
            System.out.println("Incomplete ingredient format." + "\n"+ "Please follow the format: 'amount, measurement, ingredient.'");
            return null;
        }
        
        for(int i = 0; i < ingredient.length; i++)
        {
            ingredient[i] = ingredient[i].trim();
        }

        if(!rI.validMeasurement(ingredient[1]))
        {
            System.out.println("The entered measurement is invalid.");
            return null;
        } 
        else if(rI.validMeasurement(ingredient[1]) && ingredient.length >= 3)
        {
            //with measurement
            if(ingredient[1].equals("") || ingredient[2].equals(""))
            {
                System.out.println("Ingredient not found.");
                return null;
            } 
            else
            {
                ingredient[2] = String.join(",", Arrays.copyOfRange(ingredient, 2, ingredient.length)).trim();
            }
            
            double amount;
            String measurement = ingredient[1].toLowerCase();
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
    
    /**
     * Retrieves user input from Parser and checks if the input from user is valid
     * to create a recipe step.
     *
     * @param  input: A string that represents a step.
     *         
     * @return    valid RecipeStep if given input is not empty.
     *            ELSE, Null
     */
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
    
    /**
     * Retrieves user input from Parser and checks if the input from user is valid
     * to set a recipe's type.
     *
     * @param  input: A string that represents 1 of the 3 types.
     *         
     * @return    input if given input is one of the types allowed.
     *            ELSE, Null
     */
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
    
    /**
     * Retrieves user input from Parser and checks if the input from user is valid
     * to set a recipe's serving amount.
     *
     * @param  input: A string that represents the servings given by a recipe.
     *         
     * @return    int if given input is a valid number.
     *            ELSE, 0
     */
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
