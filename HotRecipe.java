
/**
 * Write a description of class HotRecipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
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

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setCookOrBakeTime(int heatTemp, String tempatureType)
    {
        switch(tempatureType)
        {
            case "celsius" : 
                tempatureType = "ºC";
                this.tempatureType = tempatureType;
                if(validateHeat(heatTemp, tempatureType))
                {
                    this.heatTemp = heatTemp;
                    break;
                }else
                {
                    System.out.println("Invalid heat detected.");
                    break;
                }
            
            case "fahrenheit" : 
                tempatureType = "ºF";
                this.tempatureType = tempatureType;
                if(validateHeat(heatTemp, tempatureType))
                {
                    this.heatTemp = heatTemp;
                    break;
                }else
                {
                    System.out.println("Invalid heat detected.");
                    break;
                }
                
            case "C" :
                tempatureType = "ºC";
                this.tempatureType = tempatureType;
                if(validateHeat(heatTemp, tempatureType))
                {
                    this.heatTemp = heatTemp;
                    break;
                }else
                {
                    System.out.println("Invalid heat detected.");
                    break;
                }
                
            case "F" :
                tempatureType = "ºF";
                this.tempatureType = tempatureType;
                if(validateHeat(heatTemp, tempatureType))
                {
                    this.heatTemp = heatTemp;
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
                if(aHeatTemp == 0)
                {
                    System.out.println(AutoWrapper.wrapTextByWidth("0 is not really gonna help cook or bake anything, bruv.", maxWidth));
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
                if(aHeatTemp == 0)
                {
                    System.out.println(AutoWrapper.wrapTextByWidth("0 is not really gonna help cook or bake anything, bruv.", maxWidth));
                }
            }
        }
        return valid;
    }

    public int getHeat()
    {
        return heatTemp;
    }

    public String getTempatureType()
    {
        return tempatureType;
    }
}
