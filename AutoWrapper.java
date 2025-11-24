
/**
 * The AutoWrapper class is for wrapping long inputs of Strings
 * and formatting the visuals. It is to be used for anything needing 
 * to set boundaries on text.
 *
 * @author (Aimal)
 * @version (2025/11/23)
 */
public class AutoWrapper
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class AutoWrapper
     */
    public AutoWrapper()
    {
        // initialise instance variables
        
    }

    /**
     * 
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static String wrapText(String text, int maxWidth)
    {
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();
        StringBuilder wrapped = new StringBuilder();
        
        for(String word : words)
        {
            if(line.length() + word.length() <= maxWidth )
            {
                line.append(word + " ");
            } 
            else
            {
                wrapped.append(line.toString() + "\n");
                line.setLength(0);
                line.append(word + " ");
            }
        }
        
        wrapped.append(line.toString().trim());
        System.out.println(wrapped.toString());
        return wrapped.toString();
    }
}
