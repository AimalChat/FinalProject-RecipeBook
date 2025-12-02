
/**
 * Write a description of class HotRecipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HotRecipe extends Recipe
{
    // instance variables - replace the example below with your own
    private int heatTime;
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
    public void setCookOrBakeTime(int heatTime, String tempatureType)
    {
        switch(tempatureType)
        {
            case "celsius" -> tempatureType = "ºC";
            case "fahrenheit" -> tempatureType = "ºF";
            default ->  tempatureType = null;
        }
        
        if(tempatureType == "ºC")
        {
            if(heatTime > 290)
            {
                System.out.println(AutoWrapper.wrapTextByWidth("For safety reasons we cannot allow you to exceed 290ºC. Please input a valid value.", maxWidth));
                return;
            }
        }
        else
        {
            this.heatTime = heatTime;
        }
        
        if(tempatureType == "ºF")
        {
            if(heatTime > 550)
            {
                System.out.println(AutoWrapper.wrapTextByWidth("For safety reasons we cannot allow you to exceed 550ºF. Please input a valid value.", maxWidth));
                return;
            }
        }
        else
        {
            this.heatTime = heatTime;
        }
    }
    
    public int getHeatTime()
    {
        return heatTime;
    }
    
    public String getTempatureType()
    {
        return tempatureType;
    }
}
