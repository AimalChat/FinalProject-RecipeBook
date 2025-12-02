
/**
 * Write a description of class HotRecipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HotRecipe extends Recipe
{
    // instance variables - replace the example below with your own
    private int heat;
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
    public void setCookOrBakeTime(int heat, String tempatureType)
    {
        switch(tempatureType)
        {
            case "celsius" : 
                tempatureType = "ºC";
                this.tempatureType = tempatureType;
                this.heat = validateHeat(heat, tempatureType);
                break;
            case "fahrenheit" : 
                tempatureType = "ºF";
                this.tempatureType = tempatureType;
                this.heat = validateHeat(heat, tempatureType);
                break;
            case "C" :
                tempatureType = "ºC";
                this.tempatureType = tempatureType;
                this.heat = validateHeat(heat, tempatureType);
                break;
            case "F" :
                tempatureType = "ºF";
                this.tempatureType = tempatureType;
                this.heat = validateHeat(heat, tempatureType);
                break;
            default :
                System.out.println("Invalid Tempature Type."
                    + "Must either be in fahrenheit(ºF) Or celsius(ºC).");
                break;
        }
    }

    public int validateHeat(int aHeat, String validTempatureType)
    {
        if(validTempatureType.equals("ºC"))
        {
            if(aHeat > 290)
            {
                System.out.println(AutoWrapper.wrapTextByWidth("For safety reasons we cannot allow you to exceed 290ºC. Please input a valid value.", maxWidth));
                aHeat = 0;
            }
        }

        if(validTempatureType.equals("ºF"))
        {
            if(aHeat > 550)
            {
                System.out.println(AutoWrapper.wrapTextByWidth("For safety reasons we cannot allow you to exceed 550ºF. Please input a valid value.", maxWidth));
                aHeat = 0;
            }
        }
        return aHeat;
    }

    public int getHeat()
    {
        return heat;
    }

    public String getTempatureType()
    {
        return tempatureType;
    }
}
