import java.time.LocalDateTime;

/**
 * An opinion the user can make about a recipe, with a rating and a message attached.
 *
 * @author Aimal
 * @version 12/11/2025
 */
public class Comment
{
    // instance variables - replace the example below with your own
    private String author;
    private String comment;
    private LocalDateTime timePosted;
    private int rating;
    
    /**
     * Constructor for objects of class Comment
     * 
     * @param String author, the person who wrote the comment.
     * @param String comment, the comment itself
     * @param int rating, the star rating between 1 to 5.
     */
    public Comment(String author, String comment, int rating)
    {
        this.author = author;
        this.comment = comment;
        this.rating = rating;
        timePosted = LocalDateTime.now();
    }
    
    /**
     * Set the rating of the comment
     * 
     * @param int rating
     */
    public void setRating(int rating)
    {
        this.rating = rating;
    }
    
    /**
     * Set the comment of the comment object
     * 
     * @param String comment
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    /**
     * Set the author of the comment
     * 
     * @param String author
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    /**
     * Return the rating of the comment
     * 
     * @return int rating, the rating given
     */
    public int getRating()
    {
        return rating;
    }
    
    /**
     * Return the time the comment was posted.
     * 
     * @return LocalDateTime the time it was posted
     */
    public LocalDateTime getTimePosted()
    {
        return timePosted;
    }
    
    /**
     * Return a string of the time the comment was posted
     * 
     * @return String time, the time posted
     */
    public String timeToString()
    {
        String time = (timePosted.getMonth().toString().toLowerCase() + " " + timePosted.getDayOfMonth() + " " + timePosted.getYear() 
        + ", " + + timePosted.getHour() +":" + timePosted.getMinute());
        return time;
    }
    
    /**
     * Return the comment of the comment object
     * 
     * @return String comment, the message.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Return the author of the comment
     * 
     * @return String author, the author of the comment
     */
    public String getAuthor()
    {
        return author;
    }
}
