
/**
 * The AutoWrapper class is for wrapping long inputs of Strings
 * and formatting the visuals. It is to be used for anything needing 
 * to set boundaries on text, for as long as the word isnt long enough 
 * to pass the maxWidth variable set.
 *
 * @author Aimal
 * @version (2025/11/23)
 */
public class AutoWrapper
{
    /**
     *Wraps received text and wrapping said text with a maximum length per line.
     *
     * @param  String text, int maxWidth
     * @return    the formatted text, a String
     */
    public static String wrapTextByWidth(String text, int maxWidth)
    {
        //cannot handle a word which has a character count larger than the maxWidth!!!
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
        return wrapped.toString();
    }
}
