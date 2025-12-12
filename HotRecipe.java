
/**
 * A special recipe where cook/bake/ grill time is necessary.
 * Both time and kind of heat are validated by the class.
 *
 * @author Aimal
 * @version 12/11/2025
 */
public class HotRecipe extends Recipe
{
    // instance variables - replace the example below with your own
    private int heatTemp;
    private String tempatureType;

    /**
     * Constructor for objects of class HotRecipe
     */
    public HotRecipe(String recipeName, String recipeAuthor, String description, int servingAmt)
    {
        super(recipeName, recipeAuthor, description, servingAmt);
    }
    
    public HotRecipe()
    {
    }
    
    /**
    * Constructor with an author.
    */
    public HotRecipe(String recipeAuthor)
    {
        super(recipeAuthor);
    }

    /**
     * Set bake and Cook time
     *
     * @param  int heatTemp & String tempType
     */
    public void setCookOrBakeTime(int heatTemp, String tempatureType)
    {   
        switch(tempatureType)
        {
            case "celsius" : 
                tempatureType = "ºC";
                if(validateHeat(heatTemp, tempatureType))
                {
                    this.heatTemp = heatTemp;
                    this.tempatureType = tempatureType;
                    break;
                }else
                {
                    System.out.println("Invalid heat detected.");
                    break;
                }
            
            case "fahrenheit" : 
                tempatureType = "ºF";
                if(validateHeat(heatTemp, tempatureType))
                {
                    this.heatTemp = heatTemp;
                    this.tempatureType = tempatureType;
                    break;
                }else
                {
                    System.out.println("Invalid heat detected.");
                    break;
                }
                
            case "C" :
                tempatureType = "ºC";
                if(validateHeat(heatTemp, tempatureType))
                {
                    this.heatTemp = heatTemp;
                    this.tempatureType = tempatureType;
                    break;
                }else
                {
                    System.out.println("Invalid heat detected.");
                    break;
                }
                
            case "F" :
                tempatureType = "ºF";
                if(validateHeat(heatTemp, tempatureType))
                {
                    this.heatTemp = heatTemp;
                    this.tempatureType = tempatureType;
                    break;
                }else
                {
                    System.out.println("Invalid heat detected.");
                    break;
                }
                
            default :
                System.out.println("Invalid Tempature Type."
                    + "Must either be in fahrenheit(ºF) Or celsius(ºC).");
                break;
        }
    }
    
    /**
     * Validate the heat temperature and tempature type receieved.
     * 
     * @param  int aHeatTemp & String validTemparatrueType
     * @return boolean valid, true if both heat and type are in the list
     *                        false if one is not in the accepted types or invalid.
     */
    public boolean validateHeat(int aHeatTemp, String validTempatureType)
    {
        boolean valid = true;
        if(validTempatureType.equals("ºC"))
        {
            if(aHeatTemp > 290)
            {
                System.out.println(AutoWrapper.wrapTextByWidth("For safety reasons we cannot allow you to exceed 290ºC. Please input a valid value.", maxWidth));
                //aHeat = 0;
                valid = false;
            }else
            {
                if(aHeatTemp <= 0)
                {
                    System.out.println(AutoWrapper.wrapTextByWidth(aHeatTemp + " is not really gonna help cook or bake anything, bruv.", maxWidth));
                    valid = false;
                }
            }
        }

        if(validTempatureType.equals("ºF"))
        {
            if(aHeatTemp > 550)
            {
                System.out.println(AutoWrapper.wrapTextByWidth("For safety reasons we cannot allow you to exceed 550ºF. Please input a valid value.", maxWidth));
                //aHeat = 0;
                valid = false;
            }else
            {
                if(aHeatTemp <= 0)
                {
                    System.out.println(AutoWrapper.wrapTextByWidth(aHeatTemp + " is not really gonna help cook or bake anything, bruv.", maxWidth));
                    valid = false;
                }
            }
        }
        return valid;
    }

    /**
     * Return the temperature.
     * @return int heatTemp
     */
    public int getHeat()
    {
        return heatTemp;
    }

    /**
     * Return the temperature type
     * @return String temparatureType
     */
    public String getTempatureType()
    {
        return tempatureType;
    }
}
