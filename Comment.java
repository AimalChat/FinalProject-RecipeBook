import java.time.LocalDateTime;

/**
 * Write a description of class Comment here.
 *
 * @author (your name)
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
    
    public int getRating()
    {
        return rating;
    }
    
    public LocalDateTime getTimePosted()
    {
        System.out.println(timePosted);
        return timePosted;
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
