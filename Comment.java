import java.time.LocalDateTime;

/**
 * Write a description of class Comment here.
 *
 * @author Aimal
 * @version (a version number or a date)
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
     */
    public Comment(String author, String comment, int rating)
    {
        this.author = author;
        this.comment = comment;
        this.rating = rating;
        timePosted = LocalDateTime.now();
    }
    
    public void setRating(int rating)
    {
        this.rating = rating;
    }
    
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public int getRating()
    {
        return rating;
    }
    
    public LocalDateTime getTimePosted()
    {
        return timePosted;
    }
    
    public String getTimeString()
    {
        String time = (timePosted.getMonth().toString().toLowerCase() + " " + timePosted.getDayOfMonth() + " " + timePosted.getYear() 
        + ", " + + timePosted.getHour() +":" + timePosted.getMinute());
        return time;
    }
    
    public String getComment()
    {
        return comment;
    }

    public String getAuthor()
    {
        return author;
    }
}
